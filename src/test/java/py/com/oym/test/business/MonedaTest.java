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
import org.javabeanstack.data.IDataRow;
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
        moneda.setCodigo("ARG");
        moneda.setNombre("pesos argentinos");
        moneda.setCambio(BigDecimal.ONE);
        moneda.setIdempresa(41L);
        IDataResult dataResult = dataLink.persist(moneda);
        Moneda monedaResult = dataResult.getRowUpdated();
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());    
        dataLink.remove(monedaResult);
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
        String[] v_codigo = {"AUD","ARG","RUB","MXN","BTC"};
        for (int i = 0; i < 5; i++) {
            codigo_aux = v_codigo[i];
            Moneda moneda = new Moneda();
            moneda.setCodigo(codigo_aux);
            moneda.setNombre("Dòlares varios");
            moneda.setCambio(BigDecimal.ONE);
            moneda.setIdempresa(41L);
            monedas.add(moneda);
        }
        IDataResult dataResult = dataLink.persist(monedas);
        List<IDataRow> monedasResult = dataResult.getRowsUpdated();
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
        dataLink.remove(monedasResult);
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
        moneda.setCodigo("ARG");
        moneda.setNombre("Pesos Argentinos");
        moneda.setCambio(BigDecimal.ONE);
        moneda.setIdempresa(41L);
        dataLink.persist(moneda);
        moneda = dataLink.findByQuery("select o from Moneda o where codigo = 'ARG'", null);
        moneda.setNombre("Pesos Arg");
        IDataResult dataResult = dataLink.merge(moneda);
        Moneda monedaResult = dataResult.getRowUpdated();
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
        dataLink.remove(monedaResult);
    }
    
    //Falta corregir
    @Test
    public void testMergeListMoneda() throws Exception{
        System.out.println("testMergeListMoneda");
        if (error != null) {
            System.out.println(error);
            return;
        }
        String codigo_aux;
        List<Moneda> monedas = new ArrayList();
        String[] v_codigo = {"AUD","ARG","RUB","MXN","BTC"};
        for (int i = 0; i < 5; i++) {
            codigo_aux = v_codigo[i];
            Moneda moneda = new Moneda();
            moneda.setCodigo(codigo_aux);
            moneda.setNombre("Libra");
            moneda.setCambio(BigDecimal.ONE);
            moneda.setIdempresa(41L);
            monedas.add(moneda);
        } 
        dataLink.persist(monedas);
        monedas = dataLink.findListByQuery("select o from Moneda o where nombre = 'Libra'", null);
        for (int i = 0; i < 5; i++){
           monedas.get(i).setNombre("Mexicanos"); 
        }
        IDataResult dataResult = dataLink.merge(monedas);
        List<IDataRow> monedasResult = dataResult.getRowsUpdated();
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
        assertTrue(monedasResult.get(0).getErrors().isEmpty());
        dataLink.remove(monedasResult);
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
        moneda.setCodigo("PYG");
        moneda.setNombre("Dòlares varios");
        moneda.setCambio(BigDecimal.ONE);
        moneda.setIdempresa(41L);
        //moneda.setDecimalpoint(Short.MIN_VALUE);
        
        IDataResult dataResult = dataLink.persist(moneda);
        Moneda monedaResult = dataResult.getRowUpdated();
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
        dataLink.remove(monedaResult);
    }
    @Test
    public void testRemoveListMoneda() throws Exception{
        System.out.println("testRemoveListMoneda");
        if (error != null) {
            System.out.println(error);
            return;
        }
        String codigo_aux;
        List<Moneda> monedas = new ArrayList();
        String[] v_codigo = {"AUD","ARG","RUB","MXN","BTC"};
        for (int i = 0; i < 5; i++) {
            codigo_aux = v_codigo[i];
            Moneda moneda = new Moneda();
            moneda.setCodigo(codigo_aux);
            moneda.setNombre("Dòlares varios");
            moneda.setCambio(BigDecimal.ONE);
            moneda.setIdempresa(41L);
            monedas.add(moneda);
        }
        //Remove
        IDataResult dataResult = dataLink.persist(monedas);
        List<IDataRow> monedasResult = dataResult.getRowsUpdated();
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
        dataLink.remove(monedasResult);
    }   
    @Test
    public void testUpdateMoneda() throws Exception 
    {
        System.out.println("Test Moneda Update");
        if (error != null) {
            System.out.println(error);
            return; 
        }
        //Persist
        Moneda moneda = new Moneda();
        moneda.setCodigo("PYG");
        moneda.setNombre("Dòlares varios");
        moneda.setCambio(BigDecimal.ONE);
        moneda.setIdempresa(41L);
        moneda.setAction(IDataRow.INSERT);
        dataLink.update(moneda);
        
        //Merge
        moneda = dataLink.findByQuery("select o from Moneda o where nombre='Dòlares varios'", null);
        moneda.setNombre("Peso");
        moneda.setAction(IDataRow.UPDATE);
        dataLink.update(moneda);
        
        //Remove
        moneda.setAction(IDataRow.DELETE);
        
        IDataResult dataResult = dataLink.update(moneda);
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
    }
    @Test
    public void testUpdateListMoneda() throws Exception{
        System.out.println("testUpdateListMoneda");
        if (error != null) {
            System.out.println(error);
            return;
        }
        //Insertar
        String codigo_aux;
        List<Moneda> monedas = new ArrayList();
        String[] v_codigo = {"AUD","ARG","RUB","MXN","BTC"};
        for (int i = 0; i < 5; i++) {
            codigo_aux = v_codigo[i];
            Moneda moneda = new Moneda();
            moneda.setCodigo(codigo_aux);
            moneda.setNombre("Dòlares varios");
            moneda.setCambio(BigDecimal.ONE);
            moneda.setIdempresa(41L);
            moneda.setAction(IDataRow.INSERT);
            monedas.add(moneda);
        }
        dataLink.update(monedas);
        //Merge
        monedas = dataLink.findListByQuery("select o from Moneda o where nombre = 'Dòlares varios'", null);
        for (int i = 0; i < 5; i++) {
            monedas.get(i).setNombre("pesos mexicanos");
            monedas.get(i).setAction(IDataRow.UPDATE);
        }
        dataLink.update(monedas);
        
        //Remove
        for (int i = 0; i < 5; i++) {
            monedas.get(i).setAction(IDataRow.DELETE);
        }
        dataLink.update(monedas);
        IDataResult dataResult = dataLink.update(monedas);
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
       
    }   
    @Test
    public void testUpdateMonedaDataObject() throws NamingException, SessionError, Exception {
        System.out.println("testUpdatePaisDataObject");
        //No hubo conexión con el servidor de aplicaciones
        if (error != null) {
            System.out.println(error);
            return;
        }
        
        //Moneda
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

        //Pais
        IDataObject pais = new DataObject(Pais.class, null, dataLink, null);
        pais.open();
        pais.insertRow();
        pais.setField("codigo", "119");
        pais.setField("nombre", "Brasil");
        pais.setField("region", region.getRow());
        pais.setField("region", moneda.getRow());

        IDataSet dataSet = new DataSet();
        dataSet.addDataObject("region", region);
        dataSet.addDataObject("pais", pais);
        
        boolean result = dataLink.update(dataSet).isSuccessFul();
        System.out.println(result);
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
