package article;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class ArticleController {

    Scanner scanner;
    List<Article> articles = new ArrayList<>();

    public ArticleController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void add() {
        out.print("제목 : ");
        String subject = this.scanner.nextLine();
        out.print("내용 : ");
        String content = this.scanner.nextLine();
        Article article = new Article(String.valueOf(this.articles.size()+1), subject, content);
        this.articles.add(article);
        out.printf("%d번 게시물이 등록 되었습니다.\n\n", this.articles.size());
    }

    public void update(String cmd) {
        if (emptyThenReturn()) return;
        if (cmd.contains("?")) {
            String[] cmdList = cmd.split("\\?", 2);
            if (cmdList.length == 2) {
                String[] params = cmdList[1].split("=", 2);
                if (params.length == 2 && params[0].equals("id")) {
                    String id = params[1].trim();
                    if (!id.equals("")) {
                        Article article = findById(id);
                        if (article != null) {
                            out.printf("제목(기존) : %s\n", article.getSubject());
                            out.print("제목 :");
                            String subject = scanner.nextLine();
                            out.printf("내용(기존) : %s\n", article.getContent());
                            out.print("내용:");
                            String content = scanner.nextLine();

                            if (subject != null)
                                article.setSubject(subject);
                            if (content != null)
                                article.setContent(content);
                        } else {
                            out.printf("%s번 게시물이 등록되어 있지 않습니다..\n\n", id);
                        }
                        out.println();
                    }
                }
            }
        }
    }

    public void delete(String cmd) {
        if (emptyThenReturn()) return;
        if (cmd.contains("?")) {
            String[] cmdList = cmd.split("\\?", 2);
            if (cmdList.length == 2) {
                String[] params = cmdList[1].split("=", 2);
                if (params.length == 2 && params[0].equals("id")) {
                    String id = params[1].trim();
                    if (!id.equals("")) {
                        Article article = findById(id);
                        if (article != null) {
                            this.articles.remove(article);
                            out.printf("%s번 게시물이 삭제 되었습니다.\n\n", id);
                        } else {
                            out.printf("%s번 게시물이 등록되어 있지 않습니다..\n\n", id);
                        }
                        out.println();
                    }
                }
            }
        }
    }

    public void list() {
        if (emptyThenReturn()) return;

        for (Article article : this.articles.reversed()) {
            String id = article.getId();
            String subject = article.getSubject();
            String content = article.getContent();
            out.printf("%s / %s /%s\n", id, subject, content);
        }

        out.println();
    }

    private Article findById(String id) {
        for (Article article : this.articles) {
            if (article.getId().equals(id)) {
                return article;
            }
        }
        return null;
    }

    private boolean emptyThenReturn() {
        if (this.articles.isEmpty()) {
            out.println("게시물이 없습니다.");
            return true;
        }
        return false;
    }
}

