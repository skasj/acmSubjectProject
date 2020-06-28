package base1to100;

public class MergeSortedArray {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int a=0,b=0;
        int i=0;
        int k=A.length+B.length;
        int[] C = new int[k];
        while (a<A.length&&b<B.length){
            if(A[a]<B[b]){
                C[i++]=A[a++];
            }else {
                C[i++]=B[b++];
            }
        }
        while (a<A.length){
            C[i++]=A[a++];
        }
        while (b<B.length){
            C[i++]=B[b++];
        }
        return C;
    }
}
