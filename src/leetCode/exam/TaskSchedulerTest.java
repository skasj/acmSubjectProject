package leetCode.exam;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskSchedulerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void leastInterval() {
        TaskScheduler taskScheduler = new TaskScheduler();
        Assert.assertEquals(6,taskScheduler.leastInterval(new char[]{'A','A','B','B','A','B'}, 0));
        Assert.assertEquals(8,taskScheduler.leastInterval(new char[]{'A','A','B','B','A','B'}, 2));
        Assert.assertEquals(12,taskScheduler.leastInterval(new char[]{'A','A','A','B','B','B','C','C','C','D','D','E'}, 2));
        Assert.assertEquals(10, taskScheduler.leastInterval(new char[]{'A','A','B','B','C','C','D','D','E','E'}, 2));
        Assert.assertEquals(52,taskScheduler.leastInterval(new char[]{'A','A','B','B','C','C','D','D','E','E','F','F','G','G','H','H','I','I','J','J','K','K','L','L','M','M','N','N','O','O','P','P','Q','Q','R','R','S','S','T','T','U','U','V','V','W','W','X','X','Y','Y','Z','Z'}, 2));
    }
}