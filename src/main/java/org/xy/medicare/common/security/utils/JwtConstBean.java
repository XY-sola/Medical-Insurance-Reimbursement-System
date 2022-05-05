package org.xy.medicare.common.security.utils;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: XY-GYL
 * @time: 2022/5/5 8:29
 */

@Component
@Getter
public class JwtConstBean {
    @Value("${token.header}")
    private String tokenHeader;
    @Value("${token.prefix}")
    private String tokenPrefix;
    @Value("${token.secret}")
    private String secret;
    @Value("${token.iss}")
    private String iss;
    @Value("${token.roleClaims}")
    private String roleClaims;
    @Value("${token.expiration}")
    private long expiration;
}
