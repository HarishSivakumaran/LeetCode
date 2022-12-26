// 208. Implement Trie (Prefix Tree)
// Medium
// 8.7K
// 106
// Companies
// A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

// Implement the Trie class:

// Trie() Initializes the trie object.
// void insert(String word) Inserts the string word into the trie.
// boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
// boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

class Trie {

    Node[] alphabets = new Node[26];

    class Node{
        char val;
        boolean isEnd;
        Node[] next = new Node[26];

        Node(char val, boolean isEnd){
           this.val = val;
           this.isEnd = isEnd;
        }
    }

    public Trie() {
        
    }
    
    public void insert(String word) {
        Node start = this.alphabets[word.charAt(0) -'a'];
       for(int i = 0; i < word.length(); i++){
           if(i == 0 && start  == null){
               this.alphabets[word.charAt(0) -'a']  = new Node(word.charAt(i), i == word.length()-1);
               start = this.alphabets[word.charAt(0) -'a'] ;
           }else if(i > 0){
              if (start.next[word.charAt(i) - 'a'] == null){
                  start.next[word.charAt(i) - 'a'] = new Node(word.charAt(i), i == word.length()-1);
              }  
              start = start.next[word.charAt(i) - 'a'];        
           }
            if(i == word.length()-1){
               start.isEnd = true;
           }
       }
        
    }
    
    public boolean search(String word) {
        Node start = this.alphabets[word.charAt(0) -'a'];
        if(start == null) return false;
        for(int i = 1; i < word.length(); i++){
            if(start.next[word.charAt(i) - 'a'] == null) return false;
            start = start.next[word.charAt(i) - 'a'] ;
        }

        return start.isEnd;

    }
    
    public boolean startsWith(String word) {
        Node start = this.alphabets[word.charAt(0) -'a'];
        if(start == null) return false;
        for(int i = 1; i < word.length(); i++){
            if(start.next[word.charAt(i) - 'a'] == null) return false;
            start = start.next[word.charAt(i) - 'a'] ;
        }

        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */