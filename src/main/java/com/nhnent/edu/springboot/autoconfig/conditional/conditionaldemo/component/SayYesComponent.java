package com.nhnent.edu.springboot.autoconfig.conditional.conditionaldemo.component;

public class SayYesComponent{
    private String name;

    public SayYesComponent(String name) {
        this.name = name;
    }

    public void sayYes() {
        System.out.println("Y!E!S! " + this.name);
    }
}