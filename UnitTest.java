import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class UnitTest {
        public static void main(String[] args){
            URLinkedList<Integer> test1 = new URLinkedList<Integer>();
            //add 10 elemetns to the list, expected output 1,2 ..., 10
                for (int i = 0; i < 10; i++) {
                    test1.add(i);
                }
                
            //tests to amke sure all the elements are add
            if (test1.get(7) == 7){
                System.out.println("Test 1 Passed");
            }
            //makes sure index was removed
            test1.remove(2);
            if (test1.get(2) == 3){
                System.out.println("Test 2 Passed");
            }
            //makes sure the size method works correctly
            if (test1.size() == 9){
                System.out.println("Test 3 Passed");
            }
            int hmmm = 4;
            //checks the indexOf method
            if (test1.indexOf(hmmm)==3){
                System.out.println("Test 4 Passed");
            }
            //checks the contains method
            if (test1.contains(8)==true){
                System.out.println("Test 5 Passed");
            }
            //checks the contains method x2
            if (test1.contains(2)==false){
                System.out.println("Test 6 Passed");
            }
            ArrayList<Integer> abc = new ArrayList<>();
            abc.add(1);
            abc.add(1);
            abc.add(3);
            abc.add(3);
            //tests the contains all method
            if (test1.containsAll(abc)){
                System.out.println("Test 7 Passed");
            }
           
            test1.removeAll(abc);
            
            //removes everything after index 5
            Iterator<Integer> it = test1.iterator();
            while(it.hasNext()) {
                Integer i = it.next();
                if (i > 5) {
                    it.remove();
            }
            
            }
        
        
            //tests to make sure that everything after index 5 was removed.
            if (test1.size() == 4) {
                System.out.println("Test 8 Passed");
            }
            //test the isEmpty Method

            if (test1.isEmpty()==false ){
                System.out.println("Test 9 Passed");
            }
            //tests the set method
            test1.set(2, 100);
            if (test1.get(2)==100){
                System.out.println("Test 10 Passed");
            }
            //tests the remove method
            test1.remove(2);
            if (test1.get(2)!=100){
                System.out.println("Test 11 Passed");
            }
            //tests the removeAll method
            if (!test1.containsAll(abc)){
                System.out.println("Test 12 Passed");
            }
            test1.clear();
            if (test1.size()==0){
                System.out.println("Test 13 Passed");
            }

            for (int i = 0; i < 10; i++) {
                    test1.add(i);
                }
            
            
            URList<Integer> sub = test1.subList(0, 4);
            if(sub.size()==4){
                System.out.println("Test 14 Passed");
            }


            System.out.println(Arrays.toString(sub.toArray()));
            sub.remove(3);
            System.out.println(Arrays.toString(sub.toArray()));
            System.out.println(Arrays.toString(test1.toArray()));
}
}