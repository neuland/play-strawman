package strawman

import dtos.ProductDto

object StrawmanRepository {

  object Product {
    val cheap = ProductDto("8844", "Cheap fakeproduct", 13.77)
    val expensive = ProductDto("4233", "Expensive fakeproduct", 213.77)
    lazy val all = List(cheap, expensive)
  }

}
