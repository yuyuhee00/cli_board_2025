package com.example;

import java.util.*;

import static java.lang.System.out;

public class APP {

    Scanner scanner;
    List<Article> bbs;

    public APP(Scanner scanner) {
        this.scanner = scanner;
        this.bbs = new ArrayList<>();
    }

    public void run() {
        String cmd = "";
        out.println("== 게시판 앱 ==");
        while (! cmd.equals("종료")) {
            out.print("명령 : ");
            try {
                cmd = this.scanner.nextLine();
                doJob(this.scanner, cmd);
                //scanner.nextLine();
            } catch (InputMismatchException e) {
                out.println("입력 에러..");
                this.scanner.nextLine();
            }
        }
    }

    private void doJob(Scanner scanner, String cmd) {
        if (cmd.equals("등록")) {
            insertBbs();

        } else if (cmd.equals("목록")) {
            displayBbs();
        }
        else {
            if (cmd.startsWith("수정") || cmd.startsWith("삭제")) {
                if (cmd.contains("?")) {
                    String[] cmdList = cmd.split("\\?", 2);
                    if (cmdList.length == 2) {
                        String[] params = cmdList[1].split("=", 2);
                        if (params.length == 2 && params[0].equals("id")) {
                            String id = params[1].trim();
                            if (!id.equals("")) {
                                if (cmd.startsWith("수정"))
                                    updateBbs(id);
                                else if (cmd.startsWith("삭제"))
                                deleteBbs(id);
                            }
                        }
                    }
                }
            }
        }
    }

    private void insertBbs() {
        out.print("제목 : ");
        String subject = scanner.nextLine();
        out.print("내용 : ");
        String content = scanner.nextLine();
        Article article = new Article(String.valueOf(this.bbs.size()+1), subject, content);
        this.bbs.add(article);
        out.printf("%d번 게시물이 등록 되었습니다.\n\n", this.bbs.size());
    }

    private void updateBbs(String id) {
        if (emptyThenReturn()) return;

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

    private void deleteBbs(String id) {
        if (emptyThenReturn()) return;

        Article article = findById(id);
        if (article != null) {
            this.bbs.remove(article);
            out.printf("%s번 게시물이 삭제 되었습니다.\n\n", id);
        } else {
            out.printf("%s번 게시물이 등록되어 있지 않습니다..\n\n", id);
        }
    }

    private void displayBbs() {
        if (emptyThenReturn()) return;

        for (Article article : this.bbs.reversed()) {
            String id = article.getId();
            String subject = article.getSubject();
            String content = article.getContent();
            out.printf("%s / %s /%s\n", id, subject, content);
        }

        out.println();
    }

    private Article findById(String id) {
        for (Article article : this.bbs) {
            if (article.getId().equals(id)) {
                return article;
            }
        }
        return null;
    }

    private boolean emptyThenReturn() {
        if (this.bbs.isEmpty()) {
            out.println("게시물이 없습니다.");
            return true;
        }
        return false;
    }
}
