package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import projlab.*;

public class ProtectionTests {
    private TestGame tg;

    @Before
    public void setUp(){
        tg = new TestGame();
    }

    @Test
    public void VirologistPutsOnGlove(){
        Assert.assertNotNull(tg);
        tg.moveVirologist(tg.v1, 42);
        tg.moveVirologist(tg.v1, 21);
        tg.pickUpProtection(tg.v1);
        Assert.assertTrue(tg.v1.getCurrent_field().GetFieldId() == 21);
        Assert.assertEquals(tg.v1.getCurrent_field().getClass(), Shelter.class);
        Assert.assertTrue(tg.v1.HasGlove());
        Assert.assertEquals(tg.v1.GetProtections().get(0).getClass(), Glove.class);
    }

    @Test
    public void VirologistPutsOnCloak(){
        Assert.assertNotNull(tg);
        tg.moveVirologist(tg.v1, 31);
        tg.moveVirologist(tg.v1, 21);
        tg.pickUpProtection(tg.v1);
        Assert.assertTrue(tg.v1.getCurrent_field().GetFieldId() == 21);
        Assert.assertEquals(tg.v1.getCurrent_field().getClass(), Shelter.class);
        Assert.assertTrue(tg.v1.HasCloak());
        Assert.assertEquals(tg.v1.GetProtections().get(0).getClass(), Cloak.class);
    }

    @Test
    public void VirologistPutsOnBag(){
        Assert.assertNotNull(tg);
        tg.moveVirologist(tg.v1, 33);
        tg.moveVirologist(tg.v1, 23);
        tg.moveVirologist(tg.v1, 13);
        tg.pickUpProtection(tg.v1);
        Assert.assertTrue(tg.v1.getCurrent_field().GetFieldId() == 13);
        Assert.assertEquals(tg.v1.getCurrent_field().getClass(), Shelter.class);
        Assert.assertTrue(tg.v1.GetCapacity() != 15);
        Assert.assertEquals(tg.v1.GetProtections().get(0).getClass(), Bag.class);
    }
}
