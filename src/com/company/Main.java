package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        // write your code here
        int x , y;
        Scanner scan = new Scanner(System.in);
        x = scan.nextInt();
        y = scan.nextInt();
        for(int i = 0 ; i < 3; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(i == x && j ==y) {
                    System.out.print("x ");
                }
                else{
                    System.out.print("o ");
                }
            }
            System.out.println("\n");
        }
    }
}
