/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.javabeanstack.data.IDataResult;
import org.javabeanstack.data.IDataRow;
import org.javabeanstack.data.IDataSet;
import org.javabeanstack.data.model.DataSet;
import org.javabeanstack.datactrl.DataObject;
import org.javabeanstack.datactrl.IDataObject;
import org.javabeanstack.exceptions.SessionError;
import org.javabeanstack.model.tables.Moneda;
import org.javabeanstack.model.tables.Pais;
import org.javabeanstack.model.tables.Region;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jean
 */
public class PaisTest extends TestClass {

    public PaisTest() {
    }

    /**
     * Test of getIdregion method, of class Region.
     */
    @Test
    public void testPersistPais() throws Exception{
        System.out.println("testPersistPais");
        if (error != null) {
            System.out.println(error);
            return;
        }
        //Persist
        //Moneda
        Moneda moneda;
        moneda = dataLink.findByQuery("select o from Moneda o where idmoneda = 248", null);
        //Region
        Region region;
        region = dataLink.findByQuery("select o from Region o where idregion = 228", null);
        //Pais
        Pais pais = new Pais();
        pais.setCodigo("119");
        pais.setFechamodificacion(new Date());
        pais.setLatitud(BigDecimal.TEN);
        pais.setLongitud(BigDecimal.ONE);
        pais.setNoedit(Boolean.FALSE);
        pais.setNombre("Argentina");
        pais.setIdempresa(Long.parseLong("41"));
        pais.setRegion(region);
        pais.setMoneda(moneda);
        IDataResult dataResult = dataLink.persist(pais);
        Pais paisResult = dataResult.getRowUpdated();
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
        dataLink.remove(paisResult);
    }

    @Test
    public void testPersistListPais() throws Exception {
        System.out.println("testPersistListPais");
        if (error != null) {
            System.out.println(error);
            return;
        }
        //Moneda
        Moneda moneda;
        moneda = dataLink.findByQuery("select o from Moneda o where idmoneda = 248", null);
        //Region
        Region region;
        region = dataLink.findByQuery("select o from Region o where idregion = 228", null);
        List<Pais> paises = new ArrayList();
        //Persist
        for (int i = 0; i < 5; i++) {
            Pais pais = new Pais();
            pais.setCodigo("11"+(i+5));
            pais.setFechamodificacion(new Date());
            pais.setLatitud(BigDecimal.TEN);
            pais.setIdempresa(Long.parseLong("41"));
            pais.setLongitud(BigDecimal.ONE);
            pais.setNoedit(Boolean.FALSE);
            pais.setNombre("Paraguay");
            pais.setRegion(region);
            pais.setMoneda(moneda);
            paises.add(pais);
        }
        IDataResult dataResult = dataLink.persist(paises);
        List<IDataRow> paisesResult = dataResult.getRowsUpdated();
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
        dataLink.remove(paisesResult);
    }

    @Test
    public void testMergePais() throws Exception {
        System.out.println("testMergePais");
        if (error != null) {
            System.out.println(error);
            return;
        }
        //Moneda
        Moneda moneda;
        moneda = dataLink.findByQuery("select o from Moneda o where idmoneda = 248", null);
        //Merge
        Region region;
        region = dataLink.findByQuery("select o from Region o where idregion = 228", null);
        Pais pais = new Pais();
        pais.setCodigo("119");
        pais.setFechamodificacion(new Date());
        pais.setLatitud(BigDecimal.TEN);
        pais.setNoedit(Boolean.FALSE);
        pais.setIdempresa(Long.parseLong("41"));
        pais.setLongitud(BigDecimal.ONE);
        pais.setNombre("Argentina");
        pais.setRegion(region);
        pais.setMoneda(moneda);
        dataLink.persist(pais);
        pais = dataLink.findByQuery("select o from Pais o where codigo = '119'", null);
        pais.setNombre("Perú");
        IDataResult dataResult = dataLink.merge(pais);
        Pais paisResult = dataResult.getRowUpdated();
        //String nombre = "Argentina";
        //assertEquals(nombre, paisResultado.getNombre());
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
        dataLink.remove(paisResult);
    }

    @Test
    public void testMergeListPais() throws Exception {
        System.out.println("testMergeListPais");
        if (error != null) {
            System.out.println(error);
            return;
        }
        Region region;
        region = dataLink.findByQuery("select o from Region o where idregion = 228", null);
        //Moneda
        Moneda moneda;
        moneda = dataLink.findByQuery("select o from Moneda o where idmoneda = 248", null);
        List<Pais> paises = new ArrayList();
        //Persist
        for (int i = 0; i < 5; i++) {
            Pais pais = new Pais();
            pais.setCodigo("11"+(i+5));
            pais.setFechamodificacion(new Date());
            pais.setLatitud(BigDecimal.TEN);
            pais.setNoedit(Boolean.FALSE);
            pais.setIdempresa(Long.parseLong("41"));
            pais.setLongitud(BigDecimal.ONE);
            pais.setNombre("Argentina");
            pais.setMoneda(moneda);
            pais.setRegion(region);
            paises.add(pais);
        }
        dataLink.persist(paises);
        paises = dataLink.findListByQuery("select o from Pais o where nombre='Argentina'", null);
        for (int i = 0; i < 5; i++) {
            paises.get(i).setNombre("Mexicanos");
        }
        //Merge
        dataLink.merge(paises);
        /*for (int i = 0; i < 5; i++) {
            assertTrue(paises.get(i).getCodigo().equals("11"+(i+5)));
        }*/
        IDataResult dataResult = dataLink.merge(paises);
        List<IDataRow> paisesResult = dataResult.getRowsUpdated();
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
        dataLink.remove(paisesResult);
    }

    @Test
    public void testRemovePais() throws Exception {
        System.out.println("testRemovePais");
        if (error != null) {
            System.out.println(error);
            return;
        }
        //Region
        Region region;
        region = dataLink.findByQuery("select o from Region o where idregion = 228", null);
        //Moneda
        Moneda moneda;
        moneda = dataLink.findByQuery("select o from Moneda o where idmoneda = 248", null);
        //Remove
        Pais pais = new Pais();
        pais.setCodigo("119");
        pais.setFechamodificacion(new Date());
        pais.setLatitud(BigDecimal.TEN);
        pais.setNoedit(Boolean.FALSE);
        pais.setIdempresa(Long.parseLong("41"));
        pais.setLongitud(BigDecimal.ONE);
        pais.setNombre("Argentina");
        pais.setMoneda(moneda);
        pais.setRegion(region);
        
        IDataResult dataResult = dataLink.persist(pais);
        Pais paisResult = dataResult.getRowUpdated();
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
        dataLink.remove(paisResult);
        /*
        dataLink.remove(pais);
        List<Object> queryPais = dataLink.findByNativeQuery("select * from {schema}.pais where nombre = 'Argentina'", null);
        assertTrue(queryPais.isEmpty());*/
    }
    @Test
    public void testRemoveListPais() throws Exception {
        System.out.println("testRemoveListPais");
        if (error != null) {
            System.out.println(error);
            return;
        }
        //Region
        Region region;
        region = dataLink.findByQuery("select o from Region o where idregion = 228", null);
        //Moneda
        Moneda moneda;
        moneda = dataLink.findByQuery("select o from Moneda o where idmoneda = 248", null);
        List<Pais> paises = new ArrayList();
        //Persist
        for (int i = 0; i < 5; i++) {
            Pais pais = new Pais();
            pais.setCodigo("115");
            pais.setFechamodificacion(new Date());
            pais.setLongitud(BigDecimal.ONE);
            pais.setLatitud(BigDecimal.TEN);
            pais.setNoedit(Boolean.FALSE);
            pais.setIdempresa(Long.parseLong("41"));
            pais.setNombre("Paraguay");
            pais.setMoneda(moneda);
            pais.setRegion(region);
            paises.add(pais);
        }
        //Remove
        dataLink.persist(paises);
        IDataResult dataResult = dataLink.persist(paises);
        paises = dataResult.getRowsUpdated();
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
        dataLink.remove(paises);
    }

    @Test
    public void testUpdatePais() throws Exception {
        System.out.println("testUpdatePais");
        
        if (error != null) {
            System.out.println(error);
            return;
        }
        //Region
        Region region;
        region = dataLink.findByQuery("select o from Region o where idregion = 228", null);
        //Moneda
        Moneda moneda;
        moneda = dataLink.findByQuery("select o from Moneda o where idmoneda = 248", null);
        //Update
        Pais pais = new Pais();
        pais.setCodigo("119");
        pais.setFechamodificacion(new Date());
        pais.setLatitud(BigDecimal.TEN);
        pais.setNoedit(Boolean.FALSE);
        pais.setIdempresa(Long.parseLong("41"));
        pais.setLongitud(BigDecimal.ONE);
        pais.setNombre("Argentina");
        pais.setMoneda(moneda);
        pais.setRegion(region);
        pais.setAction(IDataRow.INSERT);
        dataLink.update(pais);
        //Merge
        pais = dataLink.findByQuery("select o from Pais o where codigo = '119'", null);
        pais.setNombre("Brasil");
        pais.setAction(IDataRow.UPDATE);
        dataLink.update(pais);
        
        //Remove
        pais.setAction(IDataRow.DELETE);
        dataLink.update(pais);
        
        IDataResult dataResult = dataLink.update(pais);
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
        /*assertEquals(expPais, pais.getNombre());
        dataLink.remove(pais);*/
    }
    @Test
    public void testUpdateListPais() throws Exception {
        System.out.println("testRemoveListPais");
        if (error != null) {
            System.out.println(error);
            return;
        }
        //Region
        Region region;
        region = dataLink.findByQuery("select o from Region o where idregion = 228", null);
        //Moneda
        Moneda moneda;
        moneda = dataLink.findByQuery("select o from Moneda o where idmoneda = 248", null);
        List<Pais> paises = new ArrayList();
        //Persist
        for (int i = 0; i < 5; i++) {
            Pais pais = new Pais();
            pais.setCodigo("115");
            pais.setFechamodificacion(new Date());
            pais.setIdempresa(Long.parseLong("41"));
            pais.setLatitud(BigDecimal.TEN);
            pais.setLongitud(BigDecimal.ONE);
            pais.setNoedit(Boolean.FALSE);
            pais.setNombre("Argentina");
            pais.setMoneda(moneda);
            pais.setRegion(region);
            pais.setAction(IDataRow.INSERT);
            paises.add(pais);
        }
        dataLink.update(paises);
        
        //Merge
        paises = dataLink.findByQuery("select o from Pais o where nombre = 'Argentina'", null);
        for (int i = 0; i < 5; i++) {
            paises.get(i).setNombre("Mexicanos");
            paises.get(i).setAction(IDataRow.UPDATE);
        }
        dataLink.update(paises);
        
        for (int i = 0; i < 5; i++) {
            paises.get(i).setAction(IDataRow.DELETE);
        }
        dataLink.update(paises);
        IDataResult dataResult = dataLink.update(paises);
        System.out.println(dataResult.getErrorMsg());
        assertTrue(dataResult.isSuccessFul());
    }
    
    @Test
    public void testUpdatePaisDataObject() throws NamingException, SessionError, Exception {
        System.out.println("testUpdatePaisDataObject");
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

        //pais
        IDataObject pais = new DataObject(Pais.class, null, dataLink, null);
        pais.open();
        pais.insertRow();
        pais.setField("codigo", "119");
        pais.setField("nombre", "Paraguay");
        pais.setField("region", region.getRow());

        IDataSet dataSet = new DataSet();
        dataSet.addDataObject("region", region);
        dataSet.addDataObject("pais", pais);

        boolean result = dataLink.update(dataSet).isSuccessFul();
        assertTrue(result);
    }

    @Test
    public void testDeletePaisDataObject() throws NamingException, SessionError, Exception {
        System.out.println("testDeletePaisDataObject");
        boolean resultado;
        //No hubo conexión con el servidor de aplicaciones
        if (error != null) {
            System.out.println(error);
            return;
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
