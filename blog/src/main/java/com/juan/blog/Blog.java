package com.juan.blog;

import java.util.Date;
import java.util.UUID;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public class Blog {

	private String id = UUID.randomUUID().toString();

	@NotBlank
	private String title;

	@URL
	@NotBlank
	private String url;

	@NotBlank
	private String author;

	private final Date publishedOn = new Date();

	public Blog() {
	}

	public Blog(String title, String url, String author) {
		super();
		this.title = title;
		this.url = url;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public Date getPublishedOn() {
		return publishedOn;
	}

	public String getAuthor() {
		return author;
	}
}