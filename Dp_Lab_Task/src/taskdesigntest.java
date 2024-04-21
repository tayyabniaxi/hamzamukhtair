interface Shape {
    double area();
    double perimeter();
}

class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }

    // Assuming it's an equilateral triangle for simplicity
    @Override
    public double perimeter() {
        return 3 * base;
    }
}

class TriangleGeometry {
    public Shape createTriangle(double base, double height) {
        return new Triangle(base, height);
    }
}

class ShapeFactory {
    public static Shape createShape(String shapeType, double... params) {
        switch (shapeType) {
            case "triangle":
                TriangleGeometry triangleGeometry = new TriangleGeometry();
                return triangleGeometry.createTriangle(params[0], params[1]);
            case "square":
                return new Square(params[0]);
            case "circle":
                return new Circle(params[0]);
            default:
                throw new IllegalArgumentException("Unsupported shape type");
        }
    }
}

public class taskdesigntest {
    public static void main(String[] args) {
        Shape triangle = ShapeFactory.createShape("triangle", 4, 5);
        System.out.println("Triangle Area: " + triangle.area());
        System.out.println("Triangle Perimeter: " + triangle.perimeter());

        Shape square = ShapeFactory.createShape("square", 4);
        System.out.println("Square Area: " + square.area());
        System.out.println("Square Perimeter: " + square.perimeter());

        Shape circle = ShapeFactory.createShape("circle", 5);
        System.out.println("Circle Area: " + circle.area());
        System.out.println("Circle Circumference: " + circle.perimeter());
    }
}
