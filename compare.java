import java.util.*;
public class compare{
    public static void main(String[] args){
        Student stu1 = new Student("Tom", 14);
        Student stu2 = new Student("Jack", 12);
        Student stu3 = new Student("Tom", 17);
        Student stu4 = new Student("Apple", 17);
        Student stu5 = new Student("Jack", 14);
        List<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);
        list.add(stu5);

        //Lambda way:
        //Collections.sort(list, ((a,b)->a.age == b.age ? a.name.compareTo(b.name) : (a.age - b.age)));

        //import comparator way:
        //Collections.sort(list, new MyComparator());

        //improve Student class way:
        //Arrays.sort(list);

        TreeSet<Student> ts = new TreeSet<>();
        ts.add(stu1);
        ts.add(stu2);
        ts.add(stu3);
        ts.add(stu4);
        ts.add(stu5);
        while(!ts.isEmpty()){
            Student temp = ts.pollFirst();
            System.out.println(temp.name + " is " + temp.age);
        }


        for(Student stu: list){
            System.out.println("original "+ stu.name + " is " + stu.age);
        }

    }
}

/*
class Student{
    String name;
    int age;
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
}
*/

class Student implements Comparable<Student>{
    String name;
    int age;
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(Student s){
        if(this.age != s.age)
            return this.age - s.age;
        else
            return this.name.compareTo(s.name);
    }
}

class MyComparator implements Comparator<Student>{
    @Override
    public int compare(Student b, Student a){
        if(a.age != b.age)
            return a.age - b.age;
        else
            return a.name.compareTo(b.name);
    }
}
