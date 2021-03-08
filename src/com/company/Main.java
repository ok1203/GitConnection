package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        int counterofshots = 0;
        Field player1 = new Field();
        Field player2 = new Field();
        Field player3 = new Field();
        Field player4 = new Field();
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 6; i++){
            int x , y;
            x = scan.nextInt();
            y = scan.nextInt();
            player1.locate_ship(x, y);
            player4.locate_ship(x, y);
        }

        for (int i = 0; i < 6; i++){
            int x , y;
            int a = 0, b = 8;
            x = a + (int) (Math.random() * b);
            y = a + (int) (Math.random() * b);
            player2.locate_ship(x, y);

        }

        while (counterofshots<64){
            int countofrightshots1 = 0;
            int countofrightshots2 = 0;
            System.out.println("Your field Omar Pidor:");
            for (int i = 0; i < 8; i++){
                for (int j = 0; j < 8; j++){
                    System.out.print(player1.Field[i][j]);
                }
                System.out.println(" ");
            }
            System.out.println("Opponents field:");
            for (int i = 0; i < 8; i++){
                for (int j = 0; j < 8; j++){
                    System.out.print(player3.Field[i][j]);
                }
                System.out.println(" ");
            }

            System.out.println("Where will you shot(input coordinates):");
            int x1 , y1;
            x1 = scan.nextInt();
            y1 = scan.nextInt();
            if (player2.Field[x1][y1] == "1") {
                System.out.println("you shooted right");
                player3.Field[x1][y1] = "1";
                countofrightshots1++;

            }else{
                System.out.println("you shooted wrong");
            }

            System.out.println("Computer is making a shot");
            int x2 , y2;
            int a = 0, b = 8;
            x2 = a + (int) (Math.random() * b);
            y2 = a + (int) (Math.random() * b);
            if (player1.Field[x2][y2] == "1") {
                System.out.println("computer shooted right");
                player4.Field[x1][y1] = "1";
                countofrightshots2++;
            }else{
                System.out.println("computer shooted wrong");
            }

            if (countofrightshots1 == 6 || countofrightshots2 == 6){
                break;
            }

        }
        // write your code here
        /*

        /*for(int i = 0 ; i < 3; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(i == x && j ==y) {
                    System.out.print("x ");
                }
                else{
                    System.out.print("o ");
                }
            }
            System.out.println("\n");
        }*/
    }
}
