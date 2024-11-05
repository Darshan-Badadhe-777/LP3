import java.util.*;

public class Knapsack01 {
    public static class Item {
        int value;
        int weight;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    public static int knapsackDP(int[][] dp, int index, int capacity, Item[] items) {
        // Base case: if we are at the first item
        if (index == 0) {
            if (items[index].weight <= capacity) {
                return items[index].value;
            } else {
                return 0;
            }
        }
        // If already computed, return the stored result
        if (dp[index][capacity] != -1) {
            return dp[index][capacity];
        }

        // Case when the item is not taken
        int notTaken = knapsackDP(dp, index - 1, capacity, items);

        // Case when the item is taken (if it fits in the remaining capacity)
        int taken = Integer.MIN_VALUE;
        if (capacity >= items[index].weight) {
            taken = items[index].value + knapsackDP(dp, index - 1, capacity - items[index].weight, items);
        }

        // Store the maximum of the two choices in the DP array
        dp[index][capacity] = Math.max(notTaken, taken);
        return dp[index][capacity];
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(40, 3),
            new Item(50, 2),
            new Item(70, 5)
        };
        int capacity = 6;

        // Initialize DP array with -1 for memoization
        int[][] dp = new int[items.length][capacity + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        // Calculate the maximum profit for the given capacity
        int maxProfit = knapsackDP(dp, items.length - 1, capacity, items);
        System.out.println("Maximum profit: " + maxProfit);
    }
}
