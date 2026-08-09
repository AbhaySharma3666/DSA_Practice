class Solution {
    public int maxPower(String s) {
        int count = 1;
        int maxpower = 1; 
        
        List<Character> st = new ArrayList<>();
        for (char ch : s.toCharArray()) st.add(ch);
        
        for(int i = 0; i < st.size() - 1; i++){
            if(st.get(i) == st.get(i+1)) count++;
            else {
                maxpower = Math.max(maxpower, count);
                count = 1;
            }
        }
        return Math.max(maxpower, count);
    }
}