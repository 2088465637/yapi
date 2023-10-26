package com.yuanchanglin.yapi.util;

import cn.hutool.core.codec.Base64;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    // 密钥
    public static final String SECRET = "SECRET";
    // 过期时间:小时
    public static final int EXPIRATION_TIME = 5;

    /**
     * 生成Token
     *
     * @param userId
//     * @param shopId
     * @return
     */
    public static String createToken(String userId) throws UnsupportedEncodingException {
        long endTime = System.currentTimeMillis() + EXPIRATION_TIME * 1000 * 60 * 60;
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                // 头
                .withHeader(map)
                .withClaim("userId", userId)
//                .withClaim("shopId", shopId)
                .withSubject("ycl")
                // 签名时间
                .withIssuedAt(new Date())
                // 过期时间
                .withExpiresAt(new Date(endTime))
                // 签名
                .sign(Algorithm.HMAC256(SECRET));
        byte[] encode = Base64.encode(token.getBytes("UTF-8"),false,false);
        return new String(encode, "UTF-8");
    }

    /**
     * 验证Token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String, Claim> verifyToken(String token) {
        byte[] decode = Base64.decode(token);
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt;
        try {
            jwt = verifier.verify(new String(decode, "UTF-8"));
        } catch (Exception e) {
            throw new RuntimeException("token已过期，请重新登录");
        }
        return jwt.getClaims();
    }

    /**
     * 解析Token
     *
     * @param token
     * @return
     */
    public static Map<String, Claim> parseToken(String token) throws UnsupportedEncodingException {
        byte[] decode = Base64.decode(token);
        DecodedJWT decodedJWT = JWT.decode(new String(decode, "UTF-8"));
        return decodedJWT.getClaims();
    }

    /**
     * 获取某个值
     * @param key
     * @param token
     * @return
     */
    public static String getVal(String key, String token) {
        return verifyToken(token).get(key).asString();
    }

}