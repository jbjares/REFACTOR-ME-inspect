package de.difuture.ekut.pht.inspect.props

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import java.net.URI

@Configuration
@ConfigurationProperties(prefix = "inspect.registry")
class InspectRegistryProperties {

    // The LocalTrain Registry that should be checked for new trains
    lateinit var uri: URI

    lateinit var username: String
    lateinit var password: String

    lateinit var namespace: String
}
