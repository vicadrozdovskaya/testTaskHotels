package objects.comparator;

import objects.Hotel;

import java.util.Comparator;

public class HotelRatingComparator implements Comparator<Hotel> {
    @Override
    public int compare (Hotel o1, Hotel o2) {
        int result = o1.getHotelRating() < o2.getHotelRating() ? 1 : o1.getHotelRating() > o2.getHotelRating() ? -1 : 0;
        return result;
    }
}
