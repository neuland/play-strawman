package de.neuland.play.strawman.controllers

import play.api.mvc.{Action, Controller}
import de.neuland.play.strawman.StrawmanConfig
import play.api.Logger

object StrawmanController extends Controller {

  def index = Action {
    Ok(de.neuland.play.strawman.views.html.index(StrawmanConfig.overview))
  }

  def all(url: String, method: String) = Action {
    StrawmanConfig.find(url, method) match {
      case Some(f) => f()
      case None => {
        Logger.warn("No strawman configuration found for path '%s'. Rendering index ...".format(url))
        Ok(de.neuland.play.strawman.views.html.index(StrawmanConfig.overview))
      }
    }
  }

}
