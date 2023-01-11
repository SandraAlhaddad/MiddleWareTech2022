package com.rest.example.rest.JPA;

import javax.persistence.Entity;

@Entity
public class StudentJpa {

    private String Name;
    private String Id;
    private String Specialization;

    public StudentJpa() {
    }

    public StudentJpa(String Name, String Id, String Specialization) {
        this.Name = Name;
        this.Id = Id;
        this.Specialization = Specialization;
    }

    public StudentJpa(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getId() {
        return this.Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getSpecialization() {
        return this.Specialization;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

}
