package org.sang;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class Book {
    private String name;
    private String author;
    @JsonIgnore
    private Float price;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Float getPrice(){
        return price;
    }

    public Date getPublicationDate(){
        return publicationDate;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setPrice(Float price){
        this.price = price;
    }

    public void setPublicationDate(Date publicationDate){
        this.publicationDate = publicationDate;
    }


}