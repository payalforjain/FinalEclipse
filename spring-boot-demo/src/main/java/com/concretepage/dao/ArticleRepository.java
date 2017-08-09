package com.concretepage.dao;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.concretepage.entity.Article;
import com.concretepage.entity.Book;

public interface ArticleRepository extends MongoRepository<Article, String>
{

}
 