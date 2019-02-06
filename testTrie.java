/*
trie is good at:
1. Finding all keys with a common prefix.
2. Enumerating a dataset of strings in lexicographical order.
3. required small memory size. (length of the longest words * TreeNode array[26])

Application:
1. Auto-compete
2. Spell checker
3. IP router forward table check
4. T9 predictive text
5. Word games

search a word in trie tree: O(m) m is the length of the word.
search a word in balance tree: O(mlgn) n is the number of keys in the tree.
search a word in hash table: O(n).
As hash table increases in size, there are lots of hash collisions and the search time complexity could deteriorate from O(1) to O(n). n is the number of keys inserted.
 * */
public class testTrie{
    public static void main(String[] args){
        Trie trie = new Trie();

        trie.insert("leetcode");
        trie.insert("leet");
        trie.insert("lee");
        trie.insert("code");

        String input = args[0];
        System.out.println(trie.search(input));
        System.out.println(trie.startsWith(input));
    }
}

/*
step 2: create trie structure

可以理解为，创立了树的节点结构后，还需要再创建一个节点的管理机制
这个就是树。
然后一棵树就是一个管理树节点的对象，对外暴露一个树的对象。
用户只能通过这个new出来的对象作为入口访问树结构。

root 节点是保存在树对象中的，对外不暴露。
main中变量只保存（严格说是引用）tree对象。

这种写法下，不需要哨兵节点，每个节点都存储了实际数据（字符信息）

insert: O(m) m is the length of word.
search:
searchPrefix: O(m)
startsWith: O(m)
delect:
如果删除的字段长度小于对应路径长度，直接将isEnd 改 false就好；
如果删除字段的长度就是对应路径的长度，则需要使用递归DFS的方法删除，
一直回删到节点出现isEnd为止。
 * */
class Trie{
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for(int i = 0; i<word.length(); i++){
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)){
                node.put(currentChar);//create a new node in array
            }
            node = node.get(currentChar); // get the new node (address)
        }
        node.setEnd();
    }

    public boolean search(String word){
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for(int i = 0; i<word.length(); i++){
            char curLetter = word.charAt(i); //update each round
            if(node.containsKey(curLetter))
                node = node.get(curLetter); //update each round
            else
                return null;
        }
        return node;
    }

    public boolean startsWith(String prefix){
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public boolean delete(String word){
        return false;
    }
}

/*
step 1: create trie node
property:
links
isEnd
note: no need to create a property to store char, links do it actually.
All the function in this class is T: O(1)
 * */
class TrieNode{
    private TrieNode[] links;
    private boolean isEnd;

    public TrieNode(){
        links = new TrieNode[26]; // default: null
        isEnd = false;
    }

    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch){
        return links[ch - 'a'];
    }

    public void put(char ch){
        TrieNode node = new TrieNode();
        links[ch-'a'] = node;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }
}
