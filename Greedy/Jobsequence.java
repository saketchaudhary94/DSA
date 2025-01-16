package Greedy;
import java.util.*;

public class Jobsequence {

    static class Job{
        int deadline;
        int profit;
        int id;

        public Job(int d , int p , int i){
            this.deadline = d;
            this.profit = p;
            this.id = i;
        }
    }
    public static void main(String[] args) {
        int jobInfo[][] = {{4,20} , {1,10} , {1,40} , {1,30}};

        ArrayList<Job> jobs = new ArrayList<>();
        for(int i =0;i<jobInfo.length;i++){
            jobs.add(new Job(jobInfo[i][0] , jobInfo[i][1] , i));
        }

        Collections.sort(jobs , (a,b)-> b.profit- a.profit);
        ArrayList<Integer> list = new ArrayList<>();
        int time = 0;
        int profit = 0;

        for(int i =0;i<jobs.size();i++){
            if(jobs.get(i).deadline > time){
                time++;
                list.add(jobs.get(i).id);
                profit += jobs.get(i).profit;
            }
        }
        System.out.println("max jobs = "+ list.size());
        System.out.println(profit);
    }
}
