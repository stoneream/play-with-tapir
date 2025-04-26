import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class Demo extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:9000")
    .userAgentHeader("Gatling")

  val scn = scenario("Test Scenario")
    .exec(http("request_1").get("/"))
    .pause(5.seconds)

  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
