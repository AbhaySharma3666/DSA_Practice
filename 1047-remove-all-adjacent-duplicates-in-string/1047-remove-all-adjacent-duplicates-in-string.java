class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            // If stack is not empty and top element matches current char, pop it
            if(!st.isEmpty() && st.peek() == ch) st.pop(); 
            else st.push(ch);
        }
        
        StringBuilder result = new StringBuilder();
        for(char ch : st) result.append(ch);
        
        return result.toString();
    }
}