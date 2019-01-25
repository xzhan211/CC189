import java.util.*;

public class LCS{
	public static void main(String[] args){
		char[] arrA = {'a','b','c','b','e'};
		char[] arrB = {'b','d','c','a','e'};
		System.out.println("brute force >> "+ bf(arrA, arrB));
		System.out.println("recursion >> "+ rec(arrA, arrB));
		System.out.println("DP >> "+ dp(arrA, arrB));

	}
	//brute force
	//T: O(n*2^m)
	public static int bf(char[] arrA, char[] arrB){
		List<List<Character>> ans = new ArrayList<>();
		for(int i = 1; i <= arrA.length; i++){
			helper(ans, arrA, new ArrayList<Character>(), i, 0);
		}
		int maxLen = 0;
		for(List<Character> list : ans){
			//System.out.println(list);
			if(check(list, arrB)){
				maxLen = list.size() > maxLen ? list.size() : maxLen;
			}
		}
		return maxLen;
	}

	public static void helper(List<List<Character>> ans, char[] arr, List<Character> list, int len, int start){
		if(list.size() == len){
			ans.add(new ArrayList<Character>(list));
			return;
		}
		if(start >= arr.length) return;

		for(int i = start; i < arr.length; i++){
			list.add(arr[i]);
			helper(ans, arr, list, len, i+1);
			list.remove(list.size()-1);
		}
	}

	public static boolean check(List<Character> list, char[] arr){
		int i = 0;
		int j = 0;
		while(i<list.size() && j<arr.length){
			if(list.get(i) == arr[j]){
				i++;
				j++;
			}else
				j++;
		}

		if(i==list.size() && j<=arr.length)
			return true;
		else if(i<list.size() && j==arr.length)
			return false;
		else 
			return false;
	}

	// recursion
	// O(2^min(lenA, lenB))
    // draw a recursion tree can help to understand the time complexity
    public static int rec(char[] arrA, char[] arrB){
    	return lenLCS(arrA, arrB, arrA.length-1, arrB.length-1);
    }

    public static int lenLCS(char[] arrA, char[] arrB, int lastA, int lastB){
    	//System.out.println("**");
    	if(lastA < 0 || lastB < 0) return 0;
    	if(arrA[lastA] == arrB[lastB]) 
    		return lenLCS(arrA, arrB, lastA-1, lastB-1) + 1;
    	else
    		return Math.max(lenLCS(arrA, arrB, lastA-1,lastB), lenLCS(arrA, arrB, lastA,lastB-1));
    }

    // DP
    // O(lenA * lenB)
    public static int dp(char[] arrA, char[] arrB){
    	int[][] matrix = new int[arrA.length+1][arrB.length+1];
    	for(int i = 1; i <= arrA.length; i++){
    		for(int j = 1; j <= arrB.length; j++){
    			if(arrA[i-1] == arrB[j-1]){
    				matrix[i][j] = matrix[i-1][j-1] + 1;
    			}else{
    				if(matrix[i-1][j] >= matrix[i][j-1]){
    					matrix[i][j] = matrix[i-1][j];
    				}else{
    					matrix[i][j] = matrix[i][j-1];
    				}
    			}
    		}
    	}
    	/*
    	for(int[] test : matrix){
    		System.out.println(Arrays.toString(test));
    	}
    	*/
    	return matrix[arrA.length][arrB.length];
    }
}

