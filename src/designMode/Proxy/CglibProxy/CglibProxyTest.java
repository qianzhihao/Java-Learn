package designMode.Proxy.CglibProxy;

import designMode.Proxy.StaticProxy.BuyHouse;
import designMode.Proxy.StaticProxy.BuyHouseImpl;

/**
 * @author qianzhihao
 * @description CGLIB测试类
 * @date 20190110
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        BuyHouse buyHouse = new BuyHouseImpl();
        CglibProxy cglibProxy = new CglibProxy();
        BuyHouseImpl buyHouseCglibProxy = (BuyHouseImpl)cglibProxy.getInstance(buyHouse);
        buyHouseCglibProxy.buyHouse();
    }
}
