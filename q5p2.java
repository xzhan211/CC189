public class q5p2{
    public static void main(String[] args){
        double n = 0.72;
        String ans = check(n);
        System.out.println(ans);
    }

    public static String check(double num){
        if(num>= 1 || num<=0)
            return "error";

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while(num >0){
            if(binary.length()>=32){
                System.out.println("ans >> "+ binary.toString());
                return "error";
            }
            double r = num * 2;
            if(r>=1){
                binary.append(1);
                num = r-1;
            }else{
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }
}
