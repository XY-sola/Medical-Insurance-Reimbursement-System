package org.xy.medicare.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @description:
 * @author: XY-GYL
 * @time: 2022/5/5 8:01
 */

@Configuration
@PropertySource(value = {"classpath:conf/conf.properties"})
public class PropertyConfig {
}
