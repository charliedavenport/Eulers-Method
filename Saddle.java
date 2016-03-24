/*
 * dx/dt = y
 * dy/dt = x - 1.5y
 * Eigenvalues: 0.5, -2
 */
public class Saddle implements LinearSystem {

    public double nextX(double x, double y, double tStep) {
	double dxdt = y;
	return x + tStep*dxdt;
    }
    public double nextY(double x, double y, double tStep) {
        double dydt = x - 1.5*y;
	return y + tStep*dydt;
    }
}