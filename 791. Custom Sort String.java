class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0; i < order.length(); i++) map.put(order.charAt(i), i);

        List<Character> c = new ArrayList(s.length());
        for(int i = 0; i < s.length(); i++) c.add(s.charAt(i));
        Collections.sort(c, (a, b) -> map.getOrDefault(a, 0) - map.getOrDefault(b, 0));
        StringBuilder str = new StringBuilder();
        for(char d : c) str.append(d);
        return str.toString();
    }
}