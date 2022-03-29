
package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int width=16+1;
        final int height=16+1;
        //Создание пустого поля
        int [][] field_squares=new int[width][height];
        for (int row = 0; row < width; row++) {
            for (int colume = 0; colume < height; colume++) {
                field_squares[row][colume]=0;
            }
        }

        final int number_mine=40;
        int counter_number_mine=0;
        Random random=new Random();
//Создание поля с минами
        for (int row = 0; row < width; row++) {
            for (int colume = 0; colume < height; colume++) {
                if (random.nextInt(8) == 0 && counter_number_mine < number_mine) {
                    field_squares[row][colume] =9;
                    counter_number_mine++;
                }
            }
        }
        //Создание границы поля
        for (int row = 0; row < width; row++) {
            for (int colume = 0; colume < height; colume++) {
                if(row==0){
                    field_squares[row][colume]=10;
                }
                if(row==width-1){
                    field_squares[row][colume]=10;

                }
                if(colume==0){
                    field_squares[row][colume]=10;
                }
                if(colume==height-1){
                    field_squares[row][colume]=10;
                }
            }
        }
        // Раставление чисел в соотвествии с количеством мин возле ячейки
        for (int row = 1; row <= width-2; row++) {
            for (int colume = 1; colume <= height-2; colume++) {
                if(field_squares[row][colume]!=9){
                    int number_in_cell=0;
                    if(field_squares[row+1][colume]==9) {
                        number_in_cell++;
                    }
                    if(field_squares[row][colume+1]==9){
                        number_in_cell++;
                    }
                    if(field_squares[row-1][colume]==9){
                        number_in_cell++;
                    }if(field_squares[row][colume-1]==9){
                        number_in_cell++;
                    }if(field_squares[row+1][colume+1]==9){
                        number_in_cell++;
                    }if(field_squares[row-1][colume-1]==9){
                        number_in_cell++;
                    }if(field_squares[row-1][colume+1]==9){
                        number_in_cell++;
                    }if(field_squares[row+1][colume-1]==9){
                        number_in_cell++;
                    }
                    field_squares[row][colume] = number_in_cell;
                }
            }
        }
//Вывод всего поля
        for (int row = 0; row < width; row++) {
            for (int colume = 0; colume < height; colume++) {
                if (field_squares[row][colume] == 10) {
                    System.out.print("\u2B52" + " ");
                }
                if (field_squares[row][colume] == 9) {
                    System.out.print("\u2690" + " ");
                }
                if (field_squares[row][colume] == 0) {
                    System.out.print("\uD835\uDFEC" + " ");
                }
                if (field_squares[row][colume] == 1) {
                    System.out.print("\uD835\uDFED" + " ");
                }
                if (field_squares[row][colume] == 2) {
                    System.out.print("\uD835\uDFEE" + " ");
                }
                if (field_squares[row][colume] == 3) {
                    System.out.print("\uD835\uDFEF" + " ");
                }
                if (field_squares[row][colume] == 4) {
                    System.out.print("\uD835\uDFF0" + " ");
                }
                if (field_squares[row][colume] == 5) {
                    System.out.print("\uD835\uDFF1" + " ");
                }
                if (field_squares[row][colume] == 6) {
                    System.out.print("\uD835\uDFF2" + " ");
                }
                if (field_squares[row][colume] == 7) {
                    System.out.print("\uD835\uDFF3" + " ");
                }
                if (field_squares[row][colume] == 8) {
                    System.out.print("\uD835\uDFF4" + " ");
                }
            }
            System.out.printf("\n");
        }
    }
}
