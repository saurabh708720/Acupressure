package com.example.elearning;

public class gethelp {
    private String name;
    private String mobilenumber;
    private String email;
    private String text;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public gethelp(){}
    public gethelp(String name, String mobilenumber, String email, String text) {
        this.name = name;
        this.mobilenumber = mobilenumber;
        this.email = email;
        this.text = text;
    }
}
