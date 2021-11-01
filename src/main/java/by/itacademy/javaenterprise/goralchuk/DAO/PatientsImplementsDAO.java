package by.itacademy.javaenterprise.goralchuk.DAO;

import by.itacademy.javaenterprise.goralchuk.connect.ConnectionPool;
import by.itacademy.javaenterprise.goralchuk.service.Patients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientsImplementsDAO implements PatientsDAO {
    public static final String ADD_PATIENT = "" +
            "INSERT INTO patients " +
            "(patient_name," +
            "patient_surname," +
            "patient_sex,patient_birthday) " +
            "VALUES" +
            " (?,?,?,?)";
    public static final String SELECT_LIMITS_PATIENTS = "" +
            "SELECT * FROM patients " +
            "WHERE patient_sex = 'M' " +
            "ORDER BY patient_name ASC " +
            "LIMIT 3 " +
            "OFFSET 1 " +
            "";
    public static final String SELECT_ALL_PATIENTS = "SELECT * FROM patients";



    private static final Logger logger = LoggerFactory.getLogger(PatientsImplementsDAO.class);



    @Override
    public Patients get(Serializable id) throws SQLException {
        return null;
    }

    @Override
    public Patients create(Patients patients) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getPoolConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PreparedStatement statement = null;

        if (patients != null) {
            String name = patients.getName();
            String surname = patients.getSurname();
            String sex = patients.getSex();
            Date birthday = patients.getBirthday();

            try {
                if (connection != null) {
                    connection.setAutoCommit(false);
                    statement = connection.prepareStatement(ADD_PATIENT);
                    statement.setString(1, name);
                    statement.setString(2, surname);
                    statement.setString(3, sex);
                    statement.setDate(4, (java.sql.Date) birthday);
                    Savepoint savepointOne = connection.setSavepoint("SavepointOne");

                    try {
                        statement.executeUpdate();
                        connection.commit();
                        logger.info("Patient added to the table successfully!");
                    } catch (SQLException e) {
                        logger.error(e.toString());
                        connection.rollback(savepointOne);
                    }
                }
            } catch (SQLException ex) {
                logger.error(ex.toString());
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    logger.error(e.toString());
                }
            }
        }
        return null;
    }

    @Override
    public void update(Patients patients) throws SQLException {

    }

    @Override
    public int delete(Serializable id) throws SQLException {
        return 0;
    }

    @Override
    public List<Patients> getLimit(String sql) {
        List<Patients> patients = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionPool.getPoolConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            if (connection != null) {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                connection.setAutoCommit(false);

                while (resultSet.next()) {
                    int id = resultSet.getInt("patient_ID");
                    Date registration = resultSet.getDate("patient_registration");
                    String name = resultSet.getString("patient_name");
                    String surname = resultSet.getString("patient_surname");
                    String sex = resultSet.getString("patient_sex");
                    Date birthday = resultSet.getDate("patient_birthday");

                    Patients patient = new Patients();
                    patient.setId(id);
                    patient.setRegistration(registration);
                    patient.setName(name);
                    patient.setSurname(surname);
                    patient.setSex(sex);
                    patient.setBirthday(birthday);
                    Savepoint savepointOne = connection.setSavepoint("SavepointOne");

                    try {
                        patients.add(patient);
                        connection.commit();
                    } catch (SQLException e) {
                        logger.error(e.toString());
                        connection.rollback(savepointOne);
                    }
                }
            }
        } catch (SQLException ex) {
            logger.error(ex.toString());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.error(e.toString());
            }
        }
        return patients;
    }

    @Override
    public List<Patients> getAll() {
        List<Patients> patients = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionPool.getPoolConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            if (connection != null) {
                statement = connection.prepareStatement(SELECT_ALL_PATIENTS);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("patient_ID");
                    Date registration = resultSet.getDate("patient_registration");
                    String name = resultSet.getString("patient_name");
                    String surname = resultSet.getString("patient_surname");
                    String sex = resultSet.getString("patient_sex");
                    Date birthday = resultSet.getDate("patient_birthday");

                    Patients patient = new Patients();
                    patient.setId(id);
                    patient.setRegistration(registration);
                    patient.setName(name);
                    patient.setSurname(surname);
                    patient.setSex(sex);
                    patient.setBirthday(birthday);

                    patients.add(patient);
                }
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.error(e.toString());
            }
        }
        return patients;
    }


}
