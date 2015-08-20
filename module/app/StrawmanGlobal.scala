import de.neuland.play.strawman.controllers.StrawmanController
import de.neuland.play.strawman.StrawmanPlugin
import play.api._
import play.api.mvc._
import play.api.Play.current

object StrawmanGlobal extends GlobalSettings {

  override def onRouteRequest(request: RequestHeader): Option[Handler] = {

    val AssetRequest = Play.configuration.getString("strawman.assetPathPattern").getOrElse("(.*asset.*)").r
    val RootPath = Play.configuration.getString("strawman.rootPath").getOrElse("/")

    StrawmanPlugin.enabled() match {
      case true =>
        request.path match {
          case RootPath => Some(StrawmanController.index)
          case "/favicon.ico" => super.onRouteRequest(request)
          case AssetRequest(_) => super.onRouteRequest(request)
          case _ => Some(StrawmanController.all(request.path, request.method))
        }
      case _ => super.onRouteRequest(request)
    }

  }

}