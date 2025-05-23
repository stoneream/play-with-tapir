package healthz

import sttp.tapir.*

object Endpoints {
  private val base = endpoint.tag("Health")

  val healthzEndpoint: PublicEndpoint[Unit, Unit, String, Any] = base.get
    .in("healthz")
    .out(plainBody[String])
    .description("Health check endpoint")

  val endpoints = List(healthzEndpoint)
}
