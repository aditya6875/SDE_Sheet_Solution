import java.util.*;

public class Pascal_Triangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> row, pre = null;
		for (int i = 0; i < numRows; ++i) {
			row = new ArrayList<Integer>();
			for (int j = 0; j <= i; ++j)
				if (j == 0 || j == i)
					row.add(1);
				else
					row.add(pre.get(j - 1) + pre.get(j));
			pre = row;
			res.add(row);
		}
		return res;
    }
    public static void main(String[] args) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        int n=4;
        res =generate(n);
        for (List<Integer> row : res) {
            for (Integer num : row) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}
