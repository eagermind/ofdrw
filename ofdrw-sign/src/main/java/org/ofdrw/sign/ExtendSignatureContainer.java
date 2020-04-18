package org.ofdrw.sign;


import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.ofdrw.core.signatures.SigType;

import java.io.InputStream;
import java.security.MessageDigest;

/**
 * 扩展数字签名容器
 *
 * @author 权观宇
 * @since 2020-04-18 12:09:57
 */
public interface ExtendSignatureContainer {

    /**
     * 提供文件的摘要算法功能
     *
     * @return 摘要算法功能
     */
    MessageDigest getDigestFnc();

    /**
     * 签名方法OID
     *
     * @return 签名方法OID
     */
    ASN1ObjectIdentifier getSignAlgOID();

    /**
     * 对待签名数据签名
     *
     * @param inData 待签名数据流
     * @return 签名或签章结果值
     */
    byte[] sign(InputStream inData);

    /**
     * 获取电子印章二进制编码
     * <p>
     * 如果{@link #getSignType()} 返还类型为{@link SigType#Sign}那么请返回null
     *
     * @return 电子印章二进制编码
     */
    byte[] getSeal();

    /**
     * 获取签名节点类型
     *
     * @return 签名节点类型
     */
    SigType getSignType();
}
