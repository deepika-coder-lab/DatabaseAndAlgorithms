package practise;

public class ZeroOneKnapsackProblem {

	static int maxamizeProfit(int[] profit, int[] weight, int capacity)
	{
		int currentIndex = 0;
		 return maxamizeProfit_DC(profit,weight,capacity,currentIndex);
		
	}
	
	static int maxamizeProfit_DP(int[] profit, int[] weight, int capacity)
	{
		int currentIndex = 0;
		int calculatedProfit[] = new int [profit.length];
		 return maxamizeProfit_DP_TD(profit,weight,capacity,currentIndex, calculatedProfit);
		
	}
	
	static int maxamizeProfit_DP_BU(int[] profit, int[] weight, int capacity)
	{
		int currentIndex = 0;
		int calculatedProfit[] = new int [profit.length];
		
		
		return 0;
		
	}
	
	static int  maxamizeProfit_DP_TD(int [] profit,int [] weight,int capacity,int currentIndex, int [] calculatedProfit) {
		
		if(currentIndex<0 || capacity <= 0 || currentIndex >= profit.length) 
			return 0;
			 int profit1 = 0;
			 if(calculatedProfit[currentIndex]==0) {
			 
			 if (weight[currentIndex]<=capacity)
			 			 profit1 = profit[currentIndex] + maxamizeProfit_DC(profit,weight,capacity-weight[currentIndex],currentIndex+1); // taking 1st element
			 
			 int profit2 = maxamizeProfit_DC(profit,weight,capacity,currentIndex+1); //leaving first element
			 calculatedProfit[currentIndex] = Math.max(profit1, profit2);
			 }
			 return  calculatedProfit[currentIndex];
	}
	
	static int maxamizeProfit_DC(int[] profit,int [] weight,int capacity,int currentIndex) {
		if(currentIndex<0 || capacity <= 0 || currentIndex >= profit.length) 
		return 0;
		 int profit1 = 0;
		 
		 if (weight[currentIndex]<=capacity)
		 			 profit1 = profit[currentIndex] + maxamizeProfit_DC(profit,weight,capacity-weight[currentIndex],currentIndex+1); // taking 1st element
		 
		 int profit2 = maxamizeProfit_DC(profit,weight,capacity,currentIndex+1); //leaving first element
	
		 return Math.max(profit1, profit2);
			
	}
	
	public static void main( String args[])
	{
		int[] profits = { 31, 26, 72, 17 };
		int[] weights = { 3, 1, 5, 2 };
		int maxProfit = maxamizeProfit(profits, weights, 7);
		System.out.println(maxProfit);
		System.out.println(maxamizeProfit_DP(profits, weights, 7));
	}
}
