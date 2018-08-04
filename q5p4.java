public class q5p4{
    public static void main(String[] args){
        int input = 50055;
        System.out.println(Integer.toBinaryString(input));
        System.out.println(Integer.toBinaryString(getNextMin(input)));

        System.out.println("=======");
        System.out.println(Integer.toBinaryString(getPreviousMax(input)));
    }
    //T: O(n)
    //S: O(1)
    //A: pos start from 0.

    public static int getNextMin(int n){
        int zero = 0;
        int one = 0;
        int pos = -1;
        int mask = 1;
        int cnt = 0;
        while((mask<<cnt) <= n){
            int temp = n & (mask<<cnt);
            if(temp == 0)
                zero++;
            else
                one++;
            if(one>0 && (temp == 0)){
                pos = cnt;
                break;
            }
            cnt++;
        }
        // error, cannot find solution
        if(pos == -1)
            return -1;

        n = n | (mask<<pos);
        for(int i = 0; i<pos; i++){
            n = n & (~(mask<<i));
        }

        one--;
        for(int i = 0; i<one; i++){
            n = n | (mask<<i);
        }
        return n;
    }

    public static int getPreviousMax(int n){
        int zero = 0;
        int one = 0;
        int pos = -1;
        int mask = 1;
        int cnt = 0;

        while((mask<<cnt) <= n){
            int temp = n & (mask<<cnt);
            if(temp == 0)
                zero++;
            else
                one++;
            if(zero >0 && (temp != 0)){
                pos = cnt;
                break;
            }
            cnt++;
        }
        System.out.println("one >> "+ one + "   zero >> "+ zero);

        // error, cannot find solution
        if(pos == -1)
            return -1;

        for(int i = 0; i<=pos; i++)
            n &= (~(mask<<i));

        one--;

        for(int i = pos-1; i>= pos-one-1; i--)
            n = n | (mask<<i);

        return n;
    }
}
