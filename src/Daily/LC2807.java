package Daily;

public class LC2807 {
    
     public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    static int gcd(int a, int b)
    {
        int result = Math.min(a, b);
        while (result > 0) {
            if (a % result == 0 && b % result == 0) {
                break;
            }
            result--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(gcd(10,6));
    }


    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        //Problem looks like insert element in between them

        ListNode first = head;
        ListNode second = head.next;
        while(second != null){
            int gcd = gcd(first.val,second.val);
            ListNode temp = new ListNode(gcd);
            first.next = temp;
            temp.next = second;
            first = second;
            second = second.next;
        }

        return head;
    }
}
