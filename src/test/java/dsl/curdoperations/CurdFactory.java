package dsl.curdoperations;

import dsl.configuration.ProtocolFactory;

public class CurdFactory {
    public static CurdProtocol getProtocol(){
        return (CurdProtocol) ProtocolFactory.getInstance(CurdProtocol.class, "curdOperations");
    }
}
