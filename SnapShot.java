import java.util.*;
public class SnapShot{
    public static void main(String[] args){
        Shot ss = new Shot(5);
        ss.set(2,2);
        ss.takeSnapshot();
        ss.set(1,1);
        ss.takeSnapshot();
        System.out.println(Arrays.toString(ss.get(1)));
        System.out.println(Arrays.toString(ss.get(2)));
        ss.set(3,3);
        ss.takeSnapshot();
        ss.takeSnapshot();
        ss.takeSnapshot();
        ss.takeSnapshot();
        ss.takeSnapshot();
        System.out.println(Arrays.toString(ss.get(1)));
        System.out.println(Arrays.toString(ss.get(3)));
    }
}

class Shot{
    Map<Integer, int[]> hm;
    Set<String> hs;
    int version;
    int[] status;
    public Shot(int len){
        hm = new HashMap<>();
        hs = new HashSet<>();
        version = 0;
        status = new int[len];
    }

    public void set(int index,int val){
        status[index] = val;
    }

    public int[] get(int version){
        return hm.get(version);
    }

    public void takeSnapshot(){
        if(hs.contains(Arrays.toString(status))){
            System.out.println("same as the latest record");
            return;
        }
        hs.add(Arrays.toString(status));
        version++;
        hm.put(version, (int[]) status.clone());
    }
}
