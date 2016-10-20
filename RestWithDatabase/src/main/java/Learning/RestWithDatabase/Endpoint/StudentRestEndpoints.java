package Learning.RestWithDatabase.Endpoint;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import Learning.RestWithDatabase.DAO.StudentDAO;
import Learning.RestWithDatabase.DAO.StudentDAOImpl;
import Learning.RestWithDatabase.Model.Student;


@Path("student")
@Component
public class StudentRestEndpoints {
	

	 
  // private ApplicationContext  context = new ClassPathXmlApplicationContext("beans.xml");
   // StudentDAO studentDAO = (StudentDAO)context.getBean("studentJDBCTemplate");

	@Autowired
	StudentDAO studentDAO ;
	//private static ApplicationContext context;

	@GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> studentById() {
    	

    	
        return studentDAO.listStudents();
    }
	
	/*
	public static void main(String[] args)
	{
	private ApplicationContext  context = new ClassPathXmlApplicationContext("beans.xml");
    StudentDAO studentDAO = (StudentDAO)context.getBean("studentJDBCTemplate");
    StudentRestEndpoints a =  new StudentRestEndpoints();
    a.studentById();
   }
*/
}
