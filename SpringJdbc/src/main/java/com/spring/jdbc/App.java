package com.spring.jdbc;



import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entites.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!________________" );
//        ApplicationContext context =new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        ApplicationContext context =new  AnnotationConfigApplicationContext(SpringJdbcConfig.class);
        //JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
        
//        String query = "Insert into student(id,name,city) value(?,?,?)";
		/* int result = template.update(query,224,"Virat","Delhi"); */
		/* System.out.println("No of queries inserted is"+result); */
        StudentDao studentDao =context.getBean("studentDao",StudentDao.class);
        Student student = new Student();
//        insert operation
//        student.setId(224);
//        student.setName("root");
//        student.setCity("Edgebeston");
//        int result = studentDao.insert(student);
//        System.out.println("Student added "+result);
//        student.setName("raj");
//        student.setCity("pithampur");
//        student.setId(224);
//        int a=studentDao.change(student);
//        int b=studentDao.delete(222);
//        System.out.println("update"+a);
//        System.out.println("deleted"+b);
         System.out.println(studentDao.getStudent(223));
         List<Student> ls = studentDao.getAllStudent();
         for(Student s:ls) {
        	 System.out.println(s);
         }
         
    }
}
