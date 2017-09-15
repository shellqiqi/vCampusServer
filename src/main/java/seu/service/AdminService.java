package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import seu.dao.*;
import seu.domain.*;
import seu.domain.Class;

import java.util.List;

public class AdminService {
    @Autowired
    ClassDao classDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    TeacherDao teacherDao;
    @Autowired
    CommodityDao commodityDao;
    @Autowired
    LibraryDao libraryDao;
    @Autowired
    CourseSelectDao courseSelectDao;
    @Autowired
    CourseDao courseDao;
    @Autowired
    DormitoryDao dormitoryDao;

    //管理员添加学生基本信息
    public int addSchoolRoll(Student student){
        if(studentDao.queryStudentByStudentID(student.getStudentId()) == student)
            return 0;
        else
            return studentDao.insertStudent(student);
    }

    //管理员添加学生班级信息
    public int addStudentClass(Class cla){
        if(classDao.queryClassById(cla.getClassId()) == cla)
            return 0;
        else
            return classDao.insertClass(cla);
    }

    //管理员删除学生基本信息
    public int deleteSchoolRollById(int id){
        return studentDao.deleteStudentByStudentID(id);
    }

    //管理员删除学生班级信息
    public int deleteClassByClassId(int id){
        if(studentDao.queryStudentByClassID(id) == null)
            return classDao.deleteClassById(id);
        else
            return 0;
    }

    //管理员更改学生基本信息
    public int changeStudentNameByStudentId(Student student){
        return studentDao.updateStudentNameByStudentID(student.getStudentId(), student.getStudentName());
    }

    public int changeClassIdByStudentId(Student student){
        return studentDao.updateClassIDByStudentID(student.getStudentId(), student.getClassId());
    }

    public int changeDormitoryIdByStudentId(Student student){
        return studentDao.updateDormitoryIDByStudentID(student.getStudentId(), student.getDormitoryId());
    }

    public int changeBalanceByStudentId(Student student){
        return studentDao.updateBalanceByStudentID(student.getStudentId(), student.getBalance());
    }

    public int changePasswordByStudentId(Student student){
        return studentDao.updatePasswordByStudentID(student.getStudentId(), student.getPassword());
    }

    //管理员更改学生班级信息
    public int changeClassByClassId(Class cla){
        return classDao.updateClassById(cla.getClassId(), cla);
    }

    //管理员查询某个学生信息
    public Student getStudentByStudentId(int studentId){
        return studentDao.queryStudentByStudentID(studentId);
    }

    //管理员获取所有学生的信息
    public List<Student> getAllStudents(){
        return studentDao.queryAll();
    }

    //管理员通过学号某个学生班级信息
    public Class getClassByStudentId(int id){
        return classDao.queryClassByStudentId(id);
    }

    //管理员通过班级号获取班级信息
    public Class getClassByClassId(int id){
        return classDao.queryClassById(id);
    }

    //管理员获取所有学生的班级信息
    public List<Class> getAllClass(){
        return classDao.queryAll();
    }

    //管理员添加老师信息
    public int addTeacher(Teacher teacher){
        if(teacherDao.queryTeacherByTeacherID(teacher.getTeacherId()) == teacher)
            return 0;
        else
            return teacherDao.insertTeacher(teacher);
    }

    //管理员删除老师信息
    public int deleteTeacherByTeacherId(int id){
        return teacherDao.deleteTeacherByTeacherID(id);
    }

    //管理员更改老师信息
    public int changeTeacherNameByTeacherId(Teacher teacher){
        return teacherDao.updateTeacherNameByTeacherID(teacher.getTeacherId(), teacher.getTeacherName());
    }

    public int changePhoneNumberByTeacherId(Teacher teacher){
        return teacherDao.updatePhoneNumberByTeacherID(teacher.getTeacherId(), teacher.getTeacherPhoneNumber());
    }

    public int changePasswordByTeacherId(Teacher teacher){
        return teacherDao.updatePasswordByTeacherID(teacher.getTeacherId(), teacher.getPassword());
    }

    //管理员获取某个老师信息
    public Teacher getTeacherByTeacherId(int id){
        return teacherDao.queryTeacherByTeacherID(id);
    }

    //管理员获取所有老师的信息
    public List<Teacher> getAllTeachers(){
        return teacherDao.queryAll();
    }
    //管理员删除商品信息
    public int deleteCommodityById(int id) {
        return commodityDao.deleteCommodityById(id);
    } 

    //管理员添加课程
    public int insertCourse(Course course) {
        if(courseDao.queryCourseByCourseID(course.getCourseId()) == course)
            return 0;
        else
            return courseDao.insertCourse(course);
    }

    //管理员删除课程
    public int deleteCourseByCourseId(int id) {
        return courseDao.deleteCourseByCourseId(id);
    }

    //管理员更新课程
    public int updateCourseByCourseId(Course course) {
        if(courseDao.queryCourseByCourseID(course.getCourseId()) == course)
            return courseDao.updateCourseByCourseId(course.getCourseId(),course);
        else

            return 0;
    }

    //管理员获取课程的全部信息
    public List<Course> getCourseAll() {
        return courseDao.queryAll();
    }

}
