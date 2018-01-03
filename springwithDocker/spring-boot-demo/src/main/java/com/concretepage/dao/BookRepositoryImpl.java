package com.concretepage.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.concretepage.entity.Book;

public interface BookRepositoryImpl extends MongoRepository<Book, String>, CustomRepository{

}
