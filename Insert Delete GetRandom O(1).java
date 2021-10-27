class RandomizedSet {
    
    int [] set;
    int max = 200001;
    int idx = 0;
    Map<Integer,Integer> cache;
    public RandomizedSet() {
        set = new int[max];
        cache = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(cache.get(val)!= null ) return false;
        else{
            set[idx] = val;
            cache.put(val, idx);
            idx++;
            return true;
        }
        
    }
    
    public boolean remove(int val) {
        if(cache.get(val) == null ) return false;
        else{
            int indexOfVal = cache.get(val);
            int tmp = set[idx-1];
            set[max-1] = set[indexOfVal];
            set[indexOfVal] = tmp;
            cache.put(tmp,indexOfVal);
            cache.remove(val);
            idx--;
            return true;
        }
        
    }
    
    public int getRandom() {
       int r =  (int)(Math.random() * idx);
        return set[r];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
