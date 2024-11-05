import java.util.*;

public class js2 {
    public static class Job {
        int id;
        int deadline;
        int profit;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void js(Job j[], int md) {
        Arrays.sort(j,(a,b)->b.profit-a.profit);
        int total = 0;
        boolean status[] = new boolean[md];
        int fill[] = new int[md];
        Arrays.fill(fill, -1);
        for (int i = 0; i < j.length; i++) {
            for (int x = Math.min(md - 1, j[i].deadline - 1); x >= 0; x--) {
                if (!status[x]) {
                    status[x] = true;
                    total += j[i].profit;
                    fill[x] = j[i].id;
                    break;

                }
            }
        }
        System.out.println("Total Profit : "     + total);
        for   (int    i     =   0 ; i <  fill.length; i++) {
            System.out.print("Job"     + fill[ i ] + "--->  ");
        }

    }

    public static void main(String[] args) {
        Job[] jobs = {
                new Job(1, 2, 100),
                new Job(2, 1, 19),
                new Job(3, 2, 27),
                new Job(4, 1, 25),
                new Job(5, 3, 15)
        };
        js(jobs, 3 );

    }
}