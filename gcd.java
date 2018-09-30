public class gcd{
    public static void main(String[] args){
        int a = 22;
        int b = 40;
        System.out.println(helper(a,b));
    }
    public static int helper(int a, int b){
        while(b>0){
            int tmp = a;
            a = b;
            b = tmp%b;
        }
        return a;
    }
}
