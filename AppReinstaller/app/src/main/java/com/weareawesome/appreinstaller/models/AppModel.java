package com.weareawesome.appreinstaller.models;

public class AppModel {

    private String packageName;
    private String name;
    private Object icon;

    public AppModel(String packageName, String name, Object icon) {
        this.packageName = packageName;
        this.name = name;
        this.icon = icon;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getName() {
        return name;
    }

    public Object getIcon() {
        return icon;
    }
}
