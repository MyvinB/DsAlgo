# Sliding Window – Pattern Notes

## Core idea
We maintain a window [j .. i] and move:
- i → expand to the right
- j → shrink from the left
  so that a window invariant is always satisfied.

We never move j backwards.

---

## Main patterns

### 1) Fixed window
Window size is constant.

Template:

```java
for (int i = 0; i < n; i++) {
    // add nums[i]

    if (i >= k - 1) {
        // process window [i-k+1 .. i]
        // remove nums[i-k+1]
    }
}
```
---

### Count subarrays with (max − min) constraint using monotonic deque

Problem example:
- LC3835

Idea:
Maintain a sliding window [j..i].
Use two monotonic deques to keep track of the maximum and minimum in the window.
Shrink the window while the cost condition is violated.
Count all valid subarrays ending at each i.

Template:

```java
long count(int[] nums, long k) {

    Deque<Integer> mx = new ArrayDeque<>(); // decreasing
    Deque<Integer> mn = new ArrayDeque<>(); // increasing

    int j = 0;
    long ans = 0;

    for (int i = 0; i < nums.length; i++) {

        // insert i
        while (!mx.isEmpty() && nums[mx.peekLast()] <= nums[i]) mx.pollLast();
        while (!mn.isEmpty() && nums[mn.peekLast()] >= nums[i]) mn.pollLast();
        mx.offerLast(i);
        mn.offerLast(i);

        // shrink window
        while ((long)(nums[mx.peekFirst()] - nums[mn.peekFirst()])
                * (i - j + 1) > k) {

            if (mx.peekFirst() == j) mx.pollFirst();
            if (mn.peekFirst() == j) mn.pollFirst();
            j++;
        }

        // count subarrays ending at i
        ans += i - j + 1;
    }

    return ans;
}
