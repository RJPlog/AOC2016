import java.io.File
import kotlin.math.*

fun main(args: Array<String>) {
//****************************************************************************	
//*     Declaration Variablen
//****************************************************************************

	var pos_tria: Int = 0
	var a: Int
	var b: Int
	var c: Int
	var ah: String
	var bh: String
	var ch: String

// variables for part two	

	var pos_tria2: Int = 0
	var toggle: Int = 1
	var a1: Int = 0
	var b1: Int = 0
	var c1: Int = 0
	var ah1: String
	var bh1: String
	var ch1: String
	var a2: Int = 0
	var b2: Int = 0
	var c2: Int = 0
	var ah2: String
	var bh2: String
	var ch2: String
	var a3: Int = 0
	var b3: Int = 0
	var c3: Int = 0
	var ah3: String
	var bh3: String
	var ch3: String

//****************************************************************************	
//*     Einlesen Puzzledaten und direkt Berechnung des Weges.
//****************************************************************************


// Part 1
	File("day1603_puzzle_input.txt").forEachLine {

		ah = it.removeRange(5, 15)
		bh = it.removeRange(10, 15)
		bh = bh.removeRange(0, 5)
		ch = it.removeRange(0, 10)
		ah = ah.replace(" ", "")
		bh = bh.replace(" ", "")
		ch = ch.replace(" ", "")


		a = ah.toInt()
		b = bh.toInt()
		c = ch.toInt()

		if (a + b > c) {
			if (b + c > a) {
				if (c + a > b) {
					pos_tria = pos_tria + 1
				}
			}
		}
	}

// Part 2

	File("day1603_puzzle_input.txt").forEachLine {

		if (toggle == 1) {
			ah1 = it.removeRange(5, 15)
			ah2 = it.removeRange(10, 15)
			ah2 = ah2.removeRange(0, 5)
			ah3 = it.removeRange(0, 10)
			ah1 = ah1.replace(" ", "")
			ah2 = ah2.replace(" ", "")
			ah3 = ah3.replace(" ", "")


			a1 = ah1.toInt()
			a2 = ah2.toInt()
			a3 = ah3.toInt()
		} else if (toggle == 2) {
			bh1 = it.removeRange(5, 15)
			bh2 = it.removeRange(10, 15)
			bh2 = bh2.removeRange(0, 5)
			bh3 = it.removeRange(0, 10)
			bh1 = bh1.replace(" ", "")
			bh2 = bh2.replace(" ", "")
			bh3 = bh3.replace(" ", "")


			b1 = bh1.toInt()
			b2 = bh2.toInt()
			b3 = bh3.toInt()
		} else if (toggle == 3) {
			ch1 = it.removeRange(5, 15)
			ch2 = it.removeRange(10, 15)
			ch2 = ch2.removeRange(0, 5)
			ch3 = it.removeRange(0, 10)
			ch1 = ch1.replace(" ", "")
			ch2 = ch2.replace(" ", "")
			ch3 = ch3.replace(" ", "")


			c1 = ch1.toInt()
			c2 = ch2.toInt()
			c3 = ch3.toInt()
		} 

		if (toggle == 3) {
			if (a1 + b1 > c1) {
				if (b1 + c1 > a1) {
					if (c1 + a1 > b1) {
						pos_tria2 = pos_tria2 + 1
					}
				}
			}
			if (a2 + b2 > c2) {
				if (b2 + c2 > a2) {
					if (c2 + a2 > b2) {
						pos_tria2 = pos_tria2 + 1
					}
				}
			}
			if (a3 + b3 > c3) {
				if (b3 + c3 > a3) {
					if (c3 + a3 > b3) {
						pos_tria2 = pos_tria2 + 1
					}
				}
			}
		}
		toggle = toggle + 1
		if (toggle == 4) {
			toggle = 1
		}
	}


// Ausgabe der Lösung für Part 1
	println()
	println("******************")
	println("Solution for part1")
	println("   There are  $pos_tria possible")
	println()

// Ausgabe der Lösung für Part 2
	println()
	println("******************")
	println("Solution for part2")
	println("   There are  $pos_tria2 possible")
	println()
}