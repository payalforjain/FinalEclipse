package hemanth.messenger;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAO.Student;
import DAO.StudentJDBCTemplate;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */

    
    @GET
    @Path("student")
    @Produces(MediaType.APPLICATION_JSON)
    public Student t() {
    	repository response = new repository();
    
        return response.response();
    }
    
    @POST
    @Path("req")
    @Produces(MediaType.APPLICATION_JSON)
    public Response resp(StudentRequest studentRequest) {
    	repository Studentresponse = new repository();
    
    	Student student = new Student();
    	student = Studentresponse.response(studentRequest);
    	
    	return Response.status(201).entity(student).build();
    }
    
   
}
