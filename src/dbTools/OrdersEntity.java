package dbTools;

import myBean.Boardlist;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "orderlist", schema = "web_lab")
public class OrdersEntity {
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private int id;
    @Column(name = "OrderDate", nullable = false, length = 50)
    private String orderDate;
    @Column(name = "UserName", nullable = false, length = 50)
    private String userName;
    @Column(name = "Purchases", nullable = false, length = 512)
    private String purchases;
    @Column(name = "Address", nullable = true, length = 50)
    private String addressee;
    @Column(name = "Delivery", nullable = true)
    private byte withCurier;
    @Column(name = "ShopId", nullable = true)
    private Integer shopId;

    private Boardlist purchaseList;

    public Boardlist getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(Boardlist purchaseList) {
        this.purchaseList = purchaseList;
    }

    public OrdersEntity(){}

    public OrdersEntity(String userName, String purchases, byte withCurier, int shopId) {
        this.userName = userName;
        this.purchases = purchases;
        this.withCurier = withCurier;
        this.shopId = shopId;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm dd.MM.yyyy");
        String date = format.format(new Date());
        this.orderDate = date;
    }

    public OrdersEntity(String userName, String purchases, byte withCurier, String addressee) {
        this.userName = userName;
        this.purchases = purchases;
        this.addressee = addressee;
        this.withCurier = withCurier;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm dd.MM.yyyy");
        String date = format.format(new Date());
        this.orderDate = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPurchases() {
        return purchases;
    }

    public void setPurchases(String purchases) {
        this.purchases = purchases;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public byte getWithCurier() {
        return withCurier;
    }

    public void setWithCurier(byte withCurier) {
        this.withCurier = withCurier;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (id != that.id) return false;
        if (withCurier != that.withCurier) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (purchases != null ? !purchases.equals(that.purchases) : that.purchases != null) return false;
        if (addressee != null ? !addressee.equals(that.addressee) : that.addressee != null) return false;
        if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (purchases != null ? purchases.hashCode() : 0);
        result = 31 * result + (addressee != null ? addressee.hashCode() : 0);
        result = 31 * result + (int) withCurier;
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        return result;
    }
}