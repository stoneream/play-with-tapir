package routers.healthz

import com.google.inject.{Inject, Singleton}
import org.apache.pekko.stream.Materializer

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class HealthController @Inject() ()(using
    ExecutionContext,
    Materializer
) {
  def healthz(): Future[Either[Unit, String]] = Future {
    Right("ok")
  }
}
