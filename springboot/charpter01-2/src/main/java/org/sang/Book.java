package org.sang;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "book")
public class Book {
    private String name;
    private String author;
    private String price;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPrice(){
        return price;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setPrice(String price){
        this.price = price;
    }
}