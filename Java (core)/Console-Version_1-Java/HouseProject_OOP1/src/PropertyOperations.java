import java.util.List;

public interface PropertyOperations {
    void addProperty(House house);
    List<House> viewProperties();
    void deleteProperty(int propertyID) throws UnauthorizedAccessException;
}
