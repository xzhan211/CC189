import java.util.*;
import java.lang.*;

public class q8p6{
    public static void main(String[] args){
        int n = 6;
        Tower[] towers = new Tower[n];
        for(int i=0; i<3; i++){
            towers[i] = new Tower(i);
        }

        for(int i = n-1; i>=0; i--){
            towers[0].add(i);
        }
        for(Integer num: towers[0].disks){
            System.out.println(num);
        }
        System.out.println("============");
        towers[0].moveDisks(n, towers[2], towers[1]);
        for(Integer num: towers[2].disks){
            System.out.println(num);
        }


    }
}

class Tower{
    public Stack<Integer> disks;
    public Tower(int i){
        disks = new Stack<Integer>();
    }

    public void add(int d){
        if(!disks.isEmpty() && disks.peek() <=d){
            System.out.println("Error placing disk "+ d);
        }else {
            disks.push(d);
        }
    }
    // this method is the key point
    public void moveTopTo(Tower t){
        int top = disks.pop();
        t.add(top);
    }

    public void moveDisks(int n, Tower destination, Tower buffer){
        if(n>0){
            moveDisks(n-1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n-1, destination, this);
        }
    }
}
