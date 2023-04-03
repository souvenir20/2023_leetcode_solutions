public class N278FirstBadVersion {
    public int firstBadVersion(int n) {
        int lv = 1;
        int rv = n;
        int mv = (lv + rv)/2;
        while(lv < rv){
            if(isBadVersion(mv)){
                rv = mv;
            }
            else{
                lv = mv + 1;
            }
            mv = (rv + lv)/2;
        }
        return mv;
    }
}
