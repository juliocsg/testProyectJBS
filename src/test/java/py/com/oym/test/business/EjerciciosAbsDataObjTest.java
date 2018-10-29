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
    public void test5GetSetFirstMaxRowRegion() throws NamingException, SessionError, Exception {
        System.out.println("test5GetSetFirstMaxRowRegion");
        if (error != null) {
            System.out.println(error);
        }
        //Region
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.setFirstRow(0);
        region.setMaxRows(3);
        region.requery();
        int firstRow = 0, maxRows = 3;
        assertEquals(firstRow, region.getFirstRow());
        assertEquals(maxRows, region.getRowCount());
    }

    @Test
    public void test6ReadWriteRegion() throws NamingException, SessionError, Exception {
        System.out.println("test6ReadWriteRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.setReadWrite(false);
        if (!region.find("codigo", "PCF")) {
            region.insertRow();
            region.setField("codigo", "PCF");
            region.setField("nombre", "PACÍFICO");
            region.update(false);
            if (!region.find("codigo", "PCF")) {
                region.setReadWrite(true);
                region.insertRow();
                region.setField("codigo", "PCF");
                region.setField("nombre", "PACÍFICO");
                region.update(false);
            }
        }
        if (region.find("codigo", "PCF")) {
            region.deleteRow();
            boolean resultado = region.update(false);
            assertTrue(resultado);
            if (!resultado) {
                System.out.println(region.getErrorMsg(true));
            }
        }
    }

    @Test
    public void test7RequeryRegion() throws NamingException, SessionError, Exception {
        System.out.println("test7RequeryRegion");
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
            while (region.isEof() == false) {                
                System.out.println("Código: "+region.getField("codigo")+" Nombre: "+region.getField("nombre"));
                region.moveNext();
            }
            assertNotNull(region.getDataRows());
        }
        else
        {
            System.out.println("No existe la columna");
        }
    }

    @Test
    public void test8IsOpenCloseRegion() throws NamingException, SessionError, Exception {
        System.out.println("test8IsOpenCloseRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        assertTrue(region.isOpen());
        region.close();
        assertFalse(region.isOpen());
    }

    @Test
    public void test9IsForeignKeyPais() throws NamingException, SessionError, Exception {
        System.out.println("test9IsForeignKeyPais");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject pais = new DataObject(Pais.class, null, dataLink, null);
        pais.open();
        assertTrue(pais.isForeingKey("region"));
        assertFalse(pais.isForeingKey("nombre"));
        assertFalse(pais.isForeingKey("colforanea"));
    }

    @Test
    public void test10IsFieldExistRegion() throws NamingException, SessionError, Exception {
        System.out.println("test10IsFieldExistRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        assertTrue(region.isFieldExist("nombre"));
        assertFalse(region.isFieldExist("nombreregion"));
        
    }

    @Test
    public void test11GetRowRegion() throws NamingException, SessionError, Exception {
        System.out.println("test11GetRowRegion");
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
    public void test12GetDataRowsPais() throws NamingException, SessionError, Exception {
        System.out.println("test12GetDataRowsPais");
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
    public void test13GetRecnoRegion() throws NamingException, SessionError, Exception {
        System.out.println("test13GetRecnoRegion");
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
    public void test14GetSetFieldRegion() throws NamingException, SessionError, Exception {
        System.out.println("test14GetSetFieldRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        if (!region.find("codigo", "URU")) {
            region.insertRow();
            region.setField("codigo", "URU");
            String codigoEsperado = "URU";
            assertEquals(codigoEsperado, region.getField("codigo"));
            region.close();
        }
    }

    @Test
    public void test15GetFieldOldRegion() throws NamingException, SessionError, Exception {
        System.out.println("test15GetFieldOldRegion");
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
    public void test16FindNextRegion() throws NamingException, SessionError, Exception {
        System.out.println("test16FindNextRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        if (region.find("codigo", "MER")) {
            region.findNext();
            String codigoResultado = "MER";
            assertEquals(codigoResultado,region.getField("codigo"));
        }
    }

    @Test
    public void test17GoToRegion() throws NamingException, SessionError, Exception {
        System.out.println("test17GoToRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        assertTrue(region.goTo(2));
        String codigoResultado = "OTRO";
        assertEquals(codigoResultado,region.getField("codigo"));
    }
    @Test
    public void test18MoveFirstRegion() throws NamingException, SessionError, Exception {
        System.out.println("test18MoveFirstRegion");
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
    public void test19MoveNextRegion() throws NamingException, SessionError, Exception {
        System.out.println("test19MoveNextRegion");
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
    public void test20MovePreviousRegion() throws NamingException, SessionError, Exception {
        System.out.println("test20MovePreviousRegion");
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
    public void test21MoveLastRegion() throws NamingException, SessionError, Exception {
        System.out.println("test21MoveLastRegion");
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
    public void test22IsEOfRegion() throws NamingException, SessionError, Exception {
        System.out.println("test22IsEOfRegion");
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
    public void test23GetErrorAppRegion() throws NamingException, SessionError, Exception {
        System.out.println("test23GetErrorAppRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        assertNull(region.getErrorApp());
        assertTrue(region.getErrorApp() != null);
        assertTrue(region.getErrorApp() == null);
    }
    @Test
    public void test24GetErrorMsgsRegion() throws NamingException, SessionError, Exception {
        System.out.println("test24GetErrorMsgsRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        String resultadoEsperado = "";
        assertEquals(resultadoEsperado, region.getErrorMsg(false));
    }
    @Test
    public void test25CheckDataRegion() throws NamingException, SessionError, Exception {
        System.out.println("test25CheckDataRegion");
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
    public void test26CheckDataRowRegion() throws NamingException, SessionError, Exception {
        System.out.println("test26CheckDataRowRegion");
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
            assertEquals(resultadoEsp, resultado);
        }
    }
    @Test
    public void test27RevertRegion() throws NamingException, SessionError, Exception {
        System.out.println("test27RevertRegion");
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
