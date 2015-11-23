package org.opendaylight.iotdm.client.command.impl;

import org.opendaylight.iotdm.client.Request;
import org.opendaylight.iotdm.client.api.Client;
import org.opendaylight.iotdm.client.command.ExecutableFactory;
import org.opendaylight.iotdm.client.command.api.Executable;
import org.opendaylight.iotdm.client.command.api.Argument;
import org.opendaylight.iotdm.client.impl.Coap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenxshi on 11/17/15.
 */
public class CoapExecutable implements Executable {
    public final static String NAME = "coap";
    private Request request;
    private Client client;

    private CoapExecutable(){
        request=new Request();
        client=new Coap();
    }

    static {
        ExecutableFactory.register(NAME, new CoapExecutable());
    }

    public void execute(List<Argument> arguments) {
        
        
    }

    public Executable create() {
        return new CoapExecutable();
    }
}
