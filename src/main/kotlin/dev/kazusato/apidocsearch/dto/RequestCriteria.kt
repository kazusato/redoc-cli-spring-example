package dev.kazusato.apidocsearch.dto

import io.swagger.v3.oas.annotations.media.Schema

data class RequestCriteria(
		@field:Schema(description = "検索結果の上限数を指定します。", required = false, defaultValue = "10")
		val limit: Int,
		@field:Schema(description = "在庫切れ商品を除外する場合trueを指定します。", required = false, defaultValue = "false")
		val excludeOutOfStock: Boolean
)