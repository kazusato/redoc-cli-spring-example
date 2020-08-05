package dev.kazusato.apidocsearch.dto

import io.swagger.v3.oas.annotations.media.Schema

data class SearchRequest(
		@field:Schema(description = "検索対象の種類を指定します。", required = true)
		val type: ItemType,
		@field:Schema(description = "検索キーワードを指定します。", required = true)
		val keywords: List<String>,
		@field:Schema(description = "検索時の条件を指定します。", required = false)
		val requestCriteria: RequestCriteria
)