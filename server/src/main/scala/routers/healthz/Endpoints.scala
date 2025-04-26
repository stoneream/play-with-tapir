package routers.healthz

import com.google.inject.Singleton
import sttp.tapir.*

@Singleton
class Endpoints {

  private val base = endpoint.tag("Health")

  val healthzEndpoint: PublicEndpoint[Unit, Unit, String, Any] = base.get
    .in("healthz")
    .out(plainBody[String])
    .description("Health check endpoint")

}
