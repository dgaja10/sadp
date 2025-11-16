import java.util.*;

abstract class Pizza {
    String name;
    String dough;
    String sauce;
    List<String> toppings = new ArrayList<>();

    void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough: " + dough);
        System.out.println("Adding sauce: " + sauce);
        System.out.println("Adding toppings: " + toppings);
    }

    void bake() {
        System.out.println("Baking at 350 for 25 minutes");
    }

    void cut() {
        System.out.println("Cutting the pizza into slices");Write a Java Program to implement Adapter pattern for Enumeration iterator
    }

    void box() {
        System.out.println("Placing pizza in official box");
    }

    String getName() {
        return name;
    }
}

class NYStyleCheesePizza extends Pizza {
    NYStyleCheesePizza() {
        name = "NY Style Cheese Pizza";
        dough = "Thin Crust";
        sauce = "Marinara";
        toppings.add("Grated Reggiano Cheese");
    }
}

class ChicagoStyleCheesePizza extends Pizza {
    ChicagoStyleCheesePizza() {
        name = "Chicago Style Cheese Pizza";
        dough = "Thick Crust";
        sauce = "Plum Tomato Sauce";
        toppings.add("Shredded Mozzarella Cheese");
    }

    void cut() {
        System.out.println("Cutting into square slices");
    }
}
abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        if (pizza == null) {
            System.out.println("Sorry, pizza not available.");
            return null;
        }
        System.out.println("--- Making " + pizza.getName() + " ---");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}

class NYPizzaStore extends PizzaStore {
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) return new NYStyleCheesePizza();
       
        return null;
    }
}

class ChicagoPizzaStore extends PizzaStore {
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) return new  ChicagoStyleCheesePizza();
       
        return null;
    }
}


public class Main {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza1 = nyStore.orderPizza("cheese");
        System.out.println("Rohit ordered a " + pizza1.getName() + "\n");

        Pizza pizza2 = chicagoStore.orderPizza("cheese");
        System.out.println(" Pooja ordered a " + pizza2.getName() + "\n");
    }
}
