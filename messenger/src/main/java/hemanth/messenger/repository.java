package hemanth.messenger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.research.ws.wadl.Request;

import DAO.Student;
import DAO.StudentJDBCTemplate;

public class repository {
	
    private ApplicationContext context;


	
	
	
	public Student response() {
	   	context = new ClassPathXmlApplicationContext("beans.xml");

	   StudentJDBCTemplate studentJDBCTemplate =  (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
	   	 
	                
	                Student student = studentJDBCTemplate.getStudent(2);
	                
	            
	       return student;
	   }
	
    
	
	
	
	public Student response(StudentRequest studentRequest) {
	   	context = new ClassPathXmlApplicationContext("beans.xml");

	   StudentJDBCTemplate studentJDBCTemplate =  (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
	   	 
	   int id = studentRequest.getId();
	                
	                Student student = studentJDBCTemplate.getStudent(id);
	                
	            
	       return student;
	   
  
	}
    
}
