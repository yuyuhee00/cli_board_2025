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
            out.print("제목 : ");
            String subject = scanner.nextLine();
            out.print("내용 : ");
            String content = scanner.nextLine();
            Article article = new Article(String.valueOf(bbs.size()+1), subject, content);
            bbs.add(article);
            out.printf("%d번 게시물이 등록 되었습니다.\n\n", bbs.size());

        } else if (cmd.equals("목록")) {
            displayBbs(bbs);
        }
    }

    private void displayBbs(List<Article> bbs) {
        if (bbs.isEmpty()) {
            out.println("게시물이 없습니다.");
            return;
        }

//        Iterator<Article> iterator = bbs.iterator();
//        while (iterator.hasNext()) {
//            Article article = iterator.next();
//            String id = article.getId();
//            String subject = article.getSubject();
//            String content = article.getContent();
//            out.printf("No. %s\n", id);
//            out.printf("제목 : %s\n", subject);
//            out.printf("내용 : %s\n", content);
//        }

        for (Article article : bbs) {
            String id = article.getId();
            String subject = article.getSubject();
            String content = article.getContent();
            out.printf("No. %s\n", id);
            out.printf("제목 : %s\n", subject);
            out.printf("내용 : %s\n", content);
        }

        out.println();
    }
}
