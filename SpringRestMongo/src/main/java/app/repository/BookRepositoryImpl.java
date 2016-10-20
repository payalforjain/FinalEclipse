package app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.Book;

public interface BookRepositoryImpl extends MongoRepository<Book, String>, CustomRepository{

}
