package simpleComposite;
//leaf node
public class Developer implements Employee{

  private String name;
  private double salary;

  public Developer(String name,double salary){
    this.name = name;
    this.salary = salary;
  }

  public String getName() {
    return name;
  }
  public double getSalary() {
    return salary;
  }
  public void print() {
    System.out.println("-------------");
    System.out.println("Name ="+getName());
    System.out.println("Salary ="+getSalary());
    System.out.println("-------------");
  }

//gives you transparency as the client can treat composite and leaves uniformly but decreases safety because client may do something meaningless
  
  public void add(Employee emp1) {
	//this is leaf node so this method is not applicable to this class.
  }
  public void remove(Employee emp1) {
		//this is leaf node so this method is not applicable to this class.
	}
  public Employee getChild(int i) {
	//this is leaf node so this method is not applicable to this class.
	return null;
  }

}