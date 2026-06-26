class Solution {
    public int reverse(int x) {
        int reversed = 0;
        
        while (x != 0) {
            int pop = x % 10;
            int newReversed = reversed * 10 + pop;
            
            // If the math backtracks incorrectly, overflow happened
            if ((newReversed - pop) / 10 != reversed) {
                return 0;
            }
            reversed = newReversed;
            x /= 10;
        }
        return reversed;
    }
    
}