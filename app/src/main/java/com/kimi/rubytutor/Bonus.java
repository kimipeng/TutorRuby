package com.kimi.rubytutor;

/**
 * Created by Kimi.Peng on 2020/7/6.
 */

enum IconType {
    Black, Purple, Red, Pink, Blue, Gray
}

public class Bonus {
    private String name;
    private String description;
    private int viewType;
    private IconType iconType;

    public Bonus(String name, String description, int viewType, IconType iconType) {
        this.name = name;
        this.description = description;
        this.viewType = viewType;
        this.iconType = iconType;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getViewType() {
        return viewType;
    }

    public IconType getIconType() {
        return iconType;
    }
}
