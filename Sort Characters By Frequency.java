class Solution {
    Map<Character,Integer> frq ;
    public String frequencySort(String s) {
        frq = new HashMap<>();
        char [] mst = s.toCharArray();
        for(char c:mst){
            if(frq.get(c) ==  null){
                frq.put(c,1);
            }else{
                frq.put(c,frq.get(c) + 1);
            }
        }
		StringBuilder sb = new StringBuilder();
		frq.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).forEach(record -> {
			Character key = record.getKey();
			int value = record.getValue();
			for (int i = 0; i < value; i++) {
				sb.append(key);
			}
		});
		return sb.toString();
    }
}
