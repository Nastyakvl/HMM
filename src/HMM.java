import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Nastya on 17.10.2017.
 */
public class HMM<T> {

    private double[][] A;//transition probability matrix
    private double[][] B;//observations likelihoods
    int state; //current state 0-start, 1-Hot, 2-Cold
    T[] obs;

    public HMM(double[][] A, double[][] B, T[] obs) {
        this.A=A;
        this.B=B;
        state=1;
        this.obs=obs;

    }

    public void next(){
        Random random = new Random();
        double rnd = random.nextGaussian();
        //double rnd;
        double[] ps=new double[A.length];


        //prefix summ
        for(int k=0;k<ps.length;k++) {
            if(A[state][k]==0)
                ps[k]=0;
            else {
                for (int l = 0; l <= k; l++)
                    ps[k] = ps[k] + A[state][l];
            }
        }

        boolean flag=false;
       // rnd = Math.random();

        while(!flag) {

            int k = 0;
           for(k=0; k<ps.length && !flag;k++)
               if (rnd<ps[k] && ps[k]!=0){
                   state=k;
                   flag=true;
               }

            if(!flag)
                rnd = random.nextGaussian();
               // rnd=Math.random();

        }
        System.out.println("State: " + state);
    }

    public T observe(){
        Random random = new Random();
        double rnd = random.nextGaussian();
       // double rnd;
        double[] ps=new double[B.length];


        //prefix summ
        //state-1 because there is no start state
        for(int k=0;k<ps.length;k++) {
            if(B[k][state-1]==0)
                ps[k]=0;
            else {
                for (int l = 0; l <= k; l++)
                    ps[k] = ps[k] + B[l][state-1];
            }
        }

       // boolean flag=false;
        rnd = Math.random();
        int i=-1;

        while(i<0) {

            int k = 0;
            for(k=0; k<ps.length && i<0;k++)
                if (rnd<ps[k] && ps[k]!=0){
                    i=k;
                                    }

            if(i<0)
                rnd = random.nextGaussian();
                //rnd=Math.random();

        }
            return obs[i];
    }

    public int getState(){
        return state;
    }

    public void setState(int k){
        state=k;
    }
}
