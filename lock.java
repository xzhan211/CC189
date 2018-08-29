import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class input extends Thread{
    private LockedATM atm;
    public input(LockedATM atm){
        this.atm = atm;
    }

    @Override
    public void run(){
        atm.deposit(100);
    }
}

class output extends Thread{
    private LockedATM atm;
    public output(LockedATM atm){
        this.atm = atm;
    }

    @Override
    public void run(){
        atm.withdraw(30);
    }
}

public class lock{
    public static void main(String[] args){
        LockedATM source = new LockedATM();
        input in = new input(source);
        output ou = new output(source);
        in.start();
        ou.start();

    }
}

class LockedATM{
    private Lock lock;
    private int balance = 100;

    public LockedATM(){
        lock = new ReentrantLock();
    }

    public int withdraw(int value){
        lock.lock();
        int temp = balance;
        try{
            Thread.sleep(100);
            temp = temp - value;
            Thread.sleep(100);
            balance = temp;
            System.out.println("withdraw >> " + balance);
        }catch(InterruptedException e){
            System.out.println("error");
        }
        lock.unlock();
        return temp;
    }

    public int deposit(int value){
        lock.lock();
        int temp = balance;
        try{
            Thread.sleep(100);
            temp = temp + value;
            Thread.sleep(50);
            balance = temp;
            System.out.println("deposit >> " + balance);
        }catch (InterruptedException e){
            System.out.println("error2");
        }
        lock.unlock();
        return temp;
    }
}
