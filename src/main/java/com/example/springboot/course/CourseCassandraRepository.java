package com.example.springboot.course;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.core.utils.UUIDs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.datastax.driver.core.querybuilder.QueryBuilder.column;

@Service
public class CourseCassandraRepository {

    @Autowired
    ICourseCassandra courseCassandra;
    //private static long idCounter = 0;

    public List<Course> findAll() {
        return courseCassandra.findAll();
    }
    public Course findById(String id) {
        Optional<Course> c = courseCassandra.findById(id);

        if (!c.isPresent()) {
            return null;
        }else {
            return c.get();
        }
    }
    public void delete(Course course) {
        courseCassandra.delete(course);
    }

    public Course insert(Course course) {

        Course c = courseCassandra.insert(new Course(UUIDs.timeBased().toString(), course.getUsername(), course.getDescription()));
        return c;
    }

    public Course update(Course course, String id) {
        Optional<Course> c = courseCassandra.findById(id);

        if (c.isPresent()) {
            Course _course = c.get();

            _course.setUsername(course.getUsername());
            _course.setDescription(course.getDescription());

            return courseCassandra.save(_course);
        }
        return null;
    }
}
