import java.util.*;
public class ShortestPathNoWeight{
    public static void main(String[] args){

        int[][] matrix = {
            {0, 1, 1, 0, 0, 0},
            {1, 0, 1, 1, 0, 0},
            {1, 1, 0, 1, 1, 0},
            {0, 1, 1, 0, 1, 1},
            {0, 0, 1, 1, 0, 0},
            {0, 0, 0, 1, 0, 0}
        };


        int start = Integer.valueOf(args[0]);
        int end = Integer.valueOf(args[1]);
        List<Integer> ans = shortest(matrix, start, end);
        for(int i=ans.size()-1; i>=0; i--)
            System.out.println(ans.get(i));
    }

    public static List<Integer> shortest(int[][] matrix, int start, int end){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(graph, matrix);
        List<Integer> ans = new ArrayList<>();

        Set<Integer> hs = new HashSet<>();
        hs.add(start);

        int[] parent = new int[matrix.length];
        for(int i=0; i<matrix.length; i++)
            parent[i] = i;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int n : graph.get(cur)){
                if(!hs.contains(n)){
                    queue.offer(n);
                    hs.add(n);
                    parent[n] = cur;
                }
            }
        }

        int c = end;
        while(parent[c] != c){
            ans.add(c);
            c = parent[c];
        }
        ans.add(c);
        return ans;
    }

    public static void buildGraph(Map<Integer, List<Integer>> graph, int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                if(matrix[i][j] != 0)
                    graph.get(i).add(j);
            }
        }
    }
}
