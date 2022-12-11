package com.sustech.service_education;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = 0;
        for (int i = 0; i < 2000; i++) {
            int x = i;

            if (x % 4 == 0 && x % 100 != 0 || x % 400 == 0){
                count++;
                System.out.println("yes");
                int distance_1 = (1999 - x) * 365 + (1999 - x) / 4 + 306  + (2000 - x) / 400 + 1 - (2000 - x) / 100;

                int distance_correct = 0;
                for (int j = x; j < 2000; j++) {
                    distance_correct += 365;
                    if ((j % 4 == 0 && j % 100 != 0) || (j % 400 == 0)){
                        distance_correct ++;
                    }
                }
                distance_correct -= 59;

                System.out.println(distance_1 +  " || " + distance_correct);

            }
            else {
                System.out.println("no");
            }
        }

        System.out.println(count);
    }
}
