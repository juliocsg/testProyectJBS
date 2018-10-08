/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pruebasjbs.util;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class StringsTest {
    
    public StringsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("EJECUCION DE LOS TEST UNITARIOS DEL FRAMEWORK");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("FINALIZACION DE LOS TEST UNITARIOS DEL FRAMEWORK");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isNullorEmpty method, of class Strings.
     */
    @Test
    public void testIsNullorEmpty() {
        System.out.println("isNullorEmpty");
        String string = "";
        Boolean expResult = true;
        Boolean result = Strings.isNullorEmpty(string);
        System.out.println("Esto es vacio --> " + string);
        assertEquals(expResult, result);
        
        string = "hola como estas";
        expResult = false;
        result = Strings.isNullorEmpty(string);
        System.out.println("Esto no es nulo ni vacio --> " + string);
        assertEquals(expResult, result);
        
        string = null;
        expResult = true;
        result = Strings.isNullorEmpty(string);
        System.out.println("Esto es nulo --> " + string);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of findString method, of class Strings.
     */
    @Test
    public void testFindString_String_String() {
        System.out.println("findString");
        String searchExpr = "pelota";
        String exprIn = "un dia me fui con mi pelota a buscar amigos para chutar";
        int expResult = 21;
        int result = Strings.findString(searchExpr, exprIn);
        assertEquals(expResult, result);
        
        searchExpr = "luna";
        exprIn = "mientras los lunares";
        expResult = 13;
        result = Strings.findString(searchExpr, exprIn);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of findString method, of class Strings.
     */
    @Test
    public void testFindString_3args() {
        System.out.println("findString");
        String exprecion_a_buscar = "tatiana";
        String texto = "en el examen de matematicas romina y tatiana se aplazaron ademas tatiana rindio pesimo";
        
        int ocurrencia = 1;
        int resultadoesperado = 37;
        int resultado = Strings.findString(exprecion_a_buscar, texto, ocurrencia);
        assertEquals(resultadoesperado, resultado);
        
        ocurrencia = 0;
        resultadoesperado = -1;
        resultado = Strings.findString(exprecion_a_buscar, texto, ocurrencia);
        assertEquals(resultadoesperado, resultado);
        
        ocurrencia = 2;
        resultadoesperado = 65;
        resultado = Strings.findString(exprecion_a_buscar, texto, ocurrencia);
        assertEquals(resultadoesperado, resultado);
        
    }

    /**
     * Test of occurs method, of class Strings.
     */
    @Test
    public void testOccurs() {
        System.out.println("ocurrencia");
        String searchExpr = "dias";
        String exprIn = "los dias pasan rapido, los dias son frios";
        int expResult = 2;
        int result = Strings.occurs(searchExpr, exprIn);
        assertEquals(expResult, result);
        
        searchExpr = "matriz";
        exprIn = "el vector pude ser de orden 3*3";
        expResult = 0;
        result = Strings.occurs(searchExpr, exprIn);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of replicate method, of class Strings.
     */
    @Test
    public void testReplicate() {
        System.out.println("replicate");
        String character = "hola";
        int times = 2;
        String expResult = "holahola";
        String result = Strings.replicate(character, times);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of findLimit method, of class Strings.
     */
    @Test
    public void testFindLimit_String_String() {
        //busca un caracter en el texto, pero el caracter no debe estar en parentesis o '' o ""
        System.out.println("findLimit");
        String limit = "hola";
        String expr = "va a buscar (hola) y hola en el parentesis y tampoco en 'hola' la comilla ni comillas\"hola\"  ";
        int expResult = 21;
        int result = Strings.findLimit(limit, expr);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of findLimit method, of class Strings.
     */
    @Test
    public void testFindLimit_3args() {
        System.out.println("findLimit");
        String limit = "hola";
        String expr = "va a buscar (hola) y hola, hola en el parentesis y tampoco en 'hola' la comilla ni comillas\"hola\" ";
        int occurs = 1;
        int expResult = 21;
        int result = Strings.findLimit(limit, expr, occurs);
        assertEquals(expResult, result);
        
        occurs = 2;
        expResult = 27;
        result = Strings.findLimit(limit, expr, occurs);
        assertEquals(expResult, result);
        
        occurs = 21;
        expResult = -1;
        result = Strings.findLimit(limit, expr, occurs);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of varReplace method, of class Strings.
     */
    @Test
    public void testVarReplace_String_String() {
        System.out.println("varReplace");
        String var = "esta es la contraseña '123456'";
        String limit = "'";
        String expResult = "esta es la contraseña '******'";
        String result = Strings.varReplace(var, limit);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of varReplace method, of class Strings.
     */
    @Test
    public void testVarReplace_3args() {
        System.out.println("varReplace");
        String var = "la contraseña es '123456'";
        String limit = "'";
        String replace = "-";
        String expResult = "la contraseña es '------'";
        String result = Strings.varReplace(var, limit, replace);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of stringToList method, of class Strings.
     */
    @Test
    public void testStringToList() {
        System.out.println("String a Lista");
        String expr = "luis,carlos,tamara,raul,enrique,martina,fatima";
        List<String> expResult = new ArrayList();
        expResult.add("luis");
        expResult.add("carlos");
        expResult.add("tamara");
        expResult.add("raul");
        expResult.add("enrique");
        expResult.add("martina");
        expResult.add("fatima");
        List<String> result = Strings.stringToList(expr);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of convertToMatrix method, of class Strings.
     */
    @Test
    public void testConvertToMatrix() {
        System.out.println("convertToMatrix");
        String expr = "luis,carlos,tamara,raul,enrique,martina,fatima";
        String separator = ",";
        String[] expResult = {"luis", "carlos", "tamara", "raul", "enrique", "martina", "fatima"};
        String[] result = Strings.convertToMatrix(expr, separator);
        assertArrayEquals(expResult, result);
        
    }

    /**
     * Test of convertToList method, of class Strings.
     */
    @Test
    public void testConvertToList() {
        System.out.println("convertToList");
        String expr = "luis,carlos,tamara,raul,enrique,martina,fatima";
        String separator = ",";
        List<String> expResult = new ArrayList();
        expResult.add("luis");
        expResult.add("carlos");
        expResult.add("tamara");
        expResult.add("raul");
        expResult.add("enrique");
        expResult.add("martina");
        expResult.add("fatima");
        List<String> result = Strings.convertToList(expr, separator);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of textMerge method, of class Strings.
     */
    @Test
    public void testTextMerge_String_Map() {
        System.out.println("textMerge");
        String text = "mmmm{primervalor}mmmm";
        Map<String, String> params = new HashMap();
        params.put("primervalor", "valormodificado");
        String expResult = "mmmmvalormodificadommmm";
        String result = Strings.textMerge(text, params);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of textMerge method, of class Strings.
     */
    @Test
    public void testTextMerge_3args() {
        System.out.println("textMerge");
        String text = "mmm %{primervalor} mmm";
        Map<String, String> params = new HashMap();
        params.put("primervalor", "valormodificado");
        String iniPattern = "%";
        String expResult = "mmm valormodificado mmm";
        String result = Strings.textMerge(text, params, iniPattern);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of textMerge method, of class Strings.
     */
    @Test
    public void testTextMerge_String_ObjectArr() {
        System.out.println("textMerge");
        String text = "mm {primervalor} mmm {segundovalor} mmm";
        String expResult = "mm firstvalue mmm secondvalue mmm";
        String result = Strings.textMerge(text, "primervalor", "firstvalue", "segundovalor", "secondvalue");
        assertEquals(expResult, result);
        
    }

    /**
     * Test of left method, of class Strings.
     */
    @Test
    public void testLeft() {
        System.out.println("left");
        String str = "ciro";
        int len = 2;
        String expResult = " ciro";
        String result = Strings.left(str, len);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of right method, of class Strings.
     */
    @Test
    public void testRight() {
        System.out.println("right");
        String str = "ciro";
        int len = 2;
        String expResult = "   ciro";
        String result = Strings.right(str, len);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of substring method, of class Strings.
     */
    @Test
    public void testSubstring_String_int() {
        System.out.println("substring");
        String str = "";
        int start = 0;
        String expResult = "";
        String result = Strings.substring(str, start);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of substring method, of class Strings.
     */
    @Test
    public void testSubstring_3args() {
        System.out.println("substring");
        String str = "";
        int start = 0;
        int end = 0;
        String expResult = "";
        String result = Strings.substring(str, start, end);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of substr method, of class Strings.
     */
    @Test
    public void testSubstr_String_int() {
        System.out.println("substr");
        String str = "";
        int start = 0;
        String expResult = "";
        String result = Strings.substr(str, start);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of substr method, of class Strings.
     */
    @Test
    public void testSubstr_3args() {
        System.out.println("substr");
        String str = "";
        int start = 0;
        int charactersReturned = 0;
        String expResult = "";
        String result = Strings.substr(str, start, charactersReturned);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of dateToString method, of class Strings.
     */
    @Test
    public void testDateToString() {
        System.out.println("dateToString");
        //dia+mes+año
        Date date = Dates.toDate("07/05/1998");
        //convierte a año+mes+dia
        String expResult = "19980507";
        String result = Strings.dateToString(date);
        result = result.substring(0, 8);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of inString method, of class Strings.
     */
    @Test
    public void testInString() {
        System.out.println("inString");
        
        String search = "hola";
        String comodinBegin = "#{(";
        String comodinEnd = ")}#";
        String expression = "busca un #hola# en esta linea";
        boolean expResult = true;
        boolean result = Strings.inString(comodinBegin, search, comodinEnd, expression);
        assertEquals(expResult, result);
        
        expression = "busca un hola en esta linea";
        expResult = false;
        result = Strings.inString(comodinBegin, search, comodinEnd, expression);
        assertEquals(expResult, result);
        
        expression = "busca un {hola} en esta linea";
        expResult = true;
        result = Strings.inString(comodinBegin, search, comodinEnd, expression);
        assertEquals(expResult, result);
        
        expression = "busca un (hola) en esta linea";
        expResult = true;
        result = Strings.inString(comodinBegin, search, comodinEnd, expression);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of capitalize method, of class Strings.
     */
    @Test
    public void testCapitalize() {
        System.out.println("capitalize");
        String text = "ciro";
        String expResult = "Ciro";
        String result = Strings.capitalize(text);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of encode64 method, of class Strings.
     */
    @Test
    public void testEncode64() {
        System.out.println("encode64");
        String message = "este texto es codificado con base64";
        String expResult = "ZXN0ZSB0ZXh0byBlcyBjb2RpZmljYWRvIGNvbiBiYXNlNjQ=";
        String result = Strings.encode64(message);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of decode64 method, of class Strings.
     */
    @Test
    public void testDecode64() {
        System.out.println("decode64");
        String messageEncode = "ZXN0ZSB0ZXh0byBlcyBjb2RpZmljYWRvIGNvbiBiYXNlNjQ=";
        String expResult = "este texto es codificado con base64";
        String result = Strings.decode64(messageEncode);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testEncode64url() {
        System.out.println("encode64url");
        String message = "este texto es codificado con base64url";
        String expResult = "ZXN0ZSB0ZXh0byBlcyBjb2RpZmljYWRvIGNvbiBiYXNlNjR1cmw=";
        String result = Strings.encode64url(message);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of decode64 method, of class Strings.
     */
    @Test
    public void testDecode64url() {
        System.out.println("decode64url");
        String messageEncode = "ZXN0ZSB0ZXh0byBlcyBjb2RpZmljYWRvIGNvbiBiYXNlNjR1cmw=";
        String expResult = "este texto es codificado con base64url";
        String result = Strings.decode64url(messageEncode);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of fileToString method, of class Strings.
     */
  //  @Test
    public void testFileToString_File() {
        System.out.println("fileToString");
        File file = null;
        String expResult = "";
        String result = Strings.fileToString(file);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of fileToString method, of class Strings.
     */
 //   @Test
    public void testFileToString_String() {
        System.out.println("fileToString");
        String filePath = " ";
        String expResult = " ";
        String result = Strings.fileToString(filePath);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of fileToString method, of class Strings.
     */
 //   @Test
    public void testFileToString_String_String() {
        System.out.println("fileToString");
        String filePath = "";
        String charSet = "";
        String expResult = "";
        String result = Strings.fileToString(filePath, charSet);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of streamToString method, of class Strings.
     */
 //   @Test
    public void testStreamToString_InputStream() throws Exception {
        System.out.println("streamToString");
        InputStream input = null;
        String expResult = "";
        String result = Strings.streamToString(input);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of streamToString method, of class Strings.
     */
   // @Test
    public void testStreamToString_InputStream_String() throws Exception {
        System.out.println("streamToString");
        InputStream input = null;
        String charSet = "";
        String expResult = "";
        String result = Strings.streamToString(input, charSet);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of streamToString method, of class Strings.
     */
  //  @Test
    public void testStreamToString_InputStream_Charset() throws Exception {
        System.out.println("streamToString");
        InputStream input = null;
        Charset charSet = null;
        String expResult = "";
        String result = Strings.streamToString(input, charSet);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getXmlFileCharSet method, of class Strings.
     */
    @Test
    public void testGetXmlFileCharSet_String() {
        System.out.println("getXmlFileCharSet");
        String text = "trabajos.xml";
        String expResult = "trabajos";
        String result = Strings.getXmlFileCharSet(text);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getXmlFileCharSet method, of class Strings.
     */
 //   @Test
    public void testGetXmlFileCharSet_File() {
        System.out.println("getXmlFileCharSet");
        File file = null;
        String expResult = "";
        String result = Strings.getXmlFileCharSet(file);
        assertEquals(expResult, result);
        
    }
    
    
    //prueba para ver que valor devuelve el path
    @Test
    public void PROBAR() {
        String curFolder = System.getProperty("user.dir");
        System.out.println("valor que devuelve --->" + curFolder);
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
