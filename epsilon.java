public class epsilon{
    public static void main(String[] args){
        double a = 5.423483762;
        double b = 5.423480959;
        double c = 3.3849859843758;
        System.out.println(epsilonFunc.floorToNearestEpsilon(c));
        System.out.println(epsilonFunc.equal(a,b));
        System.out.println(epsilonFunc.equal(a,c));
        System.out.println(epsilonFunc.equal(c,b));

    }
}

class epsilonFunc{
    private static double e = .00001;
    public static double floorToNearestEpsilon(double d){
        int temp = (int) (d / e);
        return (double)temp * e;
    }

    public static boolean equal(double a, double b){
        if(Math.abs(a-b) >= e)
            return true;
        else
            return false;
    }
}
