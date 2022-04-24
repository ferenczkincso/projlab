package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import projlab.*;

public class AgentUsageTests {
    private TestGame tg;

    @Before
    public void setUp(){
        tg = new TestGame();
    }

    @Test
    public void VirologistUsesImmunityAgentOnItself(){
        Assert.assertNotNull(tg);
        tg.moveVirologist(tg.v1, 22);
        tg.moveVirologist(tg.v1, 21);
        tg.moveVirologist(tg.v1, 11);
        tg.learnGeneticCode(tg.v1);
        Assert.assertFalse(tg.v1.GetGenetic_codes().isEmpty());  //megtanulja e a kódot, hanem akkor outofIndex exceptiont is kapunk
        tg.createAgent(tg.v1, tg.v1.GetGenetic_codes().get(0));     //létrehozza az ágenst
        Assert.assertFalse(tg.v1.GetAgent().isEmpty());  //beteszi e  az ágenst a tárolóba
        tg.useAgent(tg.v1,new Immunity(),tg.v1);
        Assert.assertTrue(tg.v1.getCurrent_field().GetFieldId() == 11);
        Assert.assertEquals(tg.v1.getCurrent_field().getClass(), Lab.class);
        Assert.assertTrue(tg.v1.GetImmuneTime() > 0);  // működik e az ágens
    }

    @Test
    public void VirologistUsesParalyzedAgent(){
        Assert.assertNotNull(tg);
        tg.moveVirologist(tg.v1, 33);
        tg.moveVirologist(tg.v2,33 );
        tg.learnGeneticCode(tg.v1);
        Assert.assertFalse(tg.v1.GetGenetic_codes().isEmpty());  //megtanulja e a kódot, hanem akkor outofIndex exceptiont is kapunk
        tg.createAgent(tg.v1, tg.v1.GetGenetic_codes().get(0)); //létrehozza az ágenst
        Assert.assertFalse(tg.v1.GetAgent().isEmpty());  //beteszi e  az ágenst a tárolóba
        tg.useAgent(tg.v1,new Paralyze(),tg.v2);
        Assert.assertTrue(tg.v1.getCurrent_field().GetFieldId() == 33);
        Assert.assertTrue(tg.v2.getCurrent_field().GetFieldId() == 33);
        Assert.assertTrue(tg.v2.GetParalyzedTime() > 0);  // működik e az ágens
    }

    @Test
    public void VirologistUsesUncotrollableAgent(){
        Assert.assertNotNull(tg);
        tg.moveVirologist(tg.v1, 33);
        tg.moveVirologist(tg.v1, 34);
        tg.moveVirologist(tg.v1, 24);
        tg.moveVirologist(tg.v2,33 );
        tg.moveVirologist(tg.v2,34 );
        tg.moveVirologist(tg.v2,24 );
        tg.learnGeneticCode(tg.v1);
        Assert.assertFalse(tg.v1.GetGenetic_codes().isEmpty());  //megtanulja e a kódot, hanem akkor outofIndex exceptiont is kapunk
        tg.createAgent(tg.v1, tg.v1.GetGenetic_codes().get(0)); //létrehozza az ágenst
        Assert.assertFalse(tg.v1.GetAgent().isEmpty());  //beteszi e  az ágenst a tárolóba
        tg.useAgent(tg.v1,new Uncontrollable(),tg.v2);
        Assert.assertTrue(tg.v2.GetUncontrollableTime() > 0);  // működik e az ágens
    }

    @Test
    public void VirologistUsesForgettingAgent(){
        Assert.assertNotNull(tg);
        tg.moveVirologist(tg.v1, 33);
        tg.moveVirologist(tg.v1, 34);
        tg.moveVirologist(tg.v1, 24);
        tg.moveVirologist(tg.v1, 14);
        tg.moveVirologist(tg.v2,33 );
        tg.moveVirologist(tg.v2,34 );
        tg.moveVirologist(tg.v2,24 );
        tg.moveVirologist(tg.v2,14 );
        tg.learnGeneticCode(tg.v1);
        Assert.assertFalse(tg.v1.GetGenetic_codes().isEmpty());  //megtanulja e a kódot, hanem akkor outofIndex exceptiont is kapunk
        tg.createAgent(tg.v1, tg.v1.GetGenetic_codes().get(0)); //létrehozza az ágenst
        Assert.assertFalse(tg.v1.GetAgent().isEmpty());  //beteszi e  az ágenst a tárolóba
        tg.useAgent(tg.v1,new Forgetting(),tg.v2);
        Assert.assertTrue(tg.v2.GetGenetic_codes().isEmpty());  // működik e az ágens
    }
}
