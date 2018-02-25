package com.lh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/** 
 * 基于注解,相当于xml文件
 * @author liuhao
 * @date 2017-12-08 13:56:13
 */
@Configuration
@ComponentScan(basePackages= {"com.lh"})
public class ApplicationConfig {
	
}
