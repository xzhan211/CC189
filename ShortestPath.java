import java.util.*;
public class ShortestPath{
    public static void main(String[] args){
        int[][] matrix = {
            {0, 2, 10, 0, 0, 0},
            {2, 0, 1, 10, 0, 0},
            {10, 1, 0, 5, 1, 0},
            {0, 10, 5, 0, 2, 1},
            {0, 0, 1, 2, 0, 0},
            {0, 0, 0, 1, 0, 0}
        };

        int start = Integer.valueOf(args[0]);
        int end = Integer.valueOf(args[1]);
        List<Integer> ans = shortest(matrix, start, end);
        for(int i=ans.size()-1; i>=0; i--)
            System.out.println(ans.get(i));
    }

    public static List<Integer> shortest(int[][] matrix, int start, int end){
        Map<Integer, List<int[]>> graph = new HashMap<>();
        buildGraph(graph, matrix);
        List<Integer> ans = new ArrayList<>();
        int[] parent = new int[matrix.length];
        int[] dist = new int[matrix.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        for(int i=0; i<matrix.length; i++)
            parent[i] = i;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int[]{start, 0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int num = cur[0];
            int time = cur[1];
            for(int[] n : graph.get(num)){
                if(dist[n[0]] > n[1] + time){
                    dist[n[0]] = n[1] + time;
                    queue.offer(new int[] {n[0], n[1]+time});
                    parent[n[0]] = num;
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

    public static void buildGraph(Map<Integer, List<int[]>> graph, int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                if(matrix[i][j] != 0)
                    graph.get(i).add(new int[]{j, matrix[i][j]});;
            }
        }
    }
}
