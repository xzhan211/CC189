public class q1p3{
    public static void main(String[] args){
        String test = "Mr John Smith    ";
        int len = 13;
        System.out.println(method1(test, len));
        System.out.println(method2(test, len));
    }


    // T
    // S
    // A in replaceAll(), regex should be used. It should be better.
    public static String method1(String test, int len){
        test = test.trim();
        test = test.replaceAll(" ","%20");
        return test;
    }

    // T O(n)
    // S O(n)
    // A better,
    public static String method2(String test, int len){
        int cnt = 0;
        int index = 0;
        char[] arr = test.toCharArray();
        for(int i = 0; i<len; i++){
            if(arr[i] == ' ')
                cnt++;
        }
        index = 2*cnt + len;
        for(int i = len-1; i>=0; i--){
            if(arr[i] == ' '){
                arr[index-1] = '0';
                arr[index-2] = '2';
                arr[index-3] = '%';
                index = index - 3;
            }else{
                arr[index-1] = arr[i];
                index--;
            }
        }
        return new String(arr);
    }
}
