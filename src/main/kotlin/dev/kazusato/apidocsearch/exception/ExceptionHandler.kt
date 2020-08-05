package dev.kazusato.apidocsearch.exception

import dev.kazusato.apidocsearch.dto.ErrorInfo
import dev.kazusato.apidocsearch.dto.SearchResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {

	companion object {
		private val logger = LoggerFactory.getLogger(this.javaClass.enclosingClass)
	}

	override fun handleBindException(ex: BindException, headers: HttpHeaders, status: HttpStatus, request: WebRequest): ResponseEntity<Any> {
		logger.error("Bind exception", ex)
		return super.handleExceptionInternal(ex, SearchResponse(ErrorInfo("ERR00002", "データが不正です")),
				HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST, request)
	}

	@ExceptionHandler(Exception::class)
	fun handleUnknownException(e: Exception, webReq: WebRequest): ResponseEntity<Any> {
		logger.error("Unknown exception", e)
		return super.handleExceptionInternal(e, SearchResponse(ErrorInfo("ERR00001", "想定外のエラーが発生しました")),
				HttpHeaders.EMPTY, HttpStatus.INTERNAL_SERVER_ERROR, webReq)
	}

}