/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
*/
class GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> ana = new HashMap<>();
		for (String s : strs) {
			char[] aux = s.toCharArray();
			Arrays.sort(aux);
			String tmp = new String(aux);
			List<String> anaList = new ArrayList<>();
			if (ana.get(tmp) == null) {
				anaList = new ArrayList<>();
				anaList.add(s);
				ana.put(tmp, anaList);
			} else {
				ana.get(tmp).add(s);
			}
		}
		return new ArrayList<>(ana.values());
	}
}