import de.neuland.play.strawman.controllers.StrawmanController
import de.neuland.play.strawman.StrawmanPlugin
import play.api._
import play.api.mvc._
import play.api.Play.current

object Global extends GlobalSettings {

  override def onRouteRequest(request: RequestHeader): Option[Handler] = {

    Play.application.plugin(classOf[StrawmanPlugin]) match {
      case Some(plugin) => plugin.enabled() match {
        case true =>
          request.path match {
            case "/" => Some(StrawmanController.index)
            case _ => Some(StrawmanController.all(request.path))
          }
      }
      case None => super.onRouteRequest(request)
    }

  }

}