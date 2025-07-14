package com.example;

import java.util.*;

import static java.lang.System.out;

public class APP {

    Scanner scanner;

    public APP(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        List<Article> bbs = new ArrayList<>();
        String cmd = "";
        out.println("== 게시판 앱 ==");
        while (! cmd.equals("종료")) {
            out.print("명령 : ");
            try {
                cmd = this.scanner.nextLine();
                doJob(this.scanner, cmd, bbs);
                //scanner.nextLine();
            } catch (InputMismatchException e) {
                out.println("입력 에러..");
                this.scanner.nextLine();
            }
        }
    }

    private void doJob(Scanner scanner, String cmd, List<Article> bbs) {
        if (cmd.equals("등록")) {
            insertBbs(bbs);

        } else if (cmd.equals("목록")) {
            displayBbs(bbs);
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
                                    updateBbs(id, bbs);
                                else if (cmd.startsWith("삭제"))
                                deleteBbs(id, bbs);
                            }
                        }
                    }
                }
            }
        }
    }

    private void insertBbs(List<Article> bbs) {
        out.print("제목 : ");
        String subject = scanner.nextLine();
        out.print("내용 : ");
        String content = scanner.nextLine();
        Article article = new Article(String.valueOf(bbs.size()+1), subject, content);
        bbs.add(article);
        out.printf("%d번 게시물이 등록 되었습니다.\n\n", bbs.size());
    }

    private void updateBbs(String id, List<Article> bbs) {
        if (bbs.isEmpty()) {
            out.println("게시물이 없습니다.");
            return;
        }

        Article article = findById(id, bbs);
        if (article != null) {
            out.printf("제목(기존) : %s\n", article.getSubject());
            out.print("제목 :");
            String subject = scanner.nextLine();
            out.printf("내용(기존) : %s\n", article.getContent());
            out.print("내용:");
            String content = scanner.nextLine();

            article.setSubject(subject);
            article.setContent(content);
        } else {
            out.printf("%s번 게시물이 등록되어 있지 않습니다..\n\n", id);
        }

        out.println();
    }

    private void deleteBbs(String id, List<Article> bbs) {
        if (bbs.isEmpty()) {
            out.println("게시물이 없습니다.");
            return;
        }

        Article article = findById(id, bbs);
        if (article != null) {
            bbs.remove(article);
            out.printf("%s번 게시물이 삭제 되었습니다.\n\n", id);
        } else {
            out.printf("%s번 게시물이 등록되어 있지 않습니다..\n\n", id);
        }
    }

    private void displayBbs(List<Article> bbs) {
        if (bbs.isEmpty()) {
            out.println("게시물이 없습니다.");
            return;
        }

        for (Article article : bbs.reversed()) {
            String id = article.getId();
            String subject = article.getSubject();
            String content = article.getContent();
            out.printf("%s / %s /%s\n", id, subject, content);
        }

        out.println();
    }

    private Article findById(String id, List<Article> bbs) {
        for (Article article : bbs) {
            if (article.getId().equals(id)) {
                return article;
            }
        }
        return null;
    }
}
