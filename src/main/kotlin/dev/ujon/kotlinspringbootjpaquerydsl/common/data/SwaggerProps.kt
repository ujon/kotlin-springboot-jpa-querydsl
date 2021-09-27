package dev.ujon.kotlinspringbootjpaquerydsl.common.data

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "swagger")
@ConstructorBinding
data class SwaggerProps(
    val title: String,
    val desc: String,
    val version: String
)
