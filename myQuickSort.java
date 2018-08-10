public class myQuickSort{
    public static void main(String[] args){
        int[] test = {2,8,4,32,5,1,58,9,3,11,6,7,21,13};
        for(int i: test){
            System.out.print(i+" ");
        }
        System.out.println("");
        myQuickSort(test);
        for(int i: test){
            System.out.print(i+" ");
        }
        System.out.println("");

    }
    // inline quick sort
    // S: O(1)
    // T: O(nlogn) , worst O(n^2), so we should pick the pivot randomly.
    public static void myQuickSort(int[] arr){
        myQuickSort(arr, 0, arr.length-1);
    }

    public static void myQuickSort(int[] arr, int start, int end){
        if(start > end)
            return;
        int index = sort(arr, start,end);
        if(start < index-1)// this is the most tricky part.
            myQuickSort(arr, start, index-1);
        if(index < end)
            myQuickSort(arr, index, end);
    }

    public static int sort(int[] arr, int start, int end){
        int pivot = arr[(start+end)/2];
        while(start <= end){
            while(arr[start] < pivot)
                start++;
            while(arr[end] > pivot)
                end--;

            if(start <= end){
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    public static void swap(int[] arr, int a , int b){
        if(a != b){
            arr[a] = arr[a] + arr[b];
            arr[b] = arr[a] - arr[b];
            arr[a] = arr[a] - arr[b];
        }
    }

}
