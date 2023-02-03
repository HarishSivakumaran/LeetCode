// 451. Sort Characters By Frequency

class Solution {
    class Node {
        char val;
        Integer freq = 0;

        Node(char val) {
            this.val = val;
        }
    }

    public String frequencySort(String s) {

        Node[] count = new Node[123];

        for (int i = 0; i < 123; i++) {
            count[i] = new Node((char) i);
        }

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)].freq++;
        }

        Arrays.sort(count, (p1, p2) -> p2.freq - p1.freq);
        StringBuilder str = new StringBuilder();

        for (Node c : count) {
            if (c.freq == 0)
                break;
            for (int i = 0; i < c.freq; i++) {
                str.append(c.val);
            }

        }

        // HashMap<Character, Integer> count = new HashMap();

        // for(int i = 0; i < s.length(); i++){
        // count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        // }

        // PriorityQueue<String> pq = new PriorityQueue<String>((a,b)->
        // b.length()-a.length());
        // StringBuilder str = new StringBuilder();

        // for(Map.Entry<Character, Integer> entry : count.entrySet()){
        // str = new StringBuilder();
        // for(int i = 0; i < entry.getValue(); i++){
        // str.append(entry.getKey());
        // }
        // pq.add(str.toString());
        // }

        return str.toString();
    }
}