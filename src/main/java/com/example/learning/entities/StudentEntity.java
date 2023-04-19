
package com.example.learning.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author ibent95
 */
@Entity
@Table(name="student")
public class StudentEntity {
    
    @Id
    @SequenceGenerator(name="student_sequence", sequenceName="student_sequence", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="student_sequence")
    @JsonIgnore
    private Long id;

    @SequenceGenerator(name = "uuid_generator", sequenceName="uuid_generator")
    @GeneratedValue(strategy=GenerationType.UUID, generator="uuid_generator")
    private String uuid;

    private String name;
    private LocalDate birthDate;
    private Integer age;
    private String email;

    @Column(columnDefinition="VARCHAR(10) DEFAULT 'system'")
    @JsonIgnore
    private String inputUser;

    @CreationTimestamp
    @JsonIgnore
    private LocalDateTime inputDate;

    @Column(columnDefinition="VARCHAR(10) DEFAULT 'system'")
    @JsonIgnore
    private String updateUser;

    @UpdateTimestamp 
    @JsonIgnore
    private LocalDateTime updateDate;

    public StudentEntity() {}

    public StudentEntity(
            Long id, String uuid, String name, LocalDate birthDate,
            Integer age, String email, String inputUser, LocalDateTime inputDate,
            String updateUser, LocalDateTime updateDate
    ) {
        this.id = id;
        this.uuid = (uuid != null) ? uuid : UUID.randomUUID().toString();
        this.name = name;
        this.birthDate = birthDate;
        this.age = age;
        this.email = email;
        this.inputUser = inputUser;
        this.inputDate = inputDate;
        this.updateUser = updateUser;
        this.updateDate = updateDate;
    }
    
    public StudentEntity(
            String uuid, String name, LocalDate birthDate, Integer age,
            String email, String inputUser, LocalDateTime inputDate,
            String updateUser, LocalDateTime updateDate
    ) {
        this.uuid = (uuid != null) ? uuid : UUID.randomUUID().toString();
        this.name = name;
        this.birthDate = birthDate;
        this.age = age;
        this.email = email;
        this.inputUser = inputUser;
        this.inputDate = inputDate;
        this.updateUser = updateUser;
        this.updateDate = updateDate;
    }

    public StudentEntity(
            String uuid, String name, LocalDate birthDate, Integer age,
            String email, String inputUser, String updateUser
    ) {
        this.uuid = (uuid != null) ? uuid : UUID.randomUUID().toString();
        this.name = name;
        this.birthDate = birthDate;
        this.age = age;
        this.email = email;
        this.inputUser = inputUser;
        this.updateUser = updateUser;
    }

    public StudentEntity(
            String name, LocalDate birthDate, Integer age,
            String email, String inputUser, String updateUser
    ) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.birthDate = birthDate;
        this.age = age;
        this.email = email;
        this.inputUser = inputUser;
        this.updateUser = updateUser;
    }

    public StudentEntity(
            String uuid, String name, LocalDate birthDate,
            Integer age, String email, String updateUser
    ) {
        this.uuid = (uuid != null) ? uuid : UUID.randomUUID().toString();
        this.name = name;
        this.birthDate = birthDate;
        this.age = age;
        this.email = email;
        this.updateUser = updateUser;
    }

    // @PrePersist
    // @PreUpdate
    // public void setUuid() {
    //     this.uuid = UUID.randomUUID().toString();
    // }

    @PrePersist
    @PreUpdate
    public void updateAge() {
        Calendar birth = new GregorianCalendar();
        birth.setTime(Date.from(this.birthDate.atStartOfDay(ZoneOffset.UTC).toInstant()));

        Calendar now = new GregorianCalendar();
        now.setTime(new Date());

        int adjust = 0;
        if ( now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR) < 0) {
            adjust = -1;
        }

        this.age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + adjust;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return (uuid != null) ? uuid : UUID.randomUUID().toString();
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInputUser() {
        return inputUser;
    }

    public void setInputUser(String inputUser) {
        this.inputUser = inputUser;
    }

    public LocalDateTime getInputDate() {
        return inputDate;
    }

    public void setInputDate(LocalDateTime inputDate) {
        this.inputDate = inputDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

}
