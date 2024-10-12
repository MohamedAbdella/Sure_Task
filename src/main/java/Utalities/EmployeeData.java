package Utalities;

import com.github.javafaker.Faker;

public class EmployeeData {
    private Employee employee;
    private PersonalDetails personalDetails;

    public EmployeeData() {
        Faker faker = new Faker();

        employee = new Employee();
        employee.setFirstName(faker.name().firstName());
        employee.setMiddleName(faker.name().firstName());
        employee.setLastName(faker.name().lastName());
        employee.setEmployeeId(faker.number().digits(4));

        personalDetails = new PersonalDetails();
        personalDetails.setFirstName(employee.getFirstName());
        personalDetails.setMiddleName(employee.getMiddleName());
        personalDetails.setLastName(employee.getLastName());
        personalDetails.setEmployeeId(employee.getEmployeeId());
        personalDetails.setOtherId(faker.number().digits(4));
        personalDetails.setDrivingLicenseNo(faker.number().digits(6));
        personalDetails.setDrivingLicenseExpiredDate("2025-08-31"); // static date for simplicity
        personalDetails.setGender("1");
        personalDetails.setMaritalStatus("Single");
        personalDetails.setBirthday("1998-11-30");
        personalDetails.setNationalityId(59);
    }

    public Employee getEmployee() {
        return employee;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }
}
