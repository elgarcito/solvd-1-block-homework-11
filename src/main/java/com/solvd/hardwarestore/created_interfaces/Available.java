package com.solvd.hardwarestore.created_interfaces;

/*
This interface let us know if there is stock available or no.
The check Availability method lets us know in a boolean expression if there is or no
Stock of that product
 */
public interface Available {
    boolean checkAvailability(int stock);
}
