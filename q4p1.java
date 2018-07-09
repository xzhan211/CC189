import java.util.*;
import java.lang.*;
enum State{Unvisited, Visited, Visiting;}
class Node{
    State state;
    private int value;
    public Node(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
    private List<Node> nb = new ArrayList<>();

    public void setAdjacent(Node neighbour){
        nb.add(neighbour);
    }
    public List<Node> getAdjacent(){
        return nb;
    }
}

class Graph{
    private int[][] adjacentMatrix;
    private List<Node> nodeArr = new ArrayList<>();
    public Graph(int n){
        adjacentMatrix = new int[n][n];
    }

    public void initMatrix(int[][] matrix){

    }

    public List<Node> getNodes(){
        return nodeArr;
    }

    public void initGraph(){
        int value = 0;
        int len = nodeArr.size();
        int cnt = 0;
        while(cnt < len){
            nodeArr.add(new Node(cnt));
        }

        while(value < len){
        // add some code to init each node's neighbour address
        // just put it in Node's field nb.
        }
    }
}

/* above part is the basic idea to inital graph  */

public class q4p1 {
    public static void main(String[] args){
        //
    }
    // T: O(n)
    // S: O(n)
    // A: the hardest part is imagine what method the Graph/ Node class should
    // have. The method should be reasonable.
    // Ask interviewer!
    //
    public static boolean search(Graph g, Node start, Node end){
        if(start == end) return true;
        LinkedList<Node> queue = new LinkedList<>();
        for(Node n : g.getNodes()){
            n.state = State.Unvisited;
        }
        start.state = State.Visiting;
        queue.add(start);
        Node temp;
        while(queue.size()>0){
            temp = queue.removeFirst();
            if(temp != null){
                for(Node n : temp.getAdjacent()){
                    if(n == end)
                        return true;
                    if(n.state == State.Unvisited){
                        n.state = State.Visiting;
                        queue.add(n);
                    }
                }
            }
            temp.state = State.Visited;
        }
        return false;
    }
}
