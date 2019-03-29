package objects;

public enum HotelType {
    HOTEL("Hotel"), HOSTEL("Hostel"), APARTMENT("Apartment");

    private String typeHotel;

    HotelType(String typeHotel){
        this.typeHotel = typeHotel;
    }

    public String getTypeHotel () {
        return typeHotel;
    }

    @Override
    public String toString () {
        return typeHotel;
    }
}
