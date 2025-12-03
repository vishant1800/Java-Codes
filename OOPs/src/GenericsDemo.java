class Emp<E, V>{
    E id;
    V name;

    public Emp(E id, V name) {
        this.id = id;
        this.name = name;
    }

    E getId(){
        return id;
    }

    V getName() {
        return name;
    }
}

public class GenericsDemo {
    public static void main(String[] args) {
        Emp<Integer, String> h1 = new Emp<>(101, "Vishant");
        Emp<String, Integer> h2 = new Emp<>("Hrithik", 103); // as it is generic so any kind of values can be passed

        System.out.println(h1.getId() + " " + h1.getName());
        System.out.println(h2.getId() + " " + h2.getName());
    }
}
