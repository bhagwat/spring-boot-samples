package com

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class YamlConfig {
    @Value('${app.name}')
    String appName

    @Value('${server.port}')
    Integer port
}
