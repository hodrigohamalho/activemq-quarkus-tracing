package org.acme;

import java.io.Serializable;

public class Order implements Serializable{

    private static final long serialVersionUID = -1405849549831347801L;
    private int id;
    private String item;
    private int amount;
    private String description;
    private boolean processed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public String toString(){
        return "id: "+this.id+", item: "+this.item+", amount: "+this.amount+", description: "+this.description;
    }
}