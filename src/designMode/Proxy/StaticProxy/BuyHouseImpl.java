package designMode.Proxy.StaticProxy;

import designMode.Proxy.StaticProxy.BuyHouse;

/**
 * @author qianzhihao
 * @Description 实现服务接口
 * @Date 2019/1/10
 */
public class BuyHouseImpl implements BuyHouse {

    @Override
    public void buyHouse() {
        System.out.println("I want to Buy a new House");
    }
}
