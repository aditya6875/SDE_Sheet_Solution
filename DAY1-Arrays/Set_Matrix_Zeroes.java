/*
Given a matrix if an element in the matrix is 0 then you will have to 
set its entire column and row to 0 and then return the matrix.

Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]

Output: [[1,0,1],[0,0,0],[1,0,1]]

Naive Approach--
    Use two loop and find cell (i,j) for 0 element at mark row and col to -1 ,
    except which contain 0.
    then after all operation, we mark -1 to 0.

    TIME COMPLEXITY --  O((N*M)*(N + M)) + O(N*M)
    N*M -- traversing
    N+M -- marking to -1
    N*M -- again traversing and marking -1 to 0.
*/
//=========================================================================================
//=========================================================================================
/*
 APPROACH 2 
 we will declare two arrays: 
 a row array of size N and a col array of size M and both are initialized with 0.

 Use two loops to traverse the matrix

 If any cell (i,j) contains the value 0, we will mark ith index of row array i.e. 
 row[i] and jth index of col array col[j] as 1.

 Time Complexity: O(2*(N*M))
 */

 //=====================================================================================
 //=====================================================================================
 /*
    APPROACH 3
    we will use the 1st row and 1st column of the given matrix to keep a track of the 
    cells that need to be marked with 0.

    But here comes a problem. If we try to use the 1st row and 1st column to serve the purpose, 
    the cell matrix[0][0] is taken twice.

    To solve this problem we will take an extra variable col0 initialized with 1.

    Now the entire 1st row of the matrix will serve the purpose of the row array. 
    And the 1st column from (0,1) to (0,m-1) with the col0 variable will serve the 
    purpose of the col array.

    TIME COMPLEXITY -- O(2*(N*M))
  */

import java.util.*;

public class Set_Matrix_Zeroes{

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int n = matrix.size();
        int m = matrix.get(0).size();

        ArrayList<ArrayList<Integer>> ans = zeroMatrix1(matrix, n, m);

        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : ans) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix.get(i).get(j)==0){
                    markRow(matrix,n,m,i);
                    markCol(matrix,n,m,j);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix.get(i).get(j)==-1){
                    matrix.get(i).set(j,0);
                }
            }
        }
        

        return matrix;
    }

    private static void markCol(ArrayList<ArrayList<Integer>> matrix, int n, int m, int j) {
        for (int i = 0; i < n; i++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    private static void markRow(ArrayList<ArrayList<Integer>> matrix, int n, int m, int i) {
        for (int j = 0; j < m; j++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    // APPROACH 2 -=================================================================
    //================================================================================
    //==============================================================================
    static ArrayList<ArrayList<Integer>> zeroMatrix1(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int[] row = new int[n]; // row array
        int[] col = new int[m]; // col array

        // Traverse the matrix:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    // mark ith index of row wih 1:
                    row[i] = 1;

                    // mark jth index of col wih 1:
                    col[j] = 1;
                }
            }
        }

        // Finally, mark all (i, j) as 0
        // if row[i] or col[j] is marked with 1.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        System.out.println("Approach 2");
        return matrix;
    }
    // APPROACH 3 =========================================================================
    //======================================================================================
    //======================================================================================

    static ArrayList<ArrayList<Integer>> zeroMatrix2(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        // int[] row = new int[n]; --> matrix[..][0]
        // int[] col = new int[m]; --> matrix[0][..]

        int col0 = 1;
        // step 1: Traverse the matrix and
        // mark 1st row & col accordingly:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    // mark i-th row:
                    matrix.get(i).set(0, 0);

                    // mark j-th column:
                    if (j != 0)
                        matrix.get(0).set(j, 0);
                    else
                        col0 = 0;
                }
            }
        }

        // Step 2: Mark with 0 from (1,1) to (n-1, m-1):
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix.get(i).get(j) != 0) {
                    // check for col & row:
                    if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
                        matrix.get(i).set(j, 0);
                    }
                }
            }
        }

        //step 3: Finally mark the 1st col & then 1st row:
        if (matrix.get(0).get(0) == 0) {
            for (int j = 0; j < m; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix.get(i).set(0, 0);
            }
        }
        System.out.println("Approach 3");
        return matrix;
    }
}



