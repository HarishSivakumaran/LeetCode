class Solution {
    public List<String> buildArray(int[] target, int n) {
        int index = 0;
        List<String> out = new ArrayList();
        for(int i = 1; i <= n && index < target.length; i++) {
            out.add("Push");
            if(i == target[index]) {
                index++;
                continue;
            } else {
                out.add("Pop");
            }
        }

        return out;
    }
}