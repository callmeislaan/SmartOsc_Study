package stream;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class TestStream {
    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    public static void main(String[] args) {
        Predicate<Person> p1 = person -> person.name.equals("tai");
        Predicate<Person> p2 = person -> person.age < 30;

        System.out.println(
                Stream.of(
                        new Person("tai", 50),
                        new Person("phuoc", 20),
                        new Person("tai", 250))
                .filter(p1.and(p2))
                .peek(System.out::println)
                .anyMatch(p1.and(p2)) ? "" : "khong co");

    }
}
