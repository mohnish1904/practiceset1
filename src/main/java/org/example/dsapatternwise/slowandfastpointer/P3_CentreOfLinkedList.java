package org.example.dsapatternwise.slowandfastpointer;

public class P3_CentreOfLinkedList {

    /**
     * 876. Middle of the Linked List
     * Given the head of a singly linked list, return the middle node of the linked list.
     * If there are two middle nodes, return the second middle node.
     * <p>
     * Example 1:
     * Input: head = [1,2,3,4,5]
     * Output: [3,4,5]
     * Explanation: The middle node of the list is node 3.
     * Example 2:
     * Input: head = [1,2,3,4,5,6]
     * Output: [4,5,6]
     * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
     * <p>
     * Constraints:
     * The number of nodes in the list is in the range [1, 100].
     * 1 <= Node.val <= 100
     */

    public static void main(String[] args) {
        // Test case 1: Cycle exists
        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println("Test case 1: " + findMiddle(head1).val); // Expected: 3

        // Test case 2: Cycle exists
        ListNode head2 = new ListNode(1);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(3);
        ListNode node8 = new ListNode(4);
        ListNode node9 = new ListNode(5);
        ListNode node10 = new ListNode(6);
        head2.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        System.out.println("Test case 2: " + findMiddle(head2).val); // Expected: 4

    }

    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
