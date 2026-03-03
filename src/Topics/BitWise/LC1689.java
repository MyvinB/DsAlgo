package Topics.BitWise;

public class LC1689 {

    public static void main(String[] args) {
        System.out.println(minPartitions("27346209830709182346"));
    }

    public static int minPartitions(String n) {
        int max = 0;
        for(int i=0;i<n.length();i++){
            max = Math.max(n.charAt(i)-'0',max);
        }
        return max;
    }
}
