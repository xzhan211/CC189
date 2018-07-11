import java.util.*;
public class q4p7{
    public static void main(String[] args){
        char[] inputArr = {'a','b','c','e','d','f'};
        char[][] dependence = {
            {'a','d'},
            {'f','b'},
            {'b','d'},
            {'f','a'},
            {'d','c'}
        };
        System.out.println(order(inputArr, dependence));
    }

    // Navie way, Brute force
    // T: O(m*n^3)
    // S: O(n)
    // A: bad management in input[] output[]
    // Using graph+hashset, T: O(n+m)
    //
    public static List<Character> order(char[] inputArr ,char[][] dependence){
        int len = inputArr.length;
        int[] input = new int[len];
        int[] output = new int[len];
        for(int i = 0; i<len; i++){
            for(int j = 0; j<dependence.length; j++){
                if(inputArr[i] == dependence[j][0]){
                    output[i]++;
                    dependence[j][0] ^= 256;
                    for(int k = 0; k<len; k++){
                        if(inputArr[k] == dependence[j][1]){
                            input[k]++;
                            dependence[j][1] ^= 256;
                            break;
                        }
                    }
                }
            }
        }

        for(int i = 0; i<dependence.length; i++){
            for(int j = 0; j<2; j++){
                dependence[i][j] ^= 256;
            }
        }

        List<Character> ans = new ArrayList<>();

        while(ans.size() < len){
            for(int i = 0 ; i< len; i++){
                if(input[i] == 0 && ans.contains(inputArr[i]) == false){
                    for(int j = 0; j<dependence.length; j++){
                        if(inputArr[i] == dependence[j][0]){
                            dependence[j][0] ^= 256;
                            for(int k = 0; k<len; k++){
                                if(inputArr[k] == dependence[j][1]){
                                    input[k]--;
                                    break;
                                }
                            }
                        }
                    }
                    ans.add(inputArr[i]);
                }
            }
        }
        return ans;
    }
// ------------- below is the new code ---------------------------
//
// un-test
//
//
    public static Project[] findBuildOrder(String[] projects, String[][] dependencies){
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());

    }

    public static Graph buildGraph(String[] projects, String[][] dependencies){
        Graph graph = new Graph();
        for(String project : projects){
            graph.getOrCreateNode(project);
        }

        for(String[] dependency: dependencies){
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }
        return graph;

    }




    public static Project[] orderProjects(ArrayList<Project> projects){
        Project[] order = new Project[projects.size()];
        int endOfList = addNonDependent(order, projects, 0);
        int toBeProcessed = 0;
        while(toBeProcessed < order.length){
            Project current = order[toBeProcessed];
            if(current == null){
                return null;
            }

            ArrayList<Project> children = current.getChildren();
            for(Project child: children){
                child.decrementDependencies();
            }

            endOfList = addNonDependent(order, children, endOfList);
            toBeProcessed++;
        }
        return order;
    }


    public static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset){
        for(Project project:projects){
            if(project.getNumberDependencies() == 0){
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }

}


// better way, same logic
// T: O(n+m)
//



class Graph{
    private ArrayList<Project> nodes = new ArrayList<Project>();
    private HashMap<String, Project> map = new HashMap<String, Project>();

    public Project getOrCreateNode(String name){
        if(!map.containsKey(name)){
            Project node = new Project(name);
            nodes.add(node);
            map.put(name,node);
        }
        return map.get(name);
    }

    public void addEdge(String startName, String endName){
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);
        start.addNeighbor(end);
    }

    public ArrayList<Project> getNodes(){
        return nodes;
    }
}


class Project{
    private ArrayList<Project> children = new ArrayList<Project>();
    private HashMap<String, Project> map = new HashMap<String, Project>();
    private String name;
    private int dependencies = 0;

    public Project(String n){
        name = n;
    }

    public void addNeighbor(Project node){
        if(!map.containsKey(node.getName())){
            children.add(node);
            map.put(node.getName(), node);
            node.incrementDependencies();
        }
    }

    public void incrementDependencies(){
        dependencies++;
    }

    public void decrementDependencies(){
        dependencies--;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Project> getChildren(){
        return children;
    }

    public int getNumberDependencies(){
        return dependencies;
    }
}

//----------------- below is the topological sort--------------------
//Do it next tiem.....
