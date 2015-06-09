# project-honeybadger

An example of migrating pre-2.10 actors code to 2.10+:

```scala
/* Simple actor repeating what you send to it */

import scala.actors._

class Echo(times: Int) extends Actor {
  def act {
    while (true) {
      // hello
      receive {
        // world
        case s: String => repeatString(s)
        case i: Int => repeatInt(i)
        case x => println(s"Dunno what that is: $x.")
      }
    }
  }
  def repeatString(s: String) {
    /* Let's just print the string! */
    for (i <- 0 until times) println(s)
  }
  def repeatInt(i: Int) {
    /* Let's repeat the int, but say it's an int as well */
    for (i <- 0 until times) println(s"Int received: $i.")
  }
}
```

Works with very specific versions of scalameta and scalahost:
  * https://github.com/scalameta/scalameta/tree/e759f3ebd435428b9e7f5b6fe3ff0e05e0fd9066
  * https://github.com/scalameta/scalahost/tree/bbcd49bf8badba5c9da2453d74c3ecfb9453df5f
