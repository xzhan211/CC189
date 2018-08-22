public class q16p3{
    public static void main(String[] args){
        int[] startA = {2,3};
        int[] endA = {10,5};
        int[] startB = {7,1};
        int[] endB = {1,4};
        cal(startA, endA, startB, endB);
    }
    //[x,y]
    public static void cal(int[] startA, int[] endA, int[] startB, int[] endB){
        int kA = (startA[1] - endA[1])/(startA[0]-endA[0]);
        int kB = (startB[1] - endB[1])/(startB[0]-endB[0]);
        if(kA == kB){
            System.out.println("No intersection");
            return;
        }


    }
}
