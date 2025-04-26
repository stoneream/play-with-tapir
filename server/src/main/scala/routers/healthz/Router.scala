package routers.healthz

import com.google.inject.{Inject, Singleton}
import org.apache.pekko.stream.Materializer
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import sttp.tapir.server.play.{PlayServerInterpreter, PlayServerOptions}

import scala.concurrent.ExecutionContext

@Singleton
class Router @Inject() (
    endpoints: Endpoints,
    controller: HealthController
)(using
    ExecutionContext,
    Materializer
) extends SimpleRouter {

  private val playServerOptions: PlayServerOptions = PlayServerOptions.default()
  private val interpreter = PlayServerInterpreter(playServerOptions)

  override def routes: Routes = interpreter.toRoutes(
    endpoints.healthzEndpoint.serverLogic(_ => controller.healthz())
  )
}
