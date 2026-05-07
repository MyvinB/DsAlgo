package Topics.LinkedList;

import Daily.LC1367;



public class LC61 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);

        System.out.println(rotateRight(a,2));

    }

    public static ListNode rotateRight(ListNode head, int k) {
        ListNode cur = head;
        int totalCount = 1;
        while(cur.next!=null){
            totalCount++;
            cur = cur.next;
        }
        //Making it circular
        cur.next = head;
        //Mod for unnecessary totalCount
        k = k%totalCount;
        k = totalCount-k;
        cur = head;
        for(int i=1;i<k;i++){
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }
}
