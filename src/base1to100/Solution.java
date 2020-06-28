package base1to100;

public class Solution {

    public int nthUglyNumber(int n) {
        // write your code here
        int[] a = new int[1500];
        a[0]=1;
        int m=0;
        int x=0,y=0,z=0;
        int mx=0,my=0,mz=0;
        while(n>m){
            while (a[x]*2<=a[m]) {
                x++;
            }
            mx=a[x]*2;
            while (a[y]*3<=a[m]) {
                y++;
            }
            my=a[y]*3;
            while (a[z]*5<=a[m]) {
                z++;
            }
            mz=a[z]*5;
            if(mx<=my&&mx<=mz){
                x++;
                a[++m]=mx;
            }else if (my<=mx&&my<=mz){
                y++;
                a[++m]=my;
            }else {
                z++;
                a[++m]=mz;
            }
        }
        return a[n-1];
    }
}
