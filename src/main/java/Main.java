import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {




    public static void main(String[] args) {
ArrayList<Integer>list1 =new ArrayList<>();
        list1.add(2);
        list1.add(32);
        list1.add(24);
        list1.add(21);
        MyArrayList<Integer>list2 = new MyArrayList<>(list1);
        System.out.println(list2.toString());

         MyArrayList.bubbleSort(list2);
        System.out.println(list2.toString());

       }
    }



