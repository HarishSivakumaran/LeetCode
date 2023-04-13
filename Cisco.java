import java.util.*;

public class Cisco {
    class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Cisco cicso = new Cisco();
        List<Integer> nums = new ArrayList();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        nums.add(7);
        nums.stream().forEach((i) -> System.out.println(i));

        Node root = null;

        for (int i = 0; i < nums.size(); i++) {
            int curr = i + ; 

            int right = 2 * curr + 1;

            
            No de currNode = cicso . ne w
                ft < nums.size()-2){  
             

                
            if(right < nums.size()-2){  
             
         

    
    }

    public void preorderTraversal(Node node) {
        if (node == null)
            return;

        preorderTraversal(node.left);

        System.out.println(node.val);

        preorderTraversal(node.right);

    }
}
