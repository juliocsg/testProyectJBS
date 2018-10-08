/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebasjbs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alberto
 */
public class DatesTest {

    public DatesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("EJECUTANDOSE LOS TEST");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("FINALIZACION DE LOS TEST");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of toDate method, of class Dates.
     */
    @Test
    public void testToDate_String() throws ParseException {
        System.out.println("toDate");
        String dateString = "07/05/1998";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date expResult = formatter.parse(dateString);

        Date result = Dates.toDate(expResult);

        System.out.println(result.getTime());
        System.out.println(expResult.getTime());
        assertEquals(expResult, result);

        expResult = java.sql.Date.valueOf("1998-05-07");
        assertEquals(expResult, result);
    }

    /**
     * Test of toDate method, of class Dates.
     */
    @Test
    public void testToDate_String_String() {
        System.out.println("toDate");
        String dateString = "1998/05/07";
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date expResult = java.sql.Date.valueOf("1998-05-07");
        Date result = Dates.toDate(dateString, format);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of toDate method, of class Dates.
     */
    @Test
    public void testToDate_Date() {
        System.out.println("toDate");
        Date date = java.sql.Date.valueOf("07-05-05");
        Date expResult = java.sql.Date.valueOf("1998-05-07");
        Date result = Dates.toDate(date);
        System.out.println("fecha esperada " + result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of toDate method, of class Dates.
     */
    @Test
    public void testToDate_String_SimpleDateFormat() {
        System.out.println("toDate");
        Date date = Dates.toDate("07/05/1998", "dd/MM/yyyy");
        SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
        String expResult = "1998/05/07";
        String result = org.javabeanstack.util.Dates.toString(date, formater);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of toString method, of class Dates.
     */
    @Test
    public void testToString_Date_SimpleDateFormat() {
        System.out.println("toString");
        Date date = null;
        SimpleDateFormat formater = null;
        String expResult = "";
        String result = Dates.toString(date, formater);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of toString method, of class Dates.
     */
    @Test
    public void testToString_Date_String() {
        System.out.println("toString");
        //se pone una fecha
        Date date = java.sql.Date.valueOf("2018-05-07");
        //se elige un formato
        String format = "dd/MM/yyyy";
        //se cambia la fecha al formato que se desea
        String expResult = "07/05/2018";
        String result = Dates.toString(date, format);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of now method, of class Dates.
     */
    @Test
    public void testNow() {
        System.out.println("now");
        Date expResult = Dates.now();
        System.out.println("expresion " + expResult);
        Date result = Dates.now();
        System.out.println("expresion a comprar " + result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of today method, of class Dates.
     */
    @Test
    public void testToday() {
        System.out.println("today");
        //fecha en la que se hizo el test
        Date expResult = java.sql.Date.valueOf("2018-09-10");
        Date result = Dates.today();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of sum method, of class Dates.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        Date date = java.sql.Date.valueOf("2018-05-07");
        //CANTIDAD QUE VA A SUMAR
        int quantity = 1;
        //EL INTERVALO QUE SE VA SUMAR == en este caso puse años, pero puede ser cualquier intervalo.
        int interval = Calendar.YEAR;
        Date expResult = java.sql.Date.valueOf("2019-05-07");
        Date result = Dates.sum(date, quantity, interval);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of sumDays method, of class Dates.
     */
    @Test
    public void testSumDays() {
        System.out.println("sumDays");
        Date date = java.sql.Date.valueOf("2018-07-05");
        int days = 2;
        Date expResult = java.sql.Date.valueOf("2018-07-07");
        Date result = Dates.sumDays(date, days);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of sumHours method, of class Dates.
     */
    @Test
    public void testSumHours() {
        System.out.println("sumHours");
        Date date = java.sql.Time.valueOf("08:05:22");
        int hours = 3;
        Date expResult = java.sql.Time.valueOf("11:05:22");
        Date result = Dates.sumHours(date, hours);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of sumMinutes method, of class Dates.
     */
    @Test
    public void testSumMinutes() {
        System.out.println("sumMinutes");
        Date date = java.sql.Time.valueOf("08:2:22");
        int minutes = 8;
        Date expResult = java.sql.Time.valueOf("08:10:22");
        Date result = Dates.sumMinutes(date, minutes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of sumSeconds method, of class Dates.
     */
    @Test
    public void testSumSeconds() {
        System.out.println("sumSeconds");
        Date date = java.sql.Time.valueOf("08:05:22");
        int seconds = 8;
        Date expResult = java.sql.Time.valueOf("08:05:30");
        Date result = Dates.sumSeconds(date, seconds);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getLastTimeOfDay method, of class Dates.
     */
    @Test
    public void testGetLastTimeOfDay() {
        System.out.println("getLastTimeOfDay");
        Date date = java.sql.Date.valueOf("2018-05-07");
        Date expResult = java.sql.Timestamp.valueOf("2018-05-07 23:59:59");
        Date result = Dates.getLastTimeOfDay(date);
        System.out.println("valor esperado" + result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }


}
