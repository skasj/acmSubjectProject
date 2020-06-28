package base1to100;

public class DigitCounts {

    public int digitCounts(int k, int n) {
        // write your code here
        int i=0;
        int temp=0;
        int temp2=0;
        for (int j=0;j<=n ;j++ ){
            temp2 = j;
            while(temp2>9){
                temp = temp2%10;
                temp2=temp2/10;
                if(temp==k){
                    i++;
                }
            }
            if(temp2==k){
                i++;
            }
        }
        return i;
    }
}
