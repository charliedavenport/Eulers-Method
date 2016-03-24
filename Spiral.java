/*
 * dx/dt = 0x + y
 * dy/dt = -x - .5y
 * Complex eigenvalues: -0.25 +/- 0.97i
 */
public class Spiral implements LinearSystem {
    public double nextX(double x, double y, double tStep) {
	double dxdt = y;
	return x + (tStep * dxdt);
    }
    public double nextY(double x, double y, double tStep) {
	double dydt = -x - (0.5 * y);
	return y + (tStep * dydt);
    }
}