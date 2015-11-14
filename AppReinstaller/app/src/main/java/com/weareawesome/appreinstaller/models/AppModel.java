package com.weareawesome.appreinstaller.models;

import android.graphics.drawable.Drawable;

public class AppModel {

    private String packageName;
    private String name;
    private Drawable icon;

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getName() {
        return name;
    }

    public Drawable getIcon() {
        return icon;
    }
}
