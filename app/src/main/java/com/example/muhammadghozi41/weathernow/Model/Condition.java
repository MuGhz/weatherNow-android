package com.example.muhammadghozi41.weathernow.Model;

/**
 * Created by muhammad.ghozi41 on 10/07/17.
 */

public class Condition {
    String text;
    String icon;
    int code;
    public Condition(){}
    public Condition(String text, String icon, int code) {
        this.text = text;
        this.icon = icon;
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
