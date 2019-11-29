package com.practice.matrix;

import java.util.Date;

/**
 * @Author: Hiccup
 * @Date: 2019/10/23 6:12 下午
 * 串行算法版本
 */
public class SerialMultiplier {

    public static void multiply (double[][] matrix1, double[][] matrix2, double[][] result) {
        int rows1=matrix1.length;
        int columns1=matrix1[0].length;
        int columns2=matrix2[0].length;
        for (int i=0; i<rows1; i++) {
            for (int j=0; j<columns2; j++) {
                result[i][j]=0;
                for (int k=0; k<columns1; k++) {
                    result[i][j]+=matrix1[i][k]*matrix2[k][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        double matrix1[][] = MatrixGenerator.generate(200, 200);
        double matrix2[][] = MatrixGenerator.generate(200, 200);
        double resultSerial[][]= new double[matrix1.length]
                [matrix2[0].length];
        Date start = new Date();
        SerialMultiplier.multiply(matrix1, matrix2, resultSerial);
        Date end=new Date();
        System.out.printf("Serial: %d%n",end.getTime()-start.getTime());
    }

}
