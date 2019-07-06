public class StringIndexOf{
    public static void main(String[] args){
        String str = "abcdefghijklefgmn";
        int i = str.indexOf("efg");
        System.out.println(i);
        System.out.println(str.indexOf("efg", i+1));
    }
}
