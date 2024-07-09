package Daily;

import java.util.ArrayList;

public class LC1701 {


    //Coded by me Naive
    public double averageWaitingTime(int[][] customers) {
        double waitTime = 0;
        int prevStart = customers[0][0];
        for(int[] a:customers){
            int arrival = a[0];
            int prepTime = a[1];
            if(arrival>prevStart){
                prevStart = arrival;
            }
            int chefTimer = prevStart+prepTime;
            prevStart = chefTimer;
            waitTime += chefTimer-arrival;
            System.out.println(chefTimer-arrival);
        }
        return waitTime/customers.length;
    }

    //Slightly optimal my soln not bad
    public double averageWaitingTimeOptimal(int[][] customers) {
        double waitTime = 0;
        int availableAt = 0;
        for(int[] a:customers){
            int arrival = a[0];
            int prepTime = a[1];
            int avialableAt = Math.max(arrival,availableAt)+prepTime;
            waitTime += availableAt-arrival;
        }
        return waitTime/customers.length;
    }


}
