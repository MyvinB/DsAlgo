package Daily;

import java.util.ArrayList;
import java.util.List;

public class LC725 {
    
public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
//        n.next.next.next = new ListNode(4);
//        n.next.next.next.next = new ListNode(5);
//        n.next.next.next.next.next = new ListNode(6);
//        n.next.next.next.next.next.next = new ListNode(7);
//        n.next.next.next.next.next.next.next = new ListNode(8);
//        n.next.next.next.next.next.next.next.next = new ListNode(9);
//        n.next.next.next.next.next.next.next.next.next = new ListNode(10);
        System.out.println(splitListToParts(n,5));
    }


    public static ListNode[] splitListToParts(ListNode head, int k) {
        // First find out the number of elements
        ListNode cur = head;
        int n = 0;
        while(cur!=null){
            cur = cur.next;
            n++;
        }
        int rem = n<k?0:n%k;
        int arrSize = n<k?1:n/k;
        cur = head;
        ListNode[] list = new ListNode[k];
        int i = 0;
        while(cur!=null){
            ListNode curForArr = new ListNode(-1);
            ListNode headForArr = curForArr;
            int size=rem>0? arrSize+1:arrSize;
            if(rem>0){
                rem = rem -1;
            }
            while(size-->0  && cur!=null){
                curForArr.next = new ListNode(cur.val);
                cur = cur.next;
                curForArr = curForArr.next;
            }
            list[i++] = headForArr.next;
        }
        return list;
    }
}
