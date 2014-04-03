package controllers

import play.api.mvc.{Action, Controller}
import repostories.ProductRepository

object Product extends Controller {

  def index = Action {
    Ok(views.html.index("Products", ProductRepository.all))
  }

  def detail(code: String) = Action {
    ProductRepository.find(code) match {
      case Some(product) => Ok(views.html.detail(product))
      case None => NotFound
    }
  }

}
