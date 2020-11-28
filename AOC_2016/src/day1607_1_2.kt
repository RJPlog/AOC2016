import java.io.File
import kotlin.math.*

fun main(args: Array<String>) {
//****************************************************************************	
//*     Declaration Variablen
//****************************************************************************


	var solution1: Int = 0
	var searchstring_element: String
	var sb_inner: Boolean = false
	var sb_outer: Boolean = false

	var toggle: Int

// variables part 2
	var solution2: Int = 0
	var aba = mutableListOf<String>()
	var bab = mutableListOf<String>()
	var ssl_condition: Boolean = false
	var com_val: String 

//****************************************************************************	
//*     Einlesen Puzzledaten und direkt Berechnung des Weges.
//****************************************************************************


// Part 1
	File("day1607_puzzle_input.txt").forEachLine {

		toggle = 1
		// teile Eingangszeile in mehrere Elemente
		var searchstring = it.split("[", "]")

		// für jedes Element suche nach abba
		searchstring.forEach {
			if (toggle == 1) {
				searchstring_element = it
				if (searchstring_element.length > 3) {
					for (i in 0..searchstring_element.length - 4) {
//						println("0: ${searchstring_element[i]}, 1: ${searchstring_element[i + 1]}, 2: ${searchstring_element[i + 2]}, 3: ${searchstring_element[i + 3]} ")
						if (searchstring_element[i + 0].equals(searchstring_element[i + 3]) && searchstring_element[i + 1].equals(
								searchstring_element[i + 2]
							) && !searchstring_element[i + 0].equals(
								searchstring_element[i + 1]
							)
						) {
							// if abba found, set successbit_outside true
							sb_inner = true
//							println("yeah!!!!")
						}
					}
				}
				toggle = 0
			} else if (toggle == 0) {
				searchstring_element = it
				if (searchstring_element.length > 3) {
					for (i in 0..searchstring_element.length - 4) {
//						println("0: ${searchstring_element[i]}, 1: ${searchstring_element[i + 1]}, 2: ${searchstring_element[i + 2]}, 3: ${searchstring_element[i + 3]} ")
						if (searchstring_element[i + 0].equals(searchstring_element[i + 3]) && searchstring_element[i + 1].equals(
								searchstring_element[i + 2]
							) && !searchstring_element[i + 0].equals(
								searchstring_element[i + 1]
							)
						) {
							// if abba found, set successbit_outside true
							sb_outer = true
//							println("shit!!!!")
						}
					}
				}
				toggle = 1
			}


		}
//				println(" cond inner $sb_inner and outer $sb_outer")
		if (sb_inner && !sb_outer) {
			solution1 = solution1 + 1
		}
		sb_inner = false
		sb_outer = false

	}


//******************************************************************************************	
// part 2
//******************************************************************************************	

	File("day1607_puzzle_input.txt").forEachLine {

		toggle = 1
		// teile Eingangszeile in mehrere Elemente
		var searchstring = it.split("[", "]")

		// für jedes Element suche nach abba
		searchstring.forEach {
			if (toggle == 1) {
				searchstring_element = it
				if (searchstring_element.length > 2) {
					for (i in 0..searchstring_element.length - 3) {
						//					println("0: ${searchstring_element[i]}, 1: ${searchstring_element[i + 1]}, 2: ${searchstring_element[i + 2]}")
						if (searchstring_element[i + 0].equals(searchstring_element[i + 2]) && !searchstring_element[i + 0].equals(
								searchstring_element[i + 1]
							)
						) {
							// if abba found, set successbit_outside true
							aba.add(searchstring_element[i + 0].toString() + searchstring_element[i + 1].toString() + searchstring_element[i + 2].toString())
							//					println("yeah!!!!")
						}
					}
				}
				toggle = 0
			} else if (toggle == 0) {
				searchstring_element = it
				if (searchstring_element.length > 2) {
					for (i in 0..searchstring_element.length - 3) {
						//				println("0: ${searchstring_element[i]}, 1: ${searchstring_element[i + 1]}, 2: ${searchstring_element[i + 2]}, 3: ${searchstring_element[i + 3]} ")
						if (searchstring_element[i + 0].equals(searchstring_element[i + 2]) && !searchstring_element[i + 0].equals(
								searchstring_element[i + 1]
							)
						) {
							// if abba found, set successbit_outside true
							bab.add(searchstring_element[i + 0].toString() + searchstring_element[i + 1].toString() + searchstring_element[i + 2].toString())
							//					println("shit!!!!")
						}
					}
				}
				toggle = 1
			}


		}
		println("line parsed, look at the results:")
		println("  aba: $aba")
		println("  bab: $bab")

		aba.forEach {
			com_val = it[1].toString() + it[0] + it[1]
			println("    it: $it, compare value = $com_val")
			if (bab.contains(com_val)) {
				ssl_condition = true
				println("       yeah!!!")
			}
		}
		if (ssl_condition == true) {
			solution2 = solution2 + 1
			ssl_condition = false
		}
		println()
		aba.clear()
		bab.clear()

	}


// Ausgabe der Lösung für Part 1
	println()
	println("******************")
	println("Solution for part1")
	println("   $solution1 IPs of the input support TLS")
	println()

// Ausgabe der Lösung für Part 2   :259 is to high
	println()
	println("******************")
	println("   $solution2 IPs of the input support SSL")
	println("...")
	println()
}