package myBean;

import java.io.Serializable;

public class BoardBean implements Serializable{
    private int id;
    private String type;
    private double price;
    private String name;
    private String imageUrl;
    private String description;

    public int getId(){
        return id;
    }
    public String gettype(){
        return type;
    }
    public double getPrice(){
        return price;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public void setId(int x){
        this.id = x;
    }

    public void setType(String x){
        this.type = x;
    }

    public void setPrice(double x) {
        this.price = x;
    }

    public void setName(String x){
        this.name = x;
    }

    public void setImageUrl(String x){
        this.imageUrl = x;
    }

    public void setDescription(String x){
        this.description = x;
    }
}


