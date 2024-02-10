package com.solvd.hardwarestore.created_interfaces;

/*
This interface allows us to remove from the stock the amount sold, it needs:
A product of any category
amountSold: An amount to sold
thereIsStock: first we need to check if there is stock or no
if there is no stock it should say a message that that can be sold


 */
public interface Sellable {
    void removeStockDueSell(int amountSold);
}
