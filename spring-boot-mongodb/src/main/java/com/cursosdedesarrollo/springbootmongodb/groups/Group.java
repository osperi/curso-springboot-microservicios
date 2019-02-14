package com.cursosdedesarrollo.springbootmongodb.groups;

import com.cursosdedesarrollo.springbootmongodb.users.User;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@Document(collection = "users")
public class Group implements Serializable {
    @Id
    private String id;
    private String name;
    //private List<User> users;
}
