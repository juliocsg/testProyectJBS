/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.business;

import javax.naming.NamingException;
import org.javabeanstack.data.IDataSet;
import org.javabeanstack.data.IGenericDAORemote;
import org.javabeanstack.data.model.DataSet;
import org.javabeanstack.datactrl.DataObject;
import org.javabeanstack.datactrl.IDataObject;
import org.javabeanstack.exceptions.SessionError;
import org.junit.Test;
import static org.junit.Assert.*;
import org.javabeanstack.model.tables.Pais;
import org.javabeanstack.model.tables.Region;
import static py.com.oym.test.business.TestClass.dataLink;

/**
 *
 * @author oym-dev07
 */
public class RegionAbsDataObjTest extends TestClass {

    private static IGenericDAORemote dao;

    @Test
    public void test1AddDataRegion() throws NamingException, SessionError, Exception 
    {
        System.out.println("test1AddDataRegion");
        if (error != null) {
            System.out.println(error);
            return; 
        }
        //Region
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.insertRow();
        region.setField("codigo", "PCF");
        region.setField("nombre", "Pacífico");
        DataSet dataSet = new DataSet();
        dataSet.addDataObject("region", region);
        boolean resultado = dataLink.update(dataSet).isSuccessFul();
        assertTrue(resultado);
    }
    @Test
    public void test2DeleteDataRegion() throws NamingException, SessionError, Exception{
        if (error != null){
            System.out.println("test2DeleteDataRegion");
            return;
        }
        boolean resultadoado;
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.find("codigo", "PCF");
        region.deleteRow();
        resultadoado = region.update(false);
        assertTrue(resultadoado);
        if (!resultadoado) {
            System.out.println(region.getErrorMsg(true));
        }
    }
    @Test
    public void test3AddDeleteDataRegionPais() throws NamingException, SessionError, Exception {
        System.out.println("test3AddDeleteDataRegionPais");
        //No hubo conexión con el servidor de aplicaciones
        if (error != null) {
            System.out.println(error);
            return;
        }
        //Region
        IDataObject region = new DataObject(Region.class, null, dataLink, null);
        region.open();
        region.insertRow();
        region.setField("codigo", "PCF");
        region.setField("nombre", "Pacífico");

        //Pais
        IDataObject pais = new DataObject(Pais.class, null, dataLink, null);
        pais.open();
        pais.insertRow();
        pais.setField("codigo", "124");
        pais.setField("nombre", "Perú");
        pais.setField("region", region.getRow());

        IDataSet dataSet = new DataSet();
        dataSet.addDataObject("region", region);
        dataSet.addDataObject("pais", pais);
        
        boolean resultado = dataLink.update(dataSet).isSuccessFul();
        System.out.println(resultado);
        assertTrue(resultado);
        
        pais.find("codigo", "124");
        pais.deleteRow();
        resultado = pais.update(false);
        if (!resultado) {
            System.out.println(pais.getErrorMsg(true));
        }
        region.find("codigo", "PCF");
        region.deleteRow();
        resultado = region.update(false);
        if (!resultado) {
            System.out.println(region.getErrorMsg(true));
        }
    }
}
