package com.ll;

import com.ll.db.DBConnection;

import java.util.Scanner;

public class Container {

    private static Scanner scanner = null;
    private static DBConnection dbConnection = null;

    public static void init() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        scanner = new Scanner(System.in);
    }
    public static void close() {
        scanner.close();
    }
    public static Scanner getScanner() {
        return scanner;
    }

    public static DBConnection getDbConnection() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }


}
