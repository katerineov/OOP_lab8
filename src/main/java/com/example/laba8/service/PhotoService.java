package com.example.laba8.service;

import com.example.laba8.model.Photo;
import jakarta.servlet.ServletContext;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PhotoService {
    public static void addRentFromJson(ServletContext context, String jsonStr) throws Exception {
        JSONObject json = new JSONObject(jsonStr);
        Photo photo = new Photo(
                json.getString("Name"),
                json.getString("PhoneNumber"),
                json.getString("RentDate"),
                json.getString("ProductName"),
                json.getDouble("Price"),
                json.getString("Duration")
        );
        addRentEntry(context, photo);
    }

    public static void addRentEntry(ServletContext context, Photo photo) throws Exception {
        String currentContent = FileService.readFile(context);
        JSONArray rentsArray = new JSONArray(currentContent);

        JSONObject rentsJson = new JSONObject();
        rentsJson.put("Name", photo.getName());
        rentsJson.put("PhoneNumber", photo.getPhoneNumber());
        rentsJson.put("RentDate", photo.getRentDate());
        rentsJson.put("ProductName", photo.getProductName());
        rentsJson.put("Price", photo.getPrice());
        rentsJson.put("Duration", photo.getDuration());

        rentsArray.put(rentsJson);
        FileService.writeFile(context, rentsArray.toString());
    }

    public static String getAllRentsAsJson(ServletContext context) throws Exception {
        return FileService.readFile(context);
    }

    public static List<Photo> getAllPhotos(ServletContext context) throws Exception {
        String content = FileService.readFile(context);
        JSONArray rentArray = new JSONArray(content);
        List<Photo> rent = new ArrayList<>();

        for (int i = 0; i < rentArray.length(); i++) {
            JSONObject rentJson = rentArray.getJSONObject(i);
            rent.add(new Photo(
                    rentJson.getString("Name"),
                    rentJson.getString("PhoneNumber"),
                    rentJson.getString("RentDate"),
                    rentJson.getString("ProductName"),
                    rentJson.getDouble("Price"),
                    rentJson.getString("Duration")
            ));
        }
        return rent;
    }
}