import java.util.Random;
public class q6p7{
    public static void main(String[] args){
        System.out.println(checkFamilies(1000));

    }

    public static float checkFamilies(int n){
        int boy = 0;
        int girl = 0;
        float sum = 0;
        while(n>0){
            int[] arr = getOneFamily();
            boy += arr[0];
            girl += arr[1];
            n--;
        }
        sum = (float)girl/(boy+girl);
        return sum;
    }

    public static int[] getOneFamily(){
        Random random = new Random();
        int boy = 0;
        int girl = 0;
        while(girl == 0){
            if(random.nextBoolean() == true)
                boy++;
            else
                girl++;
        }
        int[] ans = {boy,girl};
        return ans;

    }
}
