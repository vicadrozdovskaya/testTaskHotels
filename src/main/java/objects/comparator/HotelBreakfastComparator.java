package objects.comparator;

import objects.Hotel;

import java.util.Comparator;

public class HotelBreakfastComparator implements Comparator<Hotel> {
    @Override
    public int compare (Hotel o1, Hotel o2) {
        return o1.getHotelBreakfast().getTypeBreakfast().compareTo(o2.getHotelBreakfast().getTypeBreakfast());
    }
}
