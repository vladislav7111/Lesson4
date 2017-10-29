package classwork;

import classwork.dao.CourseDao;
import classwork.dao.DefaultCourseDao;
import classwork.entity.Course;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

public class CourseDaoTest {
    private static final int TEST_ID = 999;

    private static final String UPDATE_TEST_TEACHER = "UpdateTestSurname";
    private final String TEST_TITLE = "TestTitle";
    private final String TEST_TEACHER = "TestSurname";
    private final int TEST_HOURS = 10001;

    private static CourseDao courseDao;
    private static Random random;

    private Course course = new Course();

    @BeforeClass
    public static void init() {
        courseDao = DefaultCourseDao.getInstance();
        random = new Random();
    }

    @Before
    public void createTestCourse() {
        course.setId(TEST_ID);
        course.setTitle(TEST_TITLE);
        course.setHours(TEST_HOURS);
        course.setTeacher(TEST_TEACHER);
        courseDao.saveCourse(course);
    }

    @After
    public void removeTestCourse() {
        courseDao.delete(TEST_ID);
    }

    @Test
    public void saveCourse() throws Exception {
        course.setId(TEST_ID + 1);
        course.setTitle(TEST_TITLE);
        course.setHours(TEST_HOURS);
        course.setTeacher(TEST_TEACHER);
        courseDao.saveCourse(course);

        Course course = courseDao.getCourseById(TEST_ID + 1);
        assertEquals(TEST_ID + 1, course.getId());
        assertEquals(TEST_TITLE, course.getTitle());
        assertEquals(TEST_TEACHER, course.getTeacher());
        assertEquals(TEST_HOURS, course.getHours());

        courseDao.delete(TEST_ID + 1);
    }

    @Test
    public void getCourses() throws Exception {
        List<Course> courses = courseDao.getCourses();
        assertNotNull(courses);
        assertEquals(courses.size(), 7);
    }

    @Test
    public void getCourse() throws Exception {
        Course course = courseDao.getCourseById(TEST_ID);
        assertNotNull(course);
    }

    @Test
    public void update() throws Exception {
        Course course = courseDao.getCourseById(TEST_ID);

        course.setTeacher(UPDATE_TEST_TEACHER);
        course.setHours(TEST_HOURS);
        courseDao.update(course);
        Course courseUpdate = courseDao.getCourseById(TEST_ID);
        assertEquals(UPDATE_TEST_TEACHER, courseUpdate.getTeacher());
    }
}