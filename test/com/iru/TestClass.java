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
    public void shouldFindStudDomainById() throws Exception {
        StudJDBC obj = new StudJDBC(new DaoFactory());
        Long id = 3L;
        StudDomain studDomain = obj.findById(id);
        assertEquals(studDomain.getId(), id);
    }

  /*  @Test
    public void shouldFindStudDomainByFullName() throws Exception {
        StudJDBC obj = new StudJDBC(new DaoFactory());
        String firstName = "A";
        String lastName = "AAA";
        StudDomain studDomain = obj.findByFullName(firstName, lastName);
        assertEquals(studDomain.getFirstName(), firstName);
    }

    @Test
    public void shouldShowStudDomainsList() throws Exception {
        StudJDBC obj = new StudJDBC(new DaoFactory());
        int expected = 16;
        int actual = obj.list().size();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateNewStudDomain() throws Exception {
        StudJDBC obj = new StudJDBC(new DaoFactory());
        StudDomain studDomain = new StudDomain();
        studDomain.setFirstName("m");
        studDomain.setLastName("k");
        studDomain.setEmail("pppppp");
        studDomain.setPhoneNumber("15");
        studDomain.setEnrolmentDate(LocalDate.parse("2010-10-10"));
        StudDomain newStudDomain = obj.create(studDomain);
        assertEquals("m", newStudDomain.getFirstName());
    }

    @Test
    public void shouldUpdateStudDomain() {
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
    public void shouldDeleteStudDomain() {
        StudJDBC obj = new StudJDBC(new DaoFactory());
        Long id = 16L;
        StudDomain studDomain = obj.findById(id);
        assertNotNull("Such studDomain does not exist!", studDomain);
        obj.delete(studDomain);
    }*/
}
