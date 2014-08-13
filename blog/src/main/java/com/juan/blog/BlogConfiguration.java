package com.juan.blog;

import io.dropwizard.Configuration;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class BlogConfiguration extends Configuration {
	@JsonProperty
	@NotEmpty
	public String mysqlhost = "localhost";

	@JsonProperty
	@Min(1)
	@Max(65535)
	public int mysqlport = 3306;

	@JsonProperty
	@NotEmpty
	public String mysqldb = "bloddb";

	@JsonProperty
	public String userName = "root";

	@JsonProperty
	public String password = "";
}
