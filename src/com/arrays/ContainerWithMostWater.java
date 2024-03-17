package com.arrays;

//Refer Nishant Chahar
public class ContainerWithMostWater {

	public static void main(String[] args) {

		int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 }; // 49 ans

		System.out.println("Max area of water :: bruteForce : " + containerWithMostWaterBruteForce(height));
		
		System.out.println("Max area of water :: bruteForce : " + containerWithMostWaterOptimal(height));
	}

	private static int containerWithMostWaterBruteForce(int height[]) {

		if (height.length == 0) {
			return -1;
		}
		int area = Integer.MIN_VALUE;

		for (int i = 0; i < height.length; i++) {

			for (int j = i + 1; j < height.length; j++) {

				int newArea = Math.min(height[i], height[j]) * (j - i);

				area = Math.max(area, newArea);
			}
		}
		return area;
	}

	private static int containerWithMostWaterOptimal(int arrHeight[]) {

		if (arrHeight.length == 0) {
			return -1;
		}
		int area = Integer.MIN_VALUE;

		int low = 0, high = arrHeight.length - 1;

		for (int i = 0; i < arrHeight.length; i++) {

			int newArea = Math.min(arrHeight[low], arrHeight[high]) * (high - low);

			area = Math.max(area, newArea);

			if (arrHeight[low] < arrHeight[high]) {
				low++;
			} else {
				high--;
			}
		}
		return area;
	}

}
