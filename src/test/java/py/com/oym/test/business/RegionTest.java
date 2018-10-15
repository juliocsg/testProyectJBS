/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.business;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.javabeanstack.data.IDataResult;
import org.javabeanstack.data.IDataSet;
import org.javabeanstack.data.model.DataSet;
import org.javabeanstack.datactrl.DataObject;
import org.javabeanstack.datactrl.IDataObject;
import org.javabeanstack.exceptions.SessionError;
import org.junit.Test;
import static org.junit.Assert.*;
import org.javabeanstack.model.tables.Region;
import static py.com.oym.test.business.TestClass.error;

/**
 *
 * @author oym-dev07
 */
public class RegionTest extends TestClass{
    public RegionTest(){
    }
    @Test
    public void testPersistRegion() throws Exception {
        System.out.println("Test Region Persist");
        if (error != null){
            System.out.println(error);
        }
        Region region = new Region();
        region.setCodigo("PYG");
        region.setNombre("Paraguay");
        region.setFechamodificacion(new Date());
        IDataResult dataResult = dataLink.persist(region);        
        /*Region regionResultado = dataResult.getRowUpdated();
        String nombre = "Paraguay";
        assertEquals(nombre,regionResultado.getNombre());*/
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
        dataLink.remove(region);
    } 
    @Test
    public void testPersistListRegion() throws Exception{
        System.out.println("testPersistListRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        String[] v_codigo = {"PYG","RUB", "USD", "EUR", "MXN"};
        String codigo_aux;
        List<Region> regiones = new ArrayList();
        for (int i = 0; i < 5; i++) {
            codigo_aux = v_codigo[i];
            Region region = new Region();
            region.setCodigo(codigo_aux);
            region.setNombre("Paraguay");
            region.setFechamodificacion(new Date());
            regiones.add(region);
        }
        dataLink.persist(regiones);
        IDataResult dataResult = dataLink.persist(regiones);
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
        //assertNotNull(regiones.get(0).getNombre());
        dataLink.remove(regiones);
    }
    @Test
    public void testMergeRegion() throws Exception {
        System.out.println("Test Region Merge");
        if (error != null){
            System.out.println(error);
        }
        Region region = new Region();
        region.setCodigo("PYG");
        region.setNombre("Paraguay");
        region.setFechamodificacion(new Date());
        dataLink.persist(region);   
        IDataResult dataResult = dataLink.merge(region);
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
        //Region regionResultado = dataResult.getRowUpdated();
        //assertEquals(region.getIdregion(), regionResultado.getIdregion());
        dataLink.remove(region);
    } 
    
    @Test
    public void testMergeListRegion() throws Exception{
        System.out.println("testMergeListRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        String[] v_codigo = {"PYG","RUB", "USD", "EUR", "MXN"};
        String codigo_aux;
        List<Region> regiones = new ArrayList();
        for (int i = 0; i < 5; i++) {
            codigo_aux = v_codigo[i];
            Region region = new Region();
            region.setCodigo(codigo_aux);
            region.setNombre("Paraguay");
            region.setFechamodificacion(new Date());
            regiones.add(region);
        }
        dataLink.merge(regiones);
        IDataResult dataResult = dataLink.merge(regiones);
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
       /*
        for (int i = 0; i < 5; i++) {
            assertTrue(regiones.get(i).getCodigo().trim().equals(v_codigo[i]));
        }
        dataLink.remove(regiones);*/
    }
    @Test
    public void testRemoveRegion() throws Exception {
        System.out.println("Test Region Remove");
        if (error != null){
            System.out.println(error);
        }
        Region region = new Region();
        region.setCodigo("PYG");
        region.setNombre("Paraguay");
        region.setFechamodificacion(new Date());
        dataLink.persist(region); 
        IDataResult dataResult = dataLink.persist(region);
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
        dataLink.remove(region);
        /*List<Object> queryRegion = dataLink.findByNativeQuery("select * from {schema}.region where codigo='MXN'", null);
        assertTrue(queryRegion.isEmpty());*/
    } 
    @Test
    public void testRemoveListRegion() throws Exception{
        System.out.println("testRemoveListRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        String[] v_codigo = {"PYG","RUB", "USD", "EUR", "MXN"};
        String codigo_aux;
        List<Region> regiones = new ArrayList();
        for (int i = 0; i < 5; i++) {
            codigo_aux = v_codigo[i];
            Region region = new Region();
            region.setCodigo(codigo_aux);
            region.setNombre("Paraguay");
            region.setFechamodificacion(new Date());
            regiones.add(region);
        }
        dataLink.persist(regiones);
        IDataResult dataResult = dataLink.persist(regiones);
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
        dataLink.remove(regiones);
        /*regiones = dataLink.findListByQuery("select o from Region o where codigo='MXN'", null);
        assertTrue(regiones.isEmpty());*/
    }
    @Test
    public void testUpdateRegion() throws Exception {
        System.out.println("Test Region Update");
        if (error != null){
            System.out.println(error);
        }
        Region region = new Region();
        region.setCodigo("PYG");
        region.setNombre("Paraguay");
        region.setFechamodificacion(new Date());
        dataLink.persist(region);
        region.setNombre("Argentina");
        dataLink.update(region);
        region.setCodigo("MXN");
        dataLink.update(region);
        String expCodigo = "MXN";
        IDataResult dataResult = dataLink.update(region);
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
        /*assertEquals(expCodigo, region.getCodigo());
        dataLink.remove(region);*/
    } 
    
    @Test
    public void testUpdateListRegion() throws Exception{
        System.out.println("testUpdateListRegion");
        if (error != null) {
            System.out.println(error);
            return;
        }
        String[] v_codigo = {"PYG","RUB", "USD", "EUR", "MXN"};
        String codigo_aux = "";
        List<Region> regiones = new ArrayList();
        for (int i = 0; i < 5; i++) {
            codigo_aux = v_codigo[i];
            Region region = new Region();
            region.setCodigo(codigo_aux);
            region.setNombre("Paraguay");
            region.setFechamodificacion(new Date());
            regiones.add(region);
        }
        dataLink.update(regiones);
        Region region = new Region();
        region.setNombre("Colombia");
        regiones.add(region);
        dataLink.update(regiones);
        region.setCodigo("MXN");
        regiones.add(region);
        dataLink.update(regiones);
        IDataResult dataResult = dataLink.update(regiones);
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
        /*regiones = dataLink.findListByQuery("select o from Region o where codigo='MXN'", null);
        assertTrue(regiones.isEmpty());*/
        dataLink.remove(regiones);
    }
    @Test
    public void testUpdateRegionDataObject() throws NamingException, SessionError, Exception {
        System.out.println("1-DataObject AddData");
        //No hubo conexión con el servidor de aplicaciones
        if (error != null) {
            System.out.println(error);
            return;
        }
        //Region
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.insertRow();
        region.setField("codigo", "EUR");
        region.setField("nombre", "Europa");
        IDataSet dataSet = new DataSet();
        dataSet.addDataObject("region", region);
        boolean result = dataLink.update(dataSet).isSuccessFul();
        assertTrue(result);
    }
   
    @Test
    public void testDeleteRegionDataObject() throws NamingException, SessionError, Exception {
        System.out.println("2-DataObject BorrarData");
        //No hubo conexión con el servidor de aplicaciones
        if (error != null) {
            System.out.println(error);
            return;
        }
        boolean result;
        //Campo        
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        if (region.find("codigo", "EUR"))
        {
            region.deleteRow();
            result = region.update(false);
            assertTrue(result);
            if (!result) {
                System.out.println(region.getErrorMsg(true));
            }
        }
    }
}
