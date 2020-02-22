public class FindMedianOfTwoSortedArrays {
	public double findMedian(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return findMedian(nums2, nums1);
		}
		int lenX = nums1.length;
		int lenY = nums2.length;

		int start = 0;
		int end = lenX;

		while (start <= end) {
			int partitionX = (start + end) / 2;
			int partitionY = (lenX + lenY + 1) / 2 - partitionX;

			// if partitionX is 0 it means nothing is there on left side. Use -INF for
			// maxLeftX
			// if partitionX is length of input then there is nothing on right side. Use
			// +INF for minRightX
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int minRightX = (partitionX == lenX) ? Integer.MAX_VALUE : nums1[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int minRightY = (partitionY == lenY) ? Integer.MAX_VALUE : nums2[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				// We have partitioned array at correct place
				// Now get max of left elements and min of right elements to get the median in
				// case of even length combined array size
				// or get max of left for odd length combined array size.
				if ((lenX + lenY) % 2 == 0) {
					return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				} else {
					return (double) Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) { // we are too far on right side for partitionX. Go on left side.
				end = partitionX - 1;
			} else { // we are too far on left side for partitionX. Go on right side.
				start = partitionX + 1;
			}
		}

		// Only we we can come here is if input arrays were not sorted. Throw in that
		// scenario.
		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		int[] x = { 1, 3, 8, 9, 15 };
		int[] y = { 7, 11, 19, 21, 18, 25 };

		FindMedianOfTwoSortedArrays mm = new FindMedianOfTwoSortedArrays();
		System.out.println( mm.findMedian(x, y));
	}

}
