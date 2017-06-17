package org.launchcode.cheesemvc.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Matt on 6/5/2017.
 */
public class User {
    @NotNull
    @Size(min=5, max=15)
    private String username;

    private String email;

    @NotNull
    @Size(min=6)
    private String password;

    public String getUsername() {return username;}
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
