class Encapsulation {
    private String name;
    private int salary;

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

}

public class EncapsulationPrac {
    public static void main(String[] args) {
        Encapsulation ep = new Encapsulation();
        ep.setName("Rishav");
        ep.setSalary(1000000);

        System.out.println("The name is " + ep.getName());
        System.out.println("The salary is " + ep.getSalary());
    }
}
