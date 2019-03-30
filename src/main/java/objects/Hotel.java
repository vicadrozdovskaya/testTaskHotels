package objects;

import java.util.Objects;

public class Hotel {

    private String hotelName;
    private HotelType hotelType;
    private double hotelCost;
    private double hotelRating;
    private Breakfast hotelBreakfast;

    public Breakfast getHotelBreakfast () {
        return hotelBreakfast;
    }

    public void setHotelBreakfast (Breakfast hotelBreakfast) {
        this.hotelBreakfast = hotelBreakfast;
    }

    public HotelType getHotelType () {
        return hotelType;
    }

    public void setHotelType (HotelType hotelType) {
        this.hotelType = hotelType;
    }

    public String getHotelName () {
        return hotelName;
    }

    public void setHotelName (String hotelName) {
        this.hotelName = hotelName;
    }

    public double getHotelCost () {
        return hotelCost;
    }

    public void setHotelCost (double hotelCost) {
        this.hotelCost = hotelCost;
    }

    public double getHotelRating () {
        return hotelRating;
    }

    public void setHotelRating (double hotelRating) {
        this.hotelRating = hotelRating;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Double.compare(hotel.hotelCost, hotelCost) == 0 && Double.compare(hotel.hotelRating, hotelRating) == 0 &&
               hotelType == hotel.hotelType && hotelName.equals(hotel.hotelName) && hotelBreakfast == hotel.hotelBreakfast;
    }

    @Override
    public int hashCode () {
        return Objects.hash(hotelType, hotelName, hotelCost, hotelRating, hotelBreakfast);
    }

    @Override
    public String toString () {
        return "\n" + hotelType + " {" + "hotelName='" + hotelName + '\'' + ", hotelType="
                + hotelType + ", hotelCost=" + hotelCost + " $, hotelRating="
                + hotelRating + ", hotelBreakfast=" + hotelBreakfast + '}';
    }

}
