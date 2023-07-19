package HM06;

public class EX01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.age = 3;
        cat.name = "Барсик";
        cat.condition = true;
        cat.gender = true;
        cat.hunger = true;

        System.out.println(cat.toString());
        cat.feed();
        System.out.println(cat);
        cat.whoAreYou();
    }
}
