public class BitReverse{
    public static void main(String[] args){
        int n = Integer.valueOf(args[0]);
        int lo = 0;
        int hi = 31;
        while(hi > lo){
            int h = 1 & n>>>hi;
            int l = 1 & n>>>lo;
            if(h != l){
                int temph = 1 << hi;
                int templ = 1 << lo;
                if(h == 1)
                    n = n | templ;
                else
                    n = n & ~templ;
                if(l == 1)
                    n = n | temph;
                else
                    n = n & ~temph;
            }
            hi--;
            lo++;
        }
        System.out.println(n);
    }
}
