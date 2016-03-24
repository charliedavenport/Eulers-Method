/*
 * dx/dt = 0x +  y;
 * dy/dt = -x - 2y;
 * repeated eigenvalue of -1
 */

public class Repeated implements LinearSystem {
    
    public double nextX(double x, double y, double tStep) {
        double dxdt = y;
        return x + (dxdt * tStep);
    }

    public double nextY(double x, double y, double tStep) {
        double dydt = -1*x - 2*y;
        return y + (dydt * tStep);
    }

}