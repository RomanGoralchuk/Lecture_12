package by.itacademy.javaenterprise.goralchuk;

import by.itacademy.javaenterprise.goralchuk.DAO.PatientsDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {



    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-context.xml");

        PatientsDAO patientsDAO = (PatientsDAO) context.getBean("patients");
        System.out.println(patientsDAO.getAll());
/*        System.out.println(patientsDAO.getLimit(PatientsImplementsDAO.SELECT_LIMITS_PATIENTS));*/


/*        PatientsImplementsDAO patientsImplementsDAO = new PatientsImplementsDAO();
        System.out.println(patientsImplementsDAO.getAll());*/
/*
        patientsImplementsDAO.create(new Patients("Larisa", "Dolina", "F", java.sql.Date.valueOf("1958-10-04")));
*/
/*
        System.out.println(patientsImplementsDAO.getLimit(PatientsImplementsDAO.SELECT_LIMITS_PATIENTS));
*/

    }
}
