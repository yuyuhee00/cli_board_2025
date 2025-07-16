package com.ll.article;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class ArticleService {

    List<Article> articles = new ArrayList<>();

    public ArticleService() {}

    public String create(String subject, String content) {
        Article article = new Article(String.valueOf(this.articles.size()+1), subject, content);
        this.articles.add(article);
        return article.getId();
    }

    public Boolean remove(String id) {
        Article article = this.getFindById(id);
        if (article != null) {
            this.articles.remove(article);
            return true;
        }
        return false;
    }

    public Boolean remove(Article article) {
        if (this.articles.contains(article)) {
            this.articles.remove(article);
            return true;
        }
        return false;
    }

    public Boolean modify(String id, String subject, String content) {
        Article article = this.getFindById(id);
        if (article != null) {
            article.setSubject(subject);
            article.setContent(content);
            return true;
        }

        return false;
    }

    public Boolean modify(Article article, String subject, String content) {
        if (article != null) {
            article.setSubject(subject);
            article.setContent(content);
            return true;
        }

        return false;
    }

    public List<Article> findAll() {
        return this.articles;
    }

    public Article getFindById(String id) {
        for (Article article : this.articles) {
            if (article.getId().equals(id)) {
                return article;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        if (this.articles.isEmpty()) {
            out.println("게시물이 없습니다.");
            return true;
        }
        return false;
    }
}
