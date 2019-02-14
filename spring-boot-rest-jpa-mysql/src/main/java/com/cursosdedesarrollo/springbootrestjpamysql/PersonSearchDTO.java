package com.cursosdedesarrollo.springbootrestjpamysql;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * A DTO class which is used as a form object in the search form.
 */
public class PersonSearchDTO {

    private String searchTerm;

    private PersonSearchType personSearchType;

    public PersonSearchDTO() {

    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public PersonSearchType getPersonSearchType() {
        return personSearchType;
    }

    public void setPersonSearchType(PersonSearchType personSearchType) {
        this.personSearchType = personSearchType;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
