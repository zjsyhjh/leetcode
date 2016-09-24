public class Solution {

	private HashMap<Character, Character> hashMap1, hashMap2;
    public boolean isIsomorphic(String s, String t) {
    	if (s == null && t == null) {
    		return true;
    	}
    	if ((s == null && t != null) || (s != null && t == null)) {
    		return false;
    	}

    	if (s.length() != t.length()) {
    		return false;
    	}

    	hashMap1 = new HashMap<>();
    	hashMap2 = new HashMap<>();
    	for (int i = 0; i < s.length(); i++) {
    		if (hashMap1.containsKey(s.charAt(i)) || hashMap2.containsKey(t.charAt(i))) {
    			if (hashMap1.containsKey(s.charAt(i))) {
    				char value1 = hashMap1.get(s.charAt(i));
    				if (value1 != t.charAt(i)) {
    					return false;
    				}
    			} else {
    				char value2 = hashMap2.get(t.charAt(i));
    				if (value2 != s.charAt(i)) {
    					return false;
    				}
    			}

    		} else {
    			hashMap1.put(s.charAt(i), t.charAt(i));
    			hashMap2.put(t.charAt(i), s.charAt(i));
    		}
    	}
    	return true;
    }
}