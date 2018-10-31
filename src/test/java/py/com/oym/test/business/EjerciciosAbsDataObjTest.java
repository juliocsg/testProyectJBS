/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.business;

import java.util.Date;
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
            //Realiza el proceso del filtro
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
             //Realiza el proceso del filtro
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
            //Realiza el proceso de ordenación de registros
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
        //Realiza el proceso de ordenación de registros
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
        //Asigna el primer registro
        region.setFirstRow(0);
        //Asigna el máximo registro
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
        boolean resultado;
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        //El ReadWrite impide que pueda insertar registros
        region.setReadWrite(false);
        
        if (!region.find("codigo", "PCF")) {
            region.insertRow();
            region.setField("codigo", "PCF");
            region.setField("nombre", "PACÍFICO");
            //No permite actualizar el registro
            resultado = region.update(false);
            assertFalse(resultado);
        }
        region.moveFirst();
        region.deleteRow();
        //No permite eliminar el registro
        resultado = region.update(false);
        assertTrue(!resultado);
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
            //Proceso de realización de la consulta
            region.requery();
            region.moveFirst();
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
        //Validar si está abierto
        assertTrue(region.isOpen());
        region.close();
        //Validar que esté cerrado
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
        //Control de clave foránea
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
        //Pregunta si existe el campo
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
        //Obtención de registro en la posición actual
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
        //Obtiene todos los registros
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
            //Obtención del número de fila
            assertEquals(numeroFila, region.getRecno());
        }
    }

    @Test
    public void test14GetSetFieldRegion() throws NamingException, SessionError, Exception 
    {
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
        if (region.find("idempresa", 41L)) {
            //Busca la siguiente ocurrencia en base a la columna buscada
            region.findNext();
            long idEmpresaResultado = 41L;
            assertEquals(idEmpresaResultado,region.getField("idempresa"));
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
            int numEsperado = 0;
            assertEquals(numEsperado,region.getRecno());
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
        int numEsperado = 1;
        assertEquals(numEsperado, region.getRecno());
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
        int numEsperado = 0;
        assertEquals(numEsperado,region.getRecno());
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
        region.moveNext();
        assertTrue(region.isEof()); 
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
        //Hace el recorrido para que vaya moviendo hasta rompa el ciclo terminando los registros
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
        //Region
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        //Error al abrir
        region.open("sin parametro", "", false, -4);
        assertTrue(region.getErrorApp() != null);
        assertFalse(region.isOpen());
        region.open();
        //Error de filtro
        assertTrue(region.getErrorApp() == null);
        region.setFilter("noexiste between 20 and 500");
        region.requery();
        //Error de asignación de campo
        assertFalse(region.getErrorApp() == null);
        assertTrue(!region.setField("campo1", "valor1"));
        assertTrue(region.getErrorApp() != null);
        //Error de setfield de tipo de dato
        assertTrue(!region.setField("codigo", 12345));
        assertFalse(region.getErrorApp() == null);
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
            if (!region.find("codigo", "OCC")) {
                region.insertRow();
                region.setField("codigo", "OCC");
                region.setField("nombre", "OCCIDENTAL");
                //Verifica cuantos registros tiene para guardar
                assertTrue(region.getDataRowsChanged().size() == 2);
                //Revierte el registro actual
                region.revert();
                assertTrue(region.getDataRowsChanged().size() == 1);
            }
        }
        region.moveFirst();
        region.deleteRow();
        //verifica que uno se inserta y otro que se quiere eliminar
        assertTrue(region.getDataRowsChanged().size() == 2);
        //Revierte todos los registros
        region.revert(true);
        assertTrue(region.getDataRowsChanged().size() == 0);
    }
}
