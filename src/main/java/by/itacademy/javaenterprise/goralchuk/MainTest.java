package by.itacademy.javaenterprise.goralchuk;

import by.itacademy.javaenterprise.goralchuk.DAO.PatientsDAO;
import by.itacademy.javaenterprise.goralchuk.DAO.PatientsImplementsDAO;

public class MainTest {



    public static void main(String[] args) {



/*        System.out.println(patientsDAO.getLimit(PatientsImplementsDAO.SELECT_LIMITS_PATIENTS));*/


        PatientsDAO patientsImplementsDAO = new PatientsImplementsDAO();
        System.out.println(patientsImplementsDAO.getAll());
        System.out.println(patientsImplementsDAO.getLimit(PatientsImplementsDAO.SELECT_LIMITS_PATIENTS));

/*
        patientsImplementsDAO.create(new Patients("Larisa", "Dolina", "F", java.sql.Date.valueOf("1958-10-04")));
*/
/*
        System.out.println(patientsImplementsDAO.getLimit(PatientsImplementsDAO.SELECT_LIMITS_PATIENTS));
*/

    }
}
