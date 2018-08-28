public class q16p18{
    public static void main(String[] args){
        String value = "catcatgocatgo";
        String pattern = "sb";
        System.out.println("match >> "+ match(value, pattern));
    }

    public static boolean match(String value, String pattern){
        int len = value.length();
        for(int i = 0; i<len; i++){
            String valueA = value.substring(0, i);
            for(int j = i; j<=len; j++){
                for(int k = j; k<=len; k++){
                    String valueB = value.substring(j,k);
                    String cand = build(pattern, valueA, valueB);
                    System.out.println("A: "+ valueA);
                    System.out.println("B: "+ valueB);
                    System.out.println(cand);
                    if(cand.equals(value))
                        return true;
                }
            }
        }
        return false;
    }
    public static String build(String pattern, String valueA, String valueB){
        StringBuilder sb = new StringBuilder();
        char a = pattern.charAt(0);
        for(char c: pattern.toCharArray()){
            if(c == a)
                sb.append(valueA);
            else
                sb.append(valueB);
        }
        return sb.toString();
    }
}
