package de.neuland.play.strawman.controllers

import play.api.mvc.{Action, Controller}
import de.neuland.play.strawman.StrawmanConfig
import play.api.Logger

object StrawmanController extends Controller {

  def index = Action {
    Ok(de.neuland.play.strawman.views.html.index(StrawmanConfig().overview))
  }

  def all(url: String) = Action {
    StrawmanConfig().find(url) match {
      case Some(html) => Ok(html)
      case None => {
        Logger.warn("No strawman configuration found for path '%s'. Redirecting to index ...".format(url))
        Redirect("/")
      }
    }
  }

}
