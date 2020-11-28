// 11.10.2020

import java.io.File
import kotlin.math.*


fun main(args: Array<String>) {
//****************************************************************************	
//*     Declaration Variablen
//****************************************************************************

	var solution1: Int = 0
	var run_fabric: Boolean = true
	var instruction_count: Int = 0

	val bot_chip_a = MutableList<Int>(210) { 0 }   // puzzle_input: 210

	val bot_chip_b = MutableList<Int>(210) { 0 }    // puzzle_input: 210

// variables part 2
	var output01: Int = 1
	var output02: Int = 1
	var output03: Int = 1

	var solution2: Int = 1

//****************************************************************************	
//*     Einlesen Puzzledaten und direkt Berechnung des Weges.
//****************************************************************************


// Part 1
// for (i in 0..1) {
	while (run_fabric) {
		instruction_count = instruction_count + 1
		println("-----------------------")
		println("$instruction_count Durchlauf:")
		File("day1610_puzzle_input.txt").forEachLine {
			val instruction = it.split(" ")


			// ---------------------instruction value ----------------------------		
			if (instruction[0].equals("value") && instruction_count == 1) {
				if (bot_chip_a[instruction[5].toInt()] == 0) {  // vorher auf String?
					bot_chip_a[instruction[5].toInt()] = instruction[1].toInt()
				} else if (bot_chip_b[instruction[5].toInt()] == 0) {
					bot_chip_b[instruction[5].toInt()] = instruction[1].toInt()
				}
				// ---------------------instruction bot ----------------------------	
			} else if (instruction[0].equals("bot") && bot_chip_a[instruction[1].toInt()] != 0 && bot_chip_b[instruction[1].toInt()] != 0) {
				// -----------------forward low value of bot ----------------------
				if (instruction[5].equals("output")) {
					// a < b
					if (bot_chip_a[instruction[1].toInt()] < bot_chip_b[instruction[1].toInt()]) {
						// part 2
						if (instruction[6].equals("0")) {
							output01 = output01 * bot_chip_a[instruction[1].toInt()]
						} else if (instruction[6].equals("1")) {
							output02 = output02 * bot_chip_a[instruction[1].toInt()]
						} else if (instruction[6].equals("2")) {
							output03 = output03 * bot_chip_a[instruction[1].toInt()]
						}
						// end part 2						
						bot_chip_a[instruction[1].toInt()] = 0
					}
					// a > b
					if (bot_chip_a[instruction[1].toInt()] > bot_chip_b[instruction[1].toInt()]) {
						// part 2
						if (instruction[6].equals("0")) {
							output01 = output01 * bot_chip_b[instruction[1].toInt()]
						} else if (instruction[6].equals("1")) {
							output02 = output02 * bot_chip_b[instruction[1].toInt()]
						} else if (instruction[6].equals("2")) {
							output03 = output03 * bot_chip_b[instruction[1].toInt()]
						}
						// end part 2
												bot_chip_b[instruction[1].toInt()] = 0
					}
				} else if (instruction[5].equals("bot")) {
					// a < b sender bot
					if (bot_chip_a[instruction[1].toInt()] < bot_chip_b[instruction[1].toInt()]) {

						if (bot_chip_a[instruction[6].toInt()] == 0) {
							bot_chip_a[instruction[6].toInt()] = bot_chip_a[instruction[1].toInt()]
						} else if (bot_chip_b[instruction[6].toInt()] == 0) {
							bot_chip_b[instruction[6].toInt()] = bot_chip_a[instruction[1].toInt()]
						}
						bot_chip_a[instruction[1].toInt()] = 0
					}

					// a > b sender bot
					if (bot_chip_a[instruction[1].toInt()] > bot_chip_b[instruction[1].toInt()]) {

						if (bot_chip_a[instruction[6].toInt()] == 0) {
							bot_chip_a[instruction[6].toInt()] = bot_chip_b[instruction[1].toInt()]
						} else if (bot_chip_b[instruction[6].toInt()] == 0) {
							bot_chip_b[instruction[6].toInt()] = bot_chip_b[instruction[1].toInt()]
						}
						bot_chip_b[instruction[1].toInt()] = 0
					}
				}
				// -----------------forward high value of bot ----------------------
				if (instruction[10].equals("output")) {
					// a > b
					if (bot_chip_a[instruction[1].toInt()] > bot_chip_b[instruction[1].toInt()]) {
						// part 2
						println("------------------------checky----------------------------------")
						if (instruction[11].equals("0")) {
							output01 = output01 * bot_chip_a[instruction[1].toInt()]
						} else if (instruction[11].equals("1")) {
							output02 = output02 * bot_chip_a[instruction[1].toInt()]
						} else if (instruction[11].equals("2")) {
							output03 = output03 * bot_chip_a[instruction[1].toInt()]
						}
						// end part 2
												bot_chip_a[instruction[1].toInt()] = 0
					}
					// a < b
					if (bot_chip_a[instruction[1].toInt()] < bot_chip_b[instruction[1].toInt()]) {
						// part 2
						if (instruction[11].equals("0")) {
							output01 = output01 * bot_chip_b[instruction[1].toInt()]
						} else if (instruction[11].equals("1")) {
							output02 = output02 * bot_chip_b[instruction[1].toInt()]
						} else if (instruction[11].equals("2")) {
							output03 = output03 * bot_chip_b[instruction[1].toInt()]
						}
						// end part 2
												bot_chip_b[instruction[1].toInt()] = 0
					}
				} else if (instruction[10].equals("bot")) {
					// a > b sender bot
					if (bot_chip_a[instruction[1].toInt()] > bot_chip_b[instruction[1].toInt()]) {

						if (bot_chip_a[instruction[11].toInt()] == 0) {
							bot_chip_a[instruction[11].toInt()] = bot_chip_a[instruction[1].toInt()]
						} else if (bot_chip_b[instruction[11].toInt()] == 0) {
							bot_chip_b[instruction[11].toInt()] = bot_chip_a[instruction[1].toInt()]
						}
						bot_chip_a[instruction[1].toInt()] = 0
					}

					// a < b sender bot
					if (bot_chip_a[instruction[1].toInt()] < bot_chip_b[instruction[1].toInt()]) {

						if (bot_chip_a[instruction[11].toInt()] == 0) {
							bot_chip_a[instruction[11].toInt()] = bot_chip_b[instruction[1].toInt()]
						} else if (bot_chip_b[instruction[11].toInt()] == 0) {
							bot_chip_b[instruction[11].toInt()] = bot_chip_b[instruction[1].toInt()]
						}
						bot_chip_b[instruction[1].toInt()] = 0
					}
				}
			}

			//Abbruchbedingung

			for (j in 0..bot_chip_a.size - 1) {
				if (bot_chip_a[j] == 61 && bot_chip_b[j] == 17) {
			//		run_fabric = false
			//		println("Bot NR. $j Bot_Chip_A: ${bot_chip_a[j]}, Bot_Chip_B: ${bot_chip_b[j]}")
			//		println("yeah!!! Bot nr. $j made it ")
					solution1 = j
				} else if (bot_chip_b[j] == 61 && bot_chip_a[j] == 17) {
			//		run_fabric = false
			//		println("yeah!!! Bot nr. $j made it ")
					solution1 = j
				}

			}
			if (instruction_count == 100) {
				run_fabric = false
			}

		} // Ende Read Input for Part 1

	} // end fabric

// Ausgabe der Lösung für Part 1
	println()
	println("******************")
	println("Solution for part1")
	println("    The number of the bot you are searching for is $solution1")
	println()

// Ausgabe der Lösung für Part 2   :259 is to high
	// 56869 is to high
	solution2 = output01* output02 * output03
	println()
	println("******************")
	println("    The multiplied value of all chips in Bin 0 ($output01)/   1 ($output02)/   2 ($output03) is $solution2")
	println()
}