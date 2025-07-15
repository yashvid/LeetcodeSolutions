import java.util.Arrays;

class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        int cookies= s.length;
        if(cookies==0)
        {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int maxNum = 0;
        int cookieIdx = cookies - 1;
        int childIdx=g.length-1;
        while(cookieIdx >= 0 && childIdx >= 0)
        {
            if(s[cookieIdx] >= g[childIdx])
            {
                maxNum++;
                cookieIdx--;
                childIdx--;
            }
            else
            {
                childIdx--;
            }
        }
        return maxNum;
    }
}
