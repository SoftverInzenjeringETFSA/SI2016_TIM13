package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import JdbcTemplates.KorisnikJDBCTemplate;

@SpringBootApplication
public class StartApplication {
	
  public static void main(String[] args) throws Exception {
    //SpringApplication.run(StartApplication.class, args);
	  ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	  
	  KorisnikJDBCTemplate korisnikJDBCTemplate = (KorisnikJDBCTemplate)context.getBean("korisnikJDBCTemplate");
	  
	  //korisnikJDBCTemplate.create("Test", "Testni@mail.com", "Test");
	  //korisnikJDBCTemplate.delete("Testni@mail.com");
	  //korisnikJDBCTemplate.update("Testni@mail.com", "testUpdate", null, null);
  }
  
}