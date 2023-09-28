public class UnitTest {
        public static void main(String[] args){
            URLinkedList test1 = new URLinkedList<>();
            //add 10 elemetns to the list, expected output 1,2 ..., 10
                for (int i = 0; i < 10; i++) {
                test1.add(i, i);
                System.out.println(test1.toArray());
    }
    
        
    }
    
    

}