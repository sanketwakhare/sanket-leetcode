class Trie {

    private Character data;
    private boolean isEnd;
    private Trie[] children;
    
    
    public Trie() {        
        this.data = '$';
        this.isEnd = false;
        this.children = new Trie[26];
    }
    
    public Trie(Character data) {        
        this.data = data;
        this.isEnd = false;
        this.children = new Trie[26];        
    }
    
    public void insert(String word) {
        
        Trie temp = this;
        for(int i=0; i< word.length(); i++) {
            Character c = word.charAt(i);
            int ind = c - 'a';
            if(temp.children[ind] == null) {
                temp.children[ind] = new Trie(c);
            }
            temp = temp.children[ind];
        }
        temp.isEnd = true;        
    }
    
    public boolean search(String word) {
        
        Trie temp = this;
        for(int i=0; i< word.length(); i++) {
            Character c = word.charAt(i);
            int ind = c - 'a';
            if(temp.children[ind] == null) {
                return false;
            }
            temp = temp.children[ind];
        }
        if(temp.isEnd) {
            return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        
        Trie temp = this;
        for(int i=0; i< prefix.length(); i++) {
            Character c = prefix.charAt(i);
            int ind = c - 'a';
            if(temp.children[ind] == null) {
                return false;
            }
            temp = temp.children[ind];
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