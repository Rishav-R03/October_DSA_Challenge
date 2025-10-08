
public class ClassesObj{
    private String name;
    private float salary;

    // constructor
    public Employee(String name, float salary){
        this.name = name;
        this.salary = salary;
    }
    // getters
    public String getName(){return name;}
    public float getSalary(){return salary;}

    // setters
    public void setName(String name){this.name = name;}
    public void setSalary(float salary){this.salary= salary;}

}