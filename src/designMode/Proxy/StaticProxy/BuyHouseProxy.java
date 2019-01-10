package designMode.Proxy.StaticProxy;

import designMode.Proxy.StaticProxy.BuyHouse;

/**
 * @author qianzhihao
 * @Description 创建代理类
 * @Date 2019/1/10
 */
public class BuyHouseProxy implements BuyHouse {

    private BuyHouse buyHouse;

    public BuyHouseProxy(final BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }

    @Override
    public void buyHouse() {
        System.out.println("PreWork of BuyHouse!");
        buyHouse.buyHouse();
        System.out.println("Decrate the House!");
    }
}
