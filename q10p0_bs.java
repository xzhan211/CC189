public class q10p0_bs{
    public static void main(String[] args){
        int[] test = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        System.out.println(bs1(test, 14));
        System.out.println(bs2(test, 14, 0, test.length-1));
    }

    public static int bs1(int[] arr, int num){
        int pos = -1;
        int start = 0;
        int end = arr.length-1;
        int mid = -1;
        while(start <= end){
            mid = (start + end)/2;
            if(arr[mid] == num)
                return mid;
            else if(num > arr[mid]){
                start = mid + 1;
            }else if(num < arr[mid])
                end = mid - 1;
        }
        return -1;
    }

    public static int bs2(int[] arr, int num, int start, int end){
        if(start > end)
            return -1;
        int mid = (start + end)/2;
        if(num == arr[mid])
            return mid;
        else if(num > arr[mid]){
            return bs2(arr, num, mid+1, end);
        }else if(num < arr[mid])
            return bs2(arr, num, start, mid-1);
        return -1;
    }

}
