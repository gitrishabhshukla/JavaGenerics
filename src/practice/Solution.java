package practice;

import java.util.Arrays;
import java.util.PriorityQueue;


class Solution {
    
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Integer> max_heap = new PriorityQueue<>((a,b)->b-a);
        int totalTime = 0;
    	Arrays.sort(courses,(a,b)->b[1]-a[1]);
    	for(int[] course:courses) {
    		if(totalTime+course[0]<=course[1]) {
    			max_heap.offer(course[0]);
    			totalTime += course[1];
    		} else {
    			
    			if(max_heap!=null && max_heap.peek()>course[0]) {
    				totalTime -= max_heap.poll();
    				totalTime += course[1];
    				max_heap.offer(course[0]);
    			}
    		}
    	}
    	return max_heap.size();
    }
    
}
