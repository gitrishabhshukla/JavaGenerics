package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieImplementation2 {

    TrieNode root = new TrieNode(false,new TrieNode[26],new ArrayList<Integer>());
	TrieNode root_reverse = new TrieNode(false,new TrieNode[26],new ArrayList<Integer>());
	

    public TrieImplementation2(String[] words) {
        int count=0;
    	for(String word:words) {
    		insertWord(word, count,root);
    		StringBuilder sb = new StringBuilder(word);
    		sb.reverse();
    		insertWord(sb.toString(), count, root_reverse);
            count++;
    	}
    	
    }
    
    public int f(String prefix, String suffix) {
        int res = -1;
    	List<Integer> l1 = searchWord(prefix,root);
        StringBuilder sb = new StringBuilder(suffix);
    	sb.reverse();
    	List<Integer> l2 = searchWord(sb.toString(),root_reverse);
        if(l1==null || l2==null) return -1;
        
    	int len = l1.size();
    	for(int i=len-1;i>=0;i--) {
    		if(l2.contains(l1.get(i))) {
    			res = l1.get(i);
                break;
    		}
    	}
    
    	return res;
    }
    
    public void insertWord(String word,int index,TrieNode root) {
		TrieNode temp = root;
		int wordLength = word.length();
		int count=0;
		for(char ch:word.toCharArray()) {
			count++;
			if(temp.child[ch-'a']!=null) {
			    temp = temp.child[ch-'a'];
			    temp.indexList.add(index);
			    if(count==wordLength) temp.endOfWord=true;
			} else {
				TrieNode newNode = new TrieNode(false,new TrieNode[26],new ArrayList<Integer>());
				temp.child[ch-'a'] = newNode;
				temp = temp.child[ch-'a'];
			    temp.indexList.add(index);
			    if(count==wordLength) temp.endOfWord=true;
			}
		}
		
	}
    
    public List<Integer> searchWord(String word,TrieNode root) {
    	List<Integer> res=null;
    	TrieNode temp = root;
    	int wordLength = word.length();
		int count=0;
    	for(char ch:word.toCharArray()) {
    		count++;
    		if(temp.child[ch-'a']!=null) {
    			temp = temp.child[ch-'a'];
    			if(count==wordLength) {
    				res = temp.indexList;
    			}
    		} else {
    			break;
    		}
    		
    	}
    	return res;
    }
    
    public class TrieNode {
    	boolean endOfWord;;
    	TrieNode[] child;
    	List<Integer> indexList;
    	
    	public TrieNode(boolean endOfWord, TrieNode[] child, List<Integer> index) {
			this.endOfWord = endOfWord;
			this.child = child;
			this.indexList = index;
		}
    		
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */