public class q8p8{
    public static void main(String[] args){
        String test = "aaaaaaaaaaaaa";
        permutation(test);
    }

    public static void permutation(String str){
        permutation(str, "");
    }

    public static void permutation(String str, String prefix){
        if(str.length() == 0){
            System.out.println(prefix);
            return;
        }
        for(int i = 0; i<str.length(); i++){
            if(i>0 && (str.charAt(i-1)==str.charAt(i))){
                continue;
            }
            String res = str.substring(0, i)+str.substring(i+1);
            permutation(res, prefix+str.charAt(i));
        }
    }
}
