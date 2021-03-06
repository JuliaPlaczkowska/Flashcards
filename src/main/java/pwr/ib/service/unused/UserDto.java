//package pwr.ib.service;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = UserDto.TABLE_NAME)
//public class UserDto {
//
//    public static final String TABLE_NAME="user";
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String name;
//    private String passwordHash;
//    private String role;
//
//    public UserDto(String name, String passwordHash, String role) {
//        this.name = name;
//        this.passwordHash = passwordHash;
//        this.role = role;
//    }
//
//    public UserDto() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPasswordHash() {
//        return passwordHash;
//    }
//
//    public void setPasswordHash(String passwordHash) {
//        this.passwordHash = passwordHash;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//}
