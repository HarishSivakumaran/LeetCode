// 421. Maximum XOR of Two Numbers in an Array

public class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}


// class Solution {

//     class Node{
//         int val;
//         HashMap<Integer,Node> children;

//         Node(int val){
//             this.val = val;
//             children = new HashMap();
//         }
//     }

//     class Trie{
//         Node root;
//         Trie(int[] nums){
//             this.root = new Node(-1);
//             for(int n : nums){
//                 Node curr = this.root;
//                 for(int i = 31; i>=0; i--){
//                     int sigBit = (n >> i) & 1;
//                     if(!curr.children.containsKey(sigBit)){
//                         curr.children.put(sigBit, new Node(sigBit));
//                     }
//                     curr = curr.children.get(sigBit);                  
//                 }
//             }                
//         }
//     }

//     public int findMaximumXOR(int[] nums) {

//         Trie trie = new Trie(nums);

//         int max = -1;

//         for(int n : nums){
//             Node curr = trie.root;
//             int val = 0;
//             for(int i = 31; i >= 0; i--){
//                  int sigBit = ((n >> i) & 1);
//                  int exp = (sigBit & 1) == 1 ? 0 : 1;

//                  if(curr.children.containsKey(exp)){
//                      val |= (1 << i);
//                      curr = curr.children.get(exp);
//                  }else{
//                      curr = curr.children.get(sigBit);
//                  }


//             }
//             max = Math.max(val,max);
//         }

//         return max;
        
//     }
// }