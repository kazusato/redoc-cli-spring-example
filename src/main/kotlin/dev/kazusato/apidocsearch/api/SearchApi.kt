package dev.kazusato.apidocsearch.api

import dev.kazusato.apidocsearch.dto.ItemInfo
import dev.kazusato.apidocsearch.dto.ItemType
import dev.kazusato.apidocsearch.dto.SearchRequest
import dev.kazusato.apidocsearch.dto.SearchResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.security.SecurityScheme
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/search")
class SearchApi {

	@PostMapping(consumes = ["application/json;charset=UTF-8"], produces = ["application/json;charset=UTF-8"])
	@Operation(summary = "書籍・雑誌の検索を行います。",
			parameters = [Parameter(name = "X-Hello-World", `in` = ParameterIn.HEADER, description = "Hello Worldの値を指定します。")])
	fun search(@RequestBody req: SearchRequest): SearchResponse {
		if (req.type == ItemType.BOOK) {
			return SearchResponse(listOf(
					ItemInfo("書籍1", ItemType.BOOK, "著者1", "出版社1", 1000),
					ItemInfo("書籍2", ItemType.BOOK, "著者2", "出版社2", 2000)
			))
		} else {
			return SearchResponse(listOf(
					ItemInfo("雑誌1", ItemType.BOOK, "雑誌1編集部", "出版社1", 1000),
					ItemInfo("雑誌2", ItemType.BOOK, "雑誌2編集部", "出版社2", 2000)
			))
		}
	}

}