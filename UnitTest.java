import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;

public class UnitTest {
        public static void main(String[] args) {
            URLinkedList<Integer> test1 = new URLinkedList<Integer>();
            //add 10 elemetns to the list, expected output 1,2 ..., 10
                for (int i = 0; i < 10; i++) {
                    test1.add(i,i);
                    System.out.println(Arrays.toString(test1.toArray()));
                }
                System.out.println(Arrays.toString(test1.toArray()));
            
            if (test1.get(7) == 7){
                System.out.println("Test 1 Passed");
            }
            System.out.println(Arrays.toString(test1.toArray()));
            test1.remove(2);
            if (test1.get(2) == 3){
                System.out.println("Test 2 Passed");
            }
            System.out.println(Arrays.toString(test1.toArray()));
            if (test1.size() == 9){
                System.out.println("Test 3 Passed");
            }
            int hmmm = 4;
            System.out.println(Arrays.toString(test1.toArray()));
            if (test1.indexOf(hmmm)==3){
                System.out.println("Test 4 Passed");
            }
            if (test1.contains(8)==true){
                System.out.println("Test 5 Passed");
            }
            if (test1.contains(2)==false){
                System.out.println("Test 6 Passed");
            }
            System.out.println(Arrays.toString(test1.toArray()));

            ArrayList<Integer> abc = new ArrayList<>();
            abc.add(1);
            abc.add(1);
            abc.add(3);
            abc.add(3);
            System.out.println(test1.containsAll(abc));
            test1.removeAll(abc);
            System.out.println(Arrays.toString(test1.toArray()));

            Iterator<Integer> it = test1.iterator();
            while(it.hasNext()) {
                Integer i = it.next();
                if (i > 6) it.remove();
            }

            System.out.println(Arrays.toString(test1.toArray()));
    }
}