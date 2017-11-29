package myBean;

import java.io.Serializable;
import java.util.ArrayList;

public class Boardlist implements Serializable {
    private ArrayList<Board> purchases;

    private int totalCost;

    public Boardlist() {
        purchases = new ArrayList<>();
        totalCost = 0;
    }

    public void addPurchase(Board purchase) {
        if (purchase.getCount() > 0) {
            for (Board item : purchases) {
                if (item.getId() == purchase.getId()) {
                    item = purchase;

                    this.recalculateTotalCost();
                    return;
                }
            }
            this.purchases.add(purchase);
            this.recalculateTotalCost();
        }
    }

    public double getTotalCost() {
        return totalCost;
    }

    private void recalculateTotalCost() {
        if (purchases == null) return;
        this.totalCost = 0;

        for (Board purchase : this.purchases) {
            totalCost += purchase.getTotalcost();
        }
    }

    public ArrayList<Board> getPurchases() {
        return purchases;
    }

    public void setPurchases(ArrayList<Board> purchases) {
        this.purchases = purchases;
    }


    public String getStr(Boardlist list) {
        String result = "";
        for (Board item : list.purchases) {
            result += item.PStr() + " | ";
        }

        if (result != "")
        { result += "????: " + Double.toString(list.getTotalCost()) + "$";

        return result;}
        else return "lol";
    }

}