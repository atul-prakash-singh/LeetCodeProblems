package datastructures.company.amazon;

import java.util.PriorityQueue;

/*
You have some number of sticks with positive integer lengths. These lengths are given as an array sticks, where sticks[i] is the length of the ith stick.

You can connect any two sticks of lengths x and y into one stick by paying a cost of x + y. You must connect all the sticks until there is only one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.



Example 1:

Input: sticks = [2,4,3]
Output: 14
Explanation: You start with sticks = [2,4,3].
1. Combine sticks 2 and 3 for a cost of 2 + 3 = 5. Now you have sticks = [5,4].
2. Combine sticks 5 and 4 for a cost of 5 + 4 = 9. Now you have sticks = [9].
There is only one stick left, so you are done. The total cost is 5 + 9 = 14.
Example 2:

Input: sticks = [1,8,3,5]
Output: 30
Explanation: You start with sticks = [1,8,3,5].
1. Combine sticks 1 and 3 for a cost of 1 + 3 = 4. Now you have sticks = [4,8,5].
2. Combine sticks 4 and 5 for a cost of 4 + 5 = 9. Now you have sticks = [9,8].
3. Combine sticks 9 and 8 for a cost of 9 + 8 = 17. Now you have sticks = [17].
There is only one stick left, so you are done. The total cost is 4 + 9 + 17 = 30.
Example 3:

Input: sticks = [5]
Output: 0
Explanation: There is only one stick, so you don't need to do anything. The total cost is 0.


Constraints:

1 <= sticks.length <= 104
1 <= sticks[i] <= 104
 */
public class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        int totalCost = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // add all sticks to the min heap.
        for (int stick : sticks) {
            pq.add(stick);
        }

        // combine two of the smallest sticks until we are left with just one.
        while (pq.size() > 1) {
            int stick1 = pq.remove();
            int stick2 = pq.remove();

            int cost = stick1 + stick2;
            totalCost += cost;

            pq.add(stick1 + stick2);
        }

        return totalCost;
    }
}
/*
Greedy
Intuition and Algorithm

Always pick two of the smallest sticks to connect and continue doing this until you get only one stick. Let's see why this works.

Consider 4 sticks of the following lengths:

sticks = [a_1, a_2, a_3, a_4]sticks=[a1,a2

 ,a
3

 ,a
4

 ]

Let's try to connect them left to right.

After first merge, we will have:

sticks = [(a_1 + a_2), a_3, a_4], cost = (a_1 + a_2)sticks=[(a
1

 +a
2

 ),a
3

 ,a
4

 ],cost=(a
1

 +a
2

 )

After second merge, we will have:

sticks = [(a_1 + a_2 + a_3), a_4], cost = (a_1 + a_2) + (a_1 + a_2 + a_3)sticks=[(a
1

 +a
2

 +a
3

 ),a
4

 ],cost=(a
1

 +a
2

 )+(a
1

 +a
2

 +a
3

 )

And finally, last stick will look like:

sticks = [(a_1 + a_2 + a_3 + a_4)], cost = (a_1 + a_2) + (a_1 + a_2 + a_3) +(a_1 + a_2 + a_3 + a_4)sticks=[(a
1

 +a
2

 +a
3

 +a
4

 )],cost=(a
1

 +a
2

 )+(a
1

 +a
2

 +a
3

 )+(a
1

 +a
2

 +a
3

 +a
4
 )

The final cost can be re-written as: cost = (3a_1 + 3a_2 + 2a_3 + a_4)cost=(3a1+3a2+2a3+a4)

As we can see, the sticks which are connected first are included in the final cost more than the ones that are picked later. Hence, it is optimal to pick smaller sticks first to get the smallest cost.

Let's try to figure out which data structure will be optimal to perform following tasks:

Get two of the smallest sticks (stick1 and stick2) from the array.
Add one stick (stick1 + stick2) back to the array.
We can use a min heap data structure (which is, generally, implemented as a PriorityQueue in most languages) which gives us O(\log{N})O(logN) complexity for both the operations.

Complexity Analysis

Time complexity : O(N\log{N})O(NlogN), where NN is the length of the input array. Let's break it down:

Step 1) Adding NN elements to the priority queue will be O(N\log{N})O(NlogN).

Step 2) We remove two of the smallest elements and then add one element to the priority queue until we are left with one element. Since each such operation will reduce one element from the priority queue, we will perform N-1N−1 such operations. Now, we know that both add and remove operations take O(\log{N})O(logN) in priority queue, therefore, complexity of this step will be O(N\log{N})O(NlogN).

Space complexity : O(N)O(N) since we will store NN elements in our priority queue.
 */