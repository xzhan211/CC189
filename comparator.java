import java.util.*;
public class comparator{
    public static void main(String[] args){
        Interval e1 = new Interval(0, 30);
        Interval e2 = new Interval(5, 10);
        Interval e3 = new Interval(15, 20);
        Interval[] arr = {e1,e2,e3};
        Arrays.sort(arr, new Comparator<Interval>(){
            public int compare(Interval t1, Interval t2){
                return t1.start - t2.start;
            }


        });
        for(Interval i : arr)
            System.out.println(">> "+i.start +" :: "+i.end);
    }
}

class Interval{
    int start;
    int end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}
