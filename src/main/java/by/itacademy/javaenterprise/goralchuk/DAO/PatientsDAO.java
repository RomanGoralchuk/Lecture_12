package by.itacademy.javaenterprise.goralchuk.DAO;

import by.itacademy.javaenterprise.goralchuk.service.Patients;

import java.util.List;

public interface PatientsDAO extends DAO<Patients> {
    List<Patients> getLimit(String str);
    List<Patients> getAll();
}
