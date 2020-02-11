package practise;

public class ConvertOneStringtoAnother {

	static int minimumEdit(String str1, String str2)
	{
		return minimumEdit_DC(str1, str2,0 ,0);
	}
	
	static int minimumEdit_DP_TD(String s1, String s2)
	{
		Integer[][] dp = new Integer[s1.length()+1][s2.length()+1];
		return  minimumEdit_DP_TD(s1,s2,0,0,dp);
	}
	
	
	static int minimumEdit_DP_BU(String s1, String s2)
	{
		Integer[][] dp = new Integer[s1.length()+1][s2.length()+1];

		for (int i1 = 0; i1 <= s1.length(); i1++) // if we reached in the end of str1 then add all remaining character into str2
			{
				dp[i1][0]=i1;
			}
			
		for (int i2 = 0; i2 <= s2.length(); i2++) //if we reached in the end of str2 then delete extra character from str2
			{
				dp[0][i2]=i2;
			}
			
		for (int i1 = 1; i1 <= s1.length(); i1++) {
			for (int i2 = 1; i2 <= s2.length(); i2++) { // If the strings have a matching character, recursively match for the remaining lengths.
				if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1))
					dp[i1][i2] = dp[i1 - 1][i2 - 1];
				else
					dp[i1][i2] = 1 + Math.min(dp[i1 - 1][i2], // delete
							         Math.min(dp[i1][i2 - 1], // insert
								      	dp[i1 - 1][i2 - 1])); // replace
			}
		}
		return dp[s1.length()][s2.length()];
	}
	
	static int  minimumEdit_DP_TD(String s1,String s2,int m,int n ,Integer dp[][]) {
		if(dp[m][n]== null) {
			if(m == s1.length()) // if we reached in the end of str1 then add all remaining character into str2
			{
				return s2.length() - n; 
			}
			
			if(n == s2.length()) //if we reached in the end of str2 then delete extra character from str2
			{
				return s1.length() - m;
			}
			
			if(s1.charAt(m) == s2.charAt(n))
			{
				dp[m][n] =	minimumEdit_DP_TD(s1, s2,m+1 ,n+1,dp);
			}
			else {
			
			int c1 =  minimumEdit_DP_TD(s1, s2,m ,n+1,dp); // in insertion
			int c2 = minimumEdit_DP_TD(s1, s2,m+1 ,n,dp); // in deletion
			int c3 = minimumEdit_DP_TD(s1, s2,m+1 ,n+1,dp); // in case of replace
			
			dp[m][n]=1+ Math.min(c1, Math.min(c2, c3));
			}
		}return dp[m][n];
	}
	
	
	
	static int minimumEdit_DC(String str1, String str2,int m ,int n)
	{
		if(m == str1.length()) // if we reached in the end of str1 then add all remaining character into str2
		{
			return str2.length() - n; 
		}
		
		if(n == str2.length()) //if we reached in the end of str2 then delete extra character from str2
		{
			return str1.length() - m;
		}
		
		if(str1.charAt(m) == str2.charAt(n))
		{
			return	minimumEdit_DC(str1, str2,m+1 ,n+1);
		}
		int c1 = 1 + minimumEdit_DC(str1, str2,m ,n+1); // in insertion
		int c2 = 1 + minimumEdit_DC(str1, str2,m+1 ,n); // in deletion
		int c3 = 1 + minimumEdit_DC(str1, str2,m+1 ,n+1); // in case of replace
		
		return Math.min(c1, Math.min(c2, c3));
	}
	
	public static void main(String args[]) {
		System.out.println(minimumEdit("table", "tbres"));
		System.out.println(minimumEdit_DP_TD("table", "tbres"));
		System.out.println(minimumEdit_DP_BU("table", "tbres"));
	}
}

