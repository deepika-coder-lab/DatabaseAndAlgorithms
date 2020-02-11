package practise;

public class HouseTheifProblem {

	static int maxMoney(int[] house) {
		return maxMoney_DC(house, 0);
	}

	static int maxMoney_DP_TD(int[] house) {
		int netWorth[] = new int[house.length];
		return maxMoney_DP_TD(house, 0, netWorth);

	}

	static int maxMoney_DP_BU(int[] house) {
		int netWorth[] = new int[house.length + 2];
		netWorth[house.length] = 0;

		for (int i = house.length - 1; i >= 0; i--) {

			netWorth[i] = Math.max(house[i] + netWorth[i + 2], netWorth[i + 1]);
		}
		return netWorth[0];

	}

	static int maxMoney_DP_TD(int[] house, int currentIndex, int[] netWorth) {
		int stealCurrentHouse, skipCurrentHouse = 0;
		if (currentIndex >= house.length) {
			return 0;
		}
		if (netWorth[currentIndex] == 0) {
			stealCurrentHouse = house[currentIndex] + maxMoney_DP_TD(house, currentIndex + 2, netWorth);
			skipCurrentHouse = maxMoney_DP_TD(house, currentIndex + 1, netWorth);
			netWorth[currentIndex] = Math.max(stealCurrentHouse, skipCurrentHouse);
		}
		return netWorth[currentIndex];
	}

	static int maxMoney_DC(int house[], int currentIndex) {
		int stealCurrentHouse, skipCurrentHouse = 0;
		if (currentIndex >= house.length) {
			return 0;
		} else {
			stealCurrentHouse = house[currentIndex] + maxMoney_DC(house, currentIndex + 2);
			skipCurrentHouse = maxMoney_DC(house, currentIndex + 1);
			return Math.max(stealCurrentHouse, skipCurrentHouse);
		}

	}

	public static void main(String args[]) {
		int[] HouseNetWorth = { 6, 7, 1, 30, 8, 2, 4 };
		System.out.println("Net Worth steal " + maxMoney(HouseNetWorth));

		System.out.println("Net Worth steal " + maxMoney_DP_TD(HouseNetWorth));
		System.out.println("Net Worth steal " + maxMoney_DP_BU(HouseNetWorth));
	}
}
