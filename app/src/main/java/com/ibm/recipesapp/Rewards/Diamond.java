package com.ibm.recipesapp.Rewards;

import java.io.Serializable;

public class Diamond implements Serializable {
    public String name;

    public Diamond(){
        this.name = "diamond";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
