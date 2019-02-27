package com.tancy.desiginPattern.adapter.socket;

/**
 * @author tancy
 * @description description
 * @date 2019/2/27 12:22
 **/
public class TwoSocketGeneral implements TwoSocket {
    @Override
    public void charge() {
        System.out.println("使用双头插座充电");
    }
}
