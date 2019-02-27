package com.tancy.desiginPattern.adapter.socket;

/**
 * @author tancy
 * @description description
 * @date 2019/2/27 12:20
 **/
public class SocketAdapterElectri implements SocketAdapter {

    private SocketAdapter sa;

    public SocketAdapterElectri(SocketAdapter sa) {
        this.sa = sa;
    }

    @Override
    public void chargeProtec() {
        System.out.println("电涌保护");
        sa.chargeProtec();
    }
}
