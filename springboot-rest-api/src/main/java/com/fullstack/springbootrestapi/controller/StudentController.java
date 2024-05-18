package com.fullstack.springbootrestapi.controller;

import com.fullstack.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

//    http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent() {
//        create an Object
        Student student = new Student(1, "Pratik", "Patel");
        return student;
    }

//    list of Student List
//     http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Pratik", "Patel"));
        students.add(new Student(2, "Hanuman", "RamBhakt"));
        students.add(new Student(3, "Ram", "Sita"));
        students.add(new Student(4, "Mangoo", "Mochi"));
        students.add(new Student(5, "Lallu", "Lal"));
        students.add(new Student(6, "Rambo", "Rajwadi"));
        students.add(new Student(7, "Kaka", "Kareli"));
        students.add(new Student(8, "Chucha", "Singh"));
        students.add(new Student(9, "Chaman", "Chandu"));
        students.add(new Student(10, "Magan", "Bhuwo"));
        return students;
    }

//    Spring boot REST API with path variable
//    now if I want to make this API as REST API i need to use Annotation
//    {} is called URI Template variable
//    in below method parameter, i need to change simple (int id) to annotate with
//    @PathVariable

    //     http://localhost:8080/students/5
//    @GetMapping("students/{id}")
//    public Student studentPathVariable(@PathVariable("id") int studentId){
//        return  new Student(studentId, "Lallu", "Lal");
//    }

    //     http://localhost:8080/students/5/firstName/lastName
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        return  new Student(studentId, firstName, lastName);
    }

//    Spring Boot REST API with Request Param
//    http://localhost:8080/students/query?id=1&firstName=Mangoo&lastName=Mochi

    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
//        return  new Student(id, "Mangoo", "Mochi");
        return  new Student(id,firstName, lastName);
    }

//    Spring boot REST API that handles HTTP Post Request
//    @PostMapping and @RequestBody
//    @RequestBody  => this annotation is responsible for retrieving the http request body and automatically converting it in to Java Object
//    @ResponseStatus = > its mandatory whenever we try to create ant post reqyest using REST API here we have to pass 201 status code using this annotaion with .CREATE
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudents(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

}
