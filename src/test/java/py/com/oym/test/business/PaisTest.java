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
import org.javabeanstack.data.IDataSet;
import org.javabeanstack.data.model.DataSet;
import org.javabeanstack.datactrl.DataObject;
import org.javabeanstack.datactrl.IDataObject;
import org.javabeanstack.exceptions.SessionError;
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
    public void testPersistPais() throws Exception {
        System.out.println("testPersistPais");
        if (error != null) {
            System.out.println(error);
            return;
        }
        //Persist
        Pais pais = new Pais();
        pais.setCodigo("119");
        pais.setFechamodificacion(new Date());
        pais.setIdempresa(Long.MIN_VALUE);
        pais.setIdpais(Long.MAX_VALUE);
        pais.setLatitud(BigDecimal.TEN);
        pais.setNoedit(Boolean.FALSE);
        pais.setNombre("Argentina");
        IDataResult dataResult = dataLinkCat.persist(pais);
        Pais paisResultado = dataResult.getRowUpdated();
        assertEquals(pais.getCodigo(), paisResultado.getCodigo());
    }

    @Test
    public void testPersistListPais() throws Exception {
        System.out.println("testPersistListPais");
        if (error != null) {
            System.out.println(error);
            return;
        }
        List<Pais> paises = new ArrayList();
        //Persist
        for (int i = 0; i < 5; i++) {
            Pais pais = new Pais();
            pais.setCodigo("11"+(i+5));
            pais.setFechamodificacion(new Date());
            pais.setIdempresa(Long.MIN_VALUE);
            pais.setIdpais(Long.MAX_VALUE);
            pais.setLatitud(BigDecimal.TEN);
            pais.setNoedit(Boolean.FALSE);
            pais.setNombre("Paraguay");
            paises.add(pais);
        }
        dataLinkCat.persist(paises);
        String codigo = "117";
        assertTrue(paises.get(2).getCodigo().trim().equals(codigo));
    }

    @Test
    public void testMergePais() throws Exception {
        System.out.println("testMergePais");
        if (error != null) {
            System.out.println(error);
            return;
        }
        //Merge
        Pais pais = new Pais();
        pais.setCodigo("119");
        pais.setFechamodificacion(new Date());
        pais.setIdempresa(Long.MIN_VALUE);
        pais.setIdpais(Long.MAX_VALUE);
        pais.setLatitud(BigDecimal.TEN);
        pais.setNoedit(Boolean.FALSE);
        pais.setNombre("Argentina");
        dataLinkCat.persist(pais);
        IDataResult dataResult = dataLinkCat.merge(pais);
        Pais paisResultado = dataResult.getRowUpdated();
        assertEquals(pais.getCodigo(), paisResultado.getCodigo());
    }

    @Test
    public void testMergeListPais() throws Exception {
        System.out.println("testMergeListPais");
        if (error != null) {
            System.out.println(error);
            return;
        }
        List<Pais> paises = new ArrayList();
        //Persist
        for (int i = 0; i < 5; i++) {
            Pais pais = new Pais();
            pais.setCodigo("11"+(i+5));
            pais.setFechamodificacion(new Date());
            pais.setIdempresa(Long.MIN_VALUE);
            pais.setIdpais(Long.MAX_VALUE);
            pais.setLatitud(BigDecimal.TEN);
            pais.setNoedit(Boolean.FALSE);
            pais.setNombre("Paraguay");
            paises.add(pais);
        }
        //Merge
        dataLinkCat.merge(paises);
        for (int i = 0; i < 5; i++) {
            assertTrue(paises.get(i).getCodigo().equals("11"+(i+5)));
        }
    }

    @Test
    public void testRemovePais() throws Exception {
        System.out.println("testRemovePais");
        if (error != null) {
            System.out.println(error);
            return;
        }
        //Remove
        Pais pais = new Pais();
        pais.setCodigo("119");
        pais.setFechamodificacion(new Date());
        pais.setIdempresa(Long.MIN_VALUE);
        pais.setIdpais(Long.MAX_VALUE);
        pais.setLatitud(BigDecimal.TEN);
        pais.setNoedit(Boolean.FALSE);
        pais.setNombre("Argentina");
        dataLinkCat.persist(pais);
        dataLinkCat.remove(pais);
        List<Object> queryPais = dataLink.findByNativeQuery("select * from {schema}.pais where nombre = 'Argentina'", null);
        assertTrue(queryPais.isEmpty());
    }
    @Test
    public void testRemoveListPais() throws Exception {
        System.out.println("testRemoveListPais");
        if (error != null) {
            System.out.println(error);
            return;
        }
        List<Pais> paises = new ArrayList();
        //Persist
        for (int i = 0; i < 5; i++) {
            Pais pais = new Pais();
            pais.setCodigo("115");
            pais.setFechamodificacion(new Date());
            pais.setIdempresa(Long.MIN_VALUE);
            pais.setIdpais(Long.MAX_VALUE);
            pais.setLatitud(BigDecimal.TEN);
            pais.setNoedit(Boolean.FALSE);
            pais.setNombre("Paraguay");
            paises.add(pais);
        }
        //Remove
        dataLink.persist(paises);
        dataLink.remove(paises);
        paises = dataLink.findListByQuery("select o from Pais o where codigo='115'", null);
        assertTrue(paises.isEmpty());
    }

    @Test
    public void testUpdatePais() throws Exception {
        System.out.println("testUpdatePais");
        if (error != null) {
            System.out.println(error);
            return;
        }
        //Update
        Pais pais = new Pais();
        pais.setCodigo("119");
        pais.setFechamodificacion(new Date());
        pais.setIdempresa(Long.MIN_VALUE);
        pais.setIdpais(Long.MAX_VALUE);
        pais.setLatitud(BigDecimal.TEN);
        pais.setNoedit(Boolean.FALSE);
        pais.setNombre("Argentina");
        dataLinkCat.persist(pais);
        pais.setNombre("Brasil");
        dataLinkCat.update(pais);
        String expPais = "Brasil";
        assertEquals(expPais, pais.getNombre());
    }
    @Test
    public void testUpdateListPais() throws Exception {
        System.out.println("testRemoveListPais");
        if (error != null) {
            System.out.println(error);
            return;
        }
        List<Pais> paises = new ArrayList();
        //Persist
        for (int i = 0; i < 5; i++) {
            Pais pais = new Pais();
            pais.setCodigo("115");
            pais.setFechamodificacion(new Date());
            pais.setIdempresa(Long.MIN_VALUE);
            pais.setIdpais(Long.MAX_VALUE);
            pais.setLatitud(BigDecimal.TEN);
            pais.setNoedit(Boolean.FALSE);
            pais.setNombre("Paraguay");
            paises.add(pais);
        }
        //Update
        dataLink.update(paises);
        Pais pais = new Pais();
        pais.setNombre("Argentina");
        paises.add(pais);
        dataLink.update(paises);
        pais.setCodigo("115");
        paises.add(pais);
        dataLink.update(paises);
        paises = dataLink.findListByQuery("select o from Pais o where codigo='115'", null);
        assertTrue(paises.isEmpty());
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
