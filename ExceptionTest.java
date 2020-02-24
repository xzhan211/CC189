import java.util.*;
public class ExceptionTest{
    public static void main(String[] args){
        String[] arr = {"a", "1", "+", "1", "$"};
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        set.add("$");
        for(String c : arr){
            if(stack.isEmpty()){
                if(!set.contains(c))
                    // Runtime exception no need to be threw explicitly
                    // but we can still use try... catch.
                    //try{
                        stack.push(Integer.valueOf(c));
                    //}catch(NumberFormatException ne){
                    //    System.out.println("^^^^^^^^^^^^ ");
                    //    ne.printStackTrace();
                    //    System.out.println("## " + ne.toString());
                    //}
                else
                    System.out.println("first char cannot be sign");
            }else{
                if(!set.contains(c))
                    try{
                        stack.push(Integer.valueOf(c));
                    }catch(NumberFormatException ne){
                        ne.printStackTrace();
                        System.out.println("## " + ne.toString());
                    }
                else{
                    int a = stack.pop();
                    int b = stack.pop();
                    try{
                        stack.push(cal(a, b, c));
                    }catch(ArithmeticException ae){
                        ae.printStackTrace();
                        System.out.println("## " + ae.toString());
                    }catch(Exception e){
                        e.printStackTrace();
                        System.out.println("## " + e.toString());
                    }
                }
            }
        }
        System.out.println(stack.pop());
    }

    public static int cal(int a, int b, String c) throws Exception{
        int ans = -666;
        if(c.equals("+")){
            ans = a + b;
        }else if(c.equals("-")){
            ans = b - a;
        }else if(c.equals("*")){
            ans =  a * b;
        }else if(c.equals("/")){
            ans = b / a;
        }else{
            System.out.println("sign is error");
            throw new Exception("error sign");
        }
        return ans;

    }
}
