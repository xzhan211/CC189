import java.util.*;
import java.io.*;

public class InputFromTxt{
    public static void main(String[] args) throws Exception { 
        boolean[][] map = new boolean[30][51];
        int startX = 1;
        int startY = 25;
        int endX = 29;
        int endY = 25;

        File file = new File("cave.txt"); 
        // format: 
        // 10, 20
        // 4, 12
        // 5, 13

        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String st; 
        while ((st = br.readLine()) != null) {
            String temp = st.replace(',', ' ');
            String[] arr = temp.split("\\s+");
            int x = Integer.valueOf(arr[0]);
            int y = Integer.valueOf(arr[1]);
            map[x][y] = true;
        }
            
        
} 



