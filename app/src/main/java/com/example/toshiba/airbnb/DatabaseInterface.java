package com.example.toshiba.airbnb;

/**
 * Created by TOSHIBA on 29/07/2017.
 */



import com.example.toshiba.airbnb.Explore.DTOBookSchedule;
import com.example.toshiba.airbnb.Explore.POJOBookingData;
import com.example.toshiba.airbnb.Explore.POJOBookingDataGetResult;
import com.example.toshiba.airbnb.Explore.POJOListingData;
import com.example.toshiba.airbnb.Explore.POJOMultipleListingsData;
import com.example.toshiba.airbnb.Explore.POJOMultipleListingsDataGetResult;
import com.example.toshiba.airbnb.Explore.POJOTotalListings;
import com.example.toshiba.airbnb.Profile.BecomeAHost.IdListing;
import com.example.toshiba.airbnb.Profile.BecomeAHost.ImageListingRequest;
import com.example.toshiba.airbnb.Profile.BecomeAHost.PublishListingDataRequestDTO;
import com.example.toshiba.airbnb.Profile.DTO.AboutMeDTO;
import com.example.toshiba.airbnb.Profile.DTO.EmailDetailEditDTO;
import com.example.toshiba.airbnb.Profile.DTO.LanguagesDetailEditDTO;
import com.example.toshiba.airbnb.Profile.DTO.LocationDetailEditDTO;
import com.example.toshiba.airbnb.Profile.DTO.PhoneNumDetailEditDTO;
import com.example.toshiba.airbnb.Profile.DTO.WorkDetailEditDTO;
import com.example.toshiba.airbnb.Profile.POJOUserData;
import com.example.toshiba.airbnb.Profile.ViewListing.POJOListingImageAndTitleGetResult;
import com.example.toshiba.airbnb.UserAuthentication.EmailResult;
import com.example.toshiba.airbnb.UserAuthentication.LogInRequest;
import com.example.toshiba.airbnb.UserAuthentication.PasswordMatch;
import com.example.toshiba.airbnb.UserAuthentication.UserRegistrationRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Owner on 2017-06-19.
 */

public interface DatabaseInterface {

    @Headers("Content-Type: application/json")
    @GET("/findUser/{email}")
    Call<EmailResult> findUser(@Path("email") String email);

    @Headers("Content-Type: application/json")
    @POST("/register")
    Call<Void> insertUserRegistration(@Body UserRegistrationRequest body); //Alter to Call<Void> later

    @Headers("Content-Type: application/json")
    @POST("/login")
    Call<PasswordMatch> findLogInData(@Body LogInRequest body);

    @Headers("Content-Type: application/json")
    @POST("/insertListingData")
    Call<IdListing> insertListingData(@Body PublishListingDataRequestDTO body);

    @Headers("Content-Type: application/json")
    @POST("/insertListingImages")
    Call<Void> insertListingImages(@Body ImageListingRequest body);

    @GET("/listingImageAndTitle/{user_id}")
    Call<POJOListingImageAndTitleGetResult> getListingImageAndTitle(@Path("user_id") int user_id);

    @GET("/listingData/{id}")
    Call<POJOListingData> getListingData(@Path("id") int user_id);

    @Headers("Content-Type: application/json")
    @POST("/bookSchedule/{id}/{listing_id}")
    Call<Void> insertBookingSchedule(@Path("id") int user_id, @Path("listing_id") int listing_id,
                                     @Body DTOBookSchedule body);

    @GET("/getBookingSchedules/{id}/{listing_id}")
    Call<POJOBookingDataGetResult> getBookingSchedules(@Path("id") int user_id, @Path("listing_id") int listing_id);

    @GET("/multipleListingsData/{showRowsAfter}/{showAmountOfRows}")
    Call<POJOMultipleListingsDataGetResult> getMultipleListingsData(@Path("showRowsAfter") int showRowsAfter, @Path("showAmountOfRows") int showAmountOfRows );

    @GET("/totalListingsData")
    Call<POJOTotalListings> getTotalListings();

    @GET("/getUserData/{id}")
    Call<POJOUserData> getUserData(@Path("id") int user_id);

    //HostProfileEdit Section
    @Headers("Content-Type: application/json")
    @POST("/insertProfileImagePath/{id}/{profile_image_path}")
    Call<Void> insertProfileImagePath(@Path("id") int user_id, @Path("profile_image_path") String profile_image_path);

    @Headers("Content-Type: application/json")
    @POST("/insertAboutMe/{id}")
    Call<Void> insertAboutMe(@Path("id") int user_id, @Body AboutMeDTO body);

    @Headers("Content-Type: application/json")
    @POST("/insertEmailDetailEdit/{id}")
    Call<Void> insertEmailDetailEdit(@Path("id") int user_id, @Body EmailDetailEditDTO body);

    @Headers("Content-Type: application/json")
    @POST("/insertPhoneNumDetailEdit/{id}}")
    Call<Void> insertPhoneNumDetailEdit(@Path("id") int user_id, @Body PhoneNumDetailEditDTO body);

    @Headers("Content-Type: application/json")
    @POST("/insertLocationDetailEdit/{id}")
    Call<Void> insertLocationDetailEdit(@Path("id") int user_id, @Body LocationDetailEditDTO body);

    @Headers("Content-Type: application/json")
    @POST("/insertWorkDetailEdit/{id}")
    Call<Void> insertWorkDetailEdit(@Path("id") int user_id, @Body WorkDetailEditDTO body);

    @Headers("Content-Type: application/json")
    @POST("/insertLanguagesDetailEdit/{id}")
    Call<Void> insertLanguagesDetailEdit(@Path("id") int user_id, @Body LanguagesDetailEditDTO body);


    @Headers("Content-Type: application/json")
    @GET("/hi")
    Call<Void> hi();

}
