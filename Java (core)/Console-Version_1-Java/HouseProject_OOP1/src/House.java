public class House extends Property {
    public Integer beds;
    public Integer baths;
    public Boolean yard;
    public HouseType.hType houseType;

    public House(Integer propertyID, String location, Double size, Double price,
                 Integer beds, Integer baths, Boolean yard, HouseType.hType houseType) {
        super(propertyID, location, size, price);
        this.beds = beds;
        this.baths = baths;
        this.yard = yard;
        this.houseType = houseType;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Bedrooms: " + beds);
        System.out.println("Bathrooms: " + baths);
        System.out.println("Yard: " + (yard ? "Yes" : "No"));
        System.out.println("House Type: " + houseType);
    }
}
