import java.util.ArrayList;

public class Cylinder extends GeometricShape {
    private float radius;
    private float height;

    public static final ArrayList<Cylinder> history = new ArrayList<Cylinder>();

    public Cylinder(float radius, float height) {
        super(history.size() + 1, "Yellow");

        this.radius = radius;
        this.height = height;

        history.add(this);
    }

    public float getRadius() {
        return this.radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getHeight() {
        return this.height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getVolume() {
        return (float) ((float) Math.PI * (float) Math.pow(this.radius, 2) * this.height);
    }

    public float getSurfaceArea() {
        return (float) (2.0f * (float) Math.PI * this.radius * (this.radius + this.height));
    }

    public String toString() {
        return "Radius: " + this.radius + " - Height: " + this.height + " - Volume: " + this.getVolume() + " - Surface Area: " + this.getSurfaceArea();
    }
}
