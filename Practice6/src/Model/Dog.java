class Dog implements AnimalInterface, LegInterface, HandInterface {
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
    public void Leg() {
        System.out.println("Dog has 4 legs");
    }
    public void walk() {
        System.out.println("Dog is walking");
    }
    public void Hand() {
        System.out.println("Dog has no hands");
    }
    public void Grap(){
        System.out.println("Dog cannot grasp");
    }
}