import java.util.HashMap;
import java.util.Scanner;

public class SubarrayDivisibleByK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Input for K
        System.out.print("Enter the value of K: ");
        int k = scanner.nextInt();

        // Function to count subarrays divisible by K
        int count = countSubarraysDivisibleByK(arr, k);
        System.out.println("Number of subarrays divisible by " + k + " is: " + count);

        scanner.close(); // Close the scanner
    }

    public static int countSubarraysDivisibleByK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Handle the case when a subarray sum is divisible by K from the start
        int count = 0;
        int currentSum = 0;

        for (int num : arr) {
            currentSum += num; // Update the cumulative sum
            int mod = ((currentSum % k) + k) % k; // Ensure mod is positive

            // If mod has been seen before, then there are 'map.get(mod)' subarrays ending at the current index
            count += map.getOrDefault(mod, 0);

            // Update the frequency of the current mod value
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        return count; // Return the total count of subarrays
    }
}
