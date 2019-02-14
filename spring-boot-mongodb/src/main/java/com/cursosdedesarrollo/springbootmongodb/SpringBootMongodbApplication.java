package com.cursosdedesarrollo.springbootmongodb;

import com.cursosdedesarrollo.springbootmongodb.books.Book;
import com.cursosdedesarrollo.springbootmongodb.books.BookRepository;
import com.cursosdedesarrollo.springbootmongodb.customer.Customer;
import com.cursosdedesarrollo.springbootmongodb.customer.CustomerRepository;
import com.cursosdedesarrollo.springbootmongodb.groups.Group;
import com.cursosdedesarrollo.springbootmongodb.persons.Address;
import com.cursosdedesarrollo.springbootmongodb.persons.Hobby;
import com.cursosdedesarrollo.springbootmongodb.persons.Person;
import com.cursosdedesarrollo.springbootmongodb.persons.PersonRepository;
import com.cursosdedesarrollo.springbootmongodb.users.User;
import com.cursosdedesarrollo.springbootmongodb.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;
import java.util.*;

@SpringBootApplication
@EnableSwagger2
public class SpringBootMongodbApplication {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            repository.deleteAll();
            bookRepository.deleteAll();

            // save a couple of customers
            repository.save(new Customer("Alice", "Smith"));
            repository.save(new Customer("Bob", "Smith"));

            // fetch all customers
            System.out.println("Customers found with findAll():");
            System.out.println("-------------------------------");
            for (Customer customer : repository.findAll()) {
                System.out.println(customer);
            }
            System.out.println();
            // fetch an individual customer
            System.out.println("Customer found with findByFirstName('Alice'):");
            System.out.println("--------------------------------");
            System.out.println(repository.findByFirstName("Alice"));

            System.out.println("Customers found with findByLastName('Smith'):");
            System.out.println("--------------------------------");
            for (Customer customer : repository.findByLastName("Smith")) {
                System.out.println(customer);
            }

            Book b= new Book();
            String autor1="Terry Prattchet";
            String autor2="Neil Gayman";
            List<String> autores=new ArrayList<>();
            autores.add(autor1);
            autores.add(autor2);
            b.setAuthorNames(autores);
            b.setTitle("Buenos Presagios");
            bookRepository.save(b);

            // fetch all customers
            System.out.println("Books found with findAll():");
            System.out.println("-------------------------------");
            for (Book book : bookRepository.findAll()) {
                System.out.println(book);
            }
            System.out.println();
            // fetch an individual book
            System.out.println("Book found with findByTitleContainingOrderByTitle('buenos'):");
            System.out.println("--------------------------------");
            System.out.println(bookRepository.findByTitleContainingOrderByTitle("Buenos"));

            System.out.println("Book found with findByTitle('Buenos'):");
            System.out.println("--------------------------------");
            for (Book book : bookRepository.findByTitleContaining("Buenos")) {
                System.out.println(book);
            }


            personRepository.deleteAll();

            final Address address = new Address("19 Imaginary Road", "Imaginary Place", "Imaginary City", "UK");

            final Hobby badminton = new Hobby("Badminton");
            final Hobby tv = new Hobby("TV");
            final List<Hobby> hobbies = Arrays.asList(badminton, tv);

            final Person john = new Person("John", "Doe", LocalDateTime.now(), address, "Winner", 100, hobbies);
            personRepository.save(john);

            System.out.println("Find by first name");
            personRepository.findByFirstName("John").forEach(System.out::println);

            System.out.println("Find by country (UK)");
            personRepository.findByCountry("UK").forEach(System.out::println);

            address.setCountry("US");
            personRepository.save(john);
            System.out.println("Find by country (US)");
            personRepository.findByCountry("US").forEach(System.out::println);

            userRepository.deleteAll();

            User u = new User();
            u.setName("name1");
            u.setToken("token1");
            u.setActivo(true);
            u.setPassword("1234");
            u.setEmail("email1");
            Set<Group> groups = new HashSet<>();
            Group g = new Group();
            g.setName("group_1");
            groups.add(g);
            g = new Group();
            g.setName("group_2");
            groups.add(g);
            u.setGroups(groups);
            userRepository.save(u);

            u = new User();
            u.setName("name2");
            userRepository.save(u);

            System.out.println("Users found with findAll():");
            System.out.println("-------------------------------");
            for (User user: userRepository.findAll()) {
                System.out.println(user);
            }
        };
    }

}
