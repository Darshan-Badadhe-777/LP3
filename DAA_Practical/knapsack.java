import java.util.*;

public class knapsack {
    public static class Items {
        int value;
        int weight;

        public Items(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    public static double kanpsack(Items items[], int capacity) {
        Arrays.sort(items, (a, b) -> {
            double value1 = (double) a.value / a.weight;
            double value2 = (double) b.value / b.weight;
            return Double.compare(value2, value1);
        });
        double ans = 0.0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].weight <= capacity) {
                capacity -= items[i].weight;
                ans += items[i].value;
            } else {
                ans += capacity * (double) items[i].value / items[i].weight;
                break;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        Items[] items = {
                new Items(60, 10),
                new Items(100, 20),
                new Items(116, 30)
        };

        System.out.println("Maximum value in the knapsack: " + kanpsack(items, 50));

    }
}