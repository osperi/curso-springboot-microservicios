package com.cursosdedesarrollo.springbootrestjpamysql;

import java.util.List;

/**
 * Declares methods used to obtain and modify person information.
 */
public interface PersonService {

    /**
     * Searches persons by using the search criteria given as a parameter.
     * @param searchCriteria
     * @return  A list of persons matching with the search criteria. If no persons is found, this method
     *          returns an empty list.
     * @throws IllegalArgumentException if search type is not given.
     */
    public List<Person> search(PersonSearchDTO searchCriteria);
}
