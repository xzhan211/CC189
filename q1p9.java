public class q1p9{
    public static void main(String[] args){
        String str = "elonwaterm";
        String key = "watermelon";
        System.out.println(check(str, key));
    }
    public static boolean check(String str, String key){
        String newStr = str+str;
        return isSubString(newStr, key);
    }
}
