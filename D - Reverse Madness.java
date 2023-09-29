import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

    static PrintWriter printWriter = null;
    static FastScanner in = null;

    public static void main(String[] args) {

        in = new FastScanner(System.in);
        printWriter = new PrintWriter(System.out);
        
        int c = in.nextInt();
        
        for(int z = 0; z < c; z++){
            solve();
        }
        printWriter.close();

    }
    
    public static void solve(){
        int n = in.nextInt();
        int k = in.nextInt();
        
        char[] word = in.nextLine().toCharArray();
        int[] l = new int[k], r = new int[k];
        
        for(int i = 0; i < k; i++) l[i] = in.nextInt();
        for(int i = 0; i < k; i++) r[i] = in.nextInt();
        
        int queries = in.nextInt();
        int[] noOfReversal = new int[n];
        while(queries > 0) {
            int val = in.nextInt();
            noOfReversal[val-1]++;
            queries--;
        }
        
        for(int j = 0; j < k; j++) {
            int left = l[j]-1, right = r[j]-1;
            int noRev = 0;
            for(int i = left; i <= (left+right)/2; i++) {
                noRev += noOfReversal[i] + noOfReversal[left+right-i];
                if((noRev&1) == 1) {
                    char temp = word[i];
                    word[i] = word[left+right-i];
                    word[left+right-i] = temp;
                }
            }
        }
        printWriter.println(new String(word));
        
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
