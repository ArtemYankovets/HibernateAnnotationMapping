package domain;

import bl.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Project;
import service.AddressService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

public class Domain {

    public static void main(String[] args) throws SQLException {
        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();

        Address address = new Address();
        address.setCountry("DC");
        address.setCity("Gotham city");
        address.setStreet("Arkham street 1");
        address.setPostCode("12345");

        Project project = new Project();
        project.setTitle("Gotham PD");

        Employee employee = new Employee();
        employee.setFirstName("James");
        employee.setLastName("Freeman");
        LocalDate birthday = LocalDate.of(1980, Month.JANUARY, 12);
        employee.setBirthday(Date.valueOf(birthday));
        employee.setAddress(address);

// --------------------------------------------------------------------
        addressService.add(address);

//        If we used both options we will have duplicates in table "PROJECT"

//        Option 1:
//        Set<Employee> employees = new HashSet<>();
//        employees.add(employee);
//        project.setEmployees(employees);
//
//        projectService.add(project);


//        Option 2:
        Set<Project> projects = new HashSet<>();
        projects.add(project);
        employee.setProjects(projects);

        employeeService.add(employee);
// --------------------------------------------------------------------

        HibernateUtil.shutdown();
    }
}