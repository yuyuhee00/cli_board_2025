package com.example;

import java.util.*;

import static java.lang.System.out;

public class APP {

    Scanner scanner;

    public APP(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        SequencedMap<String, String> bbs = new LinkedHashMap<>();
        String cmd = "";
        out.println("== 게시판 앱 ==");
        while (! cmd.equals("종료")) {
            out.print("명령 : ");
            try {
                cmd = this.scanner.nextLine();
                if (doJob(this.scanner, cmd, bbs))
                    displayBbs(bbs);
                //scanner.nextLine();
            } catch (InputMismatchException e) {
                out.println("입력 에러..");
                this.scanner.nextLine();
            }
        }
    }

    private boolean doJob(Scanner scanner, String cmd, SequencedMap<String, String> bbs) {
        boolean result = false;
        if (cmd.equals("등록")) {
            out.print("제목 : ");
            String key = scanner.nextLine();
            out.print("내용 : ");
            String value = scanner.nextLine();
            bbs.put(key, value);

            out.printf("%d번 게시물이 등록 되었습니다.\n\n", bbs.size());
            result = true;
        }

        return result;
    }

    private void displayBbs(SequencedMap<String, String> bbs) {
        int count = 0;
        if (bbs.isEmpty()) {
            out.println("게시물이 없습니다.");
            return;
        }

        Iterator<String> iterator = bbs.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = bbs.get(key);
            out.printf("No. %d\n", ++count);
            out.printf("제목 : %s\n", key);
            out.printf("내용 : %s\n", value);
        }
        out.println();
    }
}
