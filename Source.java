/*
 * dx/dt = y
 * dy/dt = -0.5x + 2y
 * Eigenvalues: 1.71 and 0.29
 */
public class Source implements LinearSystem {

    public double nextX(double x, double y, double tStep) {
        double dxdt = y;
	return x + (tStep*dxdt);
    }
    public double nextY(double x, double y, double tStep) {
        double dydt = (-0.5 * x) + (2*y);
	return y + (tStep*dydt);
    }
}

