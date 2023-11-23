package se.miun.whiteboiz;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import javax.sql.DataSource;

@RequestScoped
@Named
public class HelloBean {


    private String name;
    private String greeting;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGreeting() {
        return greeting;
    }
    public void setGreeting(String greeting) {
        this.greeting = "Hello " + greeting + "!";
    }
    public void doGreet() {
        greeting = "Hello " + name + "!";
    }

}



