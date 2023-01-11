package com.rest.example.rest;

public class Student {
    private String Name;
    private String Id;
    private String Specialization;
    private String description;
    private String country;

    public Student() {
    }

    public Student(String Name, String Id, String Specialization) {
        this.Name = Name;
        this.Id = Id;
        this.Specialization = Specialization;
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

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return String return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

}