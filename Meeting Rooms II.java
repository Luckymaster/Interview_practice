class Solution {
    int max = 0;
    PriorityQueue<Integer> maxHeap;
    public int minMeetingRooms(int[][] intervals) {
        maxHeap = new PriorityQueue<Integer>();
        return getMinRoom(intervals);
    }
    
    int getMinRoom(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        for(int [] interval:intervals){
            int start = interval[0];
            int end = interval[1];
            maxHeap.add(end);
            if(maxHeap.peek() > start){
                max+=1;
            }else{
                maxHeap.poll();
            }
            
        }
        return max;
    }
}
