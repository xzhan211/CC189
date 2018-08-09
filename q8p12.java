import java.util.*;
import java.lang.*;
public class q8p12{
    static int size = 8;
    public static void main(String[] args){
        ArrayList<Integer[]> ans = new ArrayList<>();
        queue(0, new Integer[size], ans);
        System.out.println(ans.size());
    }

    public static void queue(int row, Integer[] columns, ArrayList<Integer[]> results){
        if(row == size){
            results.add(columns.clone());
        }else{
            for(int col= 0; col<size; col++){
                if(check(columns, row, col)){
                    columns[row] = col;
                    queue(row+1, columns, results);
                }
            }
        }
    }

    public static boolean check(Integer[] columns, int row1, int column1){
        for(int row2 = 0; row2 < row1; row2++){
            int column2 = columns[row2];
            if(column1 == column2){
                return false;
            }


            int columnDistance = Math.abs(column2-column1);
            int rowDistance = row1 - row2;
            if(columnDistance == rowDistance){
                return false;
            }
        }
        return true;
    }




}
