package com.example;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.out;


public class Main {

    private static void doJob() {

//        out.println("종료");
//        out.println("==게시판 앱==");
        out.println("doJob()");
    }

    private static void intInput() {

        Scanner scanner = new Scanner(System.in);
        int input = 1;

        out.println("== 게시판 앱 ==");

        while (input != 0) {

            out.printf("입력 : ");

            try {
                input = scanner.nextInt();
                out.printf("입력된 문자열 : %d\n", input);

                doJob();

//                 scanner.nextInt();
            } catch (InputMismatchException e) {
                out.println("입력 에러..");
                scanner.nextInt();
            }
        }
        scanner.close();
    }

    private static void stringInput() {

        Scanner scanner = new Scanner(System.in);
        String input = "";

        out.println("== 게시판 앱 ==");

        while (! input.equals("종료")) {

            out.printf("명령 : ");

            try {
                input = scanner.nextLine();
                out.printf("입력된 문자열 : %s\n", input);

                doJob();

                // scanner.nextLine();
            } catch (InputMismatchException e) {
                out.println("입력 에러..");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {

        Main.intInput();
//        Main.stringInput();

    }
}