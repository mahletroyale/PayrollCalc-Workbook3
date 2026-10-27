package payrollcalculator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class PayrollApp {
   public static void main(String [] args) {
       try {
           FileReader file = new FileReader("employees.csv");
           BufferedReader reader = new BufferedReader(file);

           reader.readLine();
           String line;

           while ((line = reader.readLine()) != null) {

               String[] tokens = line.split("\\|");

               int employeeId = Integer.parseInt(tokens[0]);
               String name = tokens[1];
               double hoursWorked = Double.parseDouble(tokens[2]);
               double payRate = Double.parseDouble(tokens[3]);

               Employee employee = new Employee(
                       employeeId, name, hoursWorked, payRate);

               System.out.printf(
                       "ID: %d | Name: %s | Gross Pay: $%.2f%n",
                       employee.getEmployeeId(),
                       employee.getName(),
                       employee.getGrossPay());
           }

           reader.close();

       } catch (IOException e) {
           System.out.println("Error: " + e.getMessage());
       }
   }
}

