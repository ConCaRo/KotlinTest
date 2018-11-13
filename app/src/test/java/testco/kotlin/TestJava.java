package testco.kotlin;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by trong-android-dev on 29/8/17.
 */

public class TestJava {

    @Test
    public void testLamdaExpression() {


        TestInterface testInterface = () -> {
            System.out.print("hello");
        };
        testInterface.run();

        //Old way:
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        for (Integer n : list) {
            System.out.println(n);
        }

//New way:
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list1.forEach(n -> {
            System.out.println(n);
            System.out.println(n);
        });


//or we can use :: double colon operator in Java 8
        list.forEach(System.out::print);

        evaluate(list, l -> true);


        Predicate<Integer> p = (Integer n) -> n % 2 == 1;

        Predicate<Integer> p1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 1;
            }
        };
        System.out.println(p.test(1));
        System.out.println(p1.test(1));


    }

    @FunctionalInterface
    public interface TestInterface {
        void setup();

        default void run() {
            System.out.println("Hello Tester");
        }
    }

    public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }


}
