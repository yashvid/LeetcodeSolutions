class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char [] answers = answerKey.toCharArray();
        int ts=0;
        int fs=0;
        int left=0;
        int max =0;
        for(int right=0;right<answers.length;right++){
            if(answers[right]=='T'){
                ts++;
            }
            else{
                fs++;
            }
            if(Math.min(fs,ts)<=k){
                max = Math.max(fs+ts,max);
            }
            else{
                while(Math.min(fs,ts)>k){
                    if(answers[left]=='T'){
                        ts--;
                    }
                    else{
                        fs--;
                    }
                    left++;
                }
            }
        }
        return max;       
    }
}