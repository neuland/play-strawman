package strawman

import dtos.ProductDto
import play.api.mvc.{Controller, Result}
import strawman.{StrawmanRepository => repo}
import views.{html => h}

class StrawmanPages extends Controller {
  def apply: Map[String, Map[String, () => Result]] = Map(

    "Articleoverview" -> Map(
      "/products" -> (() => Ok(h.index("Fakeproducts Overview", repo.Product.all)))
    ),

    "Articledetails" -> Map(
      "/product/8844" -> { () =>
        Ok(h.detail(repo.Product.cheap))
      },
      "/product/4233" -> (() => Ok(h.detail(repo.Product.expensive))),
      "/product/5555" -> (() => Ok(h.detail(ProductDto("5555", "Inline fakeproduct", 10.99))))
    )

  )
}
