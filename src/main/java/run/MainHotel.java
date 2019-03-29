package run;


import jsonparser.JsonParser;
import objects.Hotel;
import objects.PriceRange;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainHotel {

    public static void main (String[] args) {
        List<Hotel> hotels = JsonParser.getHotelsFromJson();
        System.out.println("The first task ");
        hotels.stream()
              .sorted(Comparator.comparing((Hotel p) -> p.getHotelBreakfast().getTypeBreakfast())
                                .reversed()
                                .thenComparingDouble(p -> p.getHotelRating())
                                .reversed())
              .limit(5)
              .forEach(hotel -> System.out.println(hotel));
        System.out.println("The second task  first version");
        hotels.stream()
              .collect(Collectors.groupingBy(Hotel::getHotelType))
              .entrySet()
              .stream()
              .sorted(Map.Entry.comparingByKey())
              .forEach(el -> el.getValue()
                               .stream()
                               .sorted(Comparator.comparing(Hotel::getHotelCost))
                               .forEach(hotel -> System.out.println(hotel)));

        System.out.println("The second task second version");
        hotels.stream()
              .sorted(Comparator.comparing((Hotel hotel) -> hotel.getHotelType().getTypeHotel())
                                .reversed()
                                .thenComparingDouble(hotel -> hotel.getHotelCost()))
              .forEach(hotel -> System.out.println(hotel));
        System.out.println("The third task ");
        hotels = hotels.stream()
                       .sorted(Comparator.comparing((Hotel hotel) -> hotel.getHotelName())
                                         .thenComparingDouble(hotel -> hotel.getHotelCost()))
                       .collect(Collectors.toList());

        for (PriceRange priceRange : PriceRange.values()) {
            System.out.println("Range of cost " + priceRange.getMin() + "-" + priceRange.getMax() + "$");
            hotels.stream()
                  .filter(hotel -> hotel.getHotelCost() >= priceRange.getMin() && hotel.getHotelCost() <= priceRange.getMax())
                  .forEach(hotel -> System.out.println(hotel));
        }

    }

}
