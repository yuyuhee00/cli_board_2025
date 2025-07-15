package com.ll;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        Container.init();

        (new APP()).run();

        Container.close();
    }
}