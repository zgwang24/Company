package alibaba.campus;

import java.util.Scanner;

public class StealPeachTest {
	/**
	 * 有关猴子偷桃子的问题，实际为求数组中最长递增子序列
	 * @param peaches
	 * @return
	 */
	static int pick(int[] peaches) {
		int count = 0, n = peaches.length;
		int[] memo = new int[n];
		for(int i = 0; i < n; i++){
			memo[i] = 1;
			for(int j = 0; j < i; j++){
				if(peaches[j] < peaches[i] && (memo[j] + 1 > memo[i])){
					memo[i] = memo[j] + 1;
				}
			}
		}
		for(int i = 0; i < n; i++){
			if(memo[i] > count){
				count = memo[i];
			}
		}		
		return count;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int trees = Integer.parseInt(in.nextLine().trim());
        int[] peaches = new int[trees];
        for (int i = 0; i < peaches.length; i++) {
            peaches[i] = Integer.parseInt(in.nextLine().trim());
        }
        System.out.println(pick(peaches));
    }
}
