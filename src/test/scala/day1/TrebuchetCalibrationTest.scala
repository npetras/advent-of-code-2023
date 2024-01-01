package com.nicolaspetras
package day1

import org.scalatest.flatspec.AnyFlatSpec

class TrebuchetCalibrationTest extends AnyFlatSpec {
  "simple jumbled calibration string 1abc" should "return 12" in {
    val simpleString = "1abc2"
    val expected = 12
    val actual = extractOriginalCalibrationValues(simpleString)
    assert(actual == expected)
  }

  "jumbled calibration string pqr3sty8vmx" should "return 38" in {
    val simpleString = "pqr3sty8vmx"
    val expected = 38
    val actual = extractOriginalCalibrationValues(simpleString)
    assert(actual == expected)
  }

  "jumbled calibration string a1b2c3d4e5f" should "return 15" in {
    val simpleString = "a1b2c3d4e5f"
    val expected = 15
    val actual = extractOriginalCalibrationValues(simpleString)
    assert(actual == expected)
  }

  "12,13,14" should "sum to 39" in {
    val listOfVals: List[Int] = List.apply(12, 13, 14)
    val expected = 39
    val actual = sumCalibrationValues(listOfVals)
    assert(actual == expected)
  }
}
