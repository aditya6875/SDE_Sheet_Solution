import java.util.*;

public class Next_permutation {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(new Integer[] {1,3,2});
        List<Integer> ans= nextPermutation(arr);

        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
        

    }

    private static List<Integer> nextPermutation(List<Integer> A) {
        int n = A.size(); // size of the array.

        // Step 1: Find the break point:
        int ind = -1; // break point
        for (int i = n - 2; i >= 0; i--) {
            if (A.get(i) < A.get(i + 1)) {
                // index i is the break point
                ind = i;
                break;
            }
        }

        // If break point does not exist:
        if (ind == -1) {
            // reverse the whole array:
            Collections.reverse(A);
            return A;
        }

        // Step 2: Find the next greater element
        //         and swap it with arr[ind]:

        for (int i = n - 1; i > ind; i--) {
            if (A.get(i) > A.get(ind)) {
                int tmp = A.get(i);
                A.set(i, A.get(ind));
                A.set(ind, tmp);
                break;
            }
        }

        // Step 3: reverse the right half:
        List<Integer> sublist = A.subList(ind + 1, n);
        Collections.reverse(sublist);

        return A;
        
    }
}
