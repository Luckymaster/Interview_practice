/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
*/

class Solution {
    PriorityQueue<Pair> minqueue;
    public int[][] merge(int[][] intervals) {
        minqueue = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair p0, Pair p1){
                return Integer.compare(p1.r ,p0.r);
            }
        });
        
        return getMergedIntervals(intervals);
    }
    
    int [][] getMergedIntervals(int[][] intervals){
        Map<Integer,Integer> map = new LinkedHashMap<>();
        
        Arrays.sort(intervals, new Comparator<int []>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        }); 
        
        for(int [] in:intervals){
            int l = in[0];
            int r = in[1];
            if(!minqueue.isEmpty()){
                Pair tmp = minqueue.peek();
                if(tmp.l <= l && tmp.r >= l){
                    l = Math.min(l,tmp.l);
                    r = Math.max(r,tmp.r);
                    minqueue.poll();
                    minqueue.add(new Pair(l,r));
                }
                else{
                    minqueue.add(new Pair(l,r));
                }
            }else{
                minqueue.add(new Pair(l,r));
            }
        }
        Iterator<Pair> it = minqueue.iterator();
        int [][] res = new int[minqueue.size()][2];
        int idx = 0;
        while(it.hasNext()){
            Pair tmp = it.next();
            res[idx][0] = tmp.l;
            res[idx][1] = tmp.r;
            idx++;
        }
        return res;
    }
}
class Pair{
    int l;
    int r;
    Pair(int l, int r){
        this.l = l;
        this.r = r;
    }
}
