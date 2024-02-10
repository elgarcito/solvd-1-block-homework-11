package com.solvd.hardwarestore.created_interfaces;/*
This interface allows us to set the cost of a product.It uses:
supplierCost: the cost of the supplier
transportCost: the cost for transport the product to our store
anotherCost: any other cost that we could consider

The implementation of the method defineCost will set a unit cost for any product, we can create any rule inside
any product to define it and assign it to a cost
 */

public interface Costable {
    double defineCost(double supplierCost,double transportCost,double anotherCost);
}
