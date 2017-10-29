package classwork.dao;

import classwork.connection.ConnectionDB;
import classwork.entity.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultCourseDao implements CourseDao{

    private final String GET_COURSES = "SELECT id, title, teacher, hours FROM course";

    private final String GET_COURSES_ID = "SELECT id, title, teacher, hours FROM course WHERE id = ?";

    private final String INSERT_COURSES = "INSERT INTO course (id, title, teacher, hours) VALUES (?,?,?,?)";

    private final String UPDATE_COURSES = " UPDATE course SET title=?, teacher=?, hours=? WHERE id=?";

    private final String DELETE_COURSES = "DELETE FROM course WHERE id=?";

    private ConnectionDB connectionDB = ConnectionDB.getInstance();

    public DefaultCourseDao() {
    }

    @Override
    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionDB.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_COURSES);
            while (resultSet.next()) {
                Course course = new Course(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, statement, resultSet);
        }
        return courses;
    }

    @Override
    public Course getCourseById(int id) {
        Course course = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(GET_COURSES_ID);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                course = new Course(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement, resultSet);
        }
        return course;
    }

    @Override
    public void saveCourse(Course course) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_COURSES);
            preparedStatement.setInt(1, course.getId());
            preparedStatement.setString(2, course.getTitle());
            preparedStatement.setString(3, course.getTeacher());
            preparedStatement.setInt(4, course.getHours());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public void update(Course course) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_COURSES);
            preparedStatement.setString(1, course.getTitle());
            preparedStatement.setString(2, course.getTeacher());
            preparedStatement.setInt(3, course.getHours());
            preparedStatement.setInt(4, course.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement, resultSet);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionDB.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_COURSES);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement, resultSet);
        }
    }

    private void close(Connection connection,
                       Statement statement,
                       ResultSet resultSet){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * The inner class for implementation singleton.
     */
    private static class Holder {
        private final static DefaultCourseDao INSTANCE = new DefaultCourseDao();
    }

    /**
     * The method gives DefaultCourseDao singleton instance.
     */
    public static DefaultCourseDao getInstance() {
        return Holder.INSTANCE;
    }

}