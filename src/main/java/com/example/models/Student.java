package com.example.models;  // Attention: c'est "models" avec 's'

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Student {
    
    @NotBlank(message = "Le nom est obligatoire")
    @Size(min = 2, max = 50, message = "Le nom doit contenir entre 2 et 50 caracteres")
    private String name;
    
    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "Veuillez fournir un email valide")
    private String email;
    
    @NotBlank(message = "La filiere est obligatoire")
    private String major;
    
    public Student() {}
    
    public Student(String name, String email, String major) {
        this.name = name;
        this.email = email;
        this.major = major;
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
}
