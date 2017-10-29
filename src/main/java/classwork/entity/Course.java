package classwork.entity;

import java.util.Objects;

public class Course {

    private int id;
    private String title;
    private String teacher;
    private int hours;

    public Course() {
    }

    public Course(int id, String title, String teacher, int hours) {
        this.id = id;
        this.title = title;
        this.teacher = teacher;
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (id != course.id) return false;
        if (hours != course.hours) return false;
        if (title != null ? !title.equals(course.title) : course.title != null) return false;
        return teacher != null ? teacher.equals(course.teacher) : course.teacher == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + hours;
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", Teacher='" + teacher + '\'' +
                ", hours=" + hours +
                '}';
    }
}