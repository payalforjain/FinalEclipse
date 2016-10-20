package Learning.RestWithDatabase.Mongo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientMongo {

	
	public static void main(String[] args)
	{
		 ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("MongoDBBeans.xml");
         
	        PersonDAO personDAO = ctx.getBean("personDAO", PersonDAO.class);
	         
	        Person p = new Person("yy", "John", "USA");
	         
	        //create
	        //personDAO.create(p);
	        
	        //Person p1 = personDAO.readById(p.getId());
	        //System.out.println("Retrieved Person="+p1.getName());
	        
	        p.setName("Uncle John"
	        		+ "");
	        personDAO.update(p);
	}
}
