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

        } else if (cmd.equals("수정")) {
            out.print("번호 : ");
            String id = scanner.nextLine();
            updateBbs(id, bbs);

        } else if (cmd.equals("삭제")) {
            out.print("번호 : ");
            String id = scanner.nextLine();
            deleteBbs(id, bbs);
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
            out.printf("제목 : %s", article.getSubject());
            out.print("===> :");
            String subject = scanner.nextLine();
            out.printf("제목 수정 후 : %s\n", subject);

            out.printf("내용 : %s", article.getContent());
            out.print("===> :");
            String content = scanner.nextLine();
            out.printf("내용 수정 후 : %s\n", content);

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

        for (Article article : bbs) {
            String id = article.getId();
            String subject = article.getSubject();
            String content = article.getContent();
//            out.printf("No. %s\n", id);
//            out.printf("제목 : %s\n", subject);
//            out.printf("내용 : %s\n", content);
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
