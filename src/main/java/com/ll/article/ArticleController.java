package com.ll.article;

import com.ll.Container;
import com.ll.Request;

import java.util.List;

import static java.lang.System.out;

public class ArticleController {

    private ArticleService articleService;

    public ArticleController() {
        this.articleService = new ArticleService();
    }

    public void write() {
        out.print("제목 : ");
        String subject = Container.getScanner().nextLine().trim();
        out.print("내용 : ");
        String content = Container.getScanner().nextLine().trim();

        String id = this.articleService.create(subject, content);
        if (id != null) {
            out.printf("%s번 게시물이 등록되었습니다..", id);
        } else {
            out.printf("%s번 게시물이 등록되지 않았습니다.", id);
        }

        out.print("\n");
    }

    public void update(Request request) {
        if (this.articleService.isEmpty()) {
            out.print("등록된 계시물이 없습니다.\n");
            return;
        }

        String id = request.getParam("id");
        if (id != null && !id.equals("")) {
            Article article = this.articleService.findById(id);
            if (article != null) {
                out.printf("제목(기존) : %s\n", article.getSubject());
                out.print("제목 :");
                String subject = Container.getScanner().nextLine();
                out.printf("내용(기존) : %s\n", article.getContent());
                out.print("내용:");
                String content = Container.getScanner().nextLine();

                if (this.articleService.modify(article, subject, content))
                    out.printf("%s번 게시물이 변경되었습니다.", id);
                else
                    out.printf("%s번 게시물이 변경되지 않았습니다.", id);

            } else {
                out.printf("%s번 게시물이 등록되어 있지 않습니다..", id);
            }
        }

        out.print("\n");
    }

    public void delete(Request request) {
        if (this.articleService.isEmpty()) {
            out.print("등록된 계시물이 없습니다.\n");
            return;
        }

        String id = request.getParam("id");
        if (id != null && !id.equals("")) {
            if (this.articleService.remove(id)) {
                out.printf("%s번 게시물이 삭제 되었습니다.", id);
            } else {
                out.printf("%s번 게시물이 등록되어 있지 않습니다..", id);
            }
        }

        out.print("\n");
    }

    public void list() {
        List<Article> articles = this.articleService.findAll().reversed();
        if (articles.isEmpty()) {
            out.print("등록된 계시물이 없습니다.\n");
            return;
        }

        for (Article article : articles) {
            String id = article.getId();
            String subject = article.getSubject();
            String content = article.getContent();
            out.printf("%s / %s /%s\n", id, subject, content);
        }

        out.print("\n");
    }
}

