class LRUCache {

  	Map<Integer, Integer> cache = null;
	PriorityQueue<LruFrequency> pqueue;
	int maxCapacity = 0;
	int tcapacity = 0;
    int random = 10000;

	public LRUCache(int capacity) {
		cache = new HashMap<>(capacity);
		tcapacity = capacity;
		pqueue = new PriorityQueue<>(capacity, new customLRU());
	}

	public int get(int key) {
		int ans = cache.get(key) == null ? -1 : cache.get(key);
		if (ans != -1){
            pqueue.remove(new LruFrequency(key));
			pqueue.add(new LruFrequency(key, random++));
        }
		return ans;

	}
	public void put(int key, int value) {

		Integer keyCache = cache.get(key);
		if (tcapacity == maxCapacity) {
			if (null == keyCache) {
                cache.remove(pqueue.poll().key);
				cache.put(key, value);
				pqueue.add(new LruFrequency(key,random++));
			} else {
                cache.put(key, value);
				pqueue.remove(new LruFrequency(key));
				pqueue.add(new LruFrequency(key,random++));
			}
		} else {
			if (keyCache == null) {
				cache.put(key, value);
				pqueue.add(new LruFrequency(key,random++));
				maxCapacity++;
			}else {
				cache.put(key, value);
				pqueue.remove(new LruFrequency(key));
				pqueue.add(new LruFrequency(key,random++));
			}
		}

	}


}

class LruFrequency {

	int key;
	int frequency;

	LruFrequency(int key) {
		this.key = key;
	}

	public LruFrequency(int key, int frequency) {
		this.key = key;
		this.frequency = frequency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + key;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LruFrequency other = (LruFrequency) obj;
		if (key != other.key)
			return false;
		return true;
	}

}

class customLRU implements Comparator<LruFrequency> {

	@Override
	public int compare(LruFrequency o1, LruFrequency o2) {
		if (o1.frequency > o2.frequency)
			return 1;
		if (o1.frequency < o2.frequency)
			return -1;
		return 0;
	}

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
