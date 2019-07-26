package com.example.bloodbank;

public class detailsmodel {
    String fullname,email,phoneno,city,bloodgroup;

    public detailsmodel() {
        this.fullname = fullname;
        this.email = email;
        this.phoneno = phoneno;
        this.city = city;
        this.bloodgroup = bloodgroup;
    }

    public String getName() {
        return fullname;
    }

    public void setName(String name) {
        this.fullname = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public String getCity() {
        return city;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }
}
