package simpleComposite;
//component
public interface Employee {

   public String getName();
   public double getSalary();
   public void print();
   public void add(Employee emp1);
   public void remove(Employee emp1);
   public Employee getChild(int i);
}