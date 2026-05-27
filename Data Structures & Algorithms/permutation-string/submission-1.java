class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int l = 0; 
        int k = s1.length();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int r = 0; r<s2.length(); r++){
            char rightChar = s2.charAt(r);
            map2.put(rightChar, map2.getOrDefault(rightChar, 0) + 1);

            if(r - l + 1 > k){
                char leftChar = s2.charAt(l);
                map2.put(leftChar, map2.get(leftChar) - 1);

                if(map2.get(leftChar) == 0){
                    map2.remove(leftChar);
                }
                l++;
            }

            if(r - l + 1 == k){
                if(map.equals(map2)){
                    return true;
                }
            }
        }
        return false;
    }
}
