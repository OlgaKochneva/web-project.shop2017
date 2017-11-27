package myBean;

import java.io.Serializable;

public  class Board implements Serializable {
    private int id, count;
    private double totalcost;
    private String name, description, imgurl;

    public Board(int _id, String _name, String _description, String _imgurl, int _count, double cost){
        this.id = _id;
        this.name = _name;
        this.description = _description;
        this.imgurl = _imgurl;
        this.count = _count;
        this.totalcost = _count * cost;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImgurl() {
        return imgurl;
    }

    public int getCount() {
        return count;
    }

    public double getTotalcost() {
        return totalcost;
    }

}
