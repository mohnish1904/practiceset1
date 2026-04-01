package org.example.dsapatternwise.slowandfastpointer;

public class P7_ReorderLinkedList {

    /**
     * 143. Reorder List
     * You are given the head of a singly linked-list. The list can be represented as:
     * <p>
     * L0 → L1 → … → Ln - 1 → Ln
     * Reorder the list to be on the following form:
     * <p>
     * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
     * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
     * <p>
     * Example 1:
     * Input: head = [1,2,3,4]
     * Output: [1,4,2,3]
     * Example 2:
     * Input: head = [1,2,3,4,5]
     * Output: [1,5,2,4,3]
     * <p>
     * Constraints:
     * The number of nodes in the list is in the range [1, 5 * 104].
     * 1 <= Node.val <= 1000
     */

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
        reorderLinkedList(head1);

    }

    private static void reorderLinkedList(ListNode head) {

        // find the centre node
        // reverse the centre node
        // rearrange the list

        // use slow and fast pointer
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // here slow is the centre node
        // now reverse the LL from midpoint
        slow = reverseLL(slow);

        // rearrange the LL
        rearrangeLL(head, slow);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static void rearrangeLL(ListNode head, ListNode revList) {
        ListNode temp1,temp2;
        while (revList != null && revList.next!=null){
            temp1 = head.next;
            temp2 = revList.next;

            head.next = revList;
            revList.next=temp1;
            head = temp1;
            revList = temp2;
        }
    }

    private static ListNode reverseLL(ListNode head) {
        ListNode prev = null, curr = head, temp = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }


}
