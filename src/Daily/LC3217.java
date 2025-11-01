package Daily;

import java.util.*;

public class LC3217 {

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
     


    public static void main(String[] args) {

    }


    // ================================================================
    // Revision - 01/11/25

    public ListNode modifiedListR(int[] nums, ListNode head) {
      HashSet<Integer> set = new HashSet<>();
      for(int i=0;i<nums.length;i++){
          set.add(nums[i]);
      }
      ListNode dummy = new ListNode(-1);
      dummy.next = head;
      ListNode prev=dummy;
      ListNode cur=head;

      while(cur!=null){
          if(set.contains(cur.val)){
              //Removing the current element.
              prev.next = cur.next;
              cur = prev.next;
          }
          else{
              cur = cur.next;
              prev = prev.next;
          }
      }
      return dummy.next;
    }






    // ================================================================




    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        ListNode cur = null;
        ListNode prev = new ListNode(0);
        prev.next = head;
        cur = head;
        ListNode headNode = prev;
        while(cur!=null){
            if(set.contains(cur.val)){
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = prev.next;
        }
        return headNode.next;
    }
}
