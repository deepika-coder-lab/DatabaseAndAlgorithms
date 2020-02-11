public class NumberFactor {

	static int wayTogetNumber_DC(int n) {
		int subtract1, subtract3, subtract4 = 0;
		if (n == 0 || n == 1 || n == 2) {
			return 1;

		}
		if (n == 3) {
			return 2;
		} else {
			subtract1 = wayTogetNumber_DC(n - 1);
			subtract3 = wayTogetNumber_DC(n - 3);
			subtract4 = wayTogetNumber_DC(n - 4);
		}

		return subtract1 + subtract3 + subtract4;
	}

	static int wayTogetNumber_DP_TD(int n) {
		int dp[] = new int[n + 1];
		return wayTogetNumber_DP_TD(dp, n);
	}

	static int wayTogetNumber_DP_TD(int dp[], int n) {

		int subtract1, subtract3, subtract4 = 0;
		if (n == 0 || n == 1 || n == 2) {
			return 1;

		}
		if (n == 3) {
			return 2;
		}

		if (dp[n] == 0) {
			subtract1 = wayTogetNumber_DP_TD(dp, n - 1);
			subtract3 = wayTogetNumber_DP_TD(dp, n - 3);
			subtract4 = wayTogetNumber_DP_TD(dp, n - 4);
			dp[n] = subtract1 + subtract3 + subtract4;
		}

		return dp[n];

	}

	static int wayTogetNumber_DP_BU(int n) {
		int dp[] = new int[n + 1];
		return wayTogetNumber_DP_BU(dp, n);
	}

	static int wayTogetNumber_DP_BU(int dp[], int n) {

		dp[0] = dp[1] = dp[2] = 1;
		dp[3] = 2;

		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
		}

		return dp[n];

	}

	public static void main(String args[]) {
		System.out.println("Total combination to create number using (1,3,4) are " + wayTogetNumber_DC(4));
		System.out.println("Total combination to create number using (1,3,4) are " + wayTogetNumber_DC(5));
		System.out.println("Total combination to create number using (1,3,4) are " + wayTogetNumber_DC(6));

		System.out.println("Total combination to create number using (1,3,4) are " + wayTogetNumber_DP_TD(4));
		System.out.println("Total combination to create number using (1,3,4) are " + wayTogetNumber_DP_TD(5));
		System.out.println("Total combination to create number using (1,3,4) are " + wayTogetNumber_DP_TD(6));

		System.out.println("Total combination to create number using (1,3,4) are " + wayTogetNumber_DP_BU(4));
		System.out.println("Total combination to create number using (1,3,4) are " + wayTogetNumber_DP_BU(5));
		System.out.println("Total combination to create number using (1,3,4) are " + wayTogetNumber_DP_BU(6));
	}
}
