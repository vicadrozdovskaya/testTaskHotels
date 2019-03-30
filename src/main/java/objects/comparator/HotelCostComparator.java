package objects.comparator;

import objects.Hotel;

import java.util.Comparator;

public class HotelCostComparator implements Comparator<Hotel> {
    @Override
    public int compare (Hotel o1, Hotel o2) {
        int result = o1.getHotelCost() > o2.getHotelCost() ? 1 : o1.getHotelCost() < o2.getHotelCost() ? -1 : 0;
        return result;
    }
}
