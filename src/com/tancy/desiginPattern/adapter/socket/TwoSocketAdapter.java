package com.tancy.desiginPattern.adapter.socket;

/**
 * @author tancy
 * @description description
 * @date 2019/2/27 12:25
 **/
public class TwoSocketAdapter implements ThreeSocket,SocketAdapter {

    private TwoSocket ts;

    public TwoSocketAdapter(TwoSocket ts) {
        this.ts=ts;
    }

    @Override
    public void charge() {
        chargeProtec();
    }

    @Override
    public void chargeProtec() {
        ts.charge();
    }
}
