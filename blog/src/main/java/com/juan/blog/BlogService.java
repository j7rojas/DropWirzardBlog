package com.juan.blog;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class BlogService extends Application<BlogConfiguration> {

	public static void main(String[] args) throws Exception {
		new BlogService().run(new String[] { "server" });
	}


	@Override
	public void initialize(Bootstrap<BlogConfiguration> bootstrap) {
	}

	@Override
	public void run(BlogConfiguration configuration, Environment environment)
			throws Exception {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser(configuration.userName);
		dataSource.setPassword(configuration.password);
		dataSource.setUrl("jdbc:mysql://" + configuration.mysqlhost + ":"
				+ configuration.mysqlport + "/" + configuration.mysqldb);

		MySQLManaged mysqlManaged = new MySQLManaged(dataSource);
		environment.jersey().register(mysqlManaged);

		MySQLHealthCheck sqlHealthCheck = new MySQLHealthCheck(dataSource);
		environment.jersey().register(sqlHealthCheck);
		
		
		IndexResource indexResource = new IndexResource();
		environment.jersey().register(indexResource);

		/*BlogResource blogResource = new BlogResource(blogs);
		environment.jersey().register(blogResource);*/
	}

}