package com.holyviastores.model;

import com.holyviastores.enums.Gender;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public abstract class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private Long phoneNo;
    private Gender gender;
    private String email;

//    public Person(Integer id, String firstName, String lastName, Long phoneNo, Gender gender, String email) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phoneNo = phoneNo;
//        this.gender = gender;
//        this.email = email;
//    }
//
//    public Person() {
//
//    }

//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public Long getPhoneNo() {
//        return phoneNo;
//    }
//
//    public void setPhoneNo(Long phoneNo) {
//        this.phoneNo = phoneNo;
//    }
//
//   public Gender getGender(){
//        return gender;
//   }
//
//    public void setGender(Gender gender){
//        this.gender = gender;
//    }
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", phoneNo=" + phoneNo +
//                ", gender=" + gender +
//                ", email="+ email +
//                '}';
//    }


}
