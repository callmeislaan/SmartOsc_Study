package stream;

interface itf<T> {
//    void bbc(T s1, T s2);
//    T get();
    T[] a(int size);
}

class MyString {

    public MyString() {
        System.out.println("day la A");
    }

    @Override
    public String toString() {
        return "Day la toString A";
    }

    //    public MyString(String s1, String s2) {
////        return -s1.compareTo(s2);
//        System.out.println("a");
//    }

    public int compareTo(String s1, String s2) {
        return -s1.compareTo(s2);
    }

}


public class Main {

    public static void main(String[] args) {

//        MyString myString = new MyString();

//        Logger logger = LoggerFactory.getLogger(Main.class);
//        logger.error("a", 1);
//        logger.info("a", 2);
//        logger.info("a", 3);
//        logger.info("a", 4);

        String[] list = {"Java", "Python", "C#"};
//        Stream.of(list).filter(s -> s.startsWith("J")).forEach(s -> System.out.println(s));
//        Stream.of(list).filter(s -> s.startsWith("J")).forEach(s -> System.out.println(s));

//        streamSupplier.get().forEach(s -> System.out.println(s));
//        streamSupplier.get().forEach(s -> System.out.println(s));

//        IntStream.of(1, 2, 3).forEach(value -> System.out.println(value));
//        DoubleStream.of(1, 2, 3, 4).forEach(value -> System.out.println(value));
//        Stream.of(1, 2, 3, 4).forEach(integer -> System.out.println(integer));
//        Stream<Integer> stream = Stream.of(new Integer[] {1, 2, 3});
//        stream.forEach(integer -> System.out.println(integer));
//        Stream stream1 = new ArrayList<Integer>().stream();
//        Stream s = Stream.generate(() -> new Date()).limit(10);
////        s.forEach(o -> System.out.println(o));
//        Stream.Builder builder = Stream.builder();
//        builder.add(1);
//        List<String> data = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");

        String[] data = {"Java", "C#", "C++", "PHP", "Javascript", "Java"};
//        Integer[] i = {2, 1, 3, 5, 4};
//        Stream.of(i).peek(integers -> System.out.println(integers)).count();

//        itf compareTo =   MyString::compareTo;

//        Consumer<String> a = MyString::new;

        itf<MyString[]> my = MyString[][]::new;
        MyString[][] a = my.a(3);
        System.out.println(a.length);
//        itf a = MyString::new;
//        a.bbc("a", "a");

//        Stream.of(data)
////                .peek(System.out::println)
//                .sorted()
//                .distinct()
////                .toArray();
//                .forEach(System.out::println);
    }
}