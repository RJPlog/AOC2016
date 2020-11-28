// 11.10.2020

import java.io.File
import kotlin.math.*


fun main(args: Array<String>) {
//****************************************************************************	
//*     Declaration Variablen
//****************************************************************************


	var solution1: Int = 0
	var RegA: Int = 12
	var RegB: Int = 0
	var RegC: Int = 0           // initialize to 1 for solution 2
	var RegD: Int = 0

	var tglincr: Int = 0
	var tglinst: String = ""
	var jumpdist: Int = 0

	val ProgramCode = mutableListOf<String>()

	var ProgramCount: Int = 0

// variables part 2


	var solution2: Int = 0

//****************************************************************************	
//*     Einlesen Puzzledaten
//****************************************************************************


// Part 1: Read ProgramCode
	File("day1623_puzzle_input.txt").forEachLine {

		ProgramCode.add(it)
	}


	println()
	println("start code")
	println()

// Part 1: Run Program
	while (ProgramCount < ProgramCode.size) {
//	while (ProgramCount < 6) {
		val instruction = ProgramCode[ProgramCount].split(" ")

//		println("  ProgramCount:  $ProgramCount")
//		println("   $ProgramCode")
//		println("   ${ProgramCode[ProgramCount]}")
//		println("   A: $RegA, B: $RegB, C: $RegC, D: $RegD")
//		println()

		// instruction jnz  hier nochmal schauen, was soll hier wirklich passieren?
		if (instruction[0].equals("jnz")) {
			if (instruction[2].equals("a")) {
				jumpdist = RegA
			} else if (instruction[2].equals("b")) {
				jumpdist = RegB
			} else if (instruction[2].equals("c")) {
				jumpdist = RegC
			} else if (instruction[2].equals("d")) {
				jumpdist = RegD
			} else {
				jumpdist = instruction[2].toInt()
			}
		}
		if (instruction[0].equals("jnz") && instruction[1].equals("a")) {
			if (RegA == 0) {
				ProgramCount = ProgramCount + 1
			} else {
				ProgramCount = ProgramCount + jumpdist
			}

		} else if (instruction[0].equals("jnz") && instruction[1].equals("b")) {
			if (RegB == 0) {
				ProgramCount = ProgramCount + 1
			} else {
				ProgramCount = ProgramCount + jumpdist
			}
		} else if (instruction[0].equals("jnz") && instruction[1].equals("c")) {
			if (RegC == 0) {
				ProgramCount = ProgramCount + 1
			} else {
				ProgramCount = ProgramCount + jumpdist
			}
		} else if (instruction[0].equals("jnz") && instruction[1].equals("d")) {
			if (RegD == 0) {
				ProgramCount = ProgramCount + 1
			} else {
				ProgramCount = ProgramCount + jumpdist
			}
		} else if (instruction[0].equals("jnz") && !(instruction[1].equals("a") || instruction[1].equals("b") || instruction[1].equals(
				"c"
			) || instruction[1].equals("d"))
		) {
			if (instruction[2].equals("0")) {
				ProgramCount = ProgramCount + 1
			} else {
				ProgramCount = ProgramCount + jumpdist
			}
		}

		// instruction copy
		if (instruction[0].equals("cpy") && (instruction[2].equals("a") || instruction[2].equals("b") || instruction[2].equals(
				"c"
			) || instruction[2].equals("d"))
		) {
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
		} else if (instruction[0].equals("cpy") && (!instruction[2].equals("a") && !instruction[2].equals("b") && !instruction[2].equals(
				"c"
			) && !instruction[2].equals("d"))
		) {
			ProgramCount = ProgramCount + 1
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

// *********************************************************************	
		// instruction tgl 
		if (instruction[0].equals("tgl")) {
			if (instruction[1].equals("a")) {
				tglincr = ProgramCount + RegA
			} else if (instruction[1].equals("b")) {
				tglincr = ProgramCount + RegB
			} else if (instruction[1].equals("c")) {
				tglincr = ProgramCount + RegC
			} else if (instruction[1].equals("d")) {
				tglincr = ProgramCount + RegD
			}
			if (tglincr < ProgramCode.size) {
				var dest_instruction = ProgramCode[tglincr].split(" ")
				if (dest_instruction[0] == "inc") {
					ProgramCode[tglincr] = "dec " + dest_instruction[1]
				} else if (dest_instruction[0] == "dec" || dest_instruction[0] == "tgl") {
					ProgramCode[tglincr] = "inc " + dest_instruction[1]
				} else if (dest_instruction[0] == "cpy") {
					ProgramCode[tglincr] = "jnz " + dest_instruction[1] + " " + dest_instruction[2]
				} else if (dest_instruction[0] == "jnz") {
					ProgramCode[tglincr] = "cpy " + dest_instruction[1] + " " + dest_instruction[2]
				}
			}
			ProgramCount = ProgramCount + 1


		}
// ***********************************************************************		

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