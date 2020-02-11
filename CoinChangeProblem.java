package practise;

import java.util.Arrays;

public class CoinChangeProblem {

	static void coinChange(int[] coins, int change) {
		Arrays.sort(coins); // sort in ascending order
		int index = coins.length - 1;
		while (change != 0) {
			int coinValue = coins[index];
			index--;
			int maxAmount = (change / coinValue) * coinValue;
			if (maxAmount > 0) {
				System.out.println("Coin Value" + coinValue + " count" + change / coinValue);
				change = change - maxAmount;
			}

		}

	}

	public static void main(String args[]) {

		int[] coins = { 1, 2, 5, 10, 50, 100, 500, 2000 };
		int amount = 2758;
		System.out.println("From available Coins" + Arrays.toString(coins));
		System.out.println("We want Change Of " + amount);
		coinChange(coins, amount);
	}
}
