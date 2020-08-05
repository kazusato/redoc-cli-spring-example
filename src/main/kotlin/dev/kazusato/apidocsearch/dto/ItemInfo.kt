package dev.kazusato.apidocsearch.dto

import io.swagger.v3.oas.annotations.media.Schema

data class ItemInfo(
		@field:Schema(description = "タイトル")
		val title: String,
		@field:Schema(description = "種類（書籍・雑誌）")
		val type: ItemType,
		@field:Schema(description = "著者名（雑誌の場合、雑誌名+「編集部」が固定で指定されます）")
		val author: String,
		@field:Schema(description = "出版社名")
		val publisher: String,
		@field:Schema(description = "金額（税込）")
		val price: Int
)