public class q10p11{
    public static void main(String[] args){
        int[] arr = {1,3,5,6,4,7,8,9,2};
        peakSort(arr);
        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println("");
    }

    public static void peakSort(int[] arr){
        for(int i = 1; i<arr.length; i+=2){
            int maxPos = max(arr, i);
            swap(arr, i, maxPos);
            System.out.print(">> ");
            for(int n : arr){
                System.out.print(n+" ");
            }
            System.out.println("");
        }
    }

    public static int max(int[] arr, int i){
        if(i == arr.length-1)
            return arr[i]>=arr[i-1] ? i: i-1;

        if(i<arr.length-1){
            if(arr[i-1]>=arr[i] && arr[i-1]>=arr[i+1])
                return i-1;
            else if(arr[i]>= arr[i+1] && arr[i]>=arr[i-1])
                return i;
            else if(arr[i+1]>= arr[i]&& arr[i+1]>=arr[i-1])
                return i+1;
        }

        return -1;
    }

    public static void swap(int[] arr, int i, int max){
        if(i != max){
            arr[i] = arr[i] + arr[max];
            arr[max] = arr[i] - arr[max];
            arr[i] = arr[i] - arr[max];
        }
    }
}
