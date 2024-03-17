package com.arrays;

import java.util.Arrays;

//You want to maximize your profit by choosing a single day to buy one stock
//and choosing a different day in the future to sell that stock.
public class BuySellStock {

    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 9, 10};
        System.out.println("Max Profit :: " + buySellStockOptimal(prices) + "");
    }

    public static int buySellStockOptimal(int arr[]) {
        int buyPrice = arr[0];
        int profit = 0;

        for (int i = 1; i < arr.length; i++) {
            int sellPrice = arr[i];

            profit = Math.max(sellPrice - buyPrice, profit);

            buyPrice = Math.min(sellPrice, buyPrice);
        }
        return profit;
    }
}
