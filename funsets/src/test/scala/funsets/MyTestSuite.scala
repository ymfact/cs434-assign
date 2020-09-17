package funsets

import org.junit.runner.RunWith
import org.scalatest.Assertion
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class MyTestSuite extends AnyFunSuite {

  import FunSets._

  trait TestSets {
    val s1: Set = singletonSet(1)
    val s2: Set = singletonSet(2)
    val s3: Set = singletonSet(3)
    val s12: Set = union(s1, s2)
    val s23: Set = union(s2, s3)
    val s123: Set = union(s12, s3)

    def assertSet(set: Set, result: String): Assertion = assert(FunSets.toString(set) === result)
  }

  test("contains") {
    new TestSets {
      assert(contains(s1, 1))
      assert(!contains(s1, 2))
      assert(contains(s123, 1))
      assert(contains(s123, 2))
      assert(contains(s123, 3))
      assert(!contains(s123, 4))
    }
  }

  test("union") {
    new TestSets {
      assertSet(s12, "{1,2}")
      assertSet(s123, "{1,2,3}")
      assertSet(union(s12, s23), "{1,2,3}")
    }
  }

  test("intersect") {
    new TestSets {
      assertSet(intersect(s12, s23), "{2}")
    }
  }

  test("diff") {
    new TestSets {
      assertSet(diff(s12, s23), "{1}")
    }
  }

  test("filter") {
    new TestSets {
      assertSet(filter(s123, _ % 2 == 1), "{1,3}")
    }
  }

  test("forall") {
    new TestSets {
      assert(forall(s123, _ <= 3))
      assert(!forall(s123, _ < 3))
      assert(forall(union(singletonSet(-1000), singletonSet(1000)), _ % 2 == 0))
      assert(forall(union(singletonSet(-1000), singletonSet(1001)), _ % 2 == 0))
      assert(forall(union(singletonSet(-1001), singletonSet(1000)), _ % 2 == 0))
      assert(forall(union(singletonSet(-1001), singletonSet(1001)), _ % 2 == 0))
      assert(!forall(union(singletonSet(-999), singletonSet(1000)), _ % 2 == 0))
      assert(!forall(union(singletonSet(-1000), singletonSet(999)), _ % 2 == 0))
    }
  }

  test("exists") {
    new TestSets {
      assert(exists(s123, _ >= 3))
      assert(!exists(s123, _ > 3))
      assert(exists(union(singletonSet(-1000), singletonSet(1000)), _ % 2 == 0))
      assert(exists(union(singletonSet(-1000), singletonSet(1001)), _ % 2 == 0))
      assert(exists(union(singletonSet(-1001), singletonSet(1000)), _ % 2 == 0))
      assert(!exists(union(singletonSet(-1001), singletonSet(1001)), _ % 2 == 0))
      assert(exists(union(singletonSet(-999), singletonSet(1000)), _ % 2 == 0))
      assert(exists(union(singletonSet(-1000), singletonSet(999)), _ % 2 == 0))
      assert(!exists(union(singletonSet(-999), singletonSet(999)), _ % 2 == 0))
    }
  }

  test("map") {
    new TestSets {
      assertSet(map(s12, _ + 2), "{3,4}")
    }
  }
}
