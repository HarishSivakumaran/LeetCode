import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    
    public static class Node {
    Node left;
    Node right;
    int l = 0, r = 0, level = 0;
    long val = 0, lazy = 0;
}

    static PrintWriter printWriter = null;
    static FastScanner in = null;

    public static void main(String[] args) {

        in = new FastScanner(System.in);
        printWriter = new PrintWriter(System.out);
        
        // int c = in.nextInt();
        
        // for(int z = 0; z < c; z++){
            solve();
        // }
        printWriter.close();

    }
    

    public static void solve(){
       int n = in.nextInt();
       int[] arr = new int[n];
       for(int i = 0; i < arr.length; i++){
           arr[i] = in.nextInt();
       }
       int q = in.nextInt();
       
       Node root = build(arr, 0, arr.length-1);
       
       while(q > 0) {
           q--;
           String queryStr = in.nextLine();
           String[] queryStrArr = queryStr.split(" ");
           int[] queryType = new int[queryStrArr.length];
           for(int i = 0; i < queryType.length; i++) 
            queryType[i] = Integer.parseInt(queryStrArr[i]);
           if(queryType.length == 2) {
               // range query
               if(queryType[1] < queryType[0]) {
                   long min1 = query(root, 0, queryType[1]);
                   long min2 = query(root, queryType[0], n-1);
                   printWriter.println(Math.min(min1, min2));
               } else {
                    printWriter.println(query(root, queryType[0], queryType[1]));
               }
           }
           
           if(queryType.length == 3) {
               // range update
               if(queryType[1] < queryType[0]) {
                   rangeUpdate(root, 0, queryType[1], queryType[2]);
                   rangeUpdate(root, queryType[0], n-1, queryType[2]);
               } else {
                   rangeUpdate(root, queryType[0], queryType[1], queryType[2]);
               }
           }
       }
        
    }
    
    private static void rangeUpdate(Node node, int l, int r, int val) {
        //lazy handling
        if(node.lazy != 0) {
            node.val += node.lazy;
            if(node.left != null)
            node.left.lazy += node.lazy;
            if(node.right != null)
            node.right.lazy += node.lazy;
            node.lazy = 0;
        }
        
        if(node.l >= l && node.r <= r) {
            //full overlap
            node.val += val;
            
            // update the children's lazy value
            if(node.left != null)
                node.left.lazy += val;
            if(node.right != null)
                node.right.lazy += val;
                
        } else if(node.l <= r && node.r >= l) {
            //partial overlap

            rangeUpdate(node.left, l, r, val);
            rangeUpdate(node.right, l, r, val);
            node.val = Math.min(node.right.val, node.left.val);
        }
    }
    
    private static void update(Node node, int i , int val) {
        
        if(node.l == node.r && node.l == i) {
            node.val = val;
        } else {
            int m = node.l + (node.r-node.l)/2;
            if(i <= m) {
                update(node.left, i, val);
            } else {
                update(node.right, i, val);
            }
            
            if((node.level&1) == 1) {
                // or
                node.val = node.left.val | node.right.val;
            }else {
                node.val = node.left.val ^ node.right.val;
            }
            
        }
        
    }
    
    private static long query(Node node, int l, int r) {
        //lazy handling
        if(node.lazy != 0) {
            node.val += node.lazy;
            if(node.left != null)
            node.left.lazy += node.lazy;
            if(node.right != null)
            node.right.lazy += node.lazy;
            node.lazy = 0;
        }
        if(l <= node.l && r >= node.r) {
            // complete overlap
            return node.val;
        } else if(node.l <= r && node.r >= l){
            // partial overlap
            return Math.min(query(node.left, l, r), query(node.right, l , r));
        }
        
        return Integer.MAX_VALUE;
    }
    
    private static Node build(int[] arr, int l, int r) {
        Node node = new Node();
        if(l == r) {
            node.val = arr[l];
        } else {
            int m = l + (r-l)/2;
            node.left = build(arr, l, m);
            node.right = build(arr, m+1, r);
            node.level = 1+node.right.level;
            node.val = Math.min(node.right.val, node.left.val);
        }
        node.l = l;
        node.r = r;
        
        return node;
    } 
    
    private static int getNextSmallerOrEqualValueIndex(int[] nums, int val) {
        int l = 0, r = nums.length-1, m = 0;
        while(l <= r) {
            m = l+(r-l)/2;
            if(nums[m] > val) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return r;
    }
    
    private static void reverse(char[] word, int l, int r) {
        while(l < r) {
            char temp = word[l];
            word[l] = word[r];
            word[r] = temp;
            l++;
            r--;
        }
    }
    
    private static long getSum(int n) {
        if((n&1) == 0) {
            return (long)(n/2)*(n+1);
        } else {
            return (long)n*((n+1)/2);
        }
    }
    
    public static boolean checkEqual(char[] a, char[] b, HashSet<Integer> ignore){
        for(int i = 0; i < a.length; i++){
            if(ignore.contains(i)) continue;
            if(a[i] != b[i]) return false;
        }
        return true;
    }
    
    
    public static boolean isPrime(int n){
        if(n == 0 || n == 1) return false;
        
        
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        
        return true;
        
    }
    
    public static int getVal(int[] q, List<Integer> val) {
        // minimum admittable value which is greater than or equal to q[0]
        int l = 0, r = val.size()-1;
        while(l <= r){
            int m = l + (r-l)/2;
            if(val.get(m) < q[0]){
                l = m+1;
            } else {
                r = m-1;
            }
        }
        
        int value = l;

        // maximum value which is lesser than or equal to q[1]
        
        l = 0; r = val.size()-1;
        while(l <= r){
            int m = l + (r-l)/2;
            if(val.get(m) <= q[1]){
                l = m+1;
            } else {
                r = m-1;
            }
        }

        return r-value+1;
    }
    
    public static boolean getIfAdmittable(int v, int min, int[][] ranges) {
        int com = 0;
        for(int i = 0; i < ranges.length && ranges[i][0] <= v; i++){
            if(v >= ranges[i][0] && v <= ranges[i][1]){
                com++;
            }
            
            if(com >= min) return true;
        }
        return false;
        // //minimum interval this i falls under
        // int l = 0, r = ranges.length-1;
        // boolean match = false;
        // while(l <= r){
        //     int m = l + (r-l)/2;
        //     if(i >=  ranges[m][0] && i <= ranges[m][1]) {
        //         r = m-1;
        //         match = true;
        //     }else{
        //         // not matching
        //         if(i < ranges[m][0]) {
        //             r = m-1;
        //         }else{
        //             l = m+1;
        //         }
        //     }
        // }
        // int val = l;

        // if(!match){
        //     return false;
        // }
        
        // match = false;
        // l = 0;
        // r = ranges.length-1;
        // while(l <= r){
        //     int m = l + (r-l)/2;
        //     if(i >=  ranges[m][0] && i <= ranges[m][1]) {
        //         l = m+1;
        //         match = true;
        //     }else{
        //         // not matching
        //         if(i < ranges[m][0]) {
        //             r = m-1;
        //         }else{
        //             l = m+1;
        //         }
        //     }
        // }
        
        // if(!match){
        //     return false;
        // }
        

        // return r-val+1 >= min;
    }


    public static class FastScanner {
        private BufferedReader reader = null;
        private StringTokenizer tokenizer = null;

        public FastScanner(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
            tokenizer = null;
        }

        public String next() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    return reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return tokenizer.nextToken("\n");
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
    }

}

