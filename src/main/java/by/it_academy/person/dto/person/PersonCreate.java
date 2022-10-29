package by.it_academy.person.dto.person;

import by.it_academy.person.validation.*;

public class PersonCreate {

    @LastName
    private String lastName;
    @FirstName
    private String firstName;
    @Patronymic
    private String patronymic;
    @Email
    private String email;
    @Role
    private String role;

    public PersonCreate() {
    }

    public PersonCreate(String lastName, String firstName, String patronymic,
                        String email, String role) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.email = email;
        this.role = role;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
