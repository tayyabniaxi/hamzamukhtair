// IPerson interface
interface IPerson {
    String getName();
}

// Villager class implementing IPerson interface
class Villager implements IPerson {
    @Override
    public String getName() {
        return "Village Person";
    }
}

// CityPerson class implementing IPerson interface
class CityPerson implements IPerson {
    @Override
    public String getName() {
        return "City Person";
    }
}

// Enum defining types of persons
enum PersonType {
    Rural,
    Urban
}

// PersonFactory class responsible for creating IPerson objects
class PersonFactory {
    public IPerson getPerson(PersonType type) {
        switch (type) {
            case Rural:
                return new Villager();
            case Urban:
                return new CityPerson();
            default:
                throw new IllegalArgumentException("Unsupported PersonType");
        }
    }
}

// Triangle class representing a triangle geometry
class Triangle {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double area() {
        return 0.5 * base * height;
    }

    // Assuming it's an equilateral triangle for simplicity
    public double perimeter() {
        return 3 * base;
    }
}

// TriangleGeometry class providing the factory method for creating Triangle objects
class TriangleGeometry {
    public Triangle createTriangle(double base, double height) {
        return new Triangle(base, height);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Triangle using TriangleGeometry factory method
        TriangleGeometry triangleGeometry = new TriangleGeometry();
        Triangle triangle = triangleGeometry.createTriangle(4, 5);
        System.out.println("Triangle Area: " + triangle.area());
        System.out.println("Triangle Perimeter: " + triangle.perimeter());
    }
}
