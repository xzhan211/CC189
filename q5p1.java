public class q5p1{
    public static void main(String[] args){
        int N = 954;
        int M = 15;
        System.out.println("N >>"+ Integer.toBinaryString(N));
        System.out.println("M >>"+ Integer.toBinaryString(M));
        int j = 8;
        int i = 5;
        N = merge(N, M, j, i);
        System.out.println("ans >>"+ Integer.toBinaryString(N));
    }

    public static int merge(int big, int small, int start, int end){
        int temp1 = ~((1<<start)-1);
        //System.out.println("temp1 >> "+ Integer.toBinaryString(temp1));
        int temp2 =((1<<(end-1))-1) | temp1;
        //System.out.println("temp2 >> "+ Integer.toBinaryString(temp2));
        big = big & temp2;
        //System.out.println("big >> "+ Integer.toBinaryString(big));
        big = big | (small << (end-1));
        //System.out.println("big >> "+ Integer.toBinaryString(big));
        return big;
    }
}
