package demo.kotlin.authpayments.adaptors.ui.Auth

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/auth")
class AuthController {
    private val log = KotlinLogging.logger {}

    @PostMapping
    fun auth(@RequestBody request: AuthRequest): ResponseEntity<String> {
        log.info { "auth with identityVerificationId: ${request.identityVerificationId}" }
        return ResponseEntity.ok("인증 성공")
    }
}

data class AuthRequest(
    val identityVerificationId: String
)
