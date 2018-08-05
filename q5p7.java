public class q5p7{
    public static void main(String[] args){
        int in = 65432;
        System.out.println(Integer.toBinaryString(in));
        System.out.println(Integer.toBinaryString(swap(in)));
    }
    //A: check the question clear, input value type is integer
    //So I can use the template like 0xaaaaaaaa, 0x55555555
    public static int swap(int n){
        return ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) <<1);
    }
}
