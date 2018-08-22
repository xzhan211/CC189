public class q16p1{
    public static void main(String[] args){
        int[] test = {1, 2};
        swap2(test);
        System.out.println(test[0]+":**:"+test[1]);
    }

    public static void swap(int[] test){
        test[0] = test[0] + test[1];
        test[1] = test[0] - test[1];
        test[0] = test[0] - test[1];
    }

    public static void swap2(int[] test){
        test[0] = test[0]^test[1];
        test[1] = test[0]^test[1];
        test[0] = test[0]^test[1];
    }
}
