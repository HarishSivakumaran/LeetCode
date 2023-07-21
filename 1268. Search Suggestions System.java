class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> out = new ArrayList();
        for(int i = 0; i < searchWord.length(); i++) {
            String curr = searchWord.substring(0, i+1);
            int index = findMinIndex(products, curr);
            List<String> o = new ArrayList();

            for(int j = index; j < products.length && j < index+3; j++){
                if(products[j].substring(0, 
                Math.min(curr.length(), products[j].length())).equals(curr)){
                    o.add(products[j]);
                }
            }

            out.add(o);
        }

        return out;
    }

    private int findMinIndex(String[] words, String pre) {
        int l = 0, r = words.length-1, m = 0;
        boolean someMatch = false;

        while(l <= r){
            m = l + (r-l)/2;
            if(words[m].substring(0, 
            Math.min(words[m].length(),pre.length())).compareTo(pre) >= 0 ){
                //matches, let's find a match with a lower index
                r = m - 1;
                someMatch |= words[m].substring(0,
                 Math.min(words[m].length(),pre.length())).compareTo(pre) == 0;
            } else {
                l = m + 1;
            }
        }

        return someMatch ? l : Integer.MAX_VALUE;
    }
}