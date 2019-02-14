package com.cursosdedesarrollo.springbootrestjpamysql.manytomanybi.domain;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "category", catalog = "test")
public class Category implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "CATEGORY_ID", unique = true, nullable = false)
    private Integer categoryId;
    @Column(name = "NAME", nullable = false, length = 10)
    private String name;
    @Column(name = "[DESC]", nullable = false)
    private String desc;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private Set<Stock> stocks = new HashSet<Stock>(0);



}
