package blind75.linkedlist;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Input: head = []
 * Output: []
 * */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null, curr=head, next;
        while (curr != null) {
            next=curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }
        return prev;
    }
    public static void main(String... args) {
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
        //reverse and print the list
        ReverseList reverseList = new ReverseList();
        System.out.println();
        //print the reverse list
        nodePtr = reverseList.reverseList(newList);
        while (nodePtr!=null) {
            System.out.print(nodePtr.val + " ");
            nodePtr=nodePtr.next;
        }
        System.out.println();

        // Do this for another list
        ListNode newList2 = new ListNode();

        //print the list
        nodePtr=newList;
        while (nodePtr!=null) {
            System.out.print(nodePtr.val + " ");
            nodePtr=nodePtr.next;
        }
        //reverse and print the list
        reverseList = new ReverseList();
        System.out.println();
        //print the reverse list
        nodePtr = reverseList.reverseList(newList);
        while (nodePtr!=null) {
            System.out.print(nodePtr.val + " ");
            nodePtr=nodePtr.next;
        }

    }
}

