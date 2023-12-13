package com.example.universitymanagementsystem.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long studentId;
    private String firstName;
    private String lastName;
    private java.sql.Date dateOfBirth;
    private String major;
    private String email;
}


