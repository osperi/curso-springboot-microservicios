package com.cursosdedesarrollo.springbootmongodb.users;

public class UserNotFoundException extends RuntimeException  {
    public UserNotFoundException(String id) {
        super("Could not find customer " + id);
    }
}
