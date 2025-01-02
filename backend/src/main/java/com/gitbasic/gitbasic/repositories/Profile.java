package com.gitbasic.gitbasic.repositories;

import jakarta.persistence.Entity;
import lombok.Getter;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.MapsId;

@Getter
@Entity
public class Profile {
    @Id
    @OneToOne
    @MapsId
    private Account id;

    String name = "";
    String bio = "";
    String image = "";
    String birthday = "";
    String gender = "";
    String phone = "";
    String organization = "";
    String location = "";
    String website = "";
    String social1 = "";
    String social2 = "";
    String social3 = "";
    String social4 = "";

    protected Profile() {}
    
    public Profile(Account id, String name, String bio, String image, String birthday, String gender, String phone, String organization, String location, String website, String social1, String social2, String social3, String social4) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.image = image;
        this.birthday = birthday;
        this.gender = gender;
        this.phone = phone;
        this.organization = organization;
        this.location = location;
        this.website = website;
        this.social1 = social1;
        this.social2 = social2;
        this.social3 = social3;
        this.social4 = social4;
    }
    
}
