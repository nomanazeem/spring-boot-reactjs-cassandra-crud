package com.example.springboot.course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })

@RestController
public class CourseController {
    @Autowired
    private CourseCassandraRepository courseManagementService;

    @GetMapping("/instructors/{username}/courses")
    public List<Course> getAllCourses(@PathVariable String username) {
        return courseManagementService.findAll();
    }

    @GetMapping("/instructors/{username}/courses/{id}")
    public Course getCourse(@PathVariable String username, @PathVariable String id) {
        return courseManagementService.findById(id);
    }

    @DeleteMapping("/instructors/{username}/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String username, @PathVariable String id) {

        Course _course = courseManagementService.findById(id);
        courseManagementService.delete(_course);

        //return ResponseEntity.notFound().build();
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @PutMapping("/instructors/{username}/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable String id,
                                               @RequestBody Course course) {

        System.out.println("---------update");

        Course courseUpdated = courseManagementService.update(course, id);

        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

    @PostMapping("/instructors/{username}/courses")
    public ResponseEntity<Void> createCourse(@RequestBody Course course) {
        System.out.println("---------insert");

        Course createdCourse = courseManagementService.insert(course);

        // Location
        // Get current resource url
        /// {id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdCourse.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
/*
@RestController
public class CourseController {

    @Autowired
    //private CourseCassandraService courseManagementService;
    private CourseHardcodedRepository courseManagementService;

    @GetMapping("/instructors/{username}/courses")
    public List<Course> getAllCourses(@PathVariable String username) {
        return courseManagementService.findAll();
    }

    @GetMapping("/instructors/{username}/courses/{id}")
    public Course getCourse(@PathVariable String username, @PathVariable long id) {
        return courseManagementService.findById(id);
    }

    @DeleteMapping("/instructors/{username}/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String username, @PathVariable long id) {

        Course course = courseManagementService.deleteById(id);

        if (course != null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/instructors/{username}/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable String username, @PathVariable long id,
                                               @RequestBody Course course) {

        Course courseUpdated = courseManagementService.save(course);

        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

    @PostMapping("/instructors/{username}/courses")
    public ResponseEntity<Void> createCourse(@PathVariable String username, @RequestBody Course course) {

        Course createdCourse = courseManagementService.save(course);

        // Location
        // Get current resource url
        /// {id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdCourse.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

}
*/
