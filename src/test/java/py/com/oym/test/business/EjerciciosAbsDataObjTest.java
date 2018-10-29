/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.business;

import java.util.Map;
import javax.naming.NamingException;
import org.javabeanstack.datactrl.DataObject;
import org.javabeanstack.datactrl.IDataObject;
import org.javabeanstack.error.IErrorReg;
import org.javabeanstack.exceptions.SessionError;
import org.junit.Test;
import static org.junit.Assert.*;
import org.javabeanstack.model.tables.Pais;
import org.javabeanstack.model.tables.Region;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static py.com.oym.test.business.TestClass.dataLink;

/**
 *
 * @author oym-dev07
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EjerciciosAbsDataObjTest extends TestClass {

    @Test
    public void test1GetFIlterRegion() throws NamingException, SessionError, Exception {
        System.out.println("test1GetFIlterRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        //Region
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        if (region.isFieldExist("codigo")) {
            region.setFilter("codigo = 'GS'");
            String filter = region.getFilter();
            region.requery();
            System.out.println(filter);
            assertNotNull(filter);
        }
        else
        {
            System.out.println("No existe la columna");
        }
        
    }

    @Test
    public void test2SetFilterRegion() throws NamingException, SessionError, Exception {
        System.out.println("test2SetFilterRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        //Region
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        if (region.isFieldExist("codigo")) {
            region.setFilter("codigo like 'M%'");
            region.requery();
            System.out.println(region.getDataRows());
            assertNotNull(region.getDataRows());
        }
        else
        {
            System.out.println("No existe la columna");
        }
    }

    @Test
    public void test3GetOrderRegion() throws NamingException, SessionError, Exception {
        System.out.println("test3GetOrderRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        //Region
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        if (region.isFieldExist("codigo")) {
            region.setOrder("codigo asc");
            String order = region.getOrder();
            System.out.println(order);
            assertNotNull(order);
        }
        else
        {
            System.out.println("No existe la columna");
        }
    }

    @Test
    public void test4SetOrderRegion() throws NamingException, SessionError, Exception {
        System.out.println("test4SetOrderRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        //Region
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.setOrder("1 desc");
        region.requery();
        for (int i = 0; i < region.getRowCount(); i++) {
            System.out.println(region.getDataRows().get(i));
        }
        assertNotNull(region.getDataRows());
    }

    @Test
    public void test5GetSetFirstRowRegion() throws NamingException, SessionError, Exception {
        System.out.println("test5GetFirstRowRegion");
        if (error != null) {
            System.out.println(error);
        }
        //Region
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.setFirstRow(1);
        System.out.println(region.getFirstRow());
        assertNotNull(region.getFirstRow());
    }

    @Test
    public void test6GetSetMaxRowsRegion() throws NamingException, SessionError, Exception {
        System.out.println("test6GetMaxRowsRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.setMaxRows(4);
        System.out.println(region.getMaxRows());
        assertNotNull(region.getMaxRows());
    }

    @Test
    public void test7ReadWriteRegion() throws NamingException, SessionError, Exception {
        System.out.println("test7ReadWriteRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.setReadWrite(true);
        if (region.find("codigo", "AS")) {
            region.setField("codigo", "ASI");
            region.revert();
            region.update(false);
            region.setFilter("codigo = 'AS'");
            System.out.println(region.getDataRows());
            assertNotNull(region.getDataRows());
        }
    }

    @Test
    public void test8RequeryRegion() throws NamingException, SessionError, Exception {
        System.out.println("test8RequeryRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        if (region.isFieldExist("nombre") && region.isFieldExist("idregion")){
            region.setOrder("nombre asc");
            region.setFilter("idregion between 108 and 110");
            region.requery();
            for (int i = 0; i < region.getRowCount(); i++) {
                System.out.println(region.getDataRows().get(i));
            }
            assertNotNull(region.getDataRows());
        }
        else
        {
            System.out.println("No existe la columna");
        }
    }

    @Test
    public void test9CloseRegion() throws NamingException, SessionError, Exception {
        System.out.println("test10CloseRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        if (!region.find("codigo", "URU")) {
            region.insertRow();
            region.setField("codigo", "URU");
            region.setField("nombre", "URUGUAY");
            region.update(false);
            region.close();
            region.open();
            if (region.find("codigo", "URU")) {
                region.deleteRow();
                region.update(false);
                region.setFilter("codigo = 'URU'");
                region.requery();
                assertTrue(region.getDataRows().isEmpty());
            }
        }
    }

    @Test
    public void test10IsOpenRegion() throws NamingException, SessionError, Exception {
        System.out.println("test11IsOpenRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.close();
        if (!region.isOpen()) {
            region.open();
            region.close();
            assertFalse(region.isOpen());
        }
    }

    @Test
    public void test11IsForeignKeyPais() throws NamingException, SessionError, Exception {
        System.out.println("test12IsForeignKeyPais");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject pais = new DataObject(Pais.class, null, dataLink, null);
        pais.open();
        assertTrue(pais.isForeingKey("region"));
    }

    @Test
    public void test12IsFieldExistRegion() throws NamingException, SessionError, Exception {
        System.out.println("test13IsFieldExistRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        if (region.isFieldExist("nombre")) {
            assertFalse(region.isFieldExist("nombreregion"));
        }
    }

    @Test
    public void test13GetRowRegion() throws NamingException, SessionError, Exception {
        System.out.println("test14GetRowRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        System.out.println(region.getRow());
        assertNotNull(region.getRow());
    }

    @Test
    public void test14GetDataRowsPais() throws NamingException, SessionError, Exception {
        System.out.println("test15GetDataRowsPais");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject pais = new DataObject(Pais.class, null, dataLink, null);
        pais.open();
        pais.setOrder("idpais desc");
        pais.setFilter("idpais > 111");
        pais.requery();
        for (int i = 0; i < pais.getRowCount(); i++) {
            System.out.println(pais.getDataRows().get(i));
        }
        assertNotNull(pais.getDataRows());
    }

    @Test
    public void test15GetRecnoRegion() throws NamingException, SessionError, Exception {
        System.out.println("test16GetRecno");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        if (region.find("codigo", "OTRO")) {
            int numeroFila = 2;
            assertEquals(numeroFila, region.getRecno());
        }
    }

    @Test
    public void test16GetSetFieldRegion() throws NamingException, SessionError, Exception {
        System.out.println("test16GetRecno");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.insertRow();
        region.setField("codigo", "URU");
        String codigoEsperado = "URU";
        assertEquals(codigoEsperado, region.getField("codigo"));
        region.close();
    }

    @Test
    public void test17GetFieldOldRegion() throws NamingException, SessionError, Exception {
        System.out.println("test18GetFieldOldRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.insertRow();
        if (region.find("codigo", "OTRO")) {
            region.setField("codigo", "OTRA");
            System.out.println(region.getFieldOld("codigo"));
            String codigoEsperado = "OTRO";
            assertEquals(codigoEsperado, region.getFieldOld("codigo"));
        }
        region.close();
    }

    @Test
    public void test18FindNextRegion() throws NamingException, SessionError, Exception {
        System.out.println("test19FindNextRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        if (region.find("codigo", "MER")) {
            if (region.find("codigo", "AS")) {
                assertTrue(region.findNext());
            }
        }
    }

    @Test
    public void test19GoToRegion() throws NamingException, SessionError, Exception {
        System.out.println("test20GoToRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        assertTrue(region.goTo(2));
        assertFalse(region.goTo(200));
    }
    @Test
    public void test20MoveFirstRegion() throws NamingException, SessionError, Exception {
        System.out.println("test21MoveFirstRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        if (region.find("codigo", "OTRO")){
            assertTrue(region.moveFirst());
            String codigoEsperado = "MER ";
            assertEquals(codigoEsperado,region.getField("codigo"));
        }
    }
    @Test
    public void test21MoveNextRegion() throws NamingException, SessionError, Exception {
        System.out.println("test22MoveNextRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.moveFirst();
        region.moveNext();
        String codigoEsperado = "AS  ";
        assertEquals(codigoEsperado, region.getField("codigo"));
    }
    @Test
    public void test22MovePreviousRegion() throws NamingException, SessionError, Exception {
        System.out.println("test23MovePreviousRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.moveFirst();
        region.moveNext();
        region.movePrevious();
        String codigoEsperado = "MER ";
        assertEquals(codigoEsperado, region.getField("codigo"));
    }
    @Test
    public void test23MoveLastRegion() throws NamingException, SessionError, Exception {
        System.out.println("test24MoveLastRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.moveLast();
        String codigoEsperado = "PRG ";
        assertEquals(codigoEsperado, region.getField("codigo"));
    }
    @Test
    public void test24IsEOfRegion() throws NamingException, SessionError, Exception {
        System.out.println("test25IsEOfRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        while (region.isEof() == false) {            
            region.moveNext();
        }
        assertTrue(region.isEof());
    }
    @Test
    public void test25GetErrorAppRegion() throws NamingException, SessionError, Exception {
        System.out.println("test26GetErrorAppRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        assertNull(region.getErrorApp());
    }
    @Test
    public void test26GetErrorMsgsRegion() throws NamingException, SessionError, Exception {
        System.out.println("test27GetErrorMsgsRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        String resultadoEsperado = "";
        String resultado = region.getErrorMsg(false);
        assertEquals(resultadoEsperado,resultado);
    }
    @Test
    public void test27CheckDataRegion() throws NamingException, SessionError, Exception {
        System.out.println("test28CheckDataRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        if (!region.find("codigo", "OCC")) {
            region.insertRow();
            region.setField("codigo", "OCC");
            region.setField("nombre", "OCCIDENTAL");
            region.update(false);
            assertTrue(region.checkData(true));
        }
        if (region.find("codigo", "OCC")) {
            region.deleteRow();
            region.update(false);
        }
    }
    @Test
    public void test28CheckDataRowRegion() throws NamingException, SessionError, Exception {
        System.out.println("test29CheckDataRowRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        if (!region.find("codigo", "OCC")) {
            Map<String, IErrorReg> resultadoEsp = null;
            region.insertRow();
            region.setField("codigo", "OCC");
            region.setField("nombre", "OCCIDENTAL");
            Map<String, IErrorReg> resultado = region.checkDataRow();
            //assertNotNull(region.checkDataRow());
            assertEquals(resultadoEsp, resultado);
        }
    }
    @Test
    public void test29RevertRegion() throws NamingException, SessionError, Exception {
        System.out.println("test30RevertRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        if (!region.find("codigo", "PCF")) {
            region.insertRow();
            region.setField("codigo", "PCF");
            region.setField("nombre", "PACÍFICO");
            region.revert();
            if (!region.find("codigo", "OCC")) {
                region.insertRow();
                region.setField("codigo", "OCC");
                region.setField("nombre", "OCCIDENTAL");
                region.update(false);
                String nombreEsperado = "OCCIDENTAL";
                assertEquals(nombreEsperado, region.getField("nombre"));
            }
        }
        if (region.find("codigo", "OCC")) {
            region.deleteRow();
            region.update(false);
        }
    }
}
