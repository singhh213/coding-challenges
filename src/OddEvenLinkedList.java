public class OddEvenLinkedList {

    /*
        Given a singly linked list, group all odd nodes together followed by the even nodes.
        Please note here we are talking about the node number and not the value in the nodes.

        The program should run in O(1) space complexity and O(nodes) time complexity.

        Example:
        Given 1->2->3->4->5->NULL,
        return 1->3->5->2->4->NULL.
     */

    public static void main (String[] args) {
        ListNode list = createLinkedList(new int[] {1, 2, 3, 4, 5, 6, 7});
        ListNode oddEvenList = oddEvenList(list);
        printList(oddEvenList);

        ListNode list1 = createLinkedList(new int[] {1, 2});
        ListNode oddEvenList1 = oddEvenList(list1);
        printList(oddEvenList1);
    }

    private static ListNode oddEvenList(ListNode head) {
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    private static ListNode createLinkedList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    private static void printList(ListNode list) {
        while (list.next != null) {
            System.out.print(list.val + " -> ");
            list = list.next;
        }
        System.out.println(list.val);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
