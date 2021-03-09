package com.company;
import java.awt.*;
import java.sql.*;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        new Menu();
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


        int counterofshots = 64;
        Field player1 = new Field();
        Field player2 = new Field();
        Field player3 = new Field();
        Field player4 = new Field();
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            int x, y;
            x = scan.nextInt();
            y = scan.nextInt();
            player1.locate_ship(x, y);
            player4.locate_ship(x, y);
        }

        for (int i = 0; i < 6; i++) {
            int x, y;
            int a = 0, b = 8;
            x = a + (int) (Math.random() * b);
            y = a + (int) (Math.random() * b);
            player2.locate_ship(x, y);

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
            int x2, y2;
            int a = 0, b = 8;
            x2 = a + (int) (Math.random() * b);
            y2 = a + (int) (Math.random() * b);
            System.out.println(x2 + " " + y2);
            if (player1.Field[x2][y2] == "1") {
                System.out.println("computer shooted right");
                player4.Field[x2][y2] = "X";
                countofrightshots2++;
            } else {
                System.out.println("computer shooted wrong");
                player4.Field[x2][y2] = "X";
            }

            if (countofrightshots1 == 6 || countofrightshots2 == 6) {
                break;
            }

            counterofshots--;
        }

        System.out.println("Your score is " + counterofshots);

    }
    }

