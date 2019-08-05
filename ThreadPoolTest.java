import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadPoolTest {
    public static void main(String[] args) throws Exception {
    	ExecutorService pool = Executors.newFixedThreadPool(6);
    	//Td td = new Td(); 
    	Runnable td = () ->{
    		for(int i=0; i<51; i++) {
    			System.out.println(Thread.currentThread().getName() + "'s i value is : "+i);
    		}
    	};
    	
    	
    	pool.submit(td);
    	pool.submit(td);
    	pool.shutdown();
    }
}

class Td implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println(Thread.currentThread().getName() + "'s i value is : "+i);
		}
	}
}