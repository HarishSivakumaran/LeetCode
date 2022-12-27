// 212. Word Search II

class Solution {
    int[][] dir = {{0,1}, {1, 0}, {0, -1}, {-1,0}};

        public class Node{
            char val;
            boolean isEnd;
            Node[] next = new Node[26];

            public Node(char val, boolean isEnd){
                this.val = val;
                this.isEnd = isEnd;
            }
        }

    class Trie{
        Node root;



        public Trie(){
           this.root = new Node('#', false);
        }

        public void addWord(String word){
            Node start;
            if(this.root.next[word.charAt(0)-'a'] == null){
                this.root.next[word.charAt(0)-'a'] = new Node(word.charAt(0), word.length()==1);
            }

            start = this.root.next[word.charAt(0)-'a'];

            for(int i = 1; i < word.length(); i++){
                if(start.next[word.charAt(i)-'a'] == null){
                start.next[word.charAt(i)-'a'] = new Node(word.charAt(i), word.length()-1==i);
            }
            start = start.next[word.charAt(i)-'a'];
            }

            start.isEnd = true;

        }
    }
    public List<String> findWords(char[][] board, String[] words) {

        List<String> out = new ArrayList();
        Trie trie = new Trie();

        for(String word : words){
            trie.addWord(word);
        }

            boolean nextWord = false;
            for(int r = 0; r < board.length; r++){
                for(int c = 0; c < board[0].length; c++){
                    searchWord(board, r, c, trie.root, out, "");
                }
            }

        return out;
        
    }

    public void searchWord(char[][] board, int r, int c, Node node, List<String> out, String word){
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c]-'a' > 26 || node.next[board[r][c]-'a'] == null) return;

        word += board[r][c];

        if(node.next[board[r][c]-'a'].isEnd){
           if(!out.contains(word)) 
             out.add(word);
        }

        char temp = board[r][c];

        board[r][c] += 100;

        for(int[] d : this.dir){
            searchWord(board, r +d[0], c+d[1], node.next[temp-'a'], out, word);
        }

        board[r][c] -= 100;

        return;

    }
}