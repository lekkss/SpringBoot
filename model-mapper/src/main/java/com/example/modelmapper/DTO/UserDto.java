package com.example.modelmapper.DTO;

public class UserDto {
    private String name;
    private String email;

    // NoArgsConstructor
    public UserDto() {
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
