package SpringFrame.Example.Controller;



import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import SpringFrame.Example.Model.Book;
import SpringFrame.Example.Dao.BookDAO;;



@RestController
@RequestMapping("/book")
public class BookController {

  @Autowired
  private BookDAO bookDAO;
  
 
  
  @RequestMapping(method = RequestMethod.GET,  value="/custom/{bookId}")
  public Book getCustomBookDetails(@PathVariable("bookId") String bookId){
 
    return bookDAO.readById(bookId);
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public Map<String, Object> createBook(@RequestBody Map<String, Object> bookMap){
    Book book = new Book(bookMap.get("name").toString(), 
        bookMap.get("isbn").toString(),
        bookMap.get("author").toString(),
        Integer.parseInt(bookMap.get("pages").toString()));
    
    Map<String, Object> response = new LinkedHashMap<String, Object>();
    response.put("message", "Book created successfully");
    bookDAO.create(book);
    response.put("book", book);
    return response;
  }
  
  @RequestMapping(method = RequestMethod.GET, value="/{bookId}")
  public Book getBookDetails(@PathVariable("bookId") String bookId){
    return bookDAO.readById(bookId);
  }
  
  @RequestMapping(method = RequestMethod.PUT, value="/{bookId}")
  public Map<String, Object> editBook(@PathVariable("bookId") String bookId, 
      @RequestBody Map<String, Object> bookMap){
    Book book = new Book(bookMap.get("name").toString(), 
        bookMap.get("isbn").toString(),
        bookMap.get("author").toString(),
        Integer.parseInt(bookMap.get("pages").toString()));
    book.setId(bookId);
    
    Map<String, Object> response = new LinkedHashMap<String, Object>();
    response.put("message", "Book Updated successfully");
    bookDAO.create(book);
    response.put("book", book);
    return response;
  }
  
  


}
