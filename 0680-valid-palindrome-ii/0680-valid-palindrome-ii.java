import java.util.*;

class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return isPalindromeRange(s, l + 1, r) || isPalindromeRange(s, l, r - 1);
            }
        }
        return true;
    }

    // Helper function to check if a substring is a palindrome
    private boolean isPalindromeRange(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}