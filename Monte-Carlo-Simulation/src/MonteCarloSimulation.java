
import java.awt.*;
import java.util.LinkedList;

public class MonteCarloSimulation {
    private Circle circle;
    private LinkedList<Point> points=new LinkedList<Point>();
    private int N;

    public MonteCarloSimulation(Circle circle, int n) {
        this.circle = circle;
        N = n;
    }

    public Circle getCircle() {
        return circle;
    }

    public LinkedList<Point> getPoints() {
        return points;
    }

    public int getN() {
        return N;
    }

    public void add(Point point) {
        points.add(point);
    }
}
