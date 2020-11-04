package Geekbrains_Java2.Lesson_3;

import java.util.*;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(2);

        System.out.println(treeSet);

        TreeSet<String> treeSet1 = new TreeSet<>();
        treeSet1.add("ttt");
        treeSet1.add("uuu");
        treeSet1.add("abc");
        treeSet1.add("cbd");

        System.out.println(treeSet1);

        TreeSet<Employee> treeSet2 = new TreeSet<>(new MySalary());
        treeSet2.add(new Employee("Ram", 2000));
        treeSet2.add(new Employee("Sofia", 1000));
        treeSet2.add(new Employee("Cris", 3000));
        treeSet2.add(new Employee("Ivan", 5000));

        for (Employee employee : treeSet2) {
            employee.info();
        }
    }
}

class MySalary implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSalary() - o2.getSalary();
    }
}

class Employee {
    private String name;
    private int salary;

    public int getSalary() {
        return salary;
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public void info() {
        System.out.println(name + " " + salary);
    }
}
