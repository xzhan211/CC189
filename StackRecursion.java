import java.util.Stack;
public class StackRecursion{
    public static void main(String[] args){
        int a = 1;
        int b = 1;
        Stack<Integer> stk = new Stack<>();
        stk.push(a);
        stk.push(b);
        int loop = Integer.valueOf(args[0]);
        int ans = 0;
        if(loop <= 2) System.out.println(1);
        else{
            loop = loop - 2;
            while(loop > 0){
            int p2 = stk.pop();
            int p1 = stk.pop();
            int s = p1 + p2;
            ans = s;
            stk.push(p2);
            stk.push(s);
            loop--;
        }
        System.out.println(ans);
        }

    }
}
