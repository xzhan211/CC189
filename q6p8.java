public class q6p8{
    static int breakingPoint = 76;
    static int countDrops = 0;
    public static void main(String[] args){
        System.out.println(findBreakingPoint(100));
    }

    public static boolean drop(int floor){
        countDrops++;
        return floor >= breakingPoint;
    }

    public static int findBreakingPoint(int floors){
        int interval = 14;
        int previousFloor = 0;
        int egg1 = interval;
        while(!drop(egg1) && egg1 <= floors){
            previousFloor = egg1;
            interval--;
            egg1 += interval;
        }
        int egg2 = previousFloor+1;
        while(egg2<egg1 && egg2 <= floors && !drop(egg2)){
            egg2 += 1;
        }
        return egg2>floors? -1:egg2;
    }
}
