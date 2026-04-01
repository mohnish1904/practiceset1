package org.example.dsapatternwise.slowandfastpointer;

public class P6_PalindromeLinkedList {

    /**
     * 234. Palindrome Linked List
     * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
     * <p>
     * Example 1:
     * Input: head = [1,2,2,1]
     * Output: true
     * Example 2:
     * Input: head = [1,2]
     * Output: false
     * <p>
     * Constraints:
     * The number of nodes in the list is in the range [1, 105].
     * 0 <= Node.val <= 9
     * <p>
     * <p>
     * Follow up: Could you do it in O(n) time and O(1) space?
     */

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(1);
//        ListNode node5 = new ListNode(5);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
        System.out.println(isPalindrome(head1));

    }

    private static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow comes to centre
        // reverse linked list from mid point

        slow = reverse(slow);
        fast = head;

        while (slow !=null){
            if (slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null, temp;

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }


}
