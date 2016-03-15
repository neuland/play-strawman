# play-plugin-strawman
Strawman Plugin for Play 2

## Contents

- [Installation](#installation)
- [Usage](#usage)
- [Authors](#authors)
- [License](#license)

## Installation

Select released version from ```../releases``` folder and copy jar to ```lib```. Configure following parameters in ```conf/application.conf```

```
# Strawman configuration
strawman.active = true # default = false
strawman.config = ns.your.conf.class # defaut = strawman.StrawanPages
```

Add configuration class with following interface to your project (if strawman.config = strawman.StrawmanPages): 

```
package strawman

class StrawmanPages  {
  def apply: Map[String, Map[String, Html]]
}
```

Example:

```
package strawman

import play.api.templates.Html
import views.{html => h}
import strawman.{StrawmanRepository => repo}
import dtos.ProductDto

class StrawmanPages extends Controller {
  def apply: Map[String, Map[String, () => SimpleResult]] = Map(

    "Articleoverview" -> Map(
      "/products" -> (() => Ok(h.index("Fakeproducts Overview", repo.Product.all)))
    ),

    "Articledetails" -> Map(
      "/product/8844" -> (() => Ok(h.detail(repo.Product.cheap))),
      "/product/4233" -> (() => Ok(h.detail(repo.Product.expensive))),
      "/product/5555" -> (() => Ok(h.detail(ProductDto("5555", "Inline fakeproduct", 10.99))))
    )

  )
}
```

## Usage
See the ```app/strawman``` package in sample application 

## Author
Torben Honigbaum / [honigbaum](https://github.com/honigbaum)

## License
The MIT License

Copyright (C) 2014 [neuland Büro für Informatik](http://www.neuland-bfi.de/), Bremen, Germany

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.