import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Nastya on 12.10.2017.
 */
public class main {
    public static void main(String[] args) {
        Scanner sc;
        int N;//amount of rows
        int M;//amount of columns
        int K;//amount of observations
        String obs[];//enum of observation
        double[][] a;//transition probability matrix
        double[][] b;//observations likelihoods


        try {
            sc = new Scanner(new FileInputStream("a"));
            N = sc.nextInt();
            M = sc.nextInt();

            a = new double[M][N];
            for (int i = 0; i < M; i++)
                for (int j = 0; j < N; j++)
                    a[i][j] = sc.nextDouble();


            sc = new Scanner(new FileInputStream("b"));
            K = sc.nextInt();
            obs=new String[K];
            for(int i=0;i<K;i++)
                obs[i]=sc.next();


            b = new double[K][N-1];
            for (int i = 0; i < K; i++)
                for (int j = 0; j < N-1; j++)
                    b[i][j] = sc.nextDouble();

            int count = 10;

            HMM<String> hmm = new HMM(a, b, obs);

            for (int i = 0; i < count; i++) {
                hmm.next();
                System.out.println("Observation: " + hmm.observe());
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
