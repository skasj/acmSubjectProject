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
        Assert.assertEquals(1,solution.lengthOfLIS(new int[]{1}));
        Assert.assertEquals(2,solution.lengthOfLIS(new int[]{1,2}));
        Assert.assertEquals(1,solution.lengthOfLIS(new int[]{2,1}));
    }
}