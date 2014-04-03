package repostories

import dtos.ProductDto

object ProductRepository {

  private val products = List(
    ProductDto("4734", "Chainsaw", 99.95),
    ProductDto("6785", "Hammer", 9.95),
    ProductDto("2343", "Bike", 544.95)
  )

  def all: List[ProductDto] = products

  def find(code: String): Option[ProductDto] = products.find(_.code == code)

}
