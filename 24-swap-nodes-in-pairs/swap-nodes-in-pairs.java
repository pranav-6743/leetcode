class Solution {
    public ListNode swapPairs(ListNode head) {
        // 1. Create a dummy node to act as a point before the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode point = dummy;

        // 2. Iterate as long as there is a pair of nodes to swap
        while (point.next != null && point.next.next != null) {
            ListNode first = point.next;
            ListNode second = point.next.next;

            // 3. Perform the swap by changing pointers
            // Before: point -> first -> second -> rest
            // After:  point -> second -> first -> rest
            first.next = second.next;
            second.next = first;
            point.next = second;

            // 4. Move the point forward by two nodes for the next pair
            point = first;
        }

        return dummy.next;
    }
}
