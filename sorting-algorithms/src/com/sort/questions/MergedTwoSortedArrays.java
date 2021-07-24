package com.sort.questions;

public class MergedTwoSortedArrays {
	public static void main(String[] args) {
		int nums1[] = { 10, 20, 30, 40, 50 };
		int nums2[] = { 8, 9, 15, 17, 19 };

		MergeArraysSolution mergeArraysSolution = new MergeArraysSolution();
		int mergedArr[] = mergeArraysSolution.merge(nums1, nums2);

		for (int i = 0; i < mergedArr.length; i++) {
			System.out.print(mergedArr[i] + " ");
		}

	}

}

class MergeArraysSolution {

	public int[] merge(int[] nums1, int[] nums2) {
		int i = 0, j = 0, c = 0;

		int mergedArr[] = new int[nums1.length + nums2.length];

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				mergedArr[c++] = nums1[i++];
			} else {
				mergedArr[c++] = nums2[j++];
			}
		}

		while (i < nums1.length) {
			mergedArr[c++] = nums1[i++];
		}
		while (j < nums2.length) {
			mergedArr[c++] = nums2[j++];
		}
		return mergedArr;
	}
}