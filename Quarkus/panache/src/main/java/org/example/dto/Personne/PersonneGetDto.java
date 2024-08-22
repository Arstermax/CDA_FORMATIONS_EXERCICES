package org.example.dto.Personne;

public class PersonneGetDto {
    private long idPersonne;
    private String firstname;
    private String lastname;
    private int age;

    public PersonneGetDto(long idPersonne, String firstname, String lastname, int age) {
        this.idPersonne = idPersonne;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public long getIdPersonne() {
        return idPersonne;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }
}
