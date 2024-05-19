package com.fullstack.springbootrestapi.controller;

import com.fullstack.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

//    http://localhost:8080/student
/*    NOTE:
        All the CRUD operations are working as expected but now i want to use responseEntity,
        so, I need to pass ResponseEntity Generic class and type as Student.
        In return statment i am passing new ResposneEntity with constructor where student body with 200 status code
*/

    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
//        create an Object
        Student student = new Student(1, "Mowglee", "Patel");
//        return student;

        /*  NOTE:
         below return statements are correct to use in different requirement, However,
         I can create custom header with student body with 200 status code
         */

//        return  new ResponseEntity<>(student,HttpStatus.OK);
//        return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-Header", "Mr. Jandu").body(student);
    }

//    list of Student List
//     http://localhost:8080/students
    @GetMapping
//    public List<Student> getStudents(){
    public ResponseEntity <List<Student>> getStudents(){
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
//        return students;
        return ResponseEntity.ok(students);
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
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity <Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        Student student =  new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

//    Spring Boot REST API with Request Param
//    http://localhost:8080/students/query?id=1&firstName=Mangoo&lastName=Mochi

    @GetMapping("query")
    public ResponseEntity <Student> studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
//        return  new Student(id, "Mangoo", "Mochi");
        Student student =  new Student(id,firstName, lastName);
        return ResponseEntity.ok(student);
    }

//    Spring boot REST API that handles HTTP Post Request - creating new resources
//    @PostMapping and @RequestBody.
//    @RequestBody  => this annotation is responsible for retrieving the http request body and automatically converting it in to Java Object
//    @ResponseStatus = > its mandatory whenever we try to create ant post request using REST API here we have to pass 201 status code using this annotation with ".CREATE" .
//    CREATE status sends 201 status code for HTTP request
    @PostMapping("create")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <Student> createStudents(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }


    /* NOTE:
    in put method, in order to create REST API, i need to add @PutMapping annotation to make the method as RESTAPI.
    However, in Update method i need to add URL with url template varialble{id}.
    Also, I need to extract the JSON Object to Java Object i need to provide @RequestBody.
    Furthermore, i need to bind URL tamplate variable into "int studentID"  which both are different., for that
    I need to pass url tamplete varibale name to @Pathvariable("id")
    */

//    Spring Boot REST API that handles HTTP PUT request  - updating existed resources
    @PutMapping("{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

//    Spring Boot REST API that handles HTTP DELETE request  - deleting existing resources
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok( "Student deleted successfully!!!");
    }
}
