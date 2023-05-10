public class KadaneAlgorithm {
    public static void main(String args[]) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        int maxSum = maxSubarraySum(arr, n);
        int maxSum1 = maxSubarraySum1(arr, n);
        int maxSum2 = maxSubarraySum2(arr, n);
        System.out.println("The maximum subarray sum is APPROACH 1: " + maxSum);
        System.out.println("The maximum subarray sum is APPROACH 2: " + maxSum1);
        System.out.println("The maximum subarray sum is APPROACH 3: " + maxSum2);

    }

    // APPROACH 1
    // we will check sum of every possible subarray.
    // first loop i ==0 to n-1
    // second loop j == i to n
    // third loop k == i to j
    // TIME COMPLEXITY -- O(N^3)
    private static int maxSubarraySum(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];


                }
                maxi=Math.max(sum,maxi);
            }
        }
        return maxi;
        
    }

    // APPROACH 2
    // If we carefully observe, we can notice that to get the sum of the 
    // current subarray we just need to add the current element(i.e. arr[j]) 
    // to the sum of the previous subarray i.e. arr[i….j-1].

    public static int maxSubarraySum1(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE; // maximum sum

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                
                sum += arr[j];

                maxi = Math.max(maxi, sum);
            }
        }

        return maxi;
    }

    //APPROACH 3
    // The intuition of the algorithm is not to consider the subarray 
    // as a part of the answer if its sum is less than 0.

    // We will run a loop(say i) to iterate the given array.
    
    // Now, while iterating we will add the elements to the sum variable and 
    // consider the maximum one.
    
    // If at any point the sum becomes negative we will set the sum to 0 as 
    // we are not going to consider it as a part of our answer.
    
    private static int maxSubarraySum2(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE; // maximum sum
        int  sum = 0;

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;
            }

            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }
        // To consider the sum of the empty subarray
        // uncomment the following check:

        //if (maxi < 0) maxi = 0;

        return maxi;
    
    }

}
