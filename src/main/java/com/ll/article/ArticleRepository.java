package com.ll.article;

import com.ll.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class ArticleRepository {

    public ArticleRepository() {}

    public String create(String subject, String content) {
        String query = String.format("insert into article set subject='%s', content='%s'", subject, content);
        int id = Container.getDbConnection().insert(query);
        return String.valueOf(id);
    }

    public Boolean remove(String id) {
        Article article = this.findById(id);
        if (article != null) {
            String query = String.format("delete from article where id='%s'", id);
            int row = Container.getDbConnection().delete(query);
            return (row == 1);
        }
        return false;
    }

    public Boolean remove(Article article) {
        return this.remove(article.getId());
    }

    public Boolean modify(String id, String subject, String content) {
        String query = String.format("update  article set subject='%s', content='%s' where id=%d",
                subject, content, Integer.valueOf(id));
        int row = Container.getDbConnection().update(query);
        return (row == 1);
    }

    public Boolean modify(Article article, String subject, String content) {
        return this.modify(article.getId(), subject, content);
    }

    public List<Article> findAll() {
        List<Article> articles = new ArrayList<>();
        String query = "select * from article";
        List<Map<String, Object>>  rows = Container.getDbConnection().selectRows(query);
        for (Map<String, Object> row : rows) {
            Article article = new Article(row);
            articles.add(article);
        }
        return articles;
    }

    public Article findById(String id) {
        Article article = null;
        String query = String.format("select * from article where id=%d", Integer.valueOf(id));
        Map<String, Object> row = Container.getDbConnection().selectRow(query);
        if (row != null) {
            article = new Article();
            article.setId(row.get("id").toString());
            article.setSubject(row.get("subject").toString());
            article.setContent(row.get("content").toString());
        }
        return article;
    }

    public boolean isEmpty() {
        String query = "select count(*) from article";
        Map<String, Object> row = Container.getDbConnection().selectRow(query);
        return (row.size() == 0);
    }
}
