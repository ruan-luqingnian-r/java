package Java设计模式.创建型设计模式.工厂模式;

/**
 * @Author: ruan
 * Date: 2021/12/2 14:37
 * @Description:
 */
public class WeChatPay implements Pay{

    @Override
    public void unifiedOrder() {
        System.out.println("此部分为微信支付流程");
    }
}
