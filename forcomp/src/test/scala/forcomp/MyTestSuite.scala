package forcomp

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import Anagrams._
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MyTestSuite extends AnyFunSuite {

  test("sentence anagrams: empty") {
    val sentence = List("")
    val anas = List(
      List()
    )
    assert(sentenceAnagrams(sentence).length === anas.length)
    assert(sentenceAnagrams(sentence).toSet === anas.toSet)
    assert(sentenceAnagramsMemo(sentence).length === anas.length)
    assert(sentenceAnagramsMemo(sentence).toSet === anas.toSet)
  }
  test("sentence anagrams: Zulu") {
    val sentence = List("Zulu")
    val anas = List(
      List("Zulu")
    )
    assert(sentenceAnagrams(sentence).length === anas.length)
    assert(sentenceAnagrams(sentence).toSet === anas.toSet)
    assert(sentenceAnagramsMemo(sentence).length === anas.length)
    assert(sentenceAnagramsMemo(sentence).toSet === anas.toSet)
  }

  test("sentence anagrams: ZULUZ") {
    val sentence = List("ZULUZ")
    val anas = List(
    )
    assert(sentenceAnagrams(sentence).length === anas.length)
    assert(sentenceAnagrams(sentence).toSet === anas.toSet)
    assert(sentenceAnagramsMemo(sentence).length === anas.length)
    assert(sentenceAnagramsMemo(sentence).toSet === anas.toSet)
  }

  test("sentence anagrams: Linux rulez") {
    val sentence = List("Linux", "rulez")
    val anas = List(
      List("Rex", "Lin", "Zulu"),
      List("nil", "Zulu", "Rex"),
      List("Rex", "nil", "Zulu"),
      List("Zulu", "Rex", "Lin"),
      List("null", "Uzi", "Rex"),
      List("Rex", "Zulu", "Lin"),
      List("Uzi", "null", "Rex"),
      List("Rex", "null", "Uzi"),
      List("null", "Rex", "Uzi"),
      List("Lin", "Rex", "Zulu"),
      List("nil", "Rex", "Zulu"),
      List("Rex", "Uzi", "null"),
      List("Rex", "Zulu", "nil"),
      List("Zulu", "Rex", "nil"),
      List("Zulu", "Lin", "Rex"),
      List("Lin", "Zulu", "Rex"),
      List("Uzi", "Rex", "null"),
      List("Zulu", "nil", "Rex"),
      List("rulez", "Linux"),
      List("Linux", "rulez")
    )
    assert(sentenceAnagrams(sentence).length === anas.length)
    assert(sentenceAnagrams(sentence).toSet === anas.toSet)
    assert(sentenceAnagramsMemo(sentence).length === anas.length)
    assert(sentenceAnagramsMemo(sentence).toSet === anas.toSet)
  }

  test("sentence anagrams: Cheeseburger") {
    val sentence = List("Cheeseburger")
    assert(sentenceAnagramsMemo(sentence).toSet === sentenceAnagrams(sentence).toSet)
  }

}
