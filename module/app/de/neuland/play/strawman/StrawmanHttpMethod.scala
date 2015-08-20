package de.neuland.play.strawman

sealed trait StrawmanHttpMethod {
  val url: String
  val method: String
}

case class Get(url: String) extends StrawmanHttpMethod {
  override val method: String = "GET"
}

case class Post(url: String) extends StrawmanHttpMethod {
  override val method: String = "POST"
}

case class Put(url: String) extends StrawmanHttpMethod {
  override val method: String = "PUT"
}

case class Delete(url: String) extends StrawmanHttpMethod {
  override val method: String = "DELETE"
}

case class Head(url: String) extends StrawmanHttpMethod {
  override val method: String = "HEAD"
}

object StrawmanHttpMethod {

  def apply(url: String, method: String): StrawmanHttpMethod = {
    method.toLowerCase match {
      case "get" => Get(url)
      case "post" => Post(url)
      case "put" => Put(url)
      case "delete" => Delete(url)
      case "head" => Head(url)
    }
  }

}
