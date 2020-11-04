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
}