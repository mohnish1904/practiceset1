package org.example.dsapatternwise.slowandfastpointer;


public class P2_StartingPointOfCycle {

    /**
     * Given head, the head of a linked list, determine if the linked list has a cycle in it.
     * There is a cycle in a linked list if there is some node in the list that can be reached again
     * by continuously following the next pointer. Internally, pos is used to denote the index of the
     * node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
     * Return true if there is a cycle in the linked list. Otherwise, return false.
     * <p>
     * Example 1:
     * Input: head = [3,2,0,-4], pos = 1
     * Output: 2
     * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
     * Example 2:
     * Input: head = [1,2], pos = 0
     * Output: 1
     * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
     * Example 3:
     * Input: head = [1], pos = -1
     * Output: no cycle
     * Explanation: There is no cycle in the linked list.
     * <p>
     * Constraints:
     * The number of the nodes in the list is in the range [0, 104].
     * -105 <= Node.val <= 105
     * pos is -1 or a valid index in the linked-list.
     * Follow up: Can you solve it using O(1) (i.e. constant) memory?
     */

    public static void main(String[] args) {
        // Test case 1: Cycle exists
        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Cycle here
        System.out.println("Test case 1: " + checkStart(head1).val); // Expected: 2

        // Test case 2: Cycle exists
        ListNode head2 = new ListNode(1);
        ListNode node5 = new ListNode(2);
        head2.next = node5;
        node5.next = head2; // Cycle here
        System.out.println("Test case 2: " + checkStart(head2).val); // Expected: 1

        // Test case 3: No cycle
        ListNode head3 = new ListNode(1);
        System.out.println("Test case 3: " + checkStart(head3).val); // Expected: null
    }

    public static ListNode checkStart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                slow = head;

                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }

        }
        return null;
    }
}
