package mybatisfinalexamples.mybatisfinalexamples;


import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.learn.mybatis.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Student student = new Student("Prasson", "it",90,1985182702,"w@f.com");
        
        try {
			//insertTest(student);
        	selectTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    public static void insertTest(Student student) throws IOException {
    	
    	Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession session = sqlSessionFactory.openSession();
    	
    	
    	
    	//insert
    	
    	session.insert("Student.insert", student);
    	
    	System.out.println("Record Added");
    	
    	session.commit();
    	session.close();
    	
    	
    }
    
public static void selectTest() throws IOException {
    	
    	Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession session = sqlSessionFactory.openSession();
    	
    	
    	
    	//select
    	
    	List<Student> students = session.selectList("Student.getAll");
    	/*
    	for(Student s: students) {
    		System.out.println(s);
    	}   */ 	
    	
    	students.forEach(student -> System.out.println(student));
    	
    	System.out.println("Records Fetched");
    	
    	session.commit();
    	session.close();
    	
    	
    }
}
