package test;

;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestInitTest {
    private TestGame tg;

    @Before
    public void setUp(){
        tg = new TestGame();
    }

    @Test
    public void InitTest() {
        Assert.assertNotNull(tg);
        Assert.assertNotNull(tg.v1);
        Assert.assertNotNull(tg.v2);
        Assert.assertTrue(tg.v1.getCurrent_field().GetFieldId() == 32);
        Assert.assertTrue(tg.v2.getCurrent_field().GetFieldId() == 43);
        Assert.assertTrue(tg.v1.GetAminoacid().size() == 15);
        Assert.assertTrue(tg.v1.GetNukleotid().size() == 15);
        Assert.assertTrue(tg.fields.get(0).GetNeighbours().get(0).GetFieldId() == tg.fields.get(1).GetFieldId());
        Assert.assertTrue(tg.fields.get(0).GetNeighbours().get(1).GetFieldId() == tg.fields.get(4).GetFieldId());

    }
}

