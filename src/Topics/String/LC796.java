package Topics.String;

public class LC796 {

    public static void main(String[] args) {
        String s = "defdefdefabcabc";
        String goal = "defdefdefabcabc";
        System.out.println(rotateString(s,goal));
    }

    public static boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
