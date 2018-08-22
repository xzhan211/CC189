public class q10p9{
    public static void main(String[] args){
        int[][] matrix = {{15,20,40,85},
            {20,35,80,95},
            {30,55,95,105},
            {40,80,100,120}};
        boolean[][] mem = new boolean[matrix.length][matrix[0].length];
        System.out.println(search(matrix, 80, 0, 0, mem));
        System.out.println(search2(matrix, 80));
    }
    //suck..
    public static boolean search(int[][] matrix, int target, int pX, int pY, boolean[][] mem){
        if(pX >= matrix.length || pY >= matrix[0].length)
            return false;
        if(mem[pX][pY] == true)
            return false;
        else
            mem[pX][pY] = true;
        if(matrix[pX][pY] == target)
            return true;

        boolean tempA = search(matrix, target, pX+1, pY, mem);
        boolean tempB = search(matrix, target, pX, pY+1, mem);
        return tempA || tempB;
    }

    // this way is better
    // T: O(row+col)
    public static boolean search2(int[][] matrix, int target){
        int row = 0;
        int col = matrix[0].length-1;
        while(row < matrix.length && col >=0){
            if(matrix[row][col]==target)
                return true;
            else if(matrix[row][col] > target)
                col--;
            else
                row++;
        }
        return false;
    }

    // BST can be use in way 3.
}
