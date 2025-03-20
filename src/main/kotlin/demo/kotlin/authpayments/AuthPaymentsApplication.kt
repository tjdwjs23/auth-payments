package demo.kotlin.authpayments

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AuthPaymentsApplication

fun main(args: Array<String>) {
    runApplication<AuthPaymentsApplication>(*args)
}
