package recfun

import org.scalatest.funsuite.AnyFunSuite

import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalSuite extends AnyFunSuite {
  import Main.pascal
  test("pascal: col=0,row=2") {
    assert(pascal(0,2) === 1)
  }

  test("pascal: col=1,row=2") {
    assert(pascal(1,2) === 2)
  }

  test("pascal: col=1,row=3") {
    assert(pascal(1,3) === 3)
  }

  test("pascal: my tests") {
    assert(pascal(0,0) === 1)
    assert(pascal(7,20) === 77520)
    assert(pascal(12,20) === 125970)
  }
}
