import java.util.*;
public class q16p19{
    public static void main(String[] args){
        int[][] input = {{0,2,1,2},
                        {0,1,0,1},
                        {1,1,0,1},
                        {0,1,0,1}};
        //List<Integer> li = new ArrayList<>();
        System.out.println(pond(input).toString());
    }

    public static List<Integer> pond(int[][] input){
        List<Integer> li = new ArrayList<>();
        int cnt = 0;
        for(int i = 0; i<input.length; i++){
            for(int j = 0; j<input[0].length; j++){
                if(input[i][j] == 0){
                    cnt = count(input, i, j);
                    li.add(cnt);
                }
            }
        }
        return li;
    }

    public static int count(int[][] input, int x, int y){
        if(x<0 || y<0 || y>=input[0].length || x>=input.length ||input[x][y] != 0 ||input[x][y] == -1){
            return 0;
        }
        int cnt = 1;
        input[x][y] = -1;
        for(int i=x-1; i<=x+1; i++){
            for(int j=y-1; j<=y+1; j++){
                cnt += count(input, i, j);
            }

        }
        return cnt;
    }
}
