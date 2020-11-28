// 11.10.2020

import java.io.File
import kotlin.math.*

fun depac(depac_input: String): Int {

	var depac_string: String
	var bracket1_index: Int
	var bracket2_index: Int
	var marker: String
	var range_index: Int
	var repeat_index: Int
	var decomp_length: Int = 0

	depac_string = depac_input

	while (!depac_string.isNullOrEmpty()) {

		if (depac_string.contains("(")) {
			//suche erste Klammer
			bracket1_index = depac_string.indexOf("(")
			bracket2_index = depac_string.indexOf(")")

			// lese decompressionsvorschrift aus
			marker = depac_string.substring(bracket1_index + 1, bracket2_index)

			// werte Marker aus und ermittle Indizies für zu vervielfältigenden Bereich.
			// marker splitten bei x, siehe day 08, dann die beiden Werte zu Int machen.

			val hilf2 = marker.split("x")
			range_index = hilf2[0].toString().toInt()
			repeat_index = hilf2[1].toString().toInt()

			// Addiere Länge vor Decompressionsvorschrift auf
			decomp_length = decomp_length + depac_string.substring(0, bracket1_index).length

			//  x-mal Länge des Wiederholbereichs aufaddieren
			for (i in 1..repeat_index) {
				decomp_length = decomp_length + depac_string.substring(
					bracket2_index + 1,
					bracket2_index + range_index + 1
				).length
			}


			// lösche dekompriemierten Teil + Marker von Eingangsstring + Anwendungsbereich
			depac_string = depac_string.removeRange(0, bracket2_index + range_index + 1)

		} else {
			// länge des Reststrings aufaddieren.
			decomp_length = decomp_length + depac_string.length
			depac_string = ""
		}

	}  // Ende While Schleife

	return decomp_length
}


fun depac_enhanced(depac_input: String): Long {

	var depac_string: String
	var bracket1_index: Int
	var bracket2_index: Int
	var marker: String
	var range_index: Int
	var repeat_index: Int
	var repeat_area: String
	var decomp_length: Long = 0

	depac_string = depac_input

	while (!depac_string.isNullOrEmpty()) {

		if (depac_string.contains("(")) {
			//suche erste Klammer
			bracket1_index = depac_string.indexOf("(")
			bracket2_index = depac_string.indexOf(")")

			// lese decompressionsvorschrift aus
			marker = depac_string.substring(bracket1_index + 1, bracket2_index)

			// werte Marker aus und ermittle Indizies für zu vervielfältigenden Bereich.
			// marker splitten bei x, siehe day 08, dann die beiden Werte zu Int machen.

			val hilf2 = marker.split("x")
			range_index = hilf2[0].toString().toInt()
			repeat_index = hilf2[1].toString().toInt()

			repeat_area = depac_string.substring(bracket2_index + 1, bracket2_index + range_index + 1)

			// Addiere Länge vor Decompressionsvorschrift auf
			decomp_length = decomp_length + depac_string.substring(0, bracket1_index).length

			if (repeat_area.contains("(")) {

				decomp_length = decomp_length + depac_enhanced(repeat_area) * repeat_index

			} else {  // begin els 121

				//  x-mal Länge des Wiederholbereichs aufaddieren
				for (i in 1..repeat_index) {
					decomp_length = decomp_length + depac_string.substring(
						bracket2_index + 1,
						bracket2_index + range_index + 1
					).length
				}
			}  // end else 121

			// lösche dekompriemierten Teil + Marker von Eingangsstring + Anwendungsbereich
			depac_string = depac_string.removeRange(0, bracket2_index + range_index + 1)

		} else {
			// länge des Reststrings aufaddieren.
			decomp_length = decomp_length + depac_string.length
			depac_string = ""
		}

	}  // Ende While Schleife

	return decomp_length
}


fun main(args: Array<String>) {
//****************************************************************************	
//*     Declaration Variablen
//****************************************************************************

	var puzzle_input: String
	var decomp_length: Int = 0

// variables part 2
	var decomp_length2: Long = 0

//****************************************************************************	
//*     Einlesen Puzzledaten und direkt Berechnung des Weges.
//****************************************************************************


// Part 1
	File("day1609_puzzle_input.txt").forEachLine {
		puzzle_input = it
		decomp_length = 0
		println("  ****************************")
		println(puzzle_input)
		decomp_length = depac(puzzle_input)

		println("  Dekomprimierte Länge = $decomp_length")
		println("  ****************************")
		println()
		if (puzzle_input.contains(" ")) {
			println("Leerzeichen enthalten")
		}
	} // Ende Read Input for Part 1

// Part 2
	File("day1609_puzzle_input.txt").forEachLine {
		puzzle_input = it
		decomp_length2 = 0
		println("  ****************************")
		println(puzzle_input)
		decomp_length2 = depac_enhanced(puzzle_input)

		println("  Dekomprimierte Länge mit Enhanced Algorithmus = $decomp_length2")
		println("  ****************************")
		println()
		if (puzzle_input.contains(" ")) {
			println("Leerzeichen enthalten")
		}
	} // Ende Read Input for Part 1


// Ausgabe der Lösung für Part 1
	println()
	println("******************")
	println("Solution for part1")
	println("    The decompressed length of the file is $decomp_length")
	println()

// Ausgabe der Lösung für Part 2   :259 is to high
	println()
	println("******************")
	println("    The decompressed length of the file with improved format is $decomp_length2")
	println()
}