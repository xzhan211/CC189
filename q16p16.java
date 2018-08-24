import java.util.*;
public class q16p16{
    public static void main(String[] args){
        int[] input = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        find1(input);
        find2(input);
    }


    //poor solution
    //T:O(nlgn)
    //S:O(n)
    public static void find1(int[] input){
        int[] sortInput = input.clone();
        Arrays.sort(sortInput);
        int start = -1;
        int end = -1;
        for(int i = 0; i<input.length; i++){
            if(input[i]!=sortInput[i] && start == -1){
                    start = i;
                    break;
            }
        }
        for(int i = input.length-1; i>=0; i--){
            if(input[i]!=sortInput[i] && end == -1){
                    end = i;
                    break;
            }
        }
        System.out.println("start >> "+start+"  :::  end >> "+ end);
    }
    //better way
    //T: O(n)
    //S: O(1)
    public static void find2(int[] input){
        int start = -1;
        int end = -1;
        int leftMax = -1;
        int rightMin = -1;
        start = findStart(input);
        end = findEnd(input);
        leftMax = findLeftMax(input, start, end);
        rightMin = findRightMin(input, start,end);
        start = shrinkLeft(input, start, rightMin);
        end = shrinkRight(input, end, leftMax);
        System.out.println("start >> "+start+"  :::  end >> "+ end);
    }
    public static int findStart(int[] input){
        int start = 0;
        for(int i = 1; i<input.length; i++){
            if(input[i]<input[i-1]){
                start = i;
                return start;
            }
        }
        return input.length-1;
    }
    public static int findEnd(int[] input){
        int end = 0;
        for(int i = input.length-2; i>=0; i--){
            if(input[i]>input[i+1]){
                end = i;
                return end;
            }
        }
        return 0;
    }
    public static int findLeftMax(int[] input, int start, int end){
        int leftMax = input[start-1];
        for(int i = start; i<=end; i++){
            if(input[i]>leftMax)
                leftMax = input[i];
        }
        return leftMax;
    }
    public static int findRightMin(int[] input, int start, int end){
        int rightMin = input[end+1];
        for(int i = start; i<=end; i++){
            if(input[i]<rightMin)
                rightMin = input[i];
        }
        return rightMin;
    }
    public static int shrinkLeft(int[] input, int start, int rightMin){
        int newStart = 0;
        for(int i = start-1; i>=0; i--){
            if(input[i]>=rightMin)
                newStart = i;
        }
        return newStart;
    }
    public static int shrinkRight(int[] input, int end, int leftMax){
        int newEnd = 0;
        for(int i = end+1; i<input.length; i++){
            if(input[i]<=leftMax)
                newEnd = i;
        }
        return newEnd;
    }

}
