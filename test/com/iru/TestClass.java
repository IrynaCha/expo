package com.iru;

import com.iru.dao.DaoFactory;
import com.iru.dao.JDBC.StudJDBC;
import com.iru.domain.StudDomain;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestClass {
    @Test
    public void shouldFindStudentById() throws Exception {
        StudJDBC obj = new StudJDBC(new DaoFactory());
        Long id = 3L;
        StudDomain studDomain = obj.findById(id);
        assertEquals(studDomain.getId(), id);
    }

    /*@Test
    public void shouldFindStudentByFullName() throws Exception {
        StudJDBC obj = new StudJDBC(new DaoFactory());
        String firstName = "A";
        String lastName = "AAA";
        StudDomain stud = obj.findByFullName(firstName, lastName);
        assertEquals(stud.getFirstName(), firstName);
    }

    @Test
    public void shouldShowStudentsList() throws Exception {
        StudJDBC obj = new StudJDBC(new DaoFactory());
        int expected = 16;
        int actual = obj.list().size();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateNewStudent()throws Exception{
        StudJDBC obj = new StudJDBC(new DaoFactory());
        StudDomain stud = new StudDomain();
        stud.setFirstName("m");
        stud.setLastName("k");
        stud.setEmail("pppppp");
        stud.setPhoneNumber("15");
        stud.setEnrolmentDate(LocalDate.parse("2010-10-10"));
        StudDomain newStudent = obj.create(stud);
        assertEquals("m", newStudent.getFirstName());
    }

    @Test
    public void shouldUpdateStudent(){
        StudJDBC obj = new StudJDBC(new DaoFactory());
        Long id = 3L;
        StudDomain studDomain = obj.findById(id);
        studDomain.setFirstName("m");
        studDomain.setLastName("k");
        studDomain.setEmail("0pp00");
        studDomain.setPhoneNumber("15");
        studDomain.setEnrolmentDate(LocalDate.parse("2010-10-10"));
        StudDomain updatedStudDomain = obj.update(studDomain);
        studDomain = obj.findById(id);
        assertEquals(studDomain.getFirstName(), updatedStudDomain.getFirstName());
    }

    @Test
    public void shouldDeleteStudent(){
        StudJDBC obj = new StudJDBC(new DaoFactory());
        Long id = 16L;
        StudDomain studDomain = obj.findById(id);
        assertNotNull("Such student does not exist!", studDomain);
        obj.delete(studDomain);
    }*/
}
