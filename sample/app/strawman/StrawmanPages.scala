package strawman

import play.api.templates.Html
import views.{html => h}
import strawman.{StrawmanRepository => repo}
import dtos.ProductDto

class StrawmanPages  {
  def apply: Map[String, Map[String, Html]] = Map(

    "Articleoverview" -> Map(
      "/products" -> h.index("Fakeproducts Overview", repo.Product.all)
    ),

    "Articledetails" -> Map(
      "/product/8844" -> h.detail(repo.Product.cheap),
      "/product/4233" -> h.detail(repo.Product.expensive),
      "/product/5555" -> h.detail(ProductDto("5555", "Inline fakeproduct", 10.99))
    )

  )
}
