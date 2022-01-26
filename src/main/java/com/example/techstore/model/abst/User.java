package com.example.techstore.model.abst;

import com.example.techstore.util.enumerator.Role;
import com.example.techstore.view.abst.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

public class User implements Cloneable, Serializable {
    private static Logger logger = LogManager.getLogger();

    protected String name;
    protected String username;
    protected String password;
    protected Role role;

    public User() {
    }

    public User(String name, String username, String password, Role role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public Object clone() {
        Object object = null;

        try {
            object =  super.clone();
        } catch (CloneNotSupportedException e) {
            logger.fatal("Couldn't clone object.");
            e.printStackTrace();
        }

        return object;
    }
}
