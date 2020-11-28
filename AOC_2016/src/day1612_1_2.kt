// 11.10.2020

import java.io.File
import kotlin.math.*


fun main(args: Array<String>) {
//****************************************************************************	
//*     Declaration Variablen
//****************************************************************************


	var solution1: Int = 0
	var RegA: Int = 0
	var RegB: Int = 0
	var RegC: Int = 1           // initialize to 1 for solution 2
	var RegD: Int = 0

	val ProgramCode = mutableListOf<String>()

	var ProgramCount: Int = 0

// variables part 2


	var solution2: Int = 0

//****************************************************************************	
//*     Einlesen Puzzledaten
//****************************************************************************


// Part 1: Read ProgramCode
	File("day1612_puzzle_input.txt").forEachLine {

		ProgramCode.add(it)
	}

	println(ProgramCode)

// Part 1: Run Program
	while (ProgramCount < ProgramCode.size) {
//	while (ProgramCount < 6) {
		val instruction = ProgramCode[ProgramCount].split(" ")

		// instruction jnz  hier nochmal schauen, was soll hier wirklich passieren?
		if (instruction[0].equals("jnz") && instruction[1].equals("a")) {
			if (RegA == 0) {
				ProgramCount = ProgramCount + 1
			} else {
				ProgramCount = ProgramCount + instruction[2].toInt()
			}

		} else if (instruction[0].equals("jnz") && instruction[1].equals("b")) {
			if (RegB == 0) {
				ProgramCount = ProgramCount + 1
			} else {
				ProgramCount = ProgramCount + instruction[2].toInt()
			}
		} else if (instruction[0].equals("jnz") && instruction[1].equals("c")) {
			if (RegC == 0) {
				ProgramCount = ProgramCount + 1
			}else {
				ProgramCount = ProgramCount + instruction[2].toInt()
			}
		} else if (instruction[0].equals("jnz") && instruction[1].equals("d")) {
			if (RegD == 0) {
				ProgramCount = ProgramCount + 1
			}else {
				ProgramCount = ProgramCount + instruction[2].toInt()
			}
		} else if (instruction[0].equals("jnz") && !(instruction[1].equals("a") || instruction[1].equals("b") || instruction[1].equals(
				"c"
			) || instruction[1].equals("d"))
		) {
			if (instruction[2].toInt() == 0) {
				ProgramCount = ProgramCount + 1
			}else {
				ProgramCount = ProgramCount + instruction[2].toInt()
			}
		}

		// instruction copy
		if (instruction[0].equals("cpy") && instruction[1].equals("a")) {
			if (instruction[2].equals("a")) {
				RegA = RegA
				ProgramCount = ProgramCount + 1
			} else if (instruction[2].equals("b")) {
				RegB = RegA
				ProgramCount = ProgramCount + 1
			} else if (instruction[2].equals("c")) {
				RegC = RegA
				ProgramCount = ProgramCount + 1
			} else if (instruction[2].equals("d")) {
				RegD = RegA
				ProgramCount = ProgramCount + 1
			}
		} else if (instruction[0].equals("cpy") && instruction[1].equals("b")) {
			if (instruction[2].equals("a")) {
				RegA = RegB
				ProgramCount = ProgramCount + 1
			} else if (instruction[2].equals("b")) {
				RegB = RegB
				ProgramCount = ProgramCount + 1
			} else if (instruction[2].equals("c")) {
				RegC = RegB
				ProgramCount = ProgramCount + 1
			} else if (instruction[2].equals("d")) {
				RegD = RegB
				ProgramCount = ProgramCount + 1
			}
		} else if (instruction[0].equals("cpy") && instruction[1].equals("c")) {
			if (instruction[2].equals("a")) {
				RegA = RegC
				ProgramCount = ProgramCount + 1
			} else if (instruction[2].equals("b")) {
				RegB = RegC
				ProgramCount = ProgramCount + 1
			} else if (instruction[2].equals("c")) {
				RegC = RegC
				ProgramCount = ProgramCount + 1
			} else if (instruction[2].equals("d")) {
				RegD = RegC
				ProgramCount = ProgramCount + 1
			}
		} else if (instruction[0].equals("cpy") && instruction[1].equals("d")) {
			if (instruction[2].equals("a")) {
				RegA = RegD
				ProgramCount = ProgramCount + 1
			} else if (instruction[2].equals("b")) {
				RegB = RegD
				ProgramCount = ProgramCount + 1
			} else if (instruction[2].equals("c")) {
				RegC = RegD
				ProgramCount = ProgramCount + 1
			} else if (instruction[2].equals("d")) {
				RegD = RegD
				ProgramCount = ProgramCount + 1
			}
		} else if (instruction[0].equals("cpy") && !(instruction[1].equals("a") || instruction[1].equals("b") || instruction[1].equals(
				"c"
			) || instruction[1].equals("d"))
		) {
			if (instruction[2].equals("a")) {
				RegA = instruction[1].toInt()
				ProgramCount = ProgramCount + 1
			} else if (instruction[2].equals("b")) {
				RegB = instruction[1].toInt()
				ProgramCount = ProgramCount + 1
			} else if (instruction[2].equals("c")) {
				RegC = instruction[1].toInt()
				ProgramCount = ProgramCount + 1
			} else if (instruction[2].equals("d")) {
				RegD = instruction[1].toInt()
				ProgramCount = ProgramCount + 1
			}
		}

		// instruction increment
		if (instruction[0].equals("inc")) {
			if (instruction[1].equals("a")) {
				RegA = RegA + 1
				ProgramCount = ProgramCount + 1
			} else if (instruction[1].equals("b")) {
				RegB = RegB + 1
				ProgramCount = ProgramCount + 1
			} else if (instruction[1].equals("c")) {
				RegC = RegC + 1
				ProgramCount = ProgramCount + 1
			} else if (instruction[1].equals("d")) {
				RegD = RegD + 1
				ProgramCount = ProgramCount + 1
			}
		}

		// instruction decrement
		if (instruction[0].equals("dec")) {
			if (instruction[1].equals("a")) {
				RegA = RegA - 1
				ProgramCount = ProgramCount + 1
			} else if (instruction[1].equals("b")) {
				RegB = RegB - 1
				ProgramCount = ProgramCount + 1
			} else if (instruction[1].equals("c")) {
				RegC = RegC - 1
				ProgramCount = ProgramCount + 1
			} else if (instruction[1].equals("d")) {
				RegD = RegD - 1
				ProgramCount = ProgramCount + 1
			}
		}
	}


	solution1 = RegA


// Ausgabe der Lösung für Part 1
	println()
	println("******************")
	println("Solution for part1")
	println("    The value in register a is $solution1")
	println()

// Ausgabe der Lösung für Part 2   

	println()
	println("******************")
	println("    The value in register a is  $solution2")
	println()
}