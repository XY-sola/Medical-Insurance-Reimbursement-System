package org.xy.medicare.common.security.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description:
 * @author: XY-GYL
 * @time: 2022/5/5 8:30
 */

@Component
public class JwtTokenUtil {
    @Autowired
    private JwtConstBean myConfig;

    public String createToken(String userName) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + myConfig.getExpiration());
        return Jwts.builder().signWith(SignatureAlgorithm.HS512, myConfig.getSecret()) // 加密算法
                //.setClaims(map) // 自定义信息
                .setIssuer(myConfig.getIss()) // jwt发行人
                .setSubject(userName) // jwt面向的用户
                .setIssuedAt(now) // jwt发行时间
                .setExpiration(exp) // key过期时间
                .compact();
    }

    /**
     * 从token获取用户信息
     * @param token
     * @return
     */
    public String getUsername(String token) {
        return getTokenBody(token).getSubject();
    }

    /**
     * 从token中获取用户角色
     * @param token
     * @return
     */
    public String getUserRole(String token) {
        String role = (String)getTokenBody(token).get(myConfig.getRoleClaims());
        return role;
    }

    /**
     * 是否已过期
     *
     * @param token
     * @return
     */
    public boolean isExpiration(String token) {
        return getTokenBody(token).getExpiration().before(new Date());
    }

    private Claims getTokenBody(String token) {
        return Jwts.parser().setSigningKey(myConfig.getSecret()).parseClaimsJws(token).getBody();
    }
}
