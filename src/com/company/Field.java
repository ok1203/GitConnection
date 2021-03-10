package com.company;

import java.util.Scanner;

public class Field {
    Scanner scan = new Scanner(System.in);
    protected String Field[][] = new String[8][8];
    public Field(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                Field[i][j] = "0";
            }
        }
    }

    public void locate_ship(int x, int y){
        Field[y][x] = "1";
    }

    public int locate_ship2(int x, int y){
        int option = 0;
        System.out.println("How do you want to locate ships:");
        System.out.println("1. --");
        System.out.println("2. |");
        System.out.println("   |");
        option = scan.nextInt();

        if (option == 2){
            if (y == 7){
                Field[y][x] = "1";
                Field[y-1][x] = "1";
            }else{
                Field[y][x] = "1";
                Field[y+1][x] = "1";
            }
        } else {
            if (x == 7){
                Field[y][x-1] = "1";
                Field[y][x] = "1";
            }else{
                Field[y][x] = "1";
                Field[y][x+1] = "1";
            }
        }
    return option;

    }

    public void locate_ship2(int x, int y, int option){
        if (option == 2){
            if (y == 7){
                Field[y][x] = "1";
                Field[y-1][x] = "1";
            }else{
                Field[y][x] = "1";
                Field[y+1][x] = "1";
            }
        } else {
            if (x == 7){
                Field[y][x-1] = "1";
                Field[y][x] = "1";
            }else{
                Field[y][x] = "1";
                Field[y][x+1] = "1";
            }
        }
    }

    public int locate_ship3(int x, int y){
        int option = 0;
        System.out.println("How do you want to locate ships:");
        System.out.println("1. ---");
        System.out.println("2. |");
        System.out.println("   |");
        System.out.println("   |");
        option = scan.nextInt();

        if (option == 2){
            if (y == 7){
                Field[y][x] = "1";
                Field[y-1][x] = "1";
                Field[y-2][x] = "1";
            }else if (y == 6){
                Field[y+1][x] = "1";
                Field[y][x] = "1";
                Field[y-1][x] = "1";
            }else{
                Field[y][x] = "1";
                Field[y+1][x] = "1";
                Field[y+2][x] = "1";
            }
        } else {
            if (x == 7){
                Field[y][x-2] = "1";
                Field[y][x-1] = "1";
                Field[y][x] = "1";
            }else if (x == 6){
                Field[y][x-1] = "1";
                Field[y][x] = "1";
                Field[y][x+1] = "1";
            }else{
                Field[y][x] = "1";
                Field[y][x+1] = "1";
                Field[y][x+2] = "1";
            }
        }
        return option;

    }

    public void locate_ship3(int x, int y, int option){
        if (option == 2){
            if (y == 7){
                Field[y][x] = "1";
                Field[y-1][x] = "1";
                Field[y-2][x] = "1";
            }else if (y == 6){
                Field[y+1][x] = "1";
                Field[y][x] = "1";
                Field[y-1][x] = "1";
            }else{
                Field[y][x] = "1";
                Field[y+1][x] = "1";
                Field[y+2][x] = "1";
            }
        } else {
            if (x == 7){
                Field[y][x-2] = "1";
                Field[y][x-1] = "1";
                Field[y][x] = "1";
            }else if (x == 6){
                Field[y][x-1] = "1";
                Field[y][x] = "1";
                Field[y][x+1] = "1";
            }else{
                Field[y][x] = "1";
                Field[y][x+1] = "1";
                Field[y][x+2] = "1";
            }
        }
    }

    public void draw(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                System.out.print(this.Field[i][j]);
            }
            System.out.println(" ");
        }
    }

    public void SetField(){

    }

}
