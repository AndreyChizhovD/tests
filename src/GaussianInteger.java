public class GaussianInteger {

    int real;
    int complex;

    public GaussianInteger(int a, int b) {
        real = a;
        complex = b;
    }

    public GaussianInteger conjugate() {
        return new GaussianInteger(real, -complex);
    }

    public int norm() {
        return real * real + complex * complex;
    }

    public static GaussianInteger sum(GaussianInteger first, GaussianInteger second) {
        return new GaussianInteger(first.real + second.real, second.complex + first.complex);
    }

    public static GaussianInteger prod(GaussianInteger first, GaussianInteger second) {
        return new GaussianInteger(first.real * second.real - first.complex * second.complex,
            second.complex * first.real + first.complex * second.real);
    }

    public boolean isDivisibleBy(GaussianInteger other) {
        var prod = prod(this, other.conjugate());
        var norm = other.norm();
        return (prod.real % norm == 0) && (prod.complex % norm == 0);
    }
}
