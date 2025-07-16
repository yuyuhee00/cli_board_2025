package com.ll.article;

import java.util.Map;

public class Article {
    String id;
    String subject;
    String content;

    public Article() {}
    public Article(String id, String subject, String content) {
        this.id = id;
        this.subject = subject;
        this.content = content;
    }
    public Article(Map<String, Object> row) {
        this.id = String.valueOf(row.get("id"));
        this.subject = (String) row.get("subject");
        this.content = (String) row.get("content");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
