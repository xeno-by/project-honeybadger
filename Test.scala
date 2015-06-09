import scala.meta.{Term => _, Template => _, _}
import scala.meta.internal.ast._
import scala.meta.dialects.Scala211

object Test {
  def main(args: Array[String]): Unit = {
    val scalaLibrary = "/Users/xeno_by/Projects/2116/build/pack/lib/scala-library.jar"
    val scalaActors = "/Users/xeno_by/Projects/2116/build/pack/lib/scala-actors.jar"
    val echoClasses = "/Users/xeno_by/Projects/echo/sandbox"
    val classpath = s"$scalaLibrary:$scalaActors:$echoClasses"
    val sourcepath = "/Users/xeno_by/Projects/echo"

    implicit val c = Scalahost.mkProjectContext(sourcepath, classpath)
    val List(echoScalaActors) = c.project.sources
    // println(echoScalaActors)

    val withReceive = echoScalaActors.transform {
      case cls @ Defn.Class(_, _, _, _, templ @ Template(_, List(actor), _, Some(stats)))
      if actor.tpe == t"scala.actors.Actor" =>
        val templ1 = templ.transform {
          case act: Defn.Def if act.name.toString == "act" =>
            val List(messages) = act.collect {
              case Term.Apply(receive: Term.Ref, List(messages: Term.PartialFunction))
              if receive.source == t"scala.actors.Actor".defs("receive").source =>
                messages
            }
            act.copy(name = q"receive", body = messages)
        }.asInstanceOf[Template]
        cls.copy(templ = templ1)
    }
    println(withReceive)
  }
}