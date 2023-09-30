import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class EmployeeRecord {
    private String name;
    private int position;
    private int consecutiveDays;
    private int hoursBetweenShifts;
    private int totalHoursWorked;

    public EmployeeRecord(String name, int position, int consecutiveDays, int hoursBetweenShifts, int totalHoursWorked) {
        this.name = name;
        this.position = position;
        this.consecutiveDays = consecutiveDays;
        this.hoursBetweenShifts = hoursBetweenShifts;
        this.totalHoursWorked = totalHoursWorked;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getConsecutiveDays() {
        return consecutiveDays;
    }

    public int getHoursBetweenShifts() {
        return hoursBetweenShifts;
    }

    public int getTotalHoursWorked() {
        return totalHoursWorked;
    }
}

public class EmployeeAnalysis {
    public static void main(String[] args) {
        String fileName = "employee_records.txt"; // Replace with your input file path

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            List<EmployeeRecord> employees = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                // Assuming each line in the file contains data in the format: name position consecutiveDays hoursBetweenShifts totalHoursWorked
                String[] parts = line.split(" ");
                if (parts.length == 5) {
                    String name = parts[0];
                    int position = Integer.parseInt(parts[1]);
                    int consecutiveDays = Integer.parseInt(parts[2]);
                    int hoursBetweenShifts = Integer.parseInt(parts[3]);
                    int totalHoursWorked = Integer.parseInt(parts[4]);

                    EmployeeRecord employee = new EmployeeRecord(name, position, consecutiveDays, hoursBetweenShifts, totalHoursWorked);
                    employees.add(employee);
                }
            }

            // Iterate over employee records and apply conditions
            for (EmployeeRecord employee : employees) {
                if (employee.getConsecutiveDays() >= 7) {
                    System.out.println("Employee: " + employee.getName() + ", Position: " + employee.getPosition() + " worked for 7 consecutive days.");
                }
                if (employee.getHoursBetweenShifts() > 1 && employee.getHoursBetweenShifts() < 10) {
                    System.out.println("Employee: " + employee.getName() + ", Position: " + employee.getPosition() + " has less than 10 hours between shifts but greater than 1 hour.");
                }
                if (employee.getTotalHoursWorked() > 14) {
                    System.out.println("Employee: " + employee.getName() + ", Position: " + employee.getPosition() + " worked for more than 14 hours in a single shift.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
