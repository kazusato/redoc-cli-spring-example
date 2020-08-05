package dev.kazusato.apidocsearch.dto

import com.fasterxml.jackson.annotation.JsonInclude
import io.swagger.v3.oas.annotations.media.Schema

@JsonInclude(JsonInclude.Include.NON_NULL)
data class SearchResponse(
		@field:Schema(description = "検索結果のリストです。エラー応答の場合、設定されません。")
		val resultList: List<ItemInfo>?,
		@field:Schema(description = "エラー情報です。正常応答の場合、設定されません。")
		val errorInfo: ErrorInfo? = null
) {
	constructor(errorInfo: ErrorInfo) : this(null, errorInfo)
}