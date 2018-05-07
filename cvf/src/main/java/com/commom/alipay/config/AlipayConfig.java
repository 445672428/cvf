package com.commom.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088301982950285";
	//商户收款账号
	public static final String SELLER = "yizhileyu@163.com";
	// 商户的私钥
	public static String private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKSSiH94+Ds5COQZ" +
	        "maybajoCvaUfyRi+BIHeBH2jZq6DZrXcw3/qCYwWXQhjXxwhwYQsmPOQ0nXFhiZq" +
	        "Qj8g9bExJCql4aGMnN6C/l2jKH1Ny3r8B9YwB+DQScGJWqfdU8/wMyBfZgCBMDhS" +
	        "SQn9IwpW45Tlx3FQPEu9wWhoeJC9AgMBAAECgYEAjSA7fVS3SdH3FeP+LE56IZUI" +
	        "G/nN8THBm7xQDY16GF0GTx4paB/CYCctUGwmu3EXCclUwEmIsQXZrEei14/kH9bN" +
	        "NgtcSdtKp+Za3LSPPFToi2hukmjFKWJ9QVpWez5HA6WqkR+zy+ZWyvQawU6E/MzT" +
	        "Tj3B5p5tyWUZvBIYueECQQDUgNACgbPr4leDE6WTj+xiDgN6MTP/niVNlbi81NGR" +
	        "kj1xztgBPlUHjHByF1h0wi7Hw4F1Mk8u1DhqqgmFWE2jAkEAxkIkoS14QJzG1xcN" +
	        "2Kk3OFFFbrKd2wh1+3B9vafPtv4Xqk/Fkde82RE1QmCa7u6QC2O7wdiQ8mnl+n0A" +
	        "A1rOHwJAeoBXaVqD8fNlJ3bn+Iz7Y/tYHdTHeRAdyQAKozC8LwLy0OzAsNbSBav8" +
	        "FolGwOhAN4CI3JrH8uL8MuEa4/fnqQJALBOEZTjgpSy1oBgGAgcMub6HuyaGpa1p" +
	        "3W6S5dkq+rnetQRrHhNibre+qXUkvL3Y1E9l7KCjCOG2OUwU9qn3bQJATBx3DJh5" +
	        "Vj4Dzq9h6vOWmNFb449b5MzSOfQiFoEq0mjWt/dYV6HlAV/EM7smDVe4aNz/ZIg8" +
	        "ah5wOVefUVGx5A==";
	
	// 支付宝的公钥，无需修改该值
	public static String ali_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "http://d3.java.shovesoft.com";//D:\\

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式 不需修改
	public static String sign_type = "RSA";

}
