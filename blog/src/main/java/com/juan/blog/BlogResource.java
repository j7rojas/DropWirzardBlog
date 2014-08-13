package com.juan.blog;

import java.util.HashMap;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 


import com.codahale.metrics.annotation.Timed;
 
@Path("/blogs")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class BlogResource {
 
    //private JacksonDBCollection<Blog, String> collection;
	private HashMap<Blog, String> collection;
 
    public BlogResource(HashMap<Blog, String> collection) {
        this.collection = collection;
    }
 
    @POST
    @Timed
    public Response publishNewBlog(@Valid Blog blog) {
        collection.put(blog, null);
        return Response.noContent().build();
    }
}
