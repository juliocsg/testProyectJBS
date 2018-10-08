/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebasjbs.util;

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
public class FnTest {

    public FnTest() {
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
     * Test of inList method, of class Fn.
     */
    @Test
    public void testInList_String_StringArr() {
        System.out.println("inList");
        String obj = "fatima";
        String[] list = {"ciro", "maria", "enrique", "luis", "fatima"};
        boolean expResult = true;
        boolean result = Fn.inList(obj, list);
        assertEquals(expResult, result);
   

    }

    /**
     * Test of inList method, of class Fn.
     */
    @Test
    public void testInList_Integer_intArr() {
        System.out.println("inList");
        Integer obj = 1;
        int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean expResult = true;
        boolean result = Fn.inList(obj, list);
        assertEquals(expResult, result);
   

    }

    /**
     * Test of iif method, of class Fn.
     */
    @Test
    public void testIif() {
        System.out.println("iif");
        Boolean condition = null;
        Object value1 = null;
        Object value2 = null;
        Object expResult = null;
        Object result = Fn.iif(condition, value1, value2);
        assertEquals(expResult, result);
   

    }

    /**
     * Test of findInMatrix method, of class Fn.
     */
    @Test
    public void testFindInMatrix_ObjectArr_Object() {
        System.out.println("findInMatrix");
        Object[] matrix = {"ciro", "carlos", "fatima", "enrique", "maria"};
        Object search = "ciro";
        Integer expResult = 0;
        Integer result = Fn.findInMatrix(matrix, search);
        assertEquals(expResult, result);
   

    }

    /**
     * Test of findInMatrix method, of class Fn.
     */
    @Test
    public void testFindInMatrix_3args() {
        System.out.println("findInMatrix");
        String[] matrix = {"ciro", "carlos", "fatima"};
        String search = "ciro";
        Boolean caseSensitive = true;
        Integer expResult = 0;
        Integer result = Fn.findInMatrix(matrix, search, caseSensitive);
        assertEquals(expResult, result);
   

    }

    /**
     * Test of toLogical method, of class Fn.
     */
    @Test
    public void testToLogical() {
        System.out.println("toLogical");
        Object value = 0;
        Boolean expResult = false;
        Boolean result = Fn.toLogical(value);
        assertEquals(expResult, result);

        value = 1;
        expResult = true;
        result = Fn.toLogical(value);
        assertEquals(expResult, result);

        value = "1";
        expResult = true;
        result = Fn.toLogical(value);
        assertEquals(expResult, result);
   

    }

    /**
     * Test of nvl method, of class Fn.
     */
    @Test
    public void testNvl() {
        System.out.println("nvl");
        Object value = null;
        Object alternateValue = "es nulo el valor";
        Object expResult = "es nulo el valor";
        Object result = Fn.nvl(value, alternateValue);
        assertEquals(expResult, result);
   

    }

    /**
     * Test of bytesToHex method, of class Fn.
     */
    @Test
    public void testBytesToHex() {
        System.out.println("bytesToHex");
        byte[] bytes = {1, 2, 4, 8, 16, 32, 10};
        //se coloca en orden los numeros en el formato hexadecimal sin espacio
        String expResult = "0102040810200a";
        String result = Fn.bytesToHex(bytes);
        System.out.println("ss" + result);
        assertEquals(expResult, result);
   

    }

    /**
     * Test of hexToByte method, of class Fn.
     */
    @Test
    public void testHexToByte() {
        System.out.println("hexToByte");
        String hexText = "0102040810200a";
        byte[] expResult = {1, 2, 4, 8, 16, 32, 10};
        byte[] result = Fn.hexToByte(hexText);
        assertArrayEquals(expResult, result);
   

    }

    /**
     * Test of base64ToBytes method, of class Fn.
     */
    @Test
    public void testBase64ToBytes() {
        System.out.println("base64ToBytes");
        String encrypted64 = "MTI=";
        byte[] expResult = {12};
        byte[] result = Fn.base64ToBytes(encrypted64.toLowerCase());
        System.out.println("valor esperado  " );
        assertArrayEquals(expResult, result);
   

    }

    /**
     * Test of bytesToBase64 method, of class Fn.
     */
    @Test
    public void testBytesToBase64() {
        System.out.println("bytesToBase64");
        byte[] text = {12};
        String expResult = "MTI=";
        String result = Fn.bytesToBase64(text);
        System.out.println("resultado esperado " );
        assertEquals(expResult, result);
   

    }

}
