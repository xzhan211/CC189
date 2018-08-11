public class q10p3{
    public static void main(String[] args){
        int[] test = {15,16,19,20,25,1,3,4,5,7,10,14};
        for(int i = 0; i<test.length; i++)
            System.out.println(search(test, test[i]));
    }

    public static int search(int[] arr, int n){
        return search(arr, n, 0, arr.length-1);
    }
    // still something wrong.
    // if in test, I will use another way.
    public static int search(int[] arr, int n, int left, int right){
        if(left <= right){

        int mid = (left + right)/2;
        if(arr[mid] == n)
            return mid;
        if(arr[left] == n)
            return left;
        if(arr[right] == n)
            return right;


        if((arr[mid] < arr[right]) && (arr[mid] < n) && (n < arr[left])){
            return search(arr, n, mid+1, right);

        }else if((arr[mid] < arr[right]) && (arr[mid] < n) && (n > arr[left])){
            return search(arr, n, left, mid-1);


        }else if((arr[mid] < arr[right]) && (arr[mid] > n)){
            return search(arr, n, (left+mid-1)/2, mid-1);

        }else if((arr[mid] > arr[right]) && (arr[mid] < n)){
            return search(arr, n, mid+1, (right+mid+1)/2);

        }else if((arr[mid] > arr[right]) && (arr[mid] > n) && (n < arr[left])){
            return search(arr, n, mid+1, right);

        }else if((arr[mid] > arr[right]) && (arr[mid] > n) && (n > arr[left])){
            return search(arr, n, left, mid-1);
        }


        //return -1;
        }
        return -1;
    }
}
