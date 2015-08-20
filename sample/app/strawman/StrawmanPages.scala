package strawman

import de.neuland.play.strawman.Get
import dtos.ProductDto
import play.api.mvc.{Controller, Result}
import strawman.{StrawmanRepository => repo}
import views.{html => h}

class StrawmanPages extends Controller {
  def apply: Map[String, Map[de.neuland.play.strawman.StrawmanHttpMethod, () => Result]] = Map(

    "Articleoverview" -> Map(
      Get("/products") -> (() => Ok(h.index("Fakeproducts Overview", repo.Product.all)))
    ),

    "Articledetails" -> Map(
      Get("/product/8844") -> { () =>
        Ok(h.detail(repo.Product.cheap))
      },
      Get("/product/4233") -> (() => Ok(h.detail(repo.Product.expensive))),
      Get("/product/5555") -> (() => Ok(h.detail(ProductDto("5555", "Inline fakeproduct", 10.99))))
    )

  )
}
