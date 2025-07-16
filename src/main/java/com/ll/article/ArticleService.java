package com.ll.article;

import java.util.List;

public class ArticleService {

    private ArticleRepository articleRepository;

    public ArticleService() {
        this.articleRepository = new ArticleRepository();
    }

    public String create(String subject, String content) {
        return this.articleRepository.create(subject, content);
    }

    public Boolean remove(String id) {
        return this.articleRepository.remove(id);
    }

    public Boolean remove(Article article) {
        return this.articleRepository.remove(article);
    }

    public Boolean modify(String id, String subject, String content) {
        return this.articleRepository.modify(id, subject, content);
    }

    public Boolean modify(Article article, String subject, String content) {
        return this.articleRepository.modify(article, subject, content);
    }

    public List<Article> findAll() {
        return this.articleRepository.findAll();
    }

    public Article findById(String id) {
        return this.articleRepository.findById(id);
    }

    public boolean isEmpty() {
        return this.articleRepository.isEmpty();
    }
}
