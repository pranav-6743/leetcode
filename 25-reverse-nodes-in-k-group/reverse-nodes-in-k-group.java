class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode curr = dummy, nex = dummy, pre = dummy;
        int count = 0;

        // 1. Count the total number of nodes
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }

        // 2. Iterate and reverse each group of k
        while (count >= k) {
            curr = pre.next;
            nex = curr.next;
            
            // Standard pointer manipulation to reverse a segment
            for (int i = 1; i < k; i++) {
                curr.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = curr.next;
            }
            
            pre = curr;
            count -= k;
        }
        
        return dummy.next;
    }
}
