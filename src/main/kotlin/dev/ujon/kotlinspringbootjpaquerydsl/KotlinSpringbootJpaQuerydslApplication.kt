package dev.ujon.kotlinspringbootjpaquerydsl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class KotlinSpringbootJpaQuerydslApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringbootJpaQuerydslApplication>(*args)
}
