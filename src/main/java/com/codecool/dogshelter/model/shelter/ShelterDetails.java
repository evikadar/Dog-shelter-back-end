package com.codecool.dogshelter.model.shelter;

public interface ShelterDetails {

    Long getId();

    String getName();

    String getEmail();

    AddressDetails getAddress();

    String getPhotoPath();

    String getShelterDescription();

    String getPhoneNumber();

    interface AddressDetails {

        Long getId();

        String getCountry();

        String getCity();

        String getAddress();

        Integer getZipCode();

    }

}
