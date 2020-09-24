package patmat

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.junit.JUnitRunner
import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class MyTestSuite extends AnyFunSuite {
  test("tests") {
    val answer = string2Chars("huffmanestcool")
    assert(decode(frenchCode, secret) === answer)

    val testChars = string2Chars("thankyounext")
    assert(decode(frenchCode, encode(frenchCode)(testChars)) === testChars)
    assert(decode(frenchCode, quickEncode(frenchCode)(testChars)) === testChars)
  }
}
