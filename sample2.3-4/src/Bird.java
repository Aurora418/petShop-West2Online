public class Bird extends Animal{

    public Bird(String sex, double weight, int age, double inPrice) {
        super(sex, weight, age, inPrice);
    }

    @Override
    public String toString() {
        return "[Bird] "+super.toString();
    }
}
