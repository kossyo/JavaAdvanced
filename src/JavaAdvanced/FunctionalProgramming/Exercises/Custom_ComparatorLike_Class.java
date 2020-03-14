package FunctionalProgramming.Exercises;

import java.lang.*;
import java.util.Comparator;


// Driver class
class Main {
    public static void main(String[] args) {

        Student student = new Student("Kiro", 236);
        System.out.println(student.name);
        System.out.println(student.number);
    }
}

class Student {

    String name;
    int number;

    public Student(String name, int number) {

        this.name = name;
        this.number = number;
    }
}
class Player{

    int salary;

    public Player(int number) {

        this.salary = number;
    }
}

class SortBySalary implements Comparator<Player>{

    public int compare(Player player1, Player player2){

        return player1.salary - player2.salary;
    }
}

















class SortByNumber implements java.util.Comparator<Student>{

    public int compare(Student a, Student b){

        return a.number - b.number;
    }
}

