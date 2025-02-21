package dev.synchrony.user.user.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "users")  // Creates 'users' table
//@Data
@AllArgsConstructor
@NoArgsConstructor
//@Setter
//@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "First name is mandatory")
    private String userName;

//    @Column(nullable = false, unique = true)
//    @Email(message = "Email should be valid")
//    @NotBlank(message = "Email is mandatory")
//    private String email;

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    @NotBlank(message = "Phone number is mandatory")
    private String phoneNumber;

    @Column(nullable = false)
    @Size(min = 6, message = "Password must be at least 6 characters")
    @NotBlank(message = "Password is mandatory")
    private String password;  // Store hashed password

    public Long getId()
    {
        return id;
    }
    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName=userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password=password;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber=phoneNumber;

    }

}
