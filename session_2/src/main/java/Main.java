import java.sql.*;

public class Main {

    /**
     * Creates the employees table if it doesn't exist
     */



    private static void createEmployeesTable() {

        String createEmployeesTableQuery = """
                CREATE TABLE IF NOT EXISTS employees (
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    name VARCHAR(100) NOT NULL,
                    department VARCHAR(50) NOT NULL,
                    salary DECIMAL(10, 2) NOT NULL,
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                )
                """;

        try (Connection connection = JDBC_Config.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(createEmployeesTableQuery);
            System.out.println("Table 'employees' created or already exists\n");

        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void insertIntoEmployees(String name, String department, double salary) {

        String insertIntoEmployeesQuery = """
                INSERT INTO employees (name, department, salary) VALUES (?, ?, ?) 
                """;

        try (Connection connection = JDBC_Config.getConnection();
             PreparedStatement prepStatement = connection.prepareStatement(insertIntoEmployeesQuery)){
             //Statement statement = connection.createStatement()){


            prepStatement.setString(1, name);
            prepStatement.setString(2, department);
            prepStatement.setDouble(3, salary);
            prepStatement.execute();
            System.out.println("Insert into Employees table successful!");

        } catch (SQLException e){
            System.out.println("Insert into Employees table could not be performed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void getAllEmployeesRecords(){

        String getAllRecordsQuery = """
                SELECT * FROM Employees
                """;

        try(Connection connection = JDBC_Config.getConnection();
            Statement statement = connection.createStatement()){
            ResultSet records = statement.executeQuery(getAllRecordsQuery);
            while (records.next()){
                System.out.println("\n Name: " + records.getString("name") + " ; Department: "
                                               + records.getString("department") + " ; Salary: "
                                               + records.getDouble("salary") );
            }
        } catch (SQLException e){
            System.out.println("Could not fetch all records from Employees table - " + e.getMessage());
            e.printStackTrace();
        }

    }

    private static void getEmployeeByID(int id){

        String getEmployeeQuery = """
                SELECT id, name, department, salary FROM Employees WHERE ID = ?
                """;

        try (Connection connection = JDBC_Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(getEmployeeQuery)){
             statement.setInt(1, id);
             ResultSet rs = statement.executeQuery();
             if(rs.next()){
                 System.out.println("ID: " + rs.getInt("id") + " ; " + "Name: " + rs.getString("name")
                         + " ; " + "Department: " + rs.getString("department") + " ; "
                         + "Salary: " + rs.getDouble("salary"));
             }

        } catch (SQLException e){
            System.out.println("Unable to retrieve Employee with id: " + id + " - " + e.getMessage());
            e.printStackTrace();
        }

    }

    static void main() {

   //  createEmployeesTable();
   //  insertIntoEmployees("Pingu", "Ice", 1200);
   //  insertIntoEmployees("Ben", "AI", 1300);
       getAllEmployeesRecords();
       getEmployeeByID(3);

    }


}

