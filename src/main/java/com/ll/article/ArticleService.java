package com.ll.article;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

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

    public Article getFindById(String id) {
        return this.articleRepository.getFindById(id);
    }

    public boolean isEmpty() {
        return this.articleRepository.isEmpty();
    }
}
