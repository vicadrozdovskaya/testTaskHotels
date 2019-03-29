package jsonparser;

import objects.Breakfast;
import objects.Hotel;
import objects.HotelType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonParser {

    public static final String path = "resources/Hotels.json";

    public static String readFromFile () throws IOException {
        String lines = Files.lines(Paths.get(path)).collect(Collectors.joining());
        return lines;
    }

    public static List<Hotel> getHotelsFromJson () {
        List<Hotel> hotels = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(readFromFile());
            JSONArray array = (JSONArray) object.get("hotels");
            for (int i = 0; i < array.length(); i++) {
                JSONObject currentObject = (JSONObject) array.get(i);
                Hotel hotel = new Hotel();
                hotel.setHotelName( currentObject.getString("hotelName"));
                hotel.setHotelType(HotelType.valueOf(currentObject.getString("hotelType").toUpperCase()));
                hotel.setHotelCost(currentObject.getDouble("hotelCost"));
                hotel.setHotelRating(currentObject.getDouble("hotelRating"));
                hotel.setHotelBreakfast(Breakfast.valueOf(currentObject.getString("hotelBreakfast").split("breakfast_")[1].toUpperCase()));
                hotels.add(hotel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return hotels;
    }
}
