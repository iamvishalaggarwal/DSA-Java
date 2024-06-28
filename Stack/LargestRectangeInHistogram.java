package Stack;

import java.util.Stack;

public class LargestRectangeInHistogram {
    /*
     * Algo:
     * condition - a building can be expanded only if other building height >=
     * current building height
     * 
     * on the left and right side, we need to find smaller element than the current
     * therefore,
     * width = right_index_of_smaller - left_index_of_smaller + 1
     * total area = width * height
     */

    public static int findLeft(int[] arr, int index) {
        int count = 0;
        for (int i = index; i >= 0; i--) {
            if (arr[i] >= arr[index]) {
                count++;
            } else
                break;
        }
        return count;
    }

    public static int findRight(int[] arr, int index) {
        int count = 0;
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] >= arr[index]) {
                count++;
            } else
                break;
        }
        return count;
    }

    /*
     * Brute force -
     * TC: O(n^2)
     * SC: O(1)
     */
    // public static int largestRectangleArea(int[] heights) {
    // int max = 0;
    // for (int i = 0; i < heights.length; i++) {
    // int numberOfTallBuildingInLeft = findLeft(heights, i);
    // int numberOfTallBuildingInRight = findRight(heights, i);
    // int totalArea = heights[i] * (numberOfTallBuildingInLeft +
    // numberOfTallBuildingInRight);
    // max = Math.max(totalArea, max);
    // }
    // return max;
    // }

    /*
     * Better Approach - 2 pass solution (need to find left and right small array)
     * TC: O(n)
     * SC: O(n)
     */
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int leftSmall[] = new int[n];
        int rightSmall[] = new int[n];

        // finding left small
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            leftSmall[i] = stack.empty() ? 0 : stack.peek() + 1; // left boundary = 0 index (if stack is empty)
            stack.push(i);
        }

        // empty the below stack before re-used
        while (!stack.empty()) {
            stack.pop();
        }

        // finding right small
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            rightSmall[i] = stack.empty() ? n - 1 : stack.peek() - 1;
            stack.push(i);
        }

        int maxArea = 0;
        // find the max area using left and right array
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println("Largest rectangle = " + largestRectangleArea(arr));
    }
}
