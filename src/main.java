import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nastya on 12.10.2017.
 */
public class main {
    public static void main(String[] args) {
        Scanner sc;
        int N;//amount of states(rows and columns)
        int K;//amount of observations
        String obs[];//enum of observation
        double[][] a;//transition probability matrix
        double[][] b;//observations likelihoods
        double[] pi;////initial probability distribution

        String filepi=args[0];
        String fileA=args[1];
        String fileB=args[2];
        int count=Integer.parseInt(args[3]);



        try {

            sc = new Scanner(new FileInputStream(filepi));
            N = sc.nextInt();
            pi = new double[N];
            for (int i = 0; i < N; i++)
                pi[i] = sc.nextDouble();

            sc = new Scanner(new FileInputStream(fileA));
            a = new double[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    a[i][j] = sc.nextDouble();


            sc = new Scanner(new FileInputStream(fileB));
            K = sc.nextInt();
            obs=new String[K];
            for(int i=0;i<K;i++)
                obs[i]=sc.next();


            b = new double[K][N];
            for (int i = 0; i < K; i++)
                for (int j = 0; j < N; j++)
                    b[i][j] = sc.nextDouble();




            HMM<String> hmm = new HMM(a, b, pi,obs);
            hmm.start();
            System.out.println("Observation: " +hmm.observe());


            //FileWriter writer1= new FileWriter("dataState1.txt",false);
            //FileWriter writer2= new FileWriter("dataState2.txt",false);
            for (int i = 0; i < count; i++) {
                hmm.next();
                String observation=hmm.observe();
                System.out.println("Observation: " + observation);
               /* int k=Arrays.asList(obs).indexOf(observation)+1;
                if(hmm.getState()==0)
                   writer1.append(""+k+";");
                else if(hmm.getState()==1)writer2.append(""+k+";");*/

            }

          //  writer1.flush();
           // writer2.flush();



        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
