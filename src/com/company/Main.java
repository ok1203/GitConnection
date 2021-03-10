package com.company;
import java.awt.*;
import java.sql.*;
import java.util.*;
public class Main {

    public static int counterofshots = 64;

    public static Scanner scan = new Scanner(System.in);
    public static int option = 0;

    public static void start(){
        Field player1 = new Field();
        Field player2 = new Field();
        Field player3 = new Field();
        Field player4 = new Field();
        System.out.println("Locate your ships");

        for (int i = 0; i < 1; i++) {
            System.out.println("Input coordinates for 1 cell ship");
            int x, y;
            x = scan.nextInt();
            y = scan.nextInt();
            player1.locate_ship(x, y);
            player4.locate_ship(x, y);
        }
        for (int i = 0; i < 1; i++) {
            System.out.println("Input coordinates for 2 cell ship");
            int x, y;
            x = scan.nextInt();
            y = scan.nextInt();
            int option1 = player1.locate_ship2(x, y);
            player4.locate_ship2(x, y, option1);
        }
        for (int i = 0; i < 1; i++){
            System.out.println("Input coordinates for 3 cell ship");
            int x, y;
            x = scan.nextInt();
            y = scan.nextInt();
            int option1 = player1.locate_ship3(x, y);
            player4.locate_ship3(x, y, option1);
        }


        for (int i = 0; i < 1; i++) {
            int x, y;
            int a = 0, b = 8;
            x = a + (int) (Math.random() * b);
            y = a + (int) (Math.random() * b);
            player2.locate_ship(x, y);
        }
        for (int i = 0; i < 1; i++){
            int x, y;
            int a = 0, b = 8;
            x = a + (int) (Math.random() * b);
            y = a + (int) (Math.random() * b);
            int option1 = 1 + (int) (Math.random() * 2);
            player2.locate_ship2(x, y, option1);
        }
        for (int i = 0; i < 1; i++){
            int x, y;
            int a = 0, b = 8;
            x = a + (int) (Math.random() * b);
            y = a + (int) (Math.random() * b);
            int option1 = 1 + (int) (Math.random() * 2);
            player2.locate_ship3(x, y, option1);
        }

        int countofrightshots1 = 0;
        int countofrightshots2 = 0;



        while (counterofshots >= 0) {

            System.out.println("Your field:");
            player4.draw();
            System.out.println("Opponents field:");
            player3.draw();

            System.out.println("Where will you shot(input coordinates):");
            int x1, y1;
            x1 = scan.nextInt();
            y1 = scan.nextInt();
            if (player2.Field[x1][y1] == "1") {
                System.out.println("you shooted right");
                player3.Field[x1][y1] = "1";
                countofrightshots1++;

            } else {
                System.out.println("you shooted wrong");
                player3.Field[x1][y1] = "X";
            }
            System.out.println("Computer is making a shot");
            while(true) {

                int x2, y2;
                int a = 0, b = 8;
                x2 = a + (int) (Math.random() * b);
                y2 = a + (int) (Math.random() * b);
                if (player4.Field[x2][y2] == "1") {
                    System.out.println(x2 + " " + y2);
                    System.out.println("computer shooted right");
                    player4.Field[x2][y2] = "X";
                    countofrightshots2++;
                    break;
                } else if (player4.Field[x2][y2] == "X") {
                    continue;
                } else {
                    System.out.println(x2 + " " + y2);
                    System.out.println("computer shooted wrong");
                    player4.Field[x2][y2] = "X";
                    break;
                }
            }

            if (countofrightshots1 == 6 || countofrightshots2 == 6) {
                break;
            }

            counterofshots--;
        }

        System.out.println("Your score is " + counterofshots);
        System.out.println("What is your name?");
        scan.nextLine();
        String name = scan.nextLine();
        InsertToDB(name, counterofshots);
    }
    public static void InsertToDB(String name, int score){
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            if (conn != null) {

                Statement stmt = conn.createStatement();
                stmt.executeUpdate("INSERT INTO scoreboard VALUES(" + score + ",'" + name + "');");
                int i = 1;
            } else {
                System.out.println("Ne rabotaet");
            }
        } catch (SQLException e) {
            System.out.println("Qate");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void show(){
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
            if (conn != null) {
                System.out.println("Qosyldy");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * from  scoreboard;");
                int i = 1;
                while (rs.next()) {
                    System.out.println(rs.getInt("score") + "\t"
                            + rs.getString("name"));
                    i++;
                }
                System.out.println(i);
            } else {
                System.out.println("Ne rabotaet");
            }
        } catch (SQLException e) {
            System.out.println("Qate");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Menu();



        while (option != 3){
            System.out.println("Choose the option:");
            System.out.println("1.Start the game");
            System.out.println("2.Scoreboard");
            System.out.println("3.Leave");

            option = scan.nextInt();
            if (option == 1){
                start();
            }
            else if(option == 2){
                show();
            }
        }


        }
    }

