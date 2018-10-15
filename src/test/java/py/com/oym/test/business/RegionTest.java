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
        region.setIdregion(Long.parseLong("119"));
        region.setCodigo("PYG");
        region.setNombre("Paraguay");
        region.setFechamodificacion(new Date());
        region.setIdempresa(Long.parseLong("3"));
        IDataResult dataResult = dataLinkCat.persist(region);        
        Region regionResultado = dataResult.getRowUpdated();
        assertEquals(region.getIdregion(), regionResultado.getIdregion());  
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
            region.setIdregion(Long.parseLong("119"));
            region.setCodigo(codigo_aux);
            region.setNombre("Paraguay");
            region.setFechamodificacion(new Date());
            region.setIdempresa(Long.parseLong("3"));
            regiones.add(region);
        }
        dataLinkCat.persist(regiones);
        String codigo = "MXN";
        assertTrue(regiones.get(4).getCodigo().trim().equals(codigo));        
    }
    @Test
    public void testMergeRegion() throws Exception {
        System.out.println("Test Region Merge");
        if (error != null){
            System.out.println(error);
        }
        Region region = new Region();
        region.setIdregion(Long.parseLong("119"));
        region.setCodigo("PYG");
        region.setNombre("Paraguay");
        region.setFechamodificacion(new Date());
        region.setIdempresa(Long.parseLong("3"));
        dataLinkCat.persist(region);   
        IDataResult dataResult = dataLinkCat.merge(region);
        Region regionResultado = dataResult.getRowUpdated();
        assertEquals(region.getIdregion(), regionResultado.getIdregion());  
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
            region.setIdregion(Long.parseLong("119"));
            region.setCodigo(codigo_aux);
            region.setNombre("Paraguay");
            region.setFechamodificacion(new Date());
            region.setIdempresa(Long.parseLong("3"));
            regiones.add(region);
        }
        dataLinkCat.merge(regiones);
        for (int i = 0; i < 5; i++) {
            assertTrue(regiones.get(i).getCodigo().trim().equals(v_codigo[i]));
        }
    }
    @Test
    public void testRemoveRegion() throws Exception {
        System.out.println("Test Region Remove");
        if (error != null){
            System.out.println(error);
        }
        Region region = new Region();
        region.setIdregion(Long.parseLong("119"));
        region.setCodigo("PYG");
        region.setNombre("Paraguay");
        region.setFechamodificacion(new Date());
        region.setIdempresa(Long.parseLong("3"));
        dataLinkCat.persist(region);   
        dataLinkCat.remove(region);
        List<Object> queryRegion = dataLink.findByNativeQuery("select * from {schema}.region where codigo='MXN'", null);
        assertTrue(queryRegion.isEmpty());
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
            region.setIdregion(Long.parseLong("119"));
            region.setCodigo(codigo_aux);
            region.setNombre("Paraguay");
            region.setFechamodificacion(new Date());
            region.setIdempresa(Long.parseLong("3"));
            regiones.add(region);
        }
        dataLinkCat.persist(regiones);
        dataLinkCat.remove(regiones);
        regiones = dataLink.findListByQuery("select o from Region o where codigo='MXN'", null);
        assertTrue(regiones.isEmpty());
    }
    @Test
    public void testUpdateRegion() throws Exception {
        System.out.println("Test Region Update");
        if (error != null){
            System.out.println(error);
        }
        Region region = new Region();
        region.setIdregion(Long.parseLong("119"));
        region.setCodigo("PYG");
        region.setNombre("Paraguay");
        region.setFechamodificacion(new Date());
        region.setIdempresa(Long.parseLong("3"));
        dataLinkCat.persist(region);
        region.setNombre("Argentina");
        dataLinkCat.update(region);
        region.setCodigo("MXN");
        dataLinkCat.update(region);
        String expCodigo = "MXN";
        assertEquals(expCodigo, region.getCodigo());
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
            region.setIdregion(Long.parseLong("119"));
            region.setCodigo(codigo_aux);
            region.setNombre("Paraguay");
            region.setFechamodificacion(new Date());
            region.setIdempresa(Long.parseLong("3"));
            regiones.add(region);
        }
        dataLinkCat.update(regiones);
        Region region = new Region();
        region.setNombre("Colombia");
        regiones.add(region);
        dataLinkCat.update(regiones);
        region.setCodigo("MXN");
        regiones.add(region);
        dataLinkCat.update(regiones);
        regiones = dataLink.findListByQuery("select o from Region o where codigo='MXN'", null);
        assertTrue(regiones.isEmpty());
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