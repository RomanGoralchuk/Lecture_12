package by.itacademy.javaenterprise.goralchuk;

import by.itacademy.javaenterprise.goralchuk.dao.PatientDAO;
import by.itacademy.javaenterprise.goralchuk.dao.PatientDAOImpl;
import by.itacademy.javaenterprise.goralchuk.entity.Patient;
import by.itacademy.javaenterprise.goralchuk.entity.PatientSex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    private static final Logger logger = LoggerFactory.getLogger(MainTest.class);

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring/spring-context.xml");

        PatientDAO patientsDAO = context.getBean("patientsDAO", PatientDAOImpl.class);

        logger.info("Test response to the request: " + patientsDAO.findAllPatients());

        logger.info("Test response to the request: " + patientsDAO.findBySexPatients(PatientSex.F));

        patientsDAO.save(new Patient("Jaga", "Koshceeva", PatientSex.F, java.sql.Date.valueOf("1012-11-13")));

        context.close();
    }
}
