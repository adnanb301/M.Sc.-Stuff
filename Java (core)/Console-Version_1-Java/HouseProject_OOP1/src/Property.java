public class Property {
    protected Integer propertyID;
    protected String location;
    protected Double size;
    protected Double price;

    public Property(Integer propertyID, String location, Double size, Double price) {
        this.propertyID = propertyID;
        this.location = location;
        this.size = size;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Property ID: " + propertyID);
        System.out.println("Location: " + location);
        System.out.println("Size: " + size + " sqm");
        System.out.println("Price: €" + price);
    }
}
