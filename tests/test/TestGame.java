package test;

import projlab.*;

import java.util.ArrayList;

public class TestGame {
    public ArrayList<Field> fields;
    public ArrayList<Ticker> tickables;
    public Virologist v1;
    public Virologist v2;
    public Timer timer;

    public TestGame(){
        createCity();
        //timer = new Timer(tickables);
        //timer.start();
    }

    /*
            |immun_lab  |amino_st   |bag_sh     |forg_lab   |
            |cloak_sh   |field      |ax_sh      | uncontr_lab |
            |field      |field:v1   |parlyz_lab | bear_lab  |
            |glove_sh   |nukl_st    |field:v2   |field      |
    */
    public void createCity(){
        fields = new ArrayList<Field>();

        Lab f1 = new Lab(11); f1.SetGenetic_code(new GC_Immunity()); fields.add(f1);
        Aminoacid_storage f2 = new Aminoacid_storage(12); fields.add(f2);
        Shelter f3 = new Shelter(13); f3.SetProtection(new Bag()); fields.add(f3);
        Lab f4 = new Lab(14); f4.SetGenetic_code(new GC_Forgetting()); fields.add(f4);

        Shelter f5 = new Shelter(21); f5.SetProtection(new Cloak()); fields.add(f5);
        Field f6 = new Field(22); fields.add(f6);
        Shelter f7 = new Shelter(23); f7.SetProtection(new Ax()); fields.add(f7);
        Lab f8 = new Lab(24); f8.SetGenetic_code(new GC_Uncontrollable()); fields.add(f8);

        Field f9 = new Field(31); fields.add(f9);
        Field f10 = new Field(32); fields.add(f10);
        Lab f11 = new Lab(33); f11.SetGenetic_code(new GC_Paralyze()); fields.add(f11);
        Lab f12 = new Lab(34); f12.SetGenetic_code(new GC_Bear()); fields.add(f12);

        Shelter f13 = new Shelter(41); f13.SetProtection(new Glove()); fields.add(f13);
        Nukleotid_storage f14 = new Nukleotid_storage(42); fields.add(f14);
        Field f15 = new Field(43); fields.add(f15);
        Field f16 = new Field(44); fields.add(f16);

        v1 = new Virologist();
        v2 = new Virologist();
        f10.Accept(v1);
        f15.Accept(v2);
        for (int i = 0; i<15; i++) {
            Nukleotid n = new Nukleotid();
            v1.AddNukleotid(n);
        }
        for (int i = 0; i<15; i++) {
            Aminoacid n = new Aminoacid();
            v1.AddAminoacid(n);
        }

        tickables = new ArrayList<Ticker>();
        tickables.addAll(fields);
        tickables.add(v1);
        tickables.add(v2);

        for(Field f : fields){
            for(Field k : fields){
                if(f.GetFieldId() + 1 == k.GetFieldId() || f.GetFieldId() - 1 == k.GetFieldId() || f.GetFieldId() + 10 == k.GetFieldId() || f.GetFieldId() - 10 == k.GetFieldId()){
                    f.GetNeighbours().add(k);
                }
            }
        }
    }

    public void moveVirologist(Virologist v, int id){
        for(Field f1 : fields){
            if(f1.GetFieldId() == id){
                v.Move(f1);
                return;
            }
        }
    }
    public void learnGeneticCode(Virologist v){
        v.getCurrent_field().Collect(v);
    }


    public void createAgent(Virologist v, GeneticCode gc){
        v.UseGeneticCode(gc);
    }

    public void useAgent(Virologist v, Object AgentClass, Virologist w){
        for(Agent a : v.GetAgent()){
            if(a.getClass() == AgentClass.getClass()){
                a.Effect(w);
                return;
            }
        }
    }

    public void pickUpProtection(Virologist v){
        v.GetItem();
    }

    public void pickUpMaterial(Virologist v){
        v.CollectMaterial();
    }

    public void throwOutProtection(Virologist v, Protection p){
        v.LoseItem(p);
    }

    //for debugging
    public void showStatistics(Virologist v, String testName){
        System.out.println(testName);
        String s;
        s = (v.equals(v1)) ? "v1" : "v2";
        System.out.println("Virologist: "+s);
        System.out.println("currentField: " + v.getCurrent_field().GetFieldId());
        s = (v.GetParalyzedTime() > 0) ? "true" : "false";
        System.out.println("isParalyzed: "+ s);
        s = (v.GetUncontrollableTime() > 0) ? "true" : "false";
        System.out.println("isUncotrollable: "+s);
        s = (v.isBear()) ? "true" : "false";
        System.out.println("isBear: "+s);
        System.out.println("capacity: "+v.GetCapacity());
        if(v.GetImmuneTime() > 0) s = "100%"; else s = "0%"; //nem tudom eldönteni hogy van e rajta köpeny
        System.out.println("immunityPercentage: "+s);
        System.out.println("nukleoNumber: "+ v.GetNukleotid().size());
        System.out.println("aminoNumber: "+v.GetAminoacid().size());
    }
}
