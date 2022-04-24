package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import projlab.Aminoacid_storage;
import projlab.Field;
import projlab.Nukleotid_storage;

public class PickUpMaterialTests {
    private TestGame tg;

    @Before
    public void setUp(){
        tg = new TestGame();
    }

    @Test
    public void VirologistPickUpNukleoitd(){
        Assert.assertNotNull(tg);
        tg.moveVirologist(tg.v2, 42);
        tg.pickUpMaterial(tg.v2);
        Assert.assertTrue(tg.v2.getCurrent_field().GetFieldId() == 42);
        Assert.assertEquals(tg.v2.getCurrent_field().getClass(), Nukleotid_storage.class);
        Assert.assertFalse(tg.v2.GetNukleotid().isEmpty()); // sikerül e felvenni valamit
    }

    @Test
    public void VirologistPickUpAminoacid(){
        Assert.assertNotNull(tg);
        tg.moveVirologist(tg.v2, 33);
        tg.moveVirologist(tg.v2, 23);
        tg.moveVirologist(tg.v2, 13);
        tg.moveVirologist(tg.v2, 12);
        tg.pickUpMaterial(tg.v2);
        Assert.assertTrue(tg.v2.getCurrent_field().GetFieldId() == 12);
        Assert.assertEquals(tg.v2.getCurrent_field().getClass(), Aminoacid_storage.class);
        Assert.assertFalse(tg.v2.GetAminoacid().isEmpty()); // sikerül e felvenni valamit
    }
}
