package run;


import jsonparser.JsonParser;
import objects.Hotel;
import objects.HotelType;
import objects.PriceRange;
import objects.comparator.HotelBreakfastComparator;
import objects.comparator.HotelCostComparator;
import objects.comparator.HotelNameComparator;
import objects.comparator.HotelRatingComparator;

import java.util.*;

public class MainHotel {

    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("props");
        String path = rb.getString("fileLocation");
        List<Hotel> hotels = JsonParser.getHotelsFromJson(path);
        doFirstTask(hotels);
        doSecondTask(hotels);
        doThirdTask(hotels);
    }

    public static void doFirstTask(List<Hotel> hotels) {
        Comparator<Hotel> comparatorRatingBreakfast = new HotelBreakfastComparator().thenComparing(new HotelRatingComparator());
        hotels.sort(comparatorRatingBreakfast);
        System.out.print("The First task");
        for (int i = 0; i < 5; i++) {
            System.out.print(hotels.get(i));
        }
    }

    public static void doSecondTask(List<Hotel> hotels) {
        Map<HotelType, Set<Hotel>> hotelTypeListMap = new TreeMap<>();
        for (HotelType hotelType : HotelType.values()) {
            Set<Hotel> typeHotels = new TreeSet<>(new HotelCostComparator());
            for (Hotel hotel : hotels) {
                if (hotelType.getTypeHotel() == hotel.getHotelType().getTypeHotel()) typeHotels.add(hotel);
            }
            hotelTypeListMap.put(hotelType, typeHotels);
        }
        System.out.println("\nThe Second task");
        for (Map.Entry entry : hotelTypeListMap.entrySet()) {
            System.out.println(entry.getKey() + "\n" + entry.getValue());
        }
    }

    public static void doThirdTask(List<Hotel> hotels) {
        Map<PriceRange, Set<Hotel>> priceRangeListMap = new TreeMap<>();
        for (PriceRange priceRange : PriceRange.values()) {
            Set<Hotel> priceHotels = new TreeSet<>(new HotelNameComparator());
            for (Hotel hotel : hotels) {
                if (hotel.getHotelCost() >= priceRange.getMin() && hotel.getHotelCost() <= priceRange.getMax())
                    priceHotels.add(hotel);
            }
            priceRangeListMap.put(priceRange, priceHotels);
        }
        System.out.println("The Third task");
        for (PriceRange priceRange : priceRangeListMap.keySet()) {
            System.out.println(priceRange.getMin() + "-" + priceRange.getMax() + " $\n"
                    + priceRangeListMap.get(priceRange));
        }
    }

}
