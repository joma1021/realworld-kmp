import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


object NetworkModule {
  val client = HttpClient {
    install(ContentNegotiation) {
      json(Json { ignoreUnknownKeys = true })
    }
    defaultRequest {
      url("https://api.realworld.show/api/")
    }
  }
}