package com.wiscom.util;


import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.PostConstruct;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("file:./conf/bootJdbc.properties")
@Configuration
public class JdbcUtil { //当前工具在数据库连接断开后虽然有重连机制 但是要注意rs = null的情况，在遍历rs获取数据时，除了rs.next() 之外  还需要在前面加上rs != null 这个判断条件


    //单独维护写入到本地数据库的数据源信息和连接信息，方便其他线程调用，类似spring的切面。同时也减少数据库连接数

    @Value("${data-source.className}")
    String proclassName;
    @Value("${data-source.url}")
    String prourl;
    @Value("${data-source.username}")
    String prousername;
    @Value("${data-source.password}")
    String propassword;
    private static Connection defaultConn = null;
    private static Logger logger = LogManager.getLogger(JdbcUtil.class);

    public static int EXECUTE_SUCCESS = 0;
    public static int ERROR_CODE_CONN = -1;
    public static int ERROR_CODE_SQL = -2;

    public static String className;
    public static String url;
    public static String username;
    public static String password;

    @PostConstruct
    public void init() {
        try {
            logger.info("start init database conf");

            className = proclassName;
            url = prourl;
            username = prousername;
            password = propassword;

            try {
                Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            setCon(className, url, username, password);

            logger.info("init database conf success");
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
    public synchronized static void setCon(String driver, String url, String username, String password) {
        getDefaultConnection();
    }

    public synchronized static Connection getConnection(boolean autoCommited) {
        Connection conn = null;
        while (conn == null) {
            try {
                conn = DriverManager.getConnection(url, username, password);
                conn.setAutoCommit(autoCommited);
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error(e);

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                    logger.error(ie);
                }
            }

        }

        return conn;
    }

    public synchronized static void getDefaultConnection() {
        try {
            if (defaultConn != null){
                if (defaultConn.isValid(2)) {
                    return;
                }
                defaultConn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        }

        defaultConn = getConnection(true);
    }

    public synchronized static void close() {
        if (defaultConn != null) {
            try {
                defaultConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error(e);
            }
        }
    }

    public synchronized static ResultSet select(String sql) {
        try {
            getDefaultConnection();
            PreparedStatement pstmt = defaultConn.prepareStatement(sql);
            return pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("select ERR:" + sql + e.getMessage());
            getDefaultConnection();
        }
        return null;
    }

    public synchronized static boolean runSql(String sql) {  //执行本地数据源相关的语句
        Statement pstmt = null;
        try {
            getDefaultConnection();
            pstmt = defaultConn.createStatement();
            pstmt.executeUpdate(sql);
            pstmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("run sql error:" + sql + e.getMessage());
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    logger.error(e1);
                }
            }
            getDefaultConnection();
        }
        return false;
    }

    public synchronized static ResultSet runSql(Connection conn, String sql) { //执行其他数据源相关的语句
        Statement pstmt = null;
        try {
            pstmt = conn.createStatement();
            return pstmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("run sql error:" + sql + e.getMessage());
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    logger.error(e1);
                }
            }
        }
        return null;
    }

    public synchronized static ResultSet select(Connection conn, String sql) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            return pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("run sql error:" + sql + e.getMessage());
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    logger.error(e1);
                }
            }
        }
        return null;
    }

    //batch insert
    private static Statement st = null;
    public synchronized static boolean initBatch(){

        try {
            st = defaultConn.createStatement();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
            getDefaultConnection();
        }
        return false;
    }

    //批量增加sql
    public synchronized static boolean addBatch(String sql){
        try {
            if(st ==null){
                initBatch();
            }

            st.addBatch(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        }
        return false;
    }

    //批量执行
    public synchronized static int[] executeBatch(){
        try {
            if(st ==null){
                initBatch();
            }

            return st.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("executeBatch error:" + e.getMessage());
            initBatch();
        }
        return null;
    }

    public synchronized static boolean closeBatch(){
        try {
            if(st ==null){
                initBatch();
            }

            st.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        }
        return false;
    }

    public synchronized static Statement getBatch(Connection conn) {
        if (conn == null)
            return null;

        Statement stmt = null;

        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            logger.error("getBatch ERR:" + e.getMessage());
            e.printStackTrace();
        }
        return stmt;
    }

    public synchronized static void closeBatch(Statement st) {
        try {
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        }
    }

    public synchronized static Connection getConnection(String url, String username, String password) throws SQLException{
        return DriverManager.getConnection(url, username, password);
    }

    public synchronized static int[] executeBatchThenCommit(Connection dbConnection, Statement stmt, List<String> batchSql) {
        int[] results = null;
        try {
            for(int i = 0;i < batchSql.size();i++){
//				stmt.addBatch(batchSql.elementAt(i));
                stmt.addBatch(batchSql.get(i));//Vector改为List
            }
            results = stmt.executeBatch();
            dbConnection.commit();
        }  catch (BatchUpdateException e) {
            logger.error("executeBatch BatchUpdateException:" + e.getMessage());
            e.printStackTrace();
            try {
                if (dbConnection.isValid(5)){
                    results = e.getUpdateCounts();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
                logger.error(e1);
            }
        }catch(SQLException e){
            logger.error("executeBatch SQLException:" + e.getMessage());
            e.printStackTrace();
            logger.error(e);
        }

        return results;
    }

    public synchronized static int[] executeBatchThenCommit(Connection dbConnection, Statement stmt) {
        int[] results = null;
        try {
            results = stmt.executeBatch();
            dbConnection.commit();
        }  catch (BatchUpdateException e) {
            logger.error("executeBatch BatchUpdateException:" + e.getMessage());
            e.printStackTrace();
            try {
                if (dbConnection.isValid(5)){
                    results = e.getUpdateCounts();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
                logger.error(e1);
            }
        }catch(SQLException e){
            logger.error("executeBatch SQLException:" + e.getMessage());
            e.printStackTrace();
            logger.error(e);
        }

        return results;
    }

    public synchronized static void close(Connection dbConnection){
        try {
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
