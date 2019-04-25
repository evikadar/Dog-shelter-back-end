package com.codecool.dogshelter.model.dog;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public enum Status {
    AVAILABLE("Looking for owner"),
    PENDING("Adoption pending"),
    ADOPTED("Adopted"),
    DEAD("Passed away");

    private final String statusName;

    Status(String statusName) {
        this.statusName = statusName;
    }

    public String getStringValue() {
        return statusName;
    }

    public static Map<String, String> getMapOfStatuses() {
        Map<String, String> statusMap = new LinkedHashMap<>();
        Arrays.stream(Status.values()).forEach(status -> statusMap.put(status.toString(), status.getStringValue()));
        return statusMap;
    }
}