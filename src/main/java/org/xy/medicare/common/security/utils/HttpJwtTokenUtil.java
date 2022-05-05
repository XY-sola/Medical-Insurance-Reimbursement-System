package org.xy.medicare.common.security.utils;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: XY-GYL
 * @time: 2022/5/5 8:28
 */

@Component
@Slf4j
public class HttpJwtTokenUtil {
    public static final String KEY_USERNAME = "userName";
    public static final String KEY_ROLE = "role";

    @Autowired
    private JwtConstBean jwtConfig;
    @Autowired
    private JwtTokenUtil jwtUtil;

    public Map<String, String> getUserNameByToken(HttpServletRequest request) {
        Map<String, String> userDetail = new HashMap<String, String>(2);
        final String requestTokenHeader = request.getHeader(jwtConfig.getTokenHeader());
        if (requestTokenHeader != null && requestTokenHeader.startsWith(jwtConfig.getTokenPrefix() + " ")) {
            String jwtToken = requestTokenHeader.substring(7);
            String userName = jwtUtil.getUsername(jwtToken);
            if (StrUtil.isEmpty(userName)) {
                return null;
            }
            userDetail.put(KEY_USERNAME, userName);
            userDetail.put(KEY_ROLE, jwtUtil.getUserRole(jwtToken));
            return userDetail;
        } else {
            return null;
        }
    }

    public String getRequestPostStr(HttpServletRequest request) {
        byte buffer[] = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        try {
            return new String(buffer, charEncoding);
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public byte[] getRequestPostBytes(HttpServletRequest request) {
        int contentLength = request.getContentLength();
        if (contentLength < 0) {
            return null;
        }
        byte buffer[] = new byte[contentLength];
        try {
            for (int i = 0; i < contentLength;) {
                int readlen;
                readlen = request.getInputStream().read(buffer, i, contentLength - i);
                if (readlen == -1) {
                    break;
                }
                i += readlen;
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return buffer;
    }
}
