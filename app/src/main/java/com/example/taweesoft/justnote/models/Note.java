package com.example.taweesoft.justnote.models;

import java.io.Serializable;

/**
 * Created by TAWEESOFT on 2/25/16 AD.
 */
public class Note implements Serializable{

    private String subject , body;
    private String color;
    private long date;
    public Note(String subject, String body,String color,long date) {
        this.color = color;
        this.subject = subject;
        this.body = body;
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Note{" +
                "subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public String getColor() {
        return color;
    }

    public long getDate() {
        return date;
    }
}
