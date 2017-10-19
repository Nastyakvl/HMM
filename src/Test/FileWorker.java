package Test;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Nastya on 19.10.2017.
 */
public class FileWorker {
    public static void main(String[] args) {

        DataInputStream input;
        Scanner sc;
        int N;//amount of rows
        int M;//amount of columns

        try {
            sc = new Scanner(new FileInputStream("a"));
            N=sc.nextInt();
            M=sc.nextInt();

            double[][] a = new double[M][N];



           // System.out.println("Enter your Age :\n");

          for(int i=0;i<M;i++)
              for(int j=0;j<N;j++) {
                  a[i][j] = sc.nextDouble();
                  System.out.println(a[i][j]);
              }
            System.out.println();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
