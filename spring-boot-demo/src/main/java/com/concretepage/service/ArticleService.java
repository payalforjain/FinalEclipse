package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.ArticleRepository;
import com.concretepage.entity.Article;
@Service
public class ArticleService implements IArticleService {
	@Autowired
	private ArticleRepository articleRepository;
	@Override
	public Article getArticleById(String articleId) {
		Article obj = articleRepository.findOne(""+articleId);
		
		return obj;
	}	
	@Override
	public List<Article> getAllArticles(){
		return articleRepository.findAll();
		
	}
	@Override
	public boolean createArticle(Article article){
		
		articleRepository.save(article);
		
		return true;
	}
	@Override
	public void updateArticle(Article article) {
	articleRepository.save(article);
		
	}
	@Override
	public void deleteArticle(String articleId) {

		articleRepository.delete(articleId);
	}
}
