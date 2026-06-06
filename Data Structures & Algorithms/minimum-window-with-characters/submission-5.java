class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, formed = 0, startIndex = 0;
        int minLength = Integer.MAX_VALUE;
        int required = need.size();

        HashMap<Character, Integer> window = new HashMap<>();
        for(int right = 0; right<s.length(); right++){
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if(need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()){
                formed++;
            }
            
            while(formed == required){
                if(right - left + 1 <minLength){
                    minLength = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if(need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)){
                    formed--;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
