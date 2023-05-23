package decoratorExample;

interface Beverage {
    String getDescription();
    double cost();
}

class HouseBlend implements Beverage {
    private String description = "House Blend Coffee";

    
    public String getDescription() {
        return description;
    }

    
    public double cost() {
        return 0.68;
    }
}

class DarkRoast implements Beverage {
    private String description = "Dark Roast Coffee";

   
    public String getDescription() {
        return description;
    }

    
    public double cost() {
        return 1.99;
    }
}

class Espresso implements Beverage {
    private String description = "Espresso";

    
    public String getDescription() {
        return description;
    }

    
    public double cost() {
        return 2.99;
    }
}

class Decaf implements Beverage {
    private String description = "Decaf Coffee";

    
    public String getDescription() {
        return description;
    }

    
    public double cost() {
        return 1.05;
    }
}

interface CondimentDecorator extends Beverage {
    String getDescription();
}

class Milk implements CondimentDecorator {
    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    
    public double cost() {
        return beverage.cost() + 0.15;
    }
}

class Mocha implements CondimentDecorator {
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    
    public double cost() {
        return beverage.cost() + 0.15;
    }
}

class Soy implements CondimentDecorator {
    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

   
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    
    public double cost() {
        return beverage.cost() + 0.15;
    }
}

public class Decorator {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Milk(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}
