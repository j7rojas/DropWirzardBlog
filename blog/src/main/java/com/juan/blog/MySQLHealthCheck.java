package com.juan.blog;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.codahale.metrics.health.HealthCheck;

public class MySQLHealthCheck extends HealthCheck {
		private MysqlDataSource dataSource;
	   
	    protected MySQLHealthCheck(MysqlDataSource dataSource) {
			super();
	    	this.dataSource = dataSource;
		}
	 
	    @Override
	    protected Result check() throws Exception {
	        dataSource.getDatabaseName();
	        return Result.healthy();
	    }
}
