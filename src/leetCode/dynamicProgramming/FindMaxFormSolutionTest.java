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
}