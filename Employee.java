import java.time.LocalDate;

public class Employee {
    private String name;
    private double salary;
    private int workHours;
    private int hireYear;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public double tax() {
        if (salary <= 1000) {
            return 0;
        } else {
            return salary * 0.03;
        }
    }

    public double bonus() {
        int extraHours = Math.max(workHours - 40, 0);
        return extraHours * 30;
    }

    public double raiseSalary() {
        int yearsWorked = LocalDate.now().getYear() - hireYear;
        if (yearsWorked < 10) {
            return salary * 0.05;
        } else if (yearsWorked < 20) {
            return salary * 0.10;
        } else {
            return salary * 0.15;
        }
    }

    @Override
    public String toString() {
        double totalSalary = salary - tax() + bonus() + raiseSalary();
        
        return "Adı: " + name +
               "\nMaaşı: " + salary +
               "\nÇalışma Saati: " + workHours +
               "\nBaşlangıç Yılı: " + hireYear +
               "\nVergi: " + tax() +
               "\nBonus: " + bonus() +
               "\nMaaş Artışı: " + raiseSalary() +
               "\nVergi ve Bonuslar ile birlikte maaş: " + totalSalary +
               "\nToplam Maaş: " + (totalSalary + salary);
    }

    public static void main(String[] args) {
        Employee employee = new Employee("kemal", 2000.0, 45, 1985);
        System.out.println(employee.toString());
    }
}
