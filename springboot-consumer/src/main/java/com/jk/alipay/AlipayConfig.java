package com.jk.alipay;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101700706603";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "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";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyCTrRFXuVN77EOSC3jXyfX5Bj5pfq06lKHo6gDlzNAEaOFcSObKuzH8e1nPwCUjP4lDFvHcPbFcPaCvbASz02I5nEY4IYRbohxuBPLBSgucKXTuLBDzzPJjNHRJs+p0X9XyAxBlKll4j/N/ClXCNTXgHkglHZ2Kw6Wuzudnk4Ctn3DxHQdKaKeh/LOOfPPNEKhwYUmpeO1rACaYDwl1TB5adyKvvvUTDHwFa5hOWwdmMuOPCn+8+ya+4zkwKDa2zmZy8rNpemlnyPtAJ22NL8pJktdUJ9bXc0r6kKHxOf3sVgydpRGlC5J7XR1J4ouROQiaIzZme4isqg2J3lQxxUQIDAQAB+UDSOjBIU7UeGKIuUCHbc/0rg2XiumUNNfcbl2CETYd3jE2kKr3NOQyDq+IbPP88Xq67WgKjmkXx0CAkyyCK+S9IfZU5ncFe2B6CJmvTY3CTSAGjxUkwFJxM59da6dnVLEFmjWhLf7aLivpvVcRCw0DSNaMtBgbEQ4zm2PKczn2RRQN/ZtNCxTuiesxffJUp9v8rVQBrJ+a0WLEsvxd6PyhpSMXITBMqJber7GFVMw8U3LRWMSskZDFGIdzD351I7GntxCJwRA2JdhnDI/2pz3vhoIeUscbd0Z1HY5rlXZYayGqN7pp5+WINrBTEvlnqmW8LN5J3tVOn5ToXVQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://kyd.free.idcfengye.com/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://127.0.0.1:8888/returnUrl";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
