import scala.meta._

object Test {
  def main(args: Array[String]): Unit = {
    val scalaLibrary = "/Users/xeno_by/Projects/2116/build/pack/lib/scala-library.jar"
    val scalaActors = "/Users/xeno_by/Projects/2116/build/pack/lib/scala-actors.jar"
    val echoClasses = "/Users/xeno_by/Projects/echo/sandbox"
    val classpath = s"$scalaLibrary:$scalaActors:$echoClasses"
    val sourcepath = "/Users/xeno_by/Projects/echo"
  }
}