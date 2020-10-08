package com.huyy.datasource;


/**
 *     数据源切换
 * @author Fanel
 *
 */
public class CustomerContextHolder {
	
    public static final String DATA_SOURCE_MYSQL01 = "dataSourceMysqlOne";
    public static final String DATA_SOURCE_MYSQL02 = "dataSourceMysqlTwo";
    
    //数据源标识保存在线程变量ThreadLocal中，避免多线程操作数据源时互相干扰
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    
    public static void setCustomerType(String customerType) {
        contextHolder.set(customerType);
    }
    public static String getCustomerType() {
        String dataSource = contextHolder.get();
        if (dataSource.equals("") || dataSource.equals("null")) {
            return DATA_SOURCE_MYSQL01;//设置默认数据源
        }else {
            return dataSource;
        }
    }
    public static void clearCustomerType() {
        contextHolder.remove();
    }
}