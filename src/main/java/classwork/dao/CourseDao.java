package classwork.dao;

import classwork.entity.Course;

import java.util.List;

public interface CourseDao {

    List<Course> getCourses();

    Course getCourseById(int id);

    void saveCourse(Course course);

    void update(Course course);

    void delete(int id);
}