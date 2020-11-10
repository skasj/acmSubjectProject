package leetCode.dynamicProgramming;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindMaxFormSolutionTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findMaxForm() {
        FindMaxFormSolution solution = new FindMaxFormSolution();
        Assert.assertEquals(2,solution.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
        Assert.assertEquals(4,solution.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    @Test
    public void lengthOfLIS() {
        FindMaxFormSolution solution = new FindMaxFormSolution();
        Assert.assertEquals(4,solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        Assert.assertEquals(3,solution.lengthOfLIS(new int[]{4,10,4,3,8,9}));
        Assert.assertEquals(0,solution.lengthOfLIS(null));
        Assert.assertEquals(0,solution.lengthOfLIS(new int[0]));
        Assert.assertEquals(1,solution.lengthOfLIS(new int[]{1}));
        Assert.assertEquals(2,solution.lengthOfLIS(new int[]{1,2}));
        Assert.assertEquals(1,solution.lengthOfLIS(new int[]{2,1}));
    }

    @Test
    public void maxTurbulenceSize(){
        FindMaxFormSolution solution = new FindMaxFormSolution();
        Assert.assertEquals(solution.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}),5);
        Assert.assertEquals(solution.maxTurbulenceSize(new int[]{4,8,12,16}),2);
        Assert.assertEquals(solution.maxTurbulenceSize(new int[]{100}),1);
        Assert.assertEquals(solution.maxTurbulenceSize(new int[]{9,9}),1);
    }

    @Test
    public void countPalindromicSubsequences(){
        FindMaxFormSolution solution = new FindMaxFormSolution();
        Assert.assertEquals(6,solution.countPalindromicSubsequences("bccb"));
        Assert.assertEquals(744991227,solution.countPalindromicSubsequences("bddaabdbbccdcdcbbdbddccbaaccabbcacbadbdadbccddccdbdbdbdabdbddcccadddaaddbcbcbabdcaccaacabdbdaccbaacc"));
        Assert.assertEquals(104860361,solution.countPalindromicSubsequences(
                "abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));
    }

    @Test
    public void isMatch(){
        FindMaxFormSolution solution = new FindMaxFormSolution();
        Assert.assertFalse(solution.isMatch("aa","a"));
        Assert.assertTrue(solution.isMatch("aa","a*"));
        Assert.assertTrue(solution.isMatch("ab",".*"));
        Assert.assertTrue(solution.isMatch("aab","c*a*b"));
        Assert.assertFalse(solution.isMatch("mississippi" ,"mis*is*p*."));
        Assert.assertFalse(solution.isMatch("ab",".*c"));
        Assert.assertFalse(solution.isMatch("aaa","aaaa"));
        Assert.assertTrue(solution.isMatch("aaa","a*a"));
    }

    @Test
    public void maxDotProduct(){
        FindMaxFormSolution solution = new FindMaxFormSolution();
        Assert.assertEquals(18,solution.maxDotProduct(new int[]{2,1,-2,5},new int[]{3,0,-6}));
        Assert.assertEquals(21,solution.maxDotProduct(new int[]{3,-2},new int[]{2,-6,7}));
        Assert.assertEquals(-1,solution.maxDotProduct(new int[]{-1,-1},new int[]{1,1}));
    }

    @Test
    public void distinctSubseqII(){
        FindMaxFormSolution solution = new FindMaxFormSolution();
        Assert.assertEquals(7,solution.distinctSubseqII("abc"));
        Assert.assertEquals(6,solution.distinctSubseqII("aba"));
        Assert.assertEquals(3,solution.distinctSubseqII("aaa"));
        Assert.assertEquals(11,solution.distinctSubseqII("aabc"));
        Assert.assertEquals(29,solution.distinctSubseqII("abdae"));
        Assert.assertEquals(35,solution.distinctSubseqII("bcbbca"));
    }

}