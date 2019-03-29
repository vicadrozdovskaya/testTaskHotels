package objects;

public enum Breakfast {
    INCLUDED("breakfast_included"), NOT_INCLUDED("breakfast_not_included");

    private String typeBreakfast;

    Breakfast (String typeBreakfast) {
        this.typeBreakfast = typeBreakfast;
    }

    public String getTypeBreakfast () {
        return typeBreakfast;
    }

    @Override
    public String toString () {
        return typeBreakfast;
    }
}
