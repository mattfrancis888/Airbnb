package com.example.toshiba.airbnb.Profile.ViewListingAndYourBooking.EditListing.DTO;

/**
 * Created by TOSHIBA on 30/10/2017.
 */

public class DTORoomsAndGuest {
    private final String total_guest;
    private final String total_bedrooms;
    private final String total_beds;

    public DTORoomsAndGuest(String total_guest, String total_bedrooms, String total_beds){
        this.total_guest = total_guest;
        this.total_bedrooms = total_bedrooms;
        this.total_beds = total_beds;
    }
}
