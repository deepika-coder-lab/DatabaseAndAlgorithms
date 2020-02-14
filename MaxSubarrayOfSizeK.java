
public class MaxSubarrayOfSizeK {

	static int findMaxSubArray(int[] a, int k) {
		int start = 0;
		int end = 0;
		int maxSoFar = 0;
		int SumOfSubarrays = 0;

		while (end < a.length) {
			SumOfSubarrays = SumOfSubarrays + a[end];
			// maintain size of window to k
			if (end >= k - 1) {
				maxSoFar = Math.max(maxSoFar, SumOfSubarrays);
				SumOfSubarrays = SumOfSubarrays - a[start]; // remove sum of first element of subarray
				start++;
			}
			end++;

		}
		return maxSoFar;
	}

	public static void main(String args[]) {
		int a[] = { 2, 1, 5, 1, 3, 2 };
		int result = findMaxSubArray(a, 3);

		System.out.println("Max Sub array" + result);
	}

}
