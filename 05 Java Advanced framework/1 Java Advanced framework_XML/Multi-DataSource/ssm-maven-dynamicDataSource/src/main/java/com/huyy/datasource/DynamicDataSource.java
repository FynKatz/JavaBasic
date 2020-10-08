package com.huyy.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


/**
 *    动态数据源
 * @author Fanel
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return CustomerContextHolder.getCustomerType();
    }
}
