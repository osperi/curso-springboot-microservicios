package com.cursosdedesarrollo.springbootrestjpamysql;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class PersonServiceRepositoryTest {

    private static final String LAST_NAME = "Bar";

    private PersonServiceRepository personService;

    private PersonRepository personRepositoryMock;

    @Before
    public void setUp() {
        personService = new PersonServiceRepository();

        personRepositoryMock = mock(PersonRepository.class);
        personService.setPersonRepository(personRepositoryMock);
    }

    @Test
    public void searchWhenSearchTypeIsMethodName() {
        PersonSearchDTO searchCriteria = createSearchDTO(LAST_NAME, PersonSearchType.METHOD_NAME);
        List<Person> expected = new ArrayList<Person>();
        when(personRepositoryMock.findByLastName(searchCriteria.getSearchTerm())).thenReturn(expected);

        List<Person> actual = personService.search(searchCriteria);

        verify(personRepositoryMock, times(1)).findByLastName(searchCriteria.getSearchTerm());
        verifyNoMoreInteractions(personRepositoryMock);

        assertEquals(expected, actual);
    }

    @Test
    public void searchWhenSearchTypeIsNamedQuery() {
        PersonSearchDTO searchCriteria = createSearchDTO(LAST_NAME, PersonSearchType.NAMED_QUERY);
        List<Person> expected = new ArrayList<Person>();
        when(personRepositoryMock.findByName(searchCriteria.getSearchTerm())).thenReturn(expected);

        List<Person> actual = personService.search(searchCriteria);

        verify(personRepositoryMock, times(1)).findByName(searchCriteria.getSearchTerm());
        verifyNoMoreInteractions(personRepositoryMock);

        assertEquals(expected, actual);
    }

    @Test
    public void searchWhenSearchTypeIsQueryAnnotation() {
        PersonSearchDTO searchCriteria = createSearchDTO(LAST_NAME, PersonSearchType.QUERY_ANNOTATION);
        List<Person> expected = new ArrayList<Person>();
        when(personRepositoryMock.find(searchCriteria.getSearchTerm())).thenReturn(expected);

        List<Person> actual = personService.search(searchCriteria);

        verify(personRepositoryMock, times(1)).find(searchCriteria.getSearchTerm());
        verifyNoMoreInteractions(personRepositoryMock);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void searchWhenSearchTypeIsNull() {
        PersonSearchDTO searchCriteria = createSearchDTO(LAST_NAME, null);

        personService.search(searchCriteria);

        verifyZeroInteractions(personRepositoryMock);
    }

    private PersonSearchDTO createSearchDTO(String searchTerm, PersonSearchType personSearchType) {
        PersonSearchDTO searchCriteria = new PersonSearchDTO();
        searchCriteria.setSearchTerm(searchTerm);
        searchCriteria.setPersonSearchType(personSearchType);
        return searchCriteria;
    }
}