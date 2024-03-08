import java.util.*;

public class Main {
    public static void main(String[] args) {




        ArrayList<String> names = new ArrayList<>();
        names.add("Ivan");
        names.add("Maria");
        names.add("Maria");
        names.add("Oleg");
        names.add("Peter");
        names.add("Alex");
        names.add("Peter");

        // Set-ы
        // Множества
        TreeSet<String> treeSet = new TreeSet<>(names);
        Iterator<String> iterator = treeSet.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2); // 0 - +
            }
        };
        System.out.println("");
        TreeSet<String> treeSet1 = new TreeSet<>(comparator);
        treeSet1.addAll(names);
        Iterator<String> iterator2 = treeSet1.iterator();
        while(iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        //Set set = new Set();

        /*
        Реализуйте класс, который, используя TreeSet находит список учеников,
        сдавших экзамен на оценку выше заданного числа.
        Для решения задачи нужно реализовать собственный класс Student,
        реализующий интерфейс Comparable.
         */
        class Student {
            public String name;
            public int mark;

            public Student(String name, int mark) {
                this.name = name;
                this.mark = mark;
            }
        }
        Comparator<Student> comparator1 = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.mark-o2.mark;
            }
        };

        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(new Student("Ivan",40));
        arrayList.add(new Student("Olga",98));
        arrayList.add(new Student("Maria",64));
        arrayList.add(new Student("Petr",100));
        arrayList.add(new Student("Max",49));
        TreeSet<Student> studentTreeSet = new TreeSet<>(comparator1);
        studentTreeSet.addAll(arrayList);
        for(Student s: studentTreeSet) {
            System.out.println(s.mark + ", " + s.name);
        }
        int x = 50;
        System.out.println("");
        SortedSet<Student> result = studentTreeSet.tailSet(new Student("Test",x));
        for(Student r: result) {
            System.out.println(r.mark + ", " + r.name);
        }

       // studentTreeSet.headSet()
       // studentTreeSet.subSet()
    }
}