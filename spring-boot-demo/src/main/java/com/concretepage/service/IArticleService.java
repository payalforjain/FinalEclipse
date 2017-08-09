package com.concretepage.service;

import java.util.List;

import com.concretepage.entity.Article;

public interface IArticleService {
     List<Article> getAllArticles();
     Article getArticleById(String articleId);
     boolean createArticle(Article article);
     void updateArticle(Article article);
     void deleteArticle(String articleId);
}
