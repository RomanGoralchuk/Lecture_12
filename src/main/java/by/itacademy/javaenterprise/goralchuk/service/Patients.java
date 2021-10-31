package by.itacademy.javaenterprise.goralchuk.service;

import lombok.Data;
import java.util.Date;

@Data
public class Patients {
    private int id;
    private Date registration;
    private String name;
    private String surname;
    private String sex;
    private Date birthday;

    public Patients() {
    }

    public Patients(String name, String surname, String sex, Date birthday) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\n Patient: " +
                "id=" + id +
                ", registration=" + registration +
                ", name='" + name +
                ", surname='" + surname +
                ", sex='" + sex +
                ", birthday=" + birthday;
    }
}

