package com.nicolaspetras
package day1

import scala.annotation.tailrec
import scala.io.Source


/**
 * IO Function that is impure -- reads the input file with the calibration values into a list of strings
 * @return List of Strings - jumbled calibration values
 */
def readCalibrationValuesFromFile(): List[String] = {
  try {
    val source = Source.fromFile("src/main/scala/day1/input.txt")
    val lines = source.getLines().toList
    source.close()
    lines
  } catch {
    case e: java.io.FileNotFoundException =>
      println("File not found: " + e.getMessage)
      List()
    case e: java.io.IOException =>
      println("Error reading the file: " + e.getMessage)
      List()
  }
}

/**
 * Extracts the original calibration value from the jumbled string, by finding the first and last digits in the string.
 * @param jumbledCalibrationValue Jumbled Calibration Value
 * @return original calibration value
 */
def extractOriginalCalibrationValues(jumbledCalibrationValue: String): Int = {
   @tailrec
   def extractDigit(jumbledCalibrationValue: String, index: Int, iterator: Int): Char = {
     if jumbledCalibrationValue.charAt(index).isDigit then
       jumbledCalibrationValue.charAt(index)
     else
       extractDigit(jumbledCalibrationValue, index + iterator, iterator)
   }
   val firstDigit = extractDigit(jumbledCalibrationValue, 0, 1)
   val lastDigit = extractDigit(jumbledCalibrationValue, jumbledCalibrationValue.length - 1, -1)
   s"${firstDigit}${lastDigit}".toInt
}

/**
 * Sums all list of ints provided (calibration values)
 * @param calibrationValues Calibration values extracted from document
 * @return sum of the calibrationValues
 */
def sumCalibrationValues(calibrationValues: List[Int]): Int = calibrationValues match {
  case Nil => 0
  case head :: tail => head + sumCalibrationValues(tail)
}

/**
 * Recovers original calibration values from calibration document, and sums the values together.
 * @return sum of the calibration files
 */
def performCalibrationCalculation(): Int = {
  val jumbledCalibrationValues = readCalibrationValuesFromFile()
  val calibrationValues = jumbledCalibrationValues.map(extractOriginalCalibrationValues)
  sumCalibrationValues(calibrationValues)
}