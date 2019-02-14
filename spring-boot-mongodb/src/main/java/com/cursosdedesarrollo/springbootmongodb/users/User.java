package com.cursosdedesarrollo.springbootmongodb.users;

import com.cursosdedesarrollo.springbootmongodb.groups.Group;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@ToString
@Document(collection = "users")
public class User implements Serializable {
    @Id
    private String id;
    private String name;
    private String password;
    private String email;
    private boolean activo;
    private String token;
    private Set<Group> groups;
}
