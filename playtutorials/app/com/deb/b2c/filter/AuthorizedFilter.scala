package com.deb.b2c.filter

import javax.inject._
import akka.stream.Materializer
import play.api.mvc.{ Filter, RequestHeader }
import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import play.api.mvc

class AuthorizedFilter @Inject() (implicit val mat: Materializer, ec: ExecutionContext, configuration: play.api.Configuration) extends Filter {

  override def apply(next: (mvc.RequestHeader) => Future[mvc.Result])(request: mvc.RequestHeader) = {

    val url = request.path
    val method = request.method
    val reqRefId = request.headers.get("reqRefId").getOrElse(null)
    println(s"Received Details: URL: $url, Method: $method, ReqRefId: $reqRefId")
    next(request)
  }
}