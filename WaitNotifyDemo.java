public class WaitNotifyDemo{
    public static void main(String[] args){
        Res r = new Res();
        new Thread(new Input(r)).start();
        new Thread(new Output(r)).start();
    }
}

class Res{
    private String name;
    private String sex;
    private boolean flag = false;

    public synchronized void set(String name, String sex){
        if(flag)
            try{this.wait();}catch(Exception e){}
        this.name = name;
        this.sex = sex;
        flag = true;
        this.notify();
    }

    public synchronized void out(){
        if(!flag)
            try{this.wait();}catch(Exception e){}
        System.out.println(name+"....."+sex);
        flag = false;
        this.notify();
    }
}

class Input implements Runnable{
    private Res r;
    Input(Res r){
        this.r = r;
    }
    @Override
    public void run(){
        int x = 0;
        while(true){
            if(x==0)
                r.set("Tom", "man");
            else
                r.set("Kate", "woman");
            x = (x+1)%2;
        }
    }
}

class Output implements Runnable{
    private Res r;
    Output(Res r){
        this.r = r;
    }

    public void run(){
        while(true){
            r.out();
        }
    }
}
