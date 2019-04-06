import java.util.*;
public class IntegerToBinary{
    public static void main(String[] args){
        int num = Integer.valueOf(args[0]);
        if(num == 0) System.out.println(0);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<32; i++){
            if((num >>> i) != 0){
                int temp = num >>> i;
                if((temp & 1) == 0)
                    sb.append(0);
                else
                    sb.append(1);
            }else
                sb.append(0);
        }
        System.out.println(sb.reverse().toString());
    }
}
