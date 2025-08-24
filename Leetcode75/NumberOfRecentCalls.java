package Leetcode75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
You have a RecentCounter class which counts the number of recent requests within a certain time frame.

Implement the RecentCounter class:

RecentCounter() Initializes the counter with zero recent requests.
int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.

 

Example 1:

Input
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]
Output
[null, 1, 2, 3, 3]

Explanation
RecentCounter recentCounter = new RecentCounter();
recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
 
 */

// using sliding window concept
class RecentCounter {
    List<Integer> list;
    int i;
    int j;

    public RecentCounter() {
        list = new ArrayList<>();
        i = 0;
        j = -1; // points to the current element which is added recently
    }

    public int ping(int t) {
        list.add(t);
        j++;
        while (i < j && list.get(j) - 3000 > list.get(i)) {
            i++;
        }
        return j - i + 1;
    }
}

// using queue
class RecentCounter2 {
    Queue<Integer> q;

    public RecentCounter2() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.add(t);
        while (!q.isEmpty() && t - 3000 > q.peek()) {
            q.remove();
        }
        return q.size();
    }
}