public interface LinearSystem {
    abstract double nextX(double x, double y, double tStep);
    abstract double nextY(double x, double y, double tStep);
}