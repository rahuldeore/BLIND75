package blind75.linkedlist;

import java.util.HashSet;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 * */
public class LinkedListCycle {

    //Not efficient. Additional space and runtime score is 10 percentile
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> listHash = new HashSet<>();
        ListNode nodePtr = head;

        while (nodePtr != null) {
            if (!listHash.contains(nodePtr)) {
                listHash.add(nodePtr);
                nodePtr = nodePtr.next;
            } else {
                return true;
            }
        }
        return false;
    }

    // use floyd's cycle finding algorithm. Slow and fast pointer. 67 percentile
    public boolean hasCycle2(ListNode head) {

        ListNode slow = head, fast = head;

        while (fast != null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // traverse all elements and set their next to a temp node. Before setting the next to temp node, if we find next
    // already points to temp node, there is a cycle.
    // Score is 100 percentile. Fastest. But it is destructive algorithm, meaning it changes the original list.
    public boolean hasCycle3(ListNode head) {

        ListNode tempNode = new ListNode();
        ListNode listNode = head, next;
        while (listNode != null) {
            next = listNode.next;
            if (next == tempNode) {
                //cycle found
                return true;
            }
            listNode.next = tempNode;
            listNode = next;
        }
        return false;
    }

    public static void main(String... args) {
        LinkedListCycle cycle = new LinkedListCycle();

        ListNode newList = new ListNode(0);
        ListNode nodePtr = newList;

        // fill up the list
        for (int i=1; i<10;i++) {
            nodePtr.next=new ListNode(i);
            nodePtr=nodePtr.next;
        }

        //print the list
        nodePtr=newList;
        while (nodePtr!=null) {
            System.out.print(nodePtr.val + " ");
            nodePtr=nodePtr.next;
        }

        System.out.println("\nCycle detected in above list: " + cycle.hasCycle3(newList));

        //Do this for another list
        ListNode newList2 = new ListNode(0);
        nodePtr=newList2;

        // fill up the list
        for (int i=1; i<10;i++) {
            nodePtr.next=new ListNode(i);
            nodePtr=nodePtr.next;
        }

        //print the list
        nodePtr=newList2;
        while (nodePtr.next!=null) {
            System.out.print(nodePtr.val + " ");
            nodePtr=nodePtr.next;
        }
        nodePtr.next=newList2.next;
        System.out.println("\nCycle detected in above list: " + cycle.hasCycle3(newList2));

    }
}
