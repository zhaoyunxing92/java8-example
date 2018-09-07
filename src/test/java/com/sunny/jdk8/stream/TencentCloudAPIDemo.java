/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.jdk8.stream;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.Sign;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.cvm.v20170312.CvmClient;
import com.tencentcloudapi.cvm.v20170312.models.DescribeZonesRequest;
import com.tencentcloudapi.cvm.v20170312.models.DescribeZonesResponse;
import com.tencentcloudapi.vpc.v20170312.VpcClient;
import com.tencentcloudapi.vpc.v20170312.models.CreateAddressTemplateGroupRequest;
import com.tencentcloudapi.vpc.v20170312.models.CreateAddressTemplateGroupResponse;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.jdk8.stream.TencentCloudAPIDemo
 * @date: 2018-09-04 12:31
 * @des:
 */
public class TencentCloudAPIDemo {
    private final static String CHARSET = "UTF-8";

    public static String sign(String s, String key, String method) throws Exception {
        Mac mac = Mac.getInstance(method);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(CHARSET), mac.getAlgorithm());
        mac.init(secretKeySpec);
        byte[] hash = mac.doFinal(s.getBytes(CHARSET));
        return DatatypeConverter.printBase64Binary(hash);
    }

    public static String getStringToSign(TreeMap<String, Object> params) {
        StringBuilder s2s = new StringBuilder("GETvpc.tencentcloudapi.com/?");
        // 签名时要求对参数进行字典排序，此处用TreeMap保证顺序
        for (String k : params.keySet()) {
            s2s.append(k).append("=").append(params.get(k).toString()).append("&");
        }
        return s2s.toString().substring(0, s2s.length() - 1);
    }

    public static String getUrl(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder url = new StringBuilder("https://vpc.tencentcloudapi.com/?");
        // 实际请求的url中对参数顺序没有要求
        for (String k : params.keySet()) {
            // 需要对请求串进行urlencode，由于key都是英文字母，故此处仅对其value进行urlencode
            url.append(k).append("=").append(URLEncoder.encode(params.get(k), CHARSET)).append("&");
        }
        return url.toString().substring(0, url.length() - 1);
    }

    public static void main(String[] args) throws Exception {
        Map<String, String> params = new TreeMap<>(); // TreeMap可以自动排序
        // 实际调用时应当使用随机数，例如：params.put("Nonce", new Random().nextInt(java.lang.Integer.MAX_VALUE));
        //        params.put("Nonce", String.valueOf(Math.abs(new Random().nextInt())));
        //        params.put("Timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        //        // 实际调用时应当使用系统当前时间，例如：   params.put("Timestamp", System.currentTimeMillis() / 1000);
        //        //  params.put("Timestamp", System.currentTimeMillis() / 1000); // 公共参数
        //        params.put("SecretId", "AKIDoX7WjlTfcCetvm4uCNNB7uWzZ0FIapJe"); // 公共参数
        //        params.put("Action", "CreateAddressTemplateGroup"); // 公共参数
        //        params.put("Version", "2017-03-12"); // 公共参数
        //        params.put("Region", "ap-shanghai"); // 公共参数
        params.put("AddressTemplateGroupName", "Test"); // 业务参数
        params.put("AddressTemplateIds.0", "ipm-ic0j8q7k"); // 业务参数
        //        params.put("InstanceIds.0", "ins-09dx96dg"); // 业务参数
        //params.put("Signature", sign(getStringToSign(params), "HtQnxylMlyylQxJTYDl9LMbGpDRSGvPj", "HmacSHA256")); // 公共参数
        params.put("Signature", formatRequestData("CreateAddressTemplateGroup", params)); // 公共参数
        System.out.println(getUrl(params));


        //        try {
        //            // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey
        //            Credential cred = new Credential("AKIDoX7WjlTfcCetvm4uCNNB7uWzZ0FIapJe", "HtQnxylMlyylQxJTYDl9LMbGpDRSGvPj");
        //
        //            // 实例化要请求产品(以cvm为例)的client对象
        //            VpcClient client = new VpcClient(cred, "ap-shanghai");
        //            // 实例化一个请求对象
        //            CreateAddressTemplateGroupRequest request = new CreateAddressTemplateGroupRequest();
        //            request.setAddressTemplateGroupName("Test");
        //            request.setAddressTemplateIds(new String[]{"ipm-ic0j8q7k"});
        //
        //            // 通过client对象调用想要访问的接口，需要传入请求对象
        //            CreateAddressTemplateGroupResponse resp = client.CreateAddressTemplateGroup(request);
        //
        //            // 输出json格式的字符串回包
        //            System.out.println(DescribeZonesRequest.toJsonString(resp));
        //        } catch (TencentCloudSDKException e) {
        //            System.out.println(e.toString());
        //        }


    }

    private static String formatRequestData(String action, Map<String, String> param) throws TencentCloudSDKException {

        param.put("Action", action);
        param.put("Nonce", String.valueOf(Math.abs(new Random().nextInt())));
        param.put("Timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        param.put("Version", "2017-03-12");
        param.put("SecretId", "AKIDoX7WjlTfcCetvm4uCNNB7uWzZ0FIapJe");
        param.put("Region", "ap-shanghai");

        String sigInParam = Sign.makeSignPlainText(new TreeMap<>(param),
                "", "", "/");
        String sigOutParam = Sign.sign("HtQnxylMlyylQxJTYDl9LMbGpDRSGvPj", sigInParam, "HmacSHA256");


        String strParam = "";
        try {
            for (Map.Entry<String, String> entry : param.entrySet()) {
                strParam += (URLEncoder.encode(entry.getKey(), "utf-8") + "=" +
                        URLEncoder.encode(entry.getValue(), "utf-8") + "&");
            }
            strParam += ("Signature=" + URLEncoder.encode(sigOutParam, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            throw new TencentCloudSDKException(e.getMessage());
        }
        return strParam;
    }
}
