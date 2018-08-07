import java.util.*;
public class q8p2{
    public static void main(String[] args){
        int row = 3;
        int col = 4;
        int[][] matrix = new int[row][col];
        for(int[] arr: matrix){
            Arrays.fill(arr, -1);
        }
        matrix[0][2] = 0;
        matrix[2][1] = 0;
        matrix[0][0] = 1;

        System.out.println(uniquePaths(matrix, row, col));

        for(int i = 0 ; i< row; i++){
            for(int j = 0; j< col; j++){
                System.out.print(matrix[i][j]+" ");
            }
                System.out.println(" ");
        }

    }
    //DP without recursion (actually, I use iteration.
    public static int uniquePaths(int[][] matrix ,int row, int col) {
        if(row==0 ||col == 0) return 1;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(matrix[i][j] != 0){
                if((i == 0) && (j>0)){
                    matrix[i][j] = matrix[i][j-1];
                }else if((j == 0) && (i>0)){
                    matrix[i][j] = matrix[i-1][j];
                }else if(i>0 && j>0){
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
                }
                }
            }
        }
        return matrix[row-1][col-1];
    }
}
