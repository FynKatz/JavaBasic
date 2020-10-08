package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTest01 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 1.加载驱动类Driver
			Class.forName("com.mysql.jdbc.Driver");
			// 2.创建数据库连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm", "root", "123456");
			// 3.创建SQL命令发送器Statement
			String sql = "INSERT into user (id,name) VALUES(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 4);
			ps.setObject(2, "yeo");
			// 4.执行
			boolean flag = ps.execute();
			System.out.println(flag);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.关闭（从后面到前面）
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
