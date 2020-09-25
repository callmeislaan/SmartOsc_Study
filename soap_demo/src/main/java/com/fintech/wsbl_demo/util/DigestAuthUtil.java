package com.fintech.wsbl_demo.util;

import javax.xml.bind.DatatypeConverter;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DigestAuthUtil {
    public static String createNonce() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        return DatatypeConverter.printBase64Binary(bytes);
    }

    public static String createTimestamp() throws Exception {
        XMLGregorianCalendar now = null;
        DatatypeFactory xmlDatatypeFactory = DatatypeFactory.newInstance();
        now = xmlDatatypeFactory
                .newXMLGregorianCalendar(new GregorianCalendar(TimeZone
                        .getTimeZone("UTC")));
        return now.toXMLFormat();
    }

    public static String createDigest(String base64EncodedNonce, String utf8Timestamp,
                               String utf8password) throws Exception {
        MessageDigest md = null;

        // Ensure SHA-1 algorithm is supported
        md = MessageDigest.getInstance("SHA-1");

        // Decode the incoming Base64 encoded nonce
        byte[] decodedNonce = null;
        if (null != base64EncodedNonce) {

            decodedNonce = DatatypeConverter
                    .parseBase64Binary(base64EncodedNonce);

        }
        // Get the timestamp in bytes
        byte[] utf8BytesTimestamp = null;

        // the created date and utf8Timestamp are assumed to be utf-8 encoded
        utf8BytesTimestamp = utf8Timestamp.getBytes(StandardCharsets.UTF_8);

        // Get the password in bytes
        byte[] utf8BytesPassword = null;

        // the created date and utf8Timestamp are assumed to be utf-8 encoded
        utf8BytesPassword = utf8password.getBytes(StandardCharsets.UTF_8);

        // Update the digest with the byte arrays and then encode in base64
        // Hashing formula is: Base64( SHA-1( nonce + created + password ))
        md.update(decodedNonce);
        md.update(utf8BytesTimestamp);
        md.update(utf8BytesPassword);
        return DatatypeConverter.printBase64Binary(md.digest());
    }

    public static void main(String[] args) throws Exception {
        final String nonce = createNonce();
        String createTimestamp = createTimestamp();
        //Password_Digest = Base64 (SHA-1 (nonce + createtime + password))
        final String digest = createDigest(nonce, createTimestamp, "password");

        System.out.println(String.format("nonce: [%s], create: [%s], password digest: [%s]", nonce, createTimestamp, digest));
    }
}
