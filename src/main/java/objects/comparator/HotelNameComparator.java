package objects.comparator;

import objects.Hotel;

import java.util.Comparator;

public class HotelNameComparator implements Comparator<Hotel> {
    @Override
    public int compare (Hotel o1, Hotel o2) {
        return o1.getHotelName().compareTo(o2.getHotelName());
    }
}
