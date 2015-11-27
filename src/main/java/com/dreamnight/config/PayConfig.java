package com.dreamnight.config;

import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfFile;

@Service
@DisconfFile(filename = "payconfig.xml")
public class PayConfig {

}
