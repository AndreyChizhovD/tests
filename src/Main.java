public class Main {

    public static void main(String[] args) {
        GaussianInteger first = new GaussianInteger(1, 4);
        GaussianInteger second = new GaussianInteger(2, 3);
        var prod = GaussianInteger.prod(first, second);
        System.out.println(
            prod.real + " + " + prod.complex + "i"
        );
    }
}