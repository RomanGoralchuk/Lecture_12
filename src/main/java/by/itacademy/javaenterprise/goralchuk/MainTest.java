package by.itacademy.javaenterprise.goralchuk;

import by.itacademy.javaenterprise.goralchuk.DAO.PatientsDAO;
import by.itacademy.javaenterprise.goralchuk.DAO.PatientsImplementsDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {



    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring/spring-context.xml");

        PatientsDAO patientsImplementsDAO = context.getBean("patientsDAO", PatientsImplementsDAO.class);
        System.out.println(patientsImplementsDAO.getAll());
        System.out.println(patientsImplementsDAO.getLimit(PatientsImplementsDAO.SELECT_LIMITS_PATIENTS));

        context.close();
/*
        patientsImplementsDAO.create(new Patients("Larisa", "Dolina", "F", java.sql.Date.valueOf("1958-10-04")));
*/

    }
}
