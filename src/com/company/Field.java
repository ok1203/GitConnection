package com.company;

import java.util.Scanner;

public class Field {
    Scanner scan = new Scanner(System.in);
    public String Field[][] = new String[8][8];
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

    public void SetField(){

    }

}