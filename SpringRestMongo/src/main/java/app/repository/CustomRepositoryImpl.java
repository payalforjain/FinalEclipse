package app.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import app.model.Book;


@Repository
public class CustomRepositoryImpl implements CustomRepository {
	



		
		MongoTemplate mongoTemplate;
		
	
		
		
		String BOOK_COLLECTION="Book";
		
		 /* (non-Javadoc)
		 * @see app.repository.CustomRepository#readById(java.lang.String)
		 */
		@Override
		public Book readById(String id) {
		      Query query = new Query(Criteria.where("_id").is(id));
		      
		      return  mongoTemplate.findOne(query, Book.class, BOOK_COLLECTION);
		      
		     
		    }

}
