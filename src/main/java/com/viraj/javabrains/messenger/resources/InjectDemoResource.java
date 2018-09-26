package com.viraj.javabrains.messenger.resources;


import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	/*
	 * https://stackoverflow.com/questions/10183875/whats-the-difference-between-queryparam-and-matrixparam-in-jax-rs/46565703#46565703
	 * The @MatrixParam annotation will apply to particular Resource present in URL and  
	 * @QueryParam will apply to whole Request URL.
	 * Take a example of any Supermarket, If you want all fruits which will be satisfied multiple conditions like type=fruits and price range starts from 300 and list out matching 10 fruits, you can go for below API Design,
	 * http://dev.brandstore.com/inventory/grocery;type=fruits/price;range=300/?limit=10
	 * In above example, first Matrix Param type=fruits is applying to only grocery resource same range=300 is applying to only price resource but Query Param for pagination limit=10 is applying to whole Request URL. 
	 * And yes, If only query parameters were used, you would end up with parameters like "grocery_type" and "grocery_price" and you would lose the clarity added by the locality of the parameters within the request.
	 */
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
											@HeaderParam("customHeaderValue") String header,
											@CookieParam("name") String name
											//@FormParam can be used as well
											) 
	{
		return "Matrix Param: "+ matrixParam + ", custom header = " + header + ", cookie: " + name;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		return "Path : " + path + "\n Cookies:" + cookies + "\n headers:" + headers.getHeaderString("customheadervalue");
	}

}
