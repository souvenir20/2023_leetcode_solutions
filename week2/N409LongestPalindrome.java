import java.util.HashMap;
public class N409LongestPalindrome {
    public int longestPalindrome(String s) {
        if(s.length() == 1){
            return 1;
        }
        HashMap<Character,Integer> hash = new HashMap<>();
        int value = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(hash.get(s.charAt(i)) == null){
                hash.put(s.charAt(i),1);
            }
            else{
                value = hash.get(s.charAt(i));
                value++;
                hash.put(s.charAt(i), value);
            }
        }
        int longestString = 0;
        for(int val : hash.values()){
            longestString = longestString + val/2*2;
        }
        if(longestString != s.length()){
            longestString += 1;
        }
        return longestString;
    }
}

