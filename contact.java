import java.util.*;


class Student implements Comparable<Student>{
    private String name;
    private int age;
    Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name; // do not set print function here.
    }
    public int getAge(){
        return age;
    }
    @Override
    public int hashCode(){ // privilege should larger/equal than father class
        return name.hashCode() + 20 * age;// so, public should be save.
    }
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Student)){//check if o the object of Student
            throw new ClassCastException("Exception: non compatible type.");
        }// this RunTimeException is this exception's father calss.
        Student s = (Student) o;//if safe, then cast.
        return this.name.equals(s.name) && this.age == s.age;

    }
    public int compareTo(Student stu){
        int num;
        num = new Integer(this.age).compareTo(new Integer(stu.age));
        //use Integer.compareTo can return the specific value we need.
        //simply use "=" compare should write more codes.
        if(num == 0)//check in different level.
            return this.name.compareTo(stu.name);
        return num;
    }
    /**
     * to String is defined in Object class,
     * just like hashCode and equals.
     * So we can override directly.
     */
    @Override
    public String toString(){
        return name + ":" + age;
    }

}

/*
 *if we cannot modify compare function in Student class inside,
 *we can use the Comparator interface
 * */
class newComparator implements Comparator<Student>{
    public int compare(Student A, Student B){
        int num = A.getName().compareTo(B.getName());
        if(num == 0){
            return new Integer(A.getAge()).compareTo(new Integer(B.getAge()));
        }
        return num;
    }
}


public class contact{
    public static void main(String[] args){


        /*
        HashMap<Student, String> map = new HashMap<Student, String>();
        map.put(new Student("aaaa",12), "Beijing");
        map.put(new Student("bbbb",12), "Guangzhou");
        map.put(new Student("dddd",16), "Zhuzhou");
        map.put(new Student("cccc",11), "Shanghai");
        map.put(new Student("aaaa",19), "Hongkong");
        Set<Student> ks = map.keySet();
        Iterator<Student> it = ks.iterator();
        */

        TreeMap<Student, String> tmap = new TreeMap<>(new newComparator());
        tmap.put(new Student("aaaa",12), "Beijing");
        tmap.put(new Student("bbbb",12), "Guangzhou");
        tmap.put(new Student("dddd",16), "Zhuzhou");
        tmap.put(new Student("cccc",11), "Shanghai");
        tmap.put(new Student("aaaa",19), "Hongkong");

        Set<Map.Entry<Student, String>> es = tmap.entrySet();
        Iterator<Map.Entry<Student, String>> it = es.iterator();


        /*
        while(it.hasNext()){
            Student stu = it.next();
            String location = map.get(stu);
            System.out.println(stu +"   ---------   "+location);
        }
        */

        while(it.hasNext()){
            Map.Entry<Student, String> me = it.next();
            Student stu = me.getKey();
            String addr = me.getValue();
            System.out.println(stu+" ::: "+ addr);

        }


    }
}
