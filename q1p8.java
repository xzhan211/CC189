public class q1p8{
    public static void main(String[] args){
        int[][] matrix = {
            {1,2,3,4,0,5},
            {2,3,4,0,4,3},
            {0,1,4,3,2,1},
            {1,1,1,1,1,1},
            {1,2,0,2,2,2}
            };
        int[] row = new int[matrix[0].length];
        int[] col = new int[matrix.length];
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                sop(matrix[i][j]);
            }
            System.out.println("");
        }

        modify(matrix, row, col);
        System.out.println("");
        System.out.println("");


        for(int i = 0; i<col.length; i++){
            if(col[i] == 1){
                for(int j = 0; j<row.length; j++)
                    matrix[i][j] = 0;
            }
        }

        for(int i = 0; i<row.length; i++){
            if(row[i] == 1){
                for(int j = 0; j<col.length; j++)
                    matrix[j][i] = 0;
            }
        }

        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                sop(matrix[i][j]);
            }
            System.out.println("");
        }
    }


    public static void sop(Object obj){
        System.out.print(obj+"  ");
    }

    // T: O(nm)
    // S: O(n+m)
    public static void modify(int[][] matrix, int[] row, int[] col){
        for(int i = 0; i<matrix.length; i++){
            if(col[i] == 1)
                continue;
            for(int j = 0; j<matrix[0].length; j++){
                if(row[j]==0 && matrix[i][j] == 0){
                    row[j] = 1;
                    col[i] = 1;
                }
            }
        }
    }
}
