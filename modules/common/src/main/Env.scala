package lila.common

import com.softwaremill.macwire._
import play.api.Configuration
import play.api.libs.ws.StandaloneWSClient

import config._

@Module
final class Env(
    appConfig: Configuration,
    ws: StandaloneWSClient
)(implicit ec: scala.concurrent.ExecutionContext) {

  val netConfig = appConfig.get[NetConfig]("net")
  def netDomain = netConfig.domain

  lazy val detectLanguage = new DetectLanguage(ws, appConfig.get[DetectLanguage.Config]("detectlanguage.api"))
}
