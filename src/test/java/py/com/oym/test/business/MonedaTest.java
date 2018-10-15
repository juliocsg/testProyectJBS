/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.business;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.javabeanstack.data.IDataResult;
import org.javabeanstack.data.IDataSet;
import org.javabeanstack.data.IGenericDAORemote;
import org.javabeanstack.data.model.DataSet;
import org.javabeanstack.datactrl.DataObject;
import org.javabeanstack.datactrl.IDataObject;
import org.javabeanstack.exceptions.SessionError;
import org.junit.Test;
import static org.junit.Assert.*;
import org.javabeanstack.model.tables.Moneda;
import org.javabeanstack.model.tables.Pais;
import org.javabeanstack.model.tables.Region;
import static py.com.oym.test.business.TestClass.dataLink;



/**
 *
 * @author oym-dev07
 */
public class MonedaTest extends TestClass {
    private static IGenericDAORemote dao;
    
    public MonedaTest(){
    }
    
    @Test
    public void testPersistMoneda() throws Exception 
    {
        System.out.println("Test Moneda Persist");
        if (error != null) {
            System.out.println(error);
            return; 
        }
        Moneda moneda = new Moneda();
        moneda.setIdmoneda(Long.parseLong("119"));
        moneda.setCodigo("PYG");
        moneda.setNombre("Guarani");
        moneda.setCambio(BigDecimal.ZERO);
        moneda.setDecimalpoint(Short.MIN_VALUE);
        moneda.setObservacion("34424");
        moneda.setAppuser("J");
        moneda.setIdempresa(Long.parseLong("3"));
        IDataResult dataResult = dataLinkCat.persist(moneda);
        Moneda monedaResultado = dataResult.getRowUpdated();
        assertEquals(moneda.getIdmoneda(), monedaResultado.getIdmoneda());   
    }
    @Test
    public void testPersistListMoneda() throws Exception{
        System.out.println("testPersistListMoneda");
        if (error != null) {
            System.out.println(error);
            return;
        }
        String codigo_aux;
        List<Moneda> monedas = new ArrayList();
        String[] v_codigo = {"PYG","USD","RUB","MXN","BTC"};
        for (int i = 0; i < 5; i++) {
            codigo_aux = v_codigo[i];
            Moneda moneda = new Moneda();
            moneda.setIdmoneda(Long.parseLong("119"));
            moneda.setCodigo(codigo_aux);
            moneda.setNombre("Guarani");
            moneda.setCambio(BigDecimal.ZERO);
            moneda.setDecimalpoint(Short.MIN_VALUE);
            moneda.setObservacion("34424");
            moneda.setAppuser("J");
            moneda.setIdempresa(Long.parseLong("3"));
            monedas.add(moneda);
        }
        dataLinkCat.persist(monedas);
        String codigo = "MXN";
        assertTrue(monedas.get(3).getCodigo().trim().equals(codigo));
    }
    @Test
    public void testMergeMoneda() throws Exception 
    {
        System.out.println("TestMergeMoneda");
        if (error != null) {
            System.out.println(error);
            return; 
        }
        Moneda moneda = new Moneda();
        moneda.setIdmoneda(Long.parseLong("119"));
        moneda.setCodigo("PYG");
        moneda.setNombre("Guarani");
        moneda.setCambio(BigDecimal.ZERO);
        moneda.setDecimalpoint(Short.MIN_VALUE);
        moneda.setObservacion("34424");
        moneda.setAppuser("J");
        moneda.setIdempresa(Long.parseLong("3"));
        IDataResult dataResult = dataLinkCat.merge(moneda);
        Moneda monedaResultado = dataResult.getRowUpdated();
        assertEquals(moneda.getIdmoneda(), monedaResultado.getIdmoneda());   
    }
    @Test
    public void testMergeListMoneda() throws Exception{
        System.out.println("testMergeListMoneda");
        if (error != null) {
            System.out.println(error);
            return;
        }
        String codigo_aux = "";
        List<Moneda> monedas = new ArrayList();
        String[] v_codigo = {"PYG","USD","RUB","MXN","BTC"};
        for (int i = 0; i < 5; i++) {
            codigo_aux = v_codigo[i];
            Moneda moneda = new Moneda();
            moneda.setIdmoneda(Long.parseLong("119"));
            moneda.setCodigo(codigo_aux);
            moneda.setNombre("Guarani");
            moneda.setCambio(BigDecimal.ZERO);
            moneda.setDecimalpoint(Short.MIN_VALUE);
            moneda.setObservacion("34424");
            moneda.setAppuser("J");
            moneda.setIdempresa(Long.parseLong("3"));
            monedas.add(moneda);
        }
        dataLinkCat.merge(monedas);
        for (int i = 0; i < 5; i++){
            assertTrue(monedas.get(i).getCodigo().trim().equals(v_codigo[i]));    
        }
    }
    
    @Test
    public void testRemoveMoneda() throws Exception 
    {
        System.out.println("Test Moneda Remove");
        if (error != null) {
            System.out.println(error);
            return; 
        }
        Moneda moneda = new Moneda();
        moneda.setIdmoneda(Long.parseLong("119"));
        moneda.setCodigo("PYG");
        moneda.setNombre("Guarani");
        moneda.setCambio(BigDecimal.ZERO);
        moneda.setDecimalpoint(Short.MIN_VALUE);
        moneda.setObservacion("34424");
        moneda.setAppuser("J");
        moneda.setIdempresa(Long.parseLong("3"));
        dataLinkCat.persist(moneda);
        dataLinkCat.remove(moneda);
        List<Object> queryMoneda = dataLink.findByNativeQuery("select * from {schema}.moneda where idmoneda = 119", null);        
        assertTrue(queryMoneda.isEmpty());
        //assertNull(moneda); 
    }
    @Test
    public void testRemoveListMoneda() throws Exception{
        System.out.println("testRemoveListMoneda");
        if (error != null) {
            System.out.println(error);
            return;
        }
        String codigo_aux = "";
        List<Moneda> monedas = new ArrayList();
        String[] v_codigo = {"PYG","USD","RUB","MXN","BTC"};
        for (int i = 0; i < 5; i++) {
            codigo_aux = v_codigo[i];
            Moneda moneda = new Moneda();
            moneda.setIdmoneda(Long.parseLong("119"));
            moneda.setCodigo(codigo_aux);
            moneda.setNombre("Guarani");
            moneda.setCambio(BigDecimal.ZERO);
            moneda.setDecimalpoint(Short.MIN_VALUE);
            moneda.setObservacion("34424");
            moneda.setAppuser("J");
            moneda.setIdempresa(Long.parseLong("3"));
            monedas.add(moneda);
        }
        //Remove
        dataLink.persist(monedas);
        dataLink.remove(monedas);
        monedas = dataLink.findListByQuery("select o from Moneda o where idmoneda='119'", null);
        assertTrue(monedas.isEmpty());
    }   
    @Test
    public void testUpdateMoneda() throws Exception 
    {
        System.out.println("Test Moneda Update");
        if (error != null) {
            System.out.println(error);
            return; 
        }
        //Update
        Moneda moneda = new Moneda();
        moneda.setIdmoneda(Long.parseLong("119"));
        moneda.setCodigo("PYG");
        moneda.setNombre("Guarani");
        moneda.setCambio(BigDecimal.ZERO);
        moneda.setDecimalpoint(Short.MIN_VALUE);
        moneda.setObservacion("34424");
        moneda.setAppuser("J");
        moneda.setIdempresa(Long.parseLong("3"));
        dataLinkCat.persist(moneda);
        moneda.setNombre("Peso");
        dataLinkCat.update(moneda);
        String expMoneda = "Peso";
        assertEquals(expMoneda, moneda.getNombre());
    }
    @Test
    public void testUpdateListMoneda() throws Exception{
        System.out.println("testUpdateListMoneda");
        if (error != null) {
            System.out.println(error);
            return;
        }
        String codigo_aux = "";
        List<Moneda> monedas = new ArrayList();
        String[] v_codigo = {"PYG","USD","RUB","MXN","BTC"};
        for (int i = 0; i < 5; i++) {
            codigo_aux = v_codigo[i];
            Moneda moneda = new Moneda();
            moneda.setIdmoneda(Long.parseLong("119"));
            moneda.setCodigo(codigo_aux);
            moneda.setNombre("Guarani");
            moneda.setCambio(BigDecimal.ZERO);
            moneda.setDecimalpoint(Short.MIN_VALUE);
            moneda.setObservacion("34424");
            moneda.setAppuser("J");
            moneda.setIdempresa(Long.parseLong("3"));
            monedas.add(moneda);
        }
        //Update
        dataLink.update(monedas);
        Moneda moneda = new Moneda();
        moneda.setNombre("Dolar");
        monedas.add(moneda);
        dataLink.update(monedas);
        moneda.setCodigo("GBP");
        monedas.add(moneda);
        dataLink.update(monedas);
        monedas = dataLink.findListByQuery("select o from Moneda o where idmoneda='119'", null);
        assertTrue(monedas.isEmpty());
    }   
    
    @Test
    public void testUpdateMonedaDataObject() throws NamingException, SessionError, Exception {
        System.out.println("testUpdatePaisDataObject");
        //No hubo conexión con el servidor de aplicaciones
        if (error != null) {
            System.out.println(error);
            return;
        }
        
        //moneda
        IDataObject moneda = new DataObject(Moneda.class, null, dataLink, null);
        moneda.open();
        moneda.insertRow();
        moneda.setField("codigo", "MXN");
        moneda.setField("nombre", "peso");
        
        //Region
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.insertRow();
        region.setField("codigo", "EUR");
        region.setField("nombre", "Europa");

        //pais
        IDataObject pais = new DataObject(Pais.class, null, dataLink, null);
        pais.open();
        pais.insertRow();
        pais.setField("codigo", "119");
        pais.setField("nombre", "Paraguay");
        pais.setField("region", region.getRow());
        pais.setField("region", moneda.getRow());

        IDataSet dataSet = new DataSet();
        dataSet.addDataObject("region", region);
        dataSet.addDataObject("pais", pais);
        //dataSet.addDataObject("moneda", moneda);


        boolean result = dataLink.update(dataSet).isSuccessFul();
        assertTrue(result);
    }
    @Test
    public void testDeleteMonedaDataObject() throws NamingException, SessionError, Exception{
        System.out.println("testDeleteMonedaDataObject");
        if (error != null){
            System.out.println(error);
            return;
        }
        //Moneda
        boolean resultado;
        IDataObject moneda = new DataObject(Moneda.class, null, dataLink, null);
        moneda.open();
        if (moneda.find("codigo", "ARS")){
            moneda.deleteRow();
            resultado = moneda.update(false);
            assertTrue(resultado);  
            if (!resultado) {
                System.out.println(moneda.getErrorMsg(true));
            }
        }
        //Pais
        IDataObject pais = new DataObject(Pais.class, null, dataLink, null);
        pais.open();
        if (pais.find("codigo", "119")) {
            pais.deleteRow();
            resultado = pais.update(false);
            assertTrue(resultado);
        }
        //Region        
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        if (region.find("codigo", "EUR")){
            region.deleteRow();
            resultado = region.update(false);
            if (!resultado) {
                System.out.println(region.getErrorMsg(true));
            }
            assertTrue(resultado);            
        }
    }
    
    
    
}