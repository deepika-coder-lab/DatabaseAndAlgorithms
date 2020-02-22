
public class DecommerseList {
	public int[] decompressRLElist(int[] nums) {
		int totalFreq = 0;

		for (int i = 0; i < nums.length; i += 2) {
			totalFreq += nums[i];
		}

		int[] result = new int[totalFreq];

		int index = 0;
		for (int i = 0; i < nums.length; i += 2) {
			for (int k = 0; k < nums[i]; k++) {
				result[index++] = nums[i + 1];
			}
		}

		return result;
	}

	public static void main(String args[]) {
		int num[] = { 1, 2, 3, 4 };
		DecommerseList dl = new DecommerseList();
		int result[] = dl.decompressRLElist(num);
		for (int i : result) {
			System.out.println(i);
		}
	}

}
