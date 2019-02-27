package com.tancy.desiginPattern.adapter.socket;

/**
 * @author tancy
 * @description description
 * @date 2019/2/27 12:56
 **/
public class Test {

    public static void main(String[] args) {
        ThreeSocket ts=new TwoSocketAdapter(new TwoSocketGeneral());
//        ts.charge();
        SocketAdapter sa0=new SocketAdapterElectri((TwoSocketAdapter) ts);
        SocketAdapter sa1=new SocketAdapterLamp(sa0);
//        SocketAdapter sa2=new SocketAdapterWarning(sa1);
//        sa0.chargeProtec();
        sa1.chargeProtec();
    }

}
