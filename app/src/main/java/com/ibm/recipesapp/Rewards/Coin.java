package com.ibm.recipesapp.Rewards;

import java.io.Serializable;

public class Coin implements Serializable {
    public String name;

    public Coin(){
        this.name = "coin";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
