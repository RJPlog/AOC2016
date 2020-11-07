import java.io.File
import kotlin.math.*

fun main(args: Array<String>) {
//****************************************************************************	
//*     Declaration Variablen
//****************************************************************************

	var instruction: String
	var position: Int = 5
	var passwd: String = ""


// Variables for Part 2
	val pinboard: Array<IntArray> = arrayOf(
		intArrayOf(0, 0, 0, 0, 0, 0, 0),
		intArrayOf(0, 0, 0, 1, 0, 0, 0),
		intArrayOf(0, 0, 2, 3, 4, 0, 0),
		intArrayOf(0, 5, 6, 7, 8, 9, 0),
		intArrayOf(0, 0, 10, 11, 12, 0, 0),
		intArrayOf(0, 0, 0, 13, 0, 0, 0),
		intArrayOf(0, 0, 0, 0, 0, 0, 0)
	)

	var pos_h: Int = 1
	var pos_v: Int = 3
	var passwd2: String = ""

//****************************************************************************	
//*     Einlesen Puzzledaten und direkt Berechnung des Weges.
//****************************************************************************


// Part 1
	File("day1602_puzzle_input.txt").forEachLine {
		instruction = it

		//für jedes Element in String einen Floor hoch oder runter zählen
		for (i in instruction.indices) {
			if (instruction[i].equals('U') && position > 3) {
				position = position - 3
			} else if (instruction[i].equals('D') && position < 7) {
				position = position + 3
			} else if (instruction[i].equals('L') && !(position == 1 || position == 4 || position == 7)) {
				position = position - 1
			} else if (instruction[i].equals('R') && !(position == 3 || position == 6 || position == 9)) {
				position = position + 1
			}
		}
		passwd = passwd + position.toString()

	}


// part 2

	File("day1602_puzzle_input.txt").forEachLine {
		instruction = it

		//für jedes Element in String einen Floor hoch oder runter zählen
		for (i in instruction.indices) {
			if (instruction[i].equals('U')) {
				if (pinboard[pos_v - 1][pos_h] != 0) {
					pos_v = pos_v - 1
				}
			} else if (instruction[i].equals('D')) {
				if (pinboard[pos_v + 1][pos_h] != 0) {
					pos_v = pos_v + 1
				}
			} else if (instruction[i].equals('L')) {
				if (pinboard[pos_v][pos_h - 1] != 0) {
					pos_h = pos_h - 1
				}
			} else if (instruction[i].equals('R')) {
				if (pinboard[pos_v][pos_h + 1] != 0) {
					pos_h = pos_h + 1
				}
			}
		}
		if (pinboard[pos_v][pos_h] == 10) {
			passwd2 = passwd2 + "A"
		} else if (pinboard[pos_v][pos_h] == 11) {
			passwd2 = passwd2 + "B"
		} else if (pinboard[pos_v][pos_h] == 12) {
			passwd2 = passwd2 + "C"
		} else if (pinboard[pos_v][pos_h] == 13) {
			passwd2 = passwd2 + "D"
		} else {
			passwd2 = passwd2 + pinboard[pos_v][pos_h]
		}
	}

// Ausgabe der Lösung für Part 1
	println()
	println("******************")
	println("Solution for part1")
	println("   Die PinNummer lautet $passwd")
	println()

// Ausgabe der Lösung für Part 2
	println()
	println("******************")
	println("Solution for part2")
	println("   Die PinNummer lautet $passwd2")
	println()
}