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
    }
}