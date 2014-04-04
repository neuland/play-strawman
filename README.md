# play-plugin-strawman
Strawman Plugin for Play 2.0

## Contents

- [Installation](#installation)
- [Example](#example)
- [Usage](#usage)
- [Authors](#authors)
- [License](#license)

## Installation

The module is published to [Github](https://github.com/Honigbaum/releases/tree/master/neuland-play-plugin-strawman_2.10). Play framework 2.x installation: 

Add a new resolver for dependencies and the dependency to your ```build.sbt```:

```
resolvers += Resolver.url("GitHub Play Repository", url("http://github.com/Honigbaum/releases/"))(Resolver.ivyStylePatterns)

libraryDependencies ++= Seq(
  "de.neuland" %% "neuland-play-plugin-strawman" % "1.0"
)
```

Add ```1000:de.neuland.play.strawman.StrawmanPlugin``` to your ```conf/play.plugins```

The following parameters can be configured in ```conf/application.conf```

```
# Strawman configuration
strawman.active = true # default = false
strawman.config = ns.your.conf.class # defaut = strawman.StrawanPages
```

## Usage
See the ```app/strawman``` package in sample application 

## Author

Torben Honigbaum / [honigbaum](https://github.com/honigbaum)

## License

The MIT License

Copyright (C) 2011-2014 [neuland Büro für Informatik](http://www.neuland-bfi.de/), Bremen, Germany

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.