import java.util.*;
import java.lang.*;
public class q8p2_1{
    public static void main(String[] args){
        int row = 3;
        int col = 4;
        int[][] matrix = new int[row][col];
        for(int[] arr: matrix){
            Arrays.fill(arr, 1);
        }
        matrix[0][2] = 0;
        matrix[2][1] = 0;

        System.out.println(findRoute(matrix));
        for(Point p : findRoute(matrix)){
            System.out.println("x = "+p.posX+"   y= "+ p.posY);

        }

    }

    public static ArrayList<Point> findRoute(int[][] matrix){
        if(matrix == null || matrix.length == 0)
            return null;
        ArrayList<Point> ans = new ArrayList<>();
        int posX = matrix.length-1;
        int posY = matrix[0].length-1;
        if(check(posX, posY, matrix, ans)){
            return ans;
        }
        return null;
    }

    public static boolean check(int posX, int posY, int[][] matrix, ArrayList<Point> ans){
        if(posX < 0 || posY < 0)
            return false;

        if(matrix[posX][posY] == 0)
            return false;

        boolean isOriginPoint = false;
        if(posX==0 && posY==0)
            isOriginPoint = true;

        if(isOriginPoint  || check(posX -1, posY, matrix, ans) || check(posX, posY-1, matrix, ans)){
            Point point = new Point(posX, posY);
            ans.add(point);
            return true;
        }
        return false;
    }
}

class Point{
    public int posX;
    public int posY;
    public Point(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }
}
