// String test about address

public class test{
    public static void main(String[] args){
        String a = "abc";
        String b = new String("abc");
        // a, b point to different address
        // a point to constant pool.
        // b point to heap, then point to constant.
        String c = "abc";
        // a, c point to same constant pool, so a == b, true(address same).
        System.out.println(a.equals(b));
        // compare the content.
        System.out.println(a == b);
        // compare the address.(reference type variable)
        System.out.println(a == c);
    }
}

// in String class, equals() and hashCode() method has been override.
// Returns a hash code for this string. The hash code for a String object is
// computed as
//  s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
//
//
//  Important:
//  Different object, if we have to compare them, equals and hashCode methods
//  should be override.
//
//  When we compare string in hash table, we actually use the equals(2ed) and
//  hashcode(1st)
