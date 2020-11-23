package nodescala

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.junit.JUnitRunner

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._
import scala.language.postfixOps
import scala.util.Success

@RunWith(classOf[JUnitRunner])
class CancellationTokenTestSuite extends AnyFunSuite {

  test("Cancellation Token Test") {
    val working = Future.run() { ct =>
      Future {
        while (ct.nonCancelled) {
          println("working")
        }
        println("done")
      }
    }
    Future.delay(1 seconds) onComplete  {
      case Success(_) => working.unsubscribe()
    }
    Thread.sleep(2 * 1000)
  }
}




