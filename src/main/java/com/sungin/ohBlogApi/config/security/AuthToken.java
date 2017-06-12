package com.sungin.ohBlogApi.config.security;

import com.sungin.ohBlogApi.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.codec.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hwangseong-in on 2017. 6. 6..
 */
public class AuthToken {
    private static final Logger logger = LoggerFactory.getLogger(AuthToken.class);
    private static final String AUTH_KEY = "SUNGIN";
    private static final long EXPIRES_TIME = 1000L * 60 * 4; // 4시간


    public static String create(UserVO userVO) {

        // 인증토크 유효시간.
        long expires = System.currentTimeMillis() + EXPIRES_TIME;

        StringBuilder tokenBuilder = new StringBuilder();
        tokenBuilder.append(userVO.getUsername());
        tokenBuilder.append(":");
        tokenBuilder.append(expires);
        tokenBuilder.append(":");
        tokenBuilder.append(AuthToken.computeSignature(userVO, expires));

        return tokenBuilder.toString();
    }


    public static String computeSignature(UserVO userVO, long expires) {
        StringBuilder signatureBuilder = new StringBuilder();
        signatureBuilder.append(userVO.getUsername());
        signatureBuilder.append(":");
        signatureBuilder.append(expires);
        signatureBuilder.append(":");
        signatureBuilder.append(userVO.getPassword());
        signatureBuilder.append(":");
        signatureBuilder.append(AuthToken.AUTH_KEY);

        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 algorithm is not available!");
        }

        return new String(Hex.encode(digest.digest(signatureBuilder.toString().getBytes())));
    }


    public static String getUserName(String authToken) {
        if (null == authToken) return null;

        String[] parts = authToken.split(":");
        return parts[0];
    }


    public static boolean validate(String authToken, UserVO userVO) {
        String[] parts = authToken.split(":");
        long now = System.currentTimeMillis();
        long expires = Long.parseLong(parts[1]);
        String signature = parts[2];

        if (logger.isDebugEnabled()) {
            logger.debug("인증토큰 유효시간: (" + expires + " / " + now + ")");
        }

        if (expires < now) {
            logger.error("인증토큰 유효시간이 만료되었습니다. (" + expires + " / " + now + ")");
            return false;
        }

        return signature.equals(AuthToken.computeSignature(userVO, expires));
    }
}
