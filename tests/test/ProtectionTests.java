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
        tg.moveVirologist(tg.v1, 31);
        tg.moveVirologist(tg.v1, 41);
        tg.pickUpProtection(tg.v1);
        Assert.assertTrue(tg.v1.getCurrent_field().GetFieldId() == 41);
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

    @Test
    public void VirologistUsesAxOnBear(){
        Assert.assertNotNull(tg);
        tg.moveVirologist(tg.v2, 44);
        tg.moveVirologist(tg.v2, 34);
        tg.moveVirologist(tg.v1, 33);
        tg.moveVirologist(tg.v1, 23);
        tg.pickUpProtection(tg.v1);
        Assert.assertEquals(tg.v1.GetProtections().get(0).getClass(), Ax.class); //felvette e a baltát
        tg.moveVirologist(tg.v1, 24);
        tg.moveVirologist(tg.v1, 34);
        tg.useAx(tg.v1,tg.v2);
       //Assert.assertNull(tg.v2.getCurrent_field());
    }

    @Test
    public void VirologistUsesGlove() throws InterruptedException {
        Assert.assertNotNull(tg);
        tg.moveVirologist(tg.v1,33);
        tg.learnGeneticCode(tg.v1);
        tg.moveVirologist(tg.v2,42);
        tg.moveVirologist(tg.v2,41);
        tg.pickUpProtection(tg.v2);
        tg.moveVirologist(tg.v2,42);
        tg.moveVirologist(tg.v2,43);
        tg.moveVirologist(tg.v1,43);
        tg.useAgent(tg.v1,new Paralyze(),tg.v2);
        Assert.assertTrue(tg.v2.HasGlove());
    }
}
