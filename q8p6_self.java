import java.util.*;
import java.lang.*;
public class q8p6_self{
    public static void main(String[] args){
        int in = 5;
        Tower[] towers = new Tower[3];
        for(int i = 0; i<3; i++){
            towers[i] = new Tower();
        }

        for(int i = in-1; i>=0; i--){
            towers[0].add(i);
        }

        for(Integer num: towers[0].level){
            System.out.println(num);
        }
        System.out.println("===========");
        towers[0].move(in, towers[2], towers[1]);
        for(Integer num: towers[2].level){
            System.out.println(num);
        }
    }
}

class Tower{
    public Stack<Integer> level;
    public Tower(){
        level = new Stack<Integer>();
    }

    public void add(int n){
        if(!level.empty() && level.peek() < n)
            System.out.println("Error1");
        else
            level.push(n);
    }

    public void moveTopTo(Tower t){
        if(!t.level.empty() && (this.level.peek() > t.level.peek()))
            System.out.println("Error2");
        else
            t.add(this.level.pop());
    }

    public void move(int n, Tower dest, Tower buf){
        if(n>0){
            move(n-1, buf, dest);
            moveTopTo(dest);
            buf.move(n-1, dest, this);
        }
    }
}
