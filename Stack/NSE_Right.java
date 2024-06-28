package Stack;

import java.util.Stack;

/*
Example - 
Input: N = 5, arr[] = {3, 8, 5, 2, 25}
Output: 2 5 2 -1 -1
Explanation: 
1. Roll number 1 has 3 marks. The first person 
who has less marks than him is roll number 4, 
who has 2 marks.
2. Roll number 2 has 8 marks, he helps student 
with 5 marks.
3. Roll number 3 has 5 marks, he helps student 
with 2 marks.
4. Roll number 4 and 5 can not pick anyone as 
no student with higher roll number has lesser 
marks than them. This is denoted by -1.
Output shows the marks of the weaker student that 
each roll number helps in order. ie- 2,5,2,-1,-1
 */

public class NSE_Right { // next smaller element to the right
    public static int[] findNSERight(int arr[], int n) {
        Stack<Integer> stack = new Stack<>();
        int rightSmall[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            if (stack.empty()) {
                rightSmall[i] = -1;
            } else {
                rightSmall[i] = stack.peek();
            }

            stack.push(arr[i]);
        }
        return rightSmall;
    }

    public static void main(String[] args) {
        int nums[] = { 5, 7, 1, 2, 6, 0 };
        for (int val : findNSERight(nums, nums.length))
            System.out.print(val + " ");
    }
}
