package aod.lab5.graph;

import java.awt.*;

public class Edge<T> {

    private Vertex<T> from;
    private Vertex<T> to;
    private double distance;
    private Color color;

    public Edge(Vertex<T> from, Vertex<T> to) {
        this.from = from;
        this.to = to;
        this.distance = calculateDistance();
        this.color = Color.GRAY;
    }

    private double calculateDistance() {

        double dx = to.getX() - from.getX();
        double dy = to.getY() - from.getY();

        return Math.sqrt(dx * dx + dy * dy);
    }

    public Vertex<T> getFrom() {
        return from;
    }

    public void setFrom(Vertex<T> from) {
        this.from = from;
    }

    public Vertex<T> getTo() {
        return to;
    }

    public void setTo(Vertex<T> to) {
        this.to = to;
    }

    public double getDistance() {
        return distance;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}