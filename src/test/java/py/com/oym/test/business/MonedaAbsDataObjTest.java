/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.oym.test.business;

import java.math.BigDecimal;
import javax.naming.NamingException;
import org.javabeanstack.data.IDataSet;
import org.javabeanstack.data.model.DataSet;
import org.javabeanstack.datactrl.DataObject;
import org.javabeanstack.datactrl.IDataObject;
import org.javabeanstack.exceptions.SessionError;
import org.junit.Test;
import static org.junit.Assert.*;
import org.javabeanstack.model.tables.Pais;
import org.javabeanstack.model.tables.Moneda;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static py.com.oym.test.business.TestClass.dataLink;

/**
 *
 * @author oym-dev07
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MonedaAbsDataObjTest extends TestClass {

    @Test
    public void test1AddDataMoneda() throws NamingException, SessionError, Exception {
        System.out.println("test1AddDataMoneda");
        if (error != null) {
            System.out.println(error);
            return;
        }
        //Moneda
        IDataObject moneda = new DataObject(Moneda.class, null, dataLink, null);
        moneda.open();
        if (!moneda.find("codigo", "MXN")) {
            moneda.insertRow();
            moneda.setField("codigo", "MXN");
            moneda.setField("nombre", "Mexicano");
            moneda.setField("cambio", BigDecimal.ONE);
            boolean resultado = moneda.update(false);
            System.out.println(moneda.getErrorMsg(true));
            assertTrue(resultado);
        } else {
            System.out.println("Ya existe en la base de datos");
        }
    }

    @Test
    public void test2DeleteDataMoneda() throws NamingException, SessionError, Exception {
        if (error != null) {
            System.out.println("test2DeleteDataMoneda");
            return;
        }
        boolean resultado;
        IDataObject moneda = new DataObject(Moneda.class, null, dataLink, null);
        moneda.open();
        if (moneda.find("codigo", "MXN")) {
            moneda.deleteRow();
            resultado = moneda.update(false);
            assertTrue(resultado);
            if (!resultado) {
                System.out.println(moneda.getErrorMsg(true));
            }
        }
    }
}
