public class q8p11_2{
    public static void main(String[] args){
        int n = 10;
        System.out.println(makeChange(n));
    }

    public static int makeChange(int n){
        int[] denoms = {25,10,5,1};
        // use the larger item first.
        //int[] denoms = {1,5,10,25};
        return makeChange(n, denoms, 0);
    }

    public static int makeChange(int n, int[] denoms, int index){
        //when all the larger items are use up, this means that there is only
        //one way to meet the n. So simply return 1.
        if(index >= denoms.length-1) return 1;
        int denomAmount = denoms[index];
        int ways = 0;
        for(int i= 0; i*denomAmount<=n; i++){
            int amountRemaining = n - i*denomAmount;
            ways += makeChange(amountRemaining, denoms, index+1);
        }
        return ways;
    }
}

// we can also use DP to reduce the duplicated calculation with same n and
// index.
