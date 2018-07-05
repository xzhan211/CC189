import java.util.*;
import java.lang.*;

public class q1p7{
    public static void main(String[] args){
        int[][] matrix = {{1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4}};
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix.length; j++){
                System.out.print(matrix[i][j]+"   ");
            }
            System.out.println("");
        }

        rotate(matrix);
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix.length; j++){
                System.out.print(matrix[i][j]+"   ");
            }
            System.out.println("");
        }

    }
    // T: O(n^2)
    // S: O(1)
    // A: layer by layer
    public static void rotate(int[][] matrix){
        int len = matrix.length;
        for(int layer = 0; layer < len/2; layer++){
            int first = layer;
            int last = len - 1 - layer;
            for(int i = first; i < last; i++){
                int offset = i - first;
                int top = matrix[first][i];
                // left -> top
                matrix[first][i] = matrix[last-offset][first];
                // bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];
                // right -> bottom
                matrix[last][last-offset] = matrix[i][last];
                // top -> right
                matrix[i][last] = top;
            }
        }
    }
}
