package org.opendaylight.iotdm.client.impl;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.opendaylight.iotdm.client.api.Client;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HttpsIT {

    // It is possible to pass obfuscated password
    private static final String TRUST_STORE_PASSWORD = "OBF:1ytc1yf21vgz1rqa1z0f1roc1vfv1yf41yta"; //"trustPass";
    private static final String TRUST_STORE_LOCATION = "src/test/java/org/opendaylight/iotdm/client/certs/trust.jks";

    static Client client = new Https(TRUST_STORE_LOCATION, TRUST_STORE_PASSWORD);
    ITCase itCase = new ITCase(client, RestConf.HOST, 8484, 1000);

    @BeforeClass
    public static void suitUp() {
        ITCase.suitUp(RestConf.HOST);
        client.start();
    }

    @AfterClass
    public static void suitDown() {
        client.stop();
        ITCase.suitDown(RestConf.HOST);
    }

    @Test
    public void test_01_create_ae() {
        itCase.create_ae();
    }

    @Test
    public void test_02_update_ae() {
        itCase.update_ae();
    }

    @Test
    public void test_03_retrieve_ae() {
        itCase.retrieve_ae();
    }

    @Test
    public void test_04_delete_ae() {
        itCase.delete_ae();
    }
}
