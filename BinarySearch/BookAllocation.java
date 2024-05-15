package BinarySearch;

public class BookAllocation {

    public static int[] findMaxAndSum(int arr[]) {
        int max = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            sum += arr[i];
        }
        int result[] = { max, sum };
        return result;
    }

    public static int numberOfStudentsToAllocateBooks(int arr[], int numberOfPages) {
        int students = 1;
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum + arr[i] <= numberOfPages) {
                sum += arr[i];
            } else {
                students++;
                sum = arr[i];
            }
        }
        return students;
    }

    // // Function to find minimum number of pages.
    // public static int findPages(int books[], int m) {
    // int maxAndSum[] = findMaxAndSum(books);
    // int sum = maxAndSum[1];
    // int max = maxAndSum[0];

    // // failure case - if number of students are more than the books
    // if (m > books.length) {
    // return -1;
    // }

    // for (int i = max; i <= sum; i++) {
    // // array, numberOfStudents, numberOfPages
    // if (numberOfStudentsToAllocateBooks(books, i) == m) {
    // return i;
    // }
    // }
    // return -1;
    // }

    public static int findPages(int books[], int m) {

        // failure case - if number of students are more than the books
        if (m > books.length) {
            return -1;
        }

        int maxAndSum[] = findMaxAndSum(books);
        int low = maxAndSum[0]; // maximum number of pages can be the lowest number of pages to allocate each
                                // book
        int high = maxAndSum[1]; // sum of all pages of books, can be the most possible answer to allocate all
                                 // books to one student
        while (low <= high) {
            int mid = (low + high) / 2;
            if (numberOfStudentsToAllocateBooks(books, mid) > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int books[] = { 15, 17, 20 };
        int m = 2; // number of students
        System.out.println("Maximum number of pages assigned to a student is minimum = " + findPages(books, m));
    }
}
