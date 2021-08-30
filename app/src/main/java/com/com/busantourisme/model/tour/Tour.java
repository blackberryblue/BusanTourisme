package com.com.busantourisme.model.tour;

import android.graphics.drawable.Drawable;

import java.lang.reflect.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tour {
    int tourId;
    String tourContnet;
    String tourCount;
    int tourImageUrl;
    int tourName;
    String tourTraffic;
    String tourUrl;

    public Tour(int tourId,int tourImageUrl,int tourName) {
        this.tourId = tourId;
        this.tourImageUrl = tourImageUrl;
        this.tourName = tourName;
    }
}
