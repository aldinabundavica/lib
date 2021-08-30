package com.example.lib;

import com.example.lib.model.*;
import com.example.lib.repository.BookRepository;
import com.example.lib.repository.RoleRepository;
import com.example.lib.repository.StudentRepository;
import com.example.lib.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class CustomApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private WriterRepository writerRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student("Aldina", "Bundavica", new Date()));
        students.add(new Student("Dina", "Bundavica", new Date()));
        students.add(new Student("Amel", "Aličić", new Date()));
        students.add(new Student("Ana", "Crkvenjaš", new Date()));

        studentRepository.saveAll(students);

        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new Role(RoleName.ROLE_ADMIN));
        roles.add(new Role(RoleName.ROLE_PM));
        roles.add(new Role(RoleName.ROLE_USER));

        roleRepository.saveAll(roles);

  /*      ArrayList<Writer> writers = new ArrayList<Writer>();
        try {
            writers.add(new Writer("Lav", "N. Tolstoj", stringToDate("02/02/1834")));
            writers.add(new Writer("Fjodor", "M. Dostojevski", stringToDate("12/06/1888")));
            writers.add(new Writer("Ivana", "Brlić Mažuranić", stringToDate("18/04/1874")));
            writers.add(new Writer("Musa Ćazim", "Ćatić", stringToDate("12/03/1878")));
        }
        catch(Exception e) {
            System.out.println("Something went wrong.");
        }

        writerRepository.saveAll(writers);

        ArrayList<Book> books = new ArrayList<Book>();

        books.add(new Book("Kozaci", writers.get(0), new ArrayList<>(), false));
        books.add(new Book("Ana Karenjina", writers.get(0), new ArrayList<>(), false));
        books.add(new Book("Zločin i kazna", writers.get(1), new ArrayList<>(), false));
        books.add(new Book("Šuma Striborova", writers.get(2), new ArrayList<>(), false));

        bookRepository.saveAll(books); */

    }

    public static Date stringToDate(String sDate) throws Exception {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
        return date;
    }
}
