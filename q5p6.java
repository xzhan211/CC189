public class q5p6{
    public static void main(String[] args){
        int a = 29;
        int b = 15;
        int c = a ^ b;
        char[] arr = Integer.toBinaryString(c).toCharArray();
        int cnt = 0;
        for(char cc : arr){
            if(cc == '1')
                cnt++;
        }
        System.out.println(cnt);
        System.out.println("=======");
        System.out.println("check1 >> "+ check1(a, b));


    }

    public static int check1(int a , int b){
        int cnt = 0;
        for(int c= a^b; c!=0; c &= (c-1)){
        //for(int c = a^b; c!=0; c >>= 1){
           // cnt += c&1;
           cnt++;
        }
        return cnt;
    }
}
