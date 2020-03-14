package repository;

public class Person {

    private String name;
    private int age;
    private String birthDate;

    public Person(String name, int age, String birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb
                .append("Name: ").append(this.name)
                .append("Age: ").append(this.age)
                .append("Birthday: ").append(this.birthDate);

        return sb.toString();
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getBirthDate() {
        return this.birthDate;
    }
}
