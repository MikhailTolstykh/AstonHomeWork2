import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {


    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list1.add(i);
        }

        MyArrayList<Integer> list2 = new MyArrayList<>();
         list2.addAll(list1);
        System.out.println(list2.toString());
    }


}
