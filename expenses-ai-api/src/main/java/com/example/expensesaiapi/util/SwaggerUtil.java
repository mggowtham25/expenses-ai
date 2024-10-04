package com.example.expensesaiapi.util;


import com.example.expensesaiapi.constant.Constant;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.apache.hc.client5.http.utils.Hex;
import org.json.simple.JSONObject;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public final class SwaggerUtil {

    public static License OA_LICENSE = new License().name("Apache 2.0").url("http://www.apache.org/licenses/LICENSE-2.0");


    public static String encode(String key, String data)
            throws NoSuchAlgorithmException,
            InvalidKeyException {
        var sha256HMAC = Mac.getInstance(Constant.HMAC_ALGORITHM);
        var secret_key = new SecretKeySpec(
                key.getBytes(StandardCharsets.UTF_8), Constant.HMAC_ALGORITHM);
        sha256HMAC.init(secret_key);

        return Hex.encodeHexString(
                sha256HMAC.doFinal(data.getBytes(StandardCharsets.UTF_8)));
    }

    public static Contact getOpenApiContact() {

        var contact = new Contact();
        contact.setEmail("mggowtham25@gmail.com");
        contact.setName("Expenses AI.");

        return contact;
    }

    public static JSONObject getACLObject(String op, String trusteeId, Integer rights, boolean isInheritable) {

        var aclO = new JSONObject();
        aclO.put("op", op);
        aclO.put("trustee", trusteeId);
        aclO.put("rights", rights);
        if (isInheritable) {
            aclO.put("inheritable", isInheritable);
        }

        return aclO;
    }
}
