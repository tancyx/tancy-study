package com.tancy.desiginPattern.adapter.socket;

/**
 * @author tancy
 * @description description
 * @date 2019/2/27 12:53
 **/
public class SocketAdapterLamp implements SocketAdapter {

    private SocketAdapter sa;

    public SocketAdapterLamp(SocketAdapter sa) {
        this.sa = sa;
    }

    @Override
    public void chargeProtec() {
        System.out.println("指示灯");
        sa.chargeProtec();
    }
}
