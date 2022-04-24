package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import projlab.*;

public class StepTests {
    private TestGame tg;

    @Before
    public void setUp(){
        tg = new TestGame();
    }

    @Test
    public void VirologistStepsOnField(){
        Assert.assertNotNull(tg);
       tg.moveVirologist(tg.v1, 22);
       Assert.assertTrue(tg.v1.getCurrent_field().GetFieldId() == 22);
       Assert.assertEquals(tg.v1.getCurrent_field().getClass(), Field.class);
    }

    @Test
    public void VirologistStepsOnLab(){
        Assert.assertNotNull(tg);
        tg.moveVirologist(tg.v1, 22);
        tg.moveVirologist(tg.v1, 12);
        tg.moveVirologist(tg.v1, 11);
        Assert.assertTrue(tg.v1.getCurrent_field().GetFieldId() == 11);
        Assert.assertEquals(tg.v1.getCurrent_field().getClass(), Lab.class);
    }

    @Test
    public void VirologistStepsOnNukelotidStorage(){
        Assert.assertNotNull(tg);
        tg.moveVirologist(tg.v1, 42);
        Assert.assertTrue(tg.v1.getCurrent_field().GetFieldId() == 42);
        Assert.assertEquals(tg.v1.getCurrent_field().getClass(), Nukleotid_storage.class);
    }

    @Test
    public void VirologistStepsOnAminoacidStorage(){
        Assert.assertNotNull(tg);
        tg.moveVirologist(tg.v1, 22);
        tg.moveVirologist(tg.v1, 12);
        Assert.assertTrue(tg.v1.getCurrent_field().GetFieldId() == 12);
        Assert.assertEquals(tg.v1.getCurrent_field().getClass(), Aminoacid_storage.class);
    }

    @Test
    public void VirologistStepsOnShelter(){
        Assert.assertNotNull(tg);
        tg.moveVirologist(tg.v1, 33);
        tg.moveVirologist(tg.v1, 23);
        Assert.assertTrue(tg.v1.getCurrent_field().GetFieldId() == 23);
        Assert.assertEquals(tg.v1.getCurrent_field().getClass(), Shelter.class);
    }
}
