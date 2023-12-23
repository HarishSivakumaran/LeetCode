class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<String> visited = new HashSet();
        char[] start = {'0', '0'};
        for(int i = 0; i <= path.length(); i++) {
            String key = new String(start);
            if(visited.contains(key)) return true;
            visited.add(key);
            if(i < path.length())
            switch(path.charAt(i)) {
                case 'N': 
                start[0]--;
                break;
                case 'S': 
                start[0]++;
                break;
                case 'E': 
                start[1]++;
                break;
                case 'W': 
                start[1]--;
                break;
            }
        }

        return false;
    }
}