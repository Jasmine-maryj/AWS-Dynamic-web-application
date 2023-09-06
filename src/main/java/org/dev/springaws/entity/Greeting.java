package org.dev.springaws.entity;


public class Greeting {
    private String id;
    private String body;
    private String name;
    private String title;

    public Greeting(String id, String body, String name, String title) {
        this.id = id;
        this.body = body;
        this.name = name;
        this.title = title;
    }

    public Greeting(){

    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
