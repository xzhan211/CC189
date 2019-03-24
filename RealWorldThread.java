import java.util.*;
class RealWorldThread{
    public static void main(String[] args){
        new Thread(){
            @Override
            public void run(){
                for(int i=0; i<100; i++)
                    System.out.println(Thread.currentThread().getName() + "....."+i);
            }
        }.start();

        for(int x=0; x<100; x++)
            System.out.println(Thread.currentThread().getName() + "....."+x);

        Runnable r = new Runnable(){
            @Override
            public void run(){
                for(int x=0; x<100; x++)
                    System.out.println(Thread.currentThread().getName() + "....."+x);
            }
        };
        new Thread(r).start();
    }
}
