import java.util.*;
public class MulHashMap{
    public static void main(String[] args){
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "aaa");
        hm.put(2, "bbb");
        hm.put(3, "ccc");
        hm.put(1, "aaa111");
        hm.put(1, "aaa222");
        //ArrayList<String> valueArr = hm.get(1);

        System.out.println(hm.get(2));
        System.out.println(hm.get(1));
        System.out.println("-------");
        HashMap<Integer, List<String>> ht = new HashMap<>();
        store(ht,1, "aaa0");
        store(ht,1, "aaa1");
        store(ht,1, "aaa2");
        store(ht,2, "bbb");
        store(ht,2, "bbbb");
        store(ht,3, "ccc");
        store(ht,4, "ddd");
        System.out.println(ht.get(1));
        System.out.println(ht.get(3));

    }
        public static void store(HashMap<Integer, List<String>> hm, int key, String str){
            if(hm.containsKey(key)){
                hm.get(key).add(str);
            }else{
                ArrayList<String> arr = new ArrayList<>();
                arr.add(str);
                hm.put(key, arr);
            }
        }

        public static List<String> getLists(HashMap<Integer, List<String>> hm, int key){
            return hm.get(key);
        }
}
