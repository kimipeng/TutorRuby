package com.kimi.rubytutor;

/**
 * Created by Kimi.Peng on 2020/7/6.
 */
public class Bonus {
    private String name;
    private String description;
    private int type;

    public Bonus(String name, String description, int type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getType() {
        return type;
    }
}
