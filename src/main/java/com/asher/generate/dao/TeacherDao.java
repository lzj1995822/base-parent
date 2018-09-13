package com.asher.generate.dao;

import com.asher.generate.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Teacher save(Teacher teacher) {
        Session session = sessionFactory.openSession();
        return (Teacher) session.save(teacher);
    }
}
