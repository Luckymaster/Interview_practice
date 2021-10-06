class LRUCache {
	Map<Integer, Integer> cache = null;

	int maxCapacity = 0;
	int tcapacity = 0;

	public LRUCache(int capacity) {
		cache = new LinkedHashMap<>(capacity);
		tcapacity = capacity;
	}

	public int get(int key) {
		int ans = cache.get(key) == null ? -1 : cache.get(key);
        if(ans!=-1){
		cache.remove(key);
		cache.put(key, ans);}
		return ans;

	}

	public void put(int key, int value) {

		Integer ans = cache.get(key);
		if (maxCapacity == tcapacity) {
			if (null == ans) {
				int toRemoved = cache.entrySet().iterator().next().getKey();
				cache.remove(toRemoved);
				cache.put(key, value);
			} else {
				cache.remove(key);
				cache.put(key, value);
			}
		} else {

			if (null == ans) {
				cache.put(key, value);
				maxCapacity++;

			} else {
				cache.remove(key);
				cache.put(key, value);
			}

		}

	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
