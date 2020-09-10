package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if(c == 0 || c == r){
      1
    }else if(c < 0 || r < c) {
      0
    }else{
      pascal(c-1, r-1) + pascal(c, r-1)
    }
  }

  /**
   * Exercise 2
   */
  @tailrec
  def balance(chars: List[Char]): Boolean = {
    chars match {
      case List() => true
      case '(' :: tail => close(tail) match
      {
        case Ok(remains) => balance(remains)
        case Failed() => false
      }
      case ')' :: tail => false
      case _ :: tail => balance(tail)
    }
  }

  abstract class ConsumeResult
  case class Failed() extends ConsumeResult
  case class Ok(remains: List[Char]) extends ConsumeResult

  def close(chars: List[Char]): ConsumeResult = {
    chars match {
      case List() => Failed()
      case '(' :: tail =>
        close(tail) match {
          case Ok(remains) => close(remains)
          case Failed() => Failed()
        }
      case ')' :: tail => Ok(tail)
      case _ :: tail => close(tail)
    }
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    coins match{
      case List() if money == 0 => 1
      case List() => 0
      case coinValue :: coinsRemain =>
        var chargeMethodCount = 0
        for(coinCount <- 0 to money / coinValue){
          val moneyRemain = money - coinCount * coinValue
          chargeMethodCount += countChange(moneyRemain, coinsRemain)
        }
        chargeMethodCount
    }
  }
}
