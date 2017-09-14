package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.*;
import seu.domain.*;
import seu.domain.Class;

import java.util.List;
@Service
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

    //管理员添加商品信息
    public int addCommodity(Commodity comm) {
        if (commodityDao.queryCommodityById(comm.getCommodityId()) == comm)
            return 0;
        else
            return commodityDao.insertCommodity(comm);
    }

    //管理员删除商品信息
    public int deleteCommodityById(int id) {
        return commodityDao.deleteCommodityById(id);
    }

    //管理员更改商品库存
    public int changeInventoryById(Commodity commodity) {
        return commodityDao.updateCommodityInventoryById(commodity.getCommodityId(), commodity.getInventory());
    }

    //管理员更改商品价格
    public int changePriceById(Commodity commodity) {
        return commodityDao.updateCommodityPrizeById(commodity.getCommodityId(), commodity.getPrize());
    }

    //管理员获取某个商品信息
    public Commodity getCommodityById(int id) {
        return commodityDao.queryCommodityById(id);
    }

    //管理员获取所有商品的信息
    public List<Commodity> getAllCommodity() {
        return commodityDao.queryAll();
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

    //管理员增加宿舍
    public int insertDormitory(Dormitory dormitory) {
        if(dormitoryDao.queryScoreByDormitoryID(dormitory.getDormitoryId()) == dormitory.getScore())
            return 0;
        else
            return dormitoryDao.insertDormitory(dormitory);
    }

    //管理员删除宿舍
    public int deleteDormitoryByID(int id) {
        if(studentDao.queryStudentByDormitoryId(id) == null)
            return dormitoryDao.deleteDormitoryByID(id);
        else
            return 0;
    }

    //管理员更新学生分数与宿舍信息
    public int updateScoreByID(Dormitory dormitory) {
        if(dormitoryDao.queryScoreByDormitoryID(dormitory.getDormitoryId()) == dormitory.getScore())
            return 0;
        else
            return dormitoryDao.updateScoreByID(dormitory.getDormitoryId()
                    , dormitory.getScore());
    }

    //管理员查询所有学生成绩及宿舍信息
    public List<Dormitory> getDormitoryAll() {
        return dormitoryDao.queryAll();
    }

    //管理员添加图书
    public int insertBook(Library book){
        if(libraryDao.queryBookByBookId(book.getBookId()) == book)
            return 0;
        else
            return libraryDao.insertBook(book);
    }

    //管理员删除图书
    public int deleteBookByBookId(int id) {
        return libraryDao.deleteBookByBookId(id);
    }

    //管理员更新图书信息
    public int updateBookByBookId(Library book) {
        if(libraryDao.queryBookByBookId(book.getBookId()) == book)
            return libraryDao.updateBookByBookId(book.getBookId(),book.getStudentId(),book.getStartDate());
        else
            return 0;
    }

    //管理员获取所有学生所借图书全部信息
    public List<Library> getLibraryAll() {
        return libraryDao.queryAll();
    }
}
