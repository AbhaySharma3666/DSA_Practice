class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int i,j;
        String y="";
        for ( i=s.length()-1 ; i>=0 ; i--) y = y + s.charAt(i);
        
        if (s.equals(y)) return true;
        else return false;
    }
}