package dev.kazusato.apidocsearch

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.security.SecurityScheme
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@SecurityScheme(name = "bearer_token", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
@OpenAPIDefinition(info = Info(title = "検索API", description = "書籍・雑誌の検索を行うためのAPIを提供します。"),
servers = [
	Server(url = "https://env1.example.com/", description = "環境1"),
	Server(url = "https://env2.example.com/", description = "環境2")
],
security = [SecurityRequirement(name = "bearer_token")])
class ApidocSearchApplication

fun main(args: Array<String>) {
	runApplication<ApidocSearchApplication>(*args)
}
