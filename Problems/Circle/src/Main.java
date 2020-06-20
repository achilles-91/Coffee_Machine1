class Circle {
    double radius;

//    public static void main(String[] args) {
//        Circle circle = new Circle();
//        circle.radius = 10;
//        System.out.println(circle.getLength() + " " + circle.getArea());
//    }


    public double getLength() {
        return Math.PI * radius * 2;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}