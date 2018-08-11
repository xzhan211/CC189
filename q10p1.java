public class q10p1{
    public static void main(String[] args){
        int[] a = {10,20,30,40,50,60,70,80, -1, -1, -1, -1,-1,-1};
        int[] b = {11,21,31,41,51,61};
        merge(a, b);
        for(int i : a){
            System.out.print(i+" ");
        }
        System.out.println("");
    }
    public static void merge(int[] a, int[] b){
        int index = a.length - 1;
        int indexB = b.length - 1;
        int indexA = index - indexB - 1;
        while(indexB>=0){
            if(indexA>=0 && a[indexA] >= b[indexB]){
                a[index] = a[indexA];
                indexA--;
            }else{
                a[index] = b[indexB];
                indexB--;
            }
            index--;
        }
    }
}
