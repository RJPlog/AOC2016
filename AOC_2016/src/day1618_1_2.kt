import java.io.File
import kotlin.math.*

fun main(args: Array<String>) {

	val TileFloor = mutableListOf<String>()
	var TileRow: String = ""
	var TileRow2: String = "."
	var SafeCount: Int = 0

	File("day1618_puzzle_input.txt").forEachLine {
		TileRow = "." + it + "."
		TileFloor.add(TileRow)
	}

	println(TileRow)
	
	for (i in 1..40-1) {
		for (j in 1..TileRow.length - 2) {
			if (TileRow.substring(j - 1, j + 2).equals("^^.") || TileRow.substring(
					j - 1,
					j + 2
				).equals(".^^") || TileRow.substring(j - 1, j + 2).equals("^..") || TileRow.substring(
					j - 1,
					j + 2
				).equals("..^")
			) {
				TileRow2 = TileRow2 + "^"
			} else {
				TileRow2 = TileRow2 + "."
			}
		}
				TileRow2 = TileRow2 +"."
	//	println(TileRow2)
        TileFloor.add(TileRow2)
				TileRow = TileRow2
		TileRow2 = "."
		}

	TileFloor.forEach{
		TileRow = it
		for  (k in 1.. TileRow.length-2){
			if (TileRow[k].equals('.')) {
				SafeCount = SafeCount +1
			}
		}
	}
//	println(TileFloor)
	
// Ausgabe der Lösung für Part 1
	println()
	println("******************")
	println("Solution for part1")
	println("    There are $SafeCount safe tiles  ")
	println()


}
