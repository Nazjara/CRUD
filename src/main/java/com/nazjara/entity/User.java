package com.nazjara.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Users")
public class User implements Serializable {
	
	private static final long serialVersionUID = -7988799579036225137L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
    @Column
    private String name;
    
    @Column
    private int age;
    
    @Column
    private boolean isAdmin;

    @Column
    private Date createdDate;

    public User()
    {
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean getisAdmin() {
        return isAdmin;
    }
    public void setisAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    public Date getCreatedDate(){return createdDate;}
    public void setCreatedDate(Date createdDate){this.createdDate = createdDate;}

    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isAdmin=" + isAdmin +
                ", createdDate=" + createdDate +
                '}';
    }
}