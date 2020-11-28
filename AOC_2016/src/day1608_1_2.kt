import java.io.File
import kotlin.math.*

fun main(args: Array<String>) {
//****************************************************************************	
//*     Declaration Variablen
//****************************************************************************

// Example
/*		val display_width: Int = 7
	val display_high: Int = 3

	val display = arrayOf(
		arrayOf(0, 0, 0, 0, 0, 0, 0),
		arrayOf(0, 0, 0, 0, 0, 0, 0),
		arrayOf(0, 0, 0, 0, 0, 0, 0)
	)
	val display_B = arrayOf(
		arrayOf(0, 0, 0, 0, 0, 0, 0),
		arrayOf(0, 0, 0, 0, 0, 0, 0),
		arrayOf(0, 0, 0, 0, 0, 0, 0)
	) */

// puzzle_input
	val display_width: Int = 50
	val display_high: Int = 6

	val display = arrayOf(
arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),				
arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
							)
	val display_B = arrayOf(
arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),				
arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
							)

	var coord_rect: String
	var coord_rect_width: Int
	var coord_rect_high: Int


	var coord_rot_row_row: Int
	var coord_rot_row_step: Int

	var coord_rot_col_col: Int
	var coord_rot_col_step: Int

	var hilf1: Int 

	var lamp_count: Int = 0

// variables part 2


//****************************************************************************	
//*     Einlesen Puzzledaten und direkt Berechnung des Weges.
//****************************************************************************


// Part 1
	// gib Display aus
	for (i in 0..display_high - 1) {
		for (j in 0..display_width - 1) {
			print(display[i][j])
		}
		println()
	}

	// Lese Instruktionen ein und bearbeite Display
	File("day1608_puzzle_input.txt").forEachLine {
		println()
		println("Zeile auswerten:")

		val instruction = it.split(" ")

		if (instruction[0].equals("rect")) {
			coord_rect = instruction[1].toString()
			val hilf2 = coord_rect.split("x")
			println(hilf2)
			coord_rect_width = hilf2[0].toString().toInt()
			coord_rect_high = hilf2[1].toString().toInt()
			println("   instruction was rect , width $coord_rect_width and high $coord_rect_high")
			for (i in 0..coord_rect_high - 1) {
				for (j in 0..coord_rect_width - 1) {
					display_B[i][j] = 1
				}
			} 
 
		} else if (instruction[0].equals("rotate")) {
			if (instruction[1].equals("column")) {
				coord_rot_col_col = instruction[2].removeRange(0, 2).toString().toInt()
				coord_rot_col_step = instruction[4].toString().toInt()
				println("   instruction was rotate column nr: $coord_rot_col_col by $coord_rot_col_step ")
				for (i in 0..display_high - 1) {
					hilf1 = i + coord_rot_col_step
					if (hilf1 > (display_high - 1)) {
						hilf1 = hilf1 - (display_high)
					}
					display_B[hilf1][coord_rot_col_col] = display[i][coord_rot_col_col]
				}

			} else if (instruction[1].equals("row")) {
				coord_rot_row_row = instruction[2].removeRange(0, 2).toString().toInt()
				coord_rot_row_step = instruction[4].toString().toInt()
				println("   instruction was rotate column nr: $coord_rot_row_row by $coord_rot_row_step ")
				for (j in 0..display_width - 1) {
					hilf1 = j + coord_rot_row_step
					if (hilf1 > (display_width - 1)) {
						hilf1 = hilf1 - (display_width)
					}

					display_B[coord_rot_row_row][hilf1] = display[coord_rot_row_row][j]
				}
			}
		}

		// gib Display aus und schreibe Hilfsdisplay auf Originaldisplay
		for (i in 0..display_high - 1) {
			for (j in 0..display_width - 1) {
				display[i][j] = display_B[i][j]
					print(display[i][j])
			}
			println()
		}




		println()
	}


	// berechne angeschaltete Lampen
	for (i in 0..display_high - 1) {
		for (j in 0..display_width - 1) {
			if (display[i][j] == 1) {
				lamp_count = lamp_count + 1
			}

		}
	}

// Ausgabe der Lösung für Part 1
	println()
	println("******************")
	println("Solution for part1")
	println("   $lamp_count pixels should be lit")
	println()

// Ausgabe der Lösung für Part 2
	println()
	println("******************")
	println("Solution for part2")
		for (i in 0..display_high - 1) {
			for (j in 0..display_width - 1) {
				display[i][j] = display_B[i][j]
				if (display[i][j] == 1){
				print("MM")
					//print(display[i][j])
				} else {print("  ")}
				
			}
			println()
		}
	println()
}