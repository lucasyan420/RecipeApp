package com.ibm.recipesapp.Rewards;

import java.io.Serializable;

public class Snack implements Serializable {
    public String name;

    public Snack(){
        this.name = "snack";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
