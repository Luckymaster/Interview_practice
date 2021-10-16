class Trie {

    TrieNode trieNode;
    
    public Trie() {
        trieNode = new TrieNode();
    }
    
    public void insert(String word) {
        
        Map<Character,TrieNode> node = trieNode.node;
        for(int i=0;i<word.length();i++){
             TrieNode t;
            if(node.containsKey(word.charAt(i))){
                t = node.get(word.charAt(i));
            }else{
                t = new TrieNode(word.charAt(i));
                node.put(word.charAt(i), t);
            }
            node = t.node;
            t.size++;
            if(i == word.length()-1){
                t.isLeaf = true;
            }
        }
    }
    
    private TrieNode searchNode(String word){
        
        TrieNode t = null;
        Map<Character,TrieNode> node = trieNode.node;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                t = node.get(word.charAt(i));
                node = t.node;
            }else{
                return null;
            }
        }
        return t;
    }
    
    public boolean search(String word) {
        TrieNode s = searchNode(word);
        return s!=null && s.isLeaf;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode s = searchNode(prefix);
        return s == null ? false :true;
        
    }
}

class TrieNode{
    
    public Map<Character,TrieNode> node ;
    char c;
    int size;
    boolean isLeaf;
    TrieNode(){
        node  = new HashMap<>();
    }
    TrieNode(char c){
        this.c = c;
        node  = new HashMap<>();
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
