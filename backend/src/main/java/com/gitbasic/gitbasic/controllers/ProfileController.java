package com.gitbasic.gitbasic.controllers;

import com.gitbasic.gitbasic.controllers.dto.ProfileAddInfoDto;
import com.gitbasic.gitbasic.repositories.AccountRepository;
import com.gitbasic.gitbasic.repositories.Profile;
import com.gitbasic.gitbasic.repositories.ProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/profile")
@RestController
public class ProfileController {
    private final ProfileRepository profileRepository;
    private final AccountRepository accountRepository;
    public ProfileController(ProfileRepository profileRepository, AccountRepository accountRepository) {
        this.profileRepository = profileRepository;
        this.accountRepository = accountRepository;
    }


    @PostMapping("/create")
    public HttpStatus createProfile(@RequestBody ProfileAddInfoDto profile) {
        profileRepository.save(new Profile(/* account id */null, profile.getName(), profile.getBio(), profile.getImage(), profile.getBirthday(), profile.getGender(), profile.getPhone(), profile.getOrganization(), profile.getLocation(), profile.getWebsite(), profile.getSocial1(), profile.getSocial2(), profile.getSocial3(), profile.getSocial4()));
        return HttpStatus.CREATED;
    }
}
