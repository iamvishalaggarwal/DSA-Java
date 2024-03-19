package Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Problem statement
Given an array 'v' of 'n' numbers.
Your task is to find and return the highest and lowest frequency elements.
If there are multiple elements that have the highest frequency or lowest frequency, 
pick the smallest element.

Example:
Input: ‘n' = 6, 'v' = [1, 2, 3, 1, 1, 4]
Output: 1 2

Explanation: The element having the highest frequency is '1', and the frequency is 3. 
The elements with the lowest frequencies are '2', '3', and '4'. 
Since we need to pick the smallest element, we pick '2'. Hence we return [1, 2].

*/

public class FindHighestAndLowestFrequency {

    public static Map<Integer, Integer> getFrequency(int[] arr) {
        Map<Integer, Integer> mapArray = new HashMap<Integer, Integer>();

        for (int val : arr) {
            if (mapArray.get(val) == null) {
                mapArray.put(val, 1);
            } else {
                mapArray.put(val, mapArray.get(val) + 1);
            }
        }
        return mapArray;
    }

    public static int[] getHighestAndLowestFrequencies(int[] arr) {
        Map<Integer, Integer> mapArray = getFrequency(arr);
        int result[] = new int[2];

        int high_value = 0, low_value = Integer.MAX_VALUE;

        // for finding max and min frequency values
        for (int key : mapArray.keySet()) {
            if (mapArray.get(key) > high_value) {
                high_value = mapArray.get(key);
            }
            if (mapArray.get(key) < low_value) {
                low_value = mapArray.get(key);
            }
        }

        // for checking the minimum key among all keys
        // for maximum and minimum frequencies respectively
        int min_req = Integer.MAX_VALUE, max_req = Integer.MAX_VALUE;
        for (int key : mapArray.keySet()) {
            if (mapArray.get(key) == high_value) {
                if (key < max_req) {
                    max_req = key;
                }
            }
            if (mapArray.get(key) == low_value) {
                if (key < min_req) {
                    min_req = key;
                }
            }
        }

        result[0] = max_req;
        result[1] = min_req;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length = ");
        int len = sc.nextInt();
        int[] arr = new int[len];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        int result[] = getHighestAndLowestFrequencies(arr);

        System.out.print("Key (Highest and Lowest Frequency) = " + result[0] + " " + result[1]);

        sc.close();
    }
}
