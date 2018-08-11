import java.util.*;
public class q10p5{
    public static void main(String[] args){
        String[] strs = {"at","","","","ball","","","car","","","dad","",""};
        String str = "ball";
        System.out.println(search(strs, str, 0, strs.length));
    }

    public static int search(String[] strs, String str, int start, int end){
        if(start > end)
            return -1;
        int mid = (start + end)/2;
        if(strs[mid].isEmpty()){
            int left = mid - 1;
            int right = mid + 1;
            while(true){
                if(left<start && right>end){
                    return -1;
                }else if(right <= end && !strs[right].isEmpty()){
                    mid = right;
                    break;
                }else if(left >= start && !strs[left].isEmpty()){
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }
        if(str.equals(strs[mid]))
            return mid;
        else if(strs[mid].compareTo(str) < 0){
            return search(strs, str, mid+1, end);
        }else{
            return search(strs, str, start, mid-1);
        }
    }
}
