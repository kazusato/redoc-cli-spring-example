package dev.kazusato.apidocsearch.dto

import io.swagger.v3.oas.annotations.media.Schema

data class ErrorInfo(
		@field:Schema(description = "エラーコード")
		val errorCode: String,
		@field:Schema(description = "エラーメッセージ")
		val message: String
)