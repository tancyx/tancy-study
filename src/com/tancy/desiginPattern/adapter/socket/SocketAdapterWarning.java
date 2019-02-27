package com.tancy.desiginPattern.adapter.socket;

/**
 * @author tancy
 * @description description
 * @date 2019/2/27 12:55
 **/
public class SocketAdapterWarning implements SocketAdapter {
    private SocketAdapter sa;

    public SocketAdapterWarning(SocketAdapter sa) {
        this.sa = sa;
    }

    @Override
    public void chargeProtec() {
        System.out.println("警报声");
        sa.chargeProtec();
    }
}
