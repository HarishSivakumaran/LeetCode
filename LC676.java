// 676. Implement Magic Dictionary

class MagicDictionary {

    class Node {
        Node[] next = new Node[26];
        char v;
        boolean isWord = false;

        Node(char v) {
            this.v = v;
        }
    }

    Node root;

    public MagicDictionary() {
        root = new Node('#');
    }

    public void buildDict(String[] dictionary) {
        for (String w : dictionary) {
            Node curr = root;
            for (int i = 0; i < w.length(); i++) {
                if (curr.next[w.charAt(i) - 'a'] == null) {
                    curr.next[w.charAt(i) - 'a'] = new Node(w.charAt(i));
                }
                curr = curr.next[w.charAt(i) - 'a'];
            }
            curr.isWord = true;
        }
    }

    public boolean search(String searchWord) {
        return search(searchWord, 0, false, root);
    }

    public boolean search(String searchWord, int i, boolean isModified, Node curr) {

        if (i == searchWord.length())
            return isModified && curr.isWord;

        if (isModified && curr.next[searchWord.charAt(i) - 'a'] == null)
            return false;

        boolean isMatched = false;

        if (curr.next[searchWord.charAt(i) - 'a'] != null) {
            isMatched = search(searchWord, i + 1, isModified, curr.next[searchWord.charAt(i) - 'a']);
            if (isMatched)
                return true;
        }

        if (isModified)
            return false;

        // process this like an incorrect match
        for (int j = 0; j < 26; j++) {
            if (curr.next[j] == null || searchWord.charAt(i) - 'a' == j)
                continue;
            isMatched = search(searchWord, i + 1, true, curr.next[j]);
            if (isMatched)
                return true;
        }

        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */