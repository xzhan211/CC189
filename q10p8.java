public class q10p8{
    public static void main(String[] args){

    }


    //no need to sort array first.
    //using bit voctor can save a lot of space.
    //but the restriction is obvious: data range should be clear.
    public static void check(int[] arr){
        bitSet set = new bitSet(32000);
        for(int i = 0; i<arr.length; i++){
            int num = arr[i];
            int num0 = num - 1; //why?
            if(set.get(num0)){
                System.out.println("duplication: "+ num);
            }else
                set.set(num0);
        }
    }
}

class bitSet{
    int[] bs;
    public bitSet(int n){
        bs = new int[(n>>5)+1]; //why?
    }

    public void set(int pos){
        int page = pos >> 5;
        int bit = pos & 0x1f;
        bs[page] |= (1<<bit);
    }

    public  boolean get(int pos){
        int page = pos >> 5;
        int bit = pos & 0x1f;
        return (bs[page] & (1<<bit)) == 1;
    }

}
