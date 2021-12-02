package Java设计模式.创建型设计模式.工厂模式;

/**
 * @Author: ruan
 * Date: 2021/12/2 14:40
 * @Description: 简单支付工厂类
 */
public class SimplePayFactory {
    /**
     * 根据支付参数返回支付对象
     * @param payType
     * @return
     */
    public static Pay createPay(String payType){
        if (payType == null){
            return null;
        }else if (payType.equalsIgnoreCase("WECHAT PAY")){
            return new WeChatPay();
        }else if (payType.equalsIgnoreCase("ALI PAY")){
            return new AliPay();
        }
        return null;
    }
}
