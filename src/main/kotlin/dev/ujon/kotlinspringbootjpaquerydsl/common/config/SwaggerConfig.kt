package dev.ujon.kotlinspringbootjpaquerydsl.common.config

import dev.ujon.kotlinspringbootjpaquerydsl.common.data.SwaggerProps
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class SwaggerConfig(
    val swaggerProps: SwaggerProps
) {
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.OAS_30)
            .select()
            .apis(RequestHandlerSelectors.basePackage("dev.ujon.kotlinspringbootjpaquerydsl.api"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo());
    }

    fun apiInfo(): ApiInfo? {

        return ApiInfoBuilder()
            .title(swaggerProps.title)
            .description(swaggerProps.desc)
            .version(swaggerProps.version)
            .build()
    }
}