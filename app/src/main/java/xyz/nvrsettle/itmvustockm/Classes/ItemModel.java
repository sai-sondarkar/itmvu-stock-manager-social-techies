package xyz.nvrsettle.itmvustockm.Classes;

/**
 * Created by sai on 24/11/17.
 */

public class ItemModel {

    public String uid; // unique Id
    public String nameOfTheItem; // it is the name of the item
    public String descriptionOfTheItem; // it is the description of the item
    public float price; // it is the price of the item
    public int stockWithUs; /// it is the stock we have in hand now
    public int reminderMinimumCount; /// it is the minimum count of the items we
                                    ///should have after which we will make a reminder call


    public ItemModel() { // default Const.
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNameOfTheItem() {
        return nameOfTheItem;
    }

    public void setNameOfTheItem(String nameOfTheItem) {
        this.nameOfTheItem = nameOfTheItem;
    }

    public String getDescriptionOfTheItem() {
        return descriptionOfTheItem;
    }

    public void setDescriptionOfTheItem(String descriptionOfTheItem) {
        this.descriptionOfTheItem = descriptionOfTheItem;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStockWithUs() {
        return stockWithUs;
    }

    public void setStockWithUs(int stockWithUs) {
        this.stockWithUs = stockWithUs;
    }

    public int getReminderMinimumCount() {
        return reminderMinimumCount;
    }

    public void setReminderMinimumCount(int reminderMinimumCount) {
        this.reminderMinimumCount = reminderMinimumCount;
    }


}
