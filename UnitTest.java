import java.util.Arrays;

public class UnitTest {
        public static void main(String[] args){
            URLinkedList<Integer> test1 = new URLinkedList<Integer>();
            //add 10 elemetns to the list, expected output 1,2 ..., 10
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    test1.add(i);
                }
                System.out.println(Arrays.toString(test1.toArray()));
            
            if (test1.get(7) == 7){
                System.out.println("Test 1 Passed");
            }
            test1.remove(2);
            if (test1.get(2) == 3){
                System.out.println("Test 2 Passed");
            }
            if (test1.size() == 9){
                System.out.println("Test 3 Passed");
            }
    }
}