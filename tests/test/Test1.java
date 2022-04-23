package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import projlab.Game;
import projlab.Virologist;

public class Test1 {
    private TestGame tg;

    @Before
    public void setUp(){
        tg = new TestGame();
    }

    @Test
    public void TestTest(){
        Assert.assertNotNull(tg.v1);
       tg.moveVirologist(tg.v1, 22);
       tg.showStatistics(tg.v1,"TEST: steps on filed");
       Assert.assertTrue(tg.v1.getCurrent_field().GetFieldId() == 22);
    }
}
