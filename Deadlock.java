import java.util.*;

public class Deadlock{
    public static void main(String[] args){
        Thread t1 = new Thread(new Test(true));
        Thread t2 = new Thread(new Test(false));
        t1.start();
        t2.start();
    }
}

class Test implements Runnable{
    private boolean flag;
    public Test(boolean flag){
        this.flag = flag;
    }
    public void run(){
        if(flag){
            synchronized(Mylock.obj1){
                System.out.println("if obj1");
                synchronized(Mylock.obj2){
                    System.out.println("else obj1");
                }
            }
        }else{
            synchronized(Mylock.obj2){
                System.out.println("if obj2");
                synchronized(Mylock.obj1){
                    System.out.println("else obj2");
                }
            }
        }
    }
}

class Mylock{
    static Object obj1 = new Object();
    static Object obj2 = new Object();
}
