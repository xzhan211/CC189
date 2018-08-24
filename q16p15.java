import java.util.Scanner;

public class q16p15{
    public static void main(String[] args){
        String robot = "RGGB";
        Scanner scanner = new Scanner( System.in);
        //System.out.print( "Type some data for the program: " );
        //String input = scanner.nextLine();
        boolean allHit = false;
        while(!allHit){
            System.out.print( "Type some data for the program: " );
            String input = scanner.nextLine();
            //System.out.println(">> "+ input);
            allHit = compare(input, robot);
        }
        System.out.println("--end--");
    }

    public static boolean compare(String input, String robot){
        int len = robot.length();
        if(input.length() != len){
            System.out.println("Input size error!");
            return false;
        }
        int[] counter = new int[len];
        int hits = 0;
        for(int i = 0; i<len; i++){
            if(input.charAt(i) == robot.charAt(i)){
                hits++;
            }else{
                counter[code(robot.charAt(i))]++;
            }
        }

        if(hits == 4){
            System.out.println("All fit!");
            return true;
        }

        int pseudoHits = 0;
        for(int i = 0; i<len; i++){
            if(input.charAt(i)!=robot.charAt(i) && counter[code(input.charAt(i))]>0){
                pseudoHits++;
                counter[code(input.charAt(i))]--;
            }
        }
        if(hits > 0 && pseudoHits >0){
            System.out.println("Hit & Pseudo-hit");
            return false;
        }else if(hits == 0 && pseudoHits>0){
            System.out.println("Only Pseudo-hit");
            return false;
        }else if(hits==0 && pseudoHits==0){
            System.out.println("None");
            return false;
        }else if(hits > 0 && pseudoHits==0){
            System.out.println("Only Hit");
            return false;
        }
        return false;
    }

    public static int code(char c){
        switch(c){
            case 'B':
                return 0;
            case 'G':
                return 1;
            case 'R':
                return 2;
            case 'Y':
                return 3;
            default:
                return -1;
        }
    }
}
