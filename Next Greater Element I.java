class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> nextLarget = new HashMap<>();
        Stack<Integer> target = new Stack<>();
        int i=-1;
        for(;++i<nums2.length;){
            while(!target.isEmpty() && target.peek() < nums2[i] ){
                nextLarget.put(target.peek(),nums2[i]);
                target.pop();
            }
            target.add(nums2[i]);
        }
        while(!target.isEmpty()){
            nextLarget.put(target.peek(), -1);
            target.pop();
        }
        int [] res = new int[nums1.length];
        for(i=0;i<nums1.length;i++){
           res[i] = nextLarget.get(nums1[i]); 
        }
        
        return res;
    }
    
}
