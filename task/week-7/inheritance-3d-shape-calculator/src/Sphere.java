import java.util.ArrayList;

public class Sphere extends GeometricShape {
    private float radius;

    public static final ArrayList<Sphere> history = new ArrayList<Sphere>();

    public Sphere(float radius) {
        super(history.size() + 1, "Purple");

        this.radius = radius;

        history.add(this);
    }

    public float getRadius() {
        return this.radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getVolume() {
        return (float) ((4.0f / 3.0f) * (float) Math.PI * (float) Math.pow(this.radius, 3));
    }

    public float getSurfaceArea() {
        return (float) (4.0f * (float) Math.PI * (float) Math.pow(this.radius, 2));
    }

    public String toString() {
        return "Radius: " + this.radius + " - Volume: " + this.getVolume() + " - Surface Area: " + this.getSurfaceArea();
    }
}
