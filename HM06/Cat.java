package HM06;

public class Cat {
    String name;
    Integer age;
    boolean gender;
    boolean condition;
    boolean hunger;

    @Override
    public String toString() {
        return String.format("name: %s age: %d gender: %b condition: %b hunger: %b", name, age, gender, condition, hunger);
    }

    public void feed () {
        if (hunger == true) {
            hunger = false;
        }
    }

    public void goToSleep(){
        if (condition == true) {
            condition = false;
        }
    }

    public void whoAreYou(){
        if (gender == true) {
            System.out.println("It's male");
        }
        else System.out.println("It's female");
    }
}
