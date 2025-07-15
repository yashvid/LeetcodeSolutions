import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> printVertically(String s) {
        String[] word = s.split(" ");
        int c=0;
        int size=0;
        List<String> ans = new ArrayList<>();
        for(String w:word){
            if(w.length() > size) size = w.length();
        }
        for(int i = 0; i < size; i++){
            StringBuilder sb = new StringBuilder();
            for(String w:word){
                if(i < w.length()) sb.append(w.charAt(i));
                else sb.append(" "); 
            }
            ans.add(sb.toString().stripTrailing());
        }
        return ans;
        
    }
}
