class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> out = new ArrayList();
        List<String> line = new ArrayList();
        int len = 0, totalSpace = 0, spaces = 0, rem = 0;
        for(String w : words) {
            if(w.length()+len+(line.size()) > maxWidth) {
                 totalSpace = (maxWidth-len);
                 spaces = line.size() < 2 ? 0 : (maxWidth-len)/(line.size()-1);
                 rem = line.size() < 2 ? 0 : (maxWidth-len)%(line.size()-1);
                StringBuilder str = new StringBuilder();
                for(int i = 0; i < line.size(); i++) {
                    str.append(line.get(i));
                    if(totalSpace > 0){
                        int spa = (spaces + (rem > 0 ? 1 : 0));
                        for(int s = 0; s < spa; s++) str.append(" ");      
                        rem--;
                        totalSpace -= (spa);
                    }
                }
                for(int s = 0; s < totalSpace; s++) str.append(" ");
                out.add(str.toString());
                line = new ArrayList();
                len = 0;
            }
            line.add(w);
            len += w.length();
        }
         spaces = (maxWidth-len);
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < line.size(); i++) {
            str.append(line.get(i));
            if(spaces > 0)
                str.append(" ");
            spaces--;
            if(i == line.size()-1)
                for(int s = 0; s < spaces; s++) str.append(" ");
        }
            out.add(str.toString());
        return out;
    }
}