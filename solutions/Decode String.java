import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        int n = s.length();
        Stack<Character>st = new Stack<>();
        StringBuilder sb3 = new StringBuilder();
        for(int i=0;i<n;i++)
        {
            char ch = s.charAt(i);
            if(ch != ']'){
                st.push(ch);
            }
            else{
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty() && st.peek() != '['){
                    sb.append(st.pop());
                }
                sb.reverse();
                st.pop();
                StringBuilder num = new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    num.insert(0,st.pop());
                }
                int val = Integer.parseInt(num.toString());
                StringBuilder sb1 = new StringBuilder();
                while(val-- > 0)
                {
                    sb1.append(sb.toString());
                }

                for(char ch1 : sb1.toString().toCharArray()){
                    st.push(ch1);
                }

            }
        }

        while(!st.isEmpty()){
            sb3.append(st.pop());
        }

        return sb3.reverse().toString();

    }
}