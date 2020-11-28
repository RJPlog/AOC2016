import java.io.File
import kotlin.math.*

// Aufsetzen des Grids für vorgegebene Größe und Favorite Number
fun SetupGrid24_t(): MutableMap<String, String> {
	val Grid = mutableMapOf<String, String>()
	var Position: String
	var Texture: String
	var ypos: Int = 0


	File("day1624_puzzle_input_test.txt").forEachLine {
		for (xpos in 0..it.length - 1) {
			Position = xpos.toString() + "=" + ypos.toString()
			Texture = it[xpos].toString()
			Grid.put(Position, Texture)
		}
		ypos = ypos + 1
	}
	return Grid
}

fun WidthGrid24_t(): Int {
	var width: Int = 0
	File("day1624_puzzle_input.txt").forEachLine { width = it.length - 1 }
	return width
}

fun DepthGrid24_t(): Int {
	var depth: Int = 0
	File("day1624_puzzle_input.txt").forEachLine { depth = depth + 1 }
	return depth - 1
}


// Zeichnen des aktuellenGrids
fun PrintGrid24_t(width: Int, depth: Int, Grid: MutableMap<String, String>) {
	for (y in 0..depth) {
		for (x in 0..width) {
			var Position = x.toString() + "=" + y.toString()
			print(Grid.get(Position))
		}
		println()
	}
	println()
}


fun CleanGrid24_t(Grid: MutableMap<String, String>): MutableMap<String, String> {
	var stilltogo: Boolean = true
	while (stilltogo) {
		stilltogo = false
		Grid.forEach {
			var position = it.key
			var texture = it.value

			var instruction = position.split("=")
			var xpos = instruction[0].toInt()
			var ypos = instruction[1].toInt()

			if (texture.equals(".")) {
				var posup = (xpos).toString() + "=" + (ypos - 1).toString()
				var posdown = (xpos).toString() + "=" + (ypos + 1).toString()
				var posleft = (xpos - 1).toString() + "=" + (ypos).toString()
				var posright = (xpos + 1).toString() + "=" + (ypos).toString()
				var textup = Grid.getValue(posup)
				var textdown = Grid.getValue(posdown)
				var textleft = Grid.getValue(posleft)
				var textright = Grid.getValue(posright)

				if (textup.equals("#") && textdown.equals("#") && textleft.equals("#") || textup.equals("#") && textdown.equals(
						"#"
					) && textright.equals("#") || textright.equals("#") && textdown.equals("#") && textleft.equals("#") || textright.equals(
						"#"
					) && textup.equals("#") && textleft.equals("#")
				) {
					Grid.put(position, "#")
					stilltogo = true
				}
			}
		}
	}
	return Grid
}


fun WalkGridtoX_t(start: String, end: String, Grid_input: MutableMap<String, String>): Int {
	var step = "0"
	var endnotreached = true
	var Grid = Grid_input

	var prepareGrid = Grid.filterValues { it != "#" }
	prepareGrid = prepareGrid.filterValues { it != "." }
	prepareGrid = prepareGrid.filterValues { it != start }
	prepareGrid = prepareGrid.filterValues { it != end }
	prepareGrid.forEach {
		Grid.put(it.key, ".")
	}
	prepareGrid = Grid.filterValues { it == end }
	prepareGrid.forEach {
		Grid.put(it.key, "X")
	}
	prepareGrid = Grid.filterValues { it == start }  /// ??
	prepareGrid.forEach {
		Grid.put(it.key, "0")
	}
	PrintGrid24(10, 4, Grid)

	while (endnotreached) {
//for (i in 0..1) {

		val filteredGrid = Grid.filterValues { it == step }
		var Hilf1: String
		var Position: String
		var Texture: String

		filteredGrid.forEach {
			val instruction = it.toString().split("=")
			Position = instruction[0] + "=" + instruction[1]
			Texture = (step.toInt() + 1).toString()
			Hilf1 = (instruction[0].toInt() - 1).toString() + "=" + instruction[1]
			//println("Instruction: $instruction, Position: $Position, Texture: $Texture, Hilf1: $Hilf1")
			if (Grid.get(Hilf1) == ".") {
				Grid.put(Hilf1, Texture)
			} else if (Grid.get(Hilf1) == "X") {
				endnotreached = false
			}
			Hilf1 = (instruction[0].toInt() + 1).toString() + "=" + instruction[1]
			//println("Instruction: $instruction, Position: $Position, Texture: $Texture, Hilf1: $Hilf1")
			if (Grid.get(Hilf1) == ".") {
				Grid.put(Hilf1, Texture)
			} else if (Grid.get(Hilf1) == "X") {
				endnotreached = false
			}
			Hilf1 = instruction[0] + "=" + (instruction[1].toInt() - 1).toString()
			//println("Instruction: $instruction, Position: $Position, Texture: $Texture, Hilf1: $Hilf1")
			if (Grid.get(Hilf1) == ".") {
				Grid.put(Hilf1, Texture)
			} else if (Grid.get(Hilf1) == "X") {
				endnotreached = false
			}
			Hilf1 = instruction[0] + "=" + (instruction[1].toInt() + 1).toString()
			//println("Instruction: $instruction, Position: $Position, Texture: $Texture, Hilf1: $Hilf1")
			if (Grid.get(Hilf1) == ".") {
				Grid.put(Hilf1, Texture)
			} else if (Grid.get(Hilf1) == "X") {
				endnotreached = false
			}
		}
		step = (step.toInt() + 1).toString()
	}
//	PrintGrid24(10, 4, Grid)
//	println(" EndnotReached: $endnotreached")
	return step.toInt()
}

fun main(args: Array<String>) {


	// Grid wird aus Puzzle_Input eingelesen
	var Grid_Init = SetupGrid24_t()

	// Ermittle width and depth
	var width = WidthGrid24_t()
	var depth = DepthGrid24_t()

	// Ausgabe des Grids
	PrintGrid24_t(width, depth, Grid_Init)

	// Lösche alle unnötigen Pfade in Grid (besere Übersicht)
	var Grid_Clean = CleanGrid24_t(Grid_Init)


	// Ausgabe des Grids
//	PrintGrid24(width, depth, Grid)
	var distmap = mutableMapOf<String, Int>()
	for (i in 0..4) {
		for (j in 1..4) {
			if (j != i) {
				Grid_Init = SetupGrid24_t()
				Grid_Clean = CleanGrid24_t(Grid_Init)

				var dist =
					WalkGridtoX_t(i.toString(), j.toString(), Grid_Clean)  // das tut noch nicht :-( -- jetzt schon :-)
				distmap.put(i.toString() + j.toString(), dist)
				println(distmap)

			}

		}
	}

	var path = mutableMapOf<String, Int>()
	for (k0 in 0..4) {
		for (k1 in 1..4) {
			for (k2 in 1..4) {
				for (k3 in 1..4) {
					for (k4 in 1..4) {
						var line = k0.toString() + k1.toString() + k2.toString() + k3.toString() + k4.toString()
						if (line.contains("0") && line.contains("1") && line.contains("2") && line.contains("3") && line.contains(
								"4"
							)
						) {
							path.put(line, 0)
						}
					}
				}
			}
		}
	}

	println(path)
	var way: Int = 0
	var waymin: Int = 10000
	var instruction: String = ""
	path.forEach {
		way = 0
		instruction = it.key
		for (m in 0..instruction.length - 2) {
			way = way + distmap.getValue(instruction.substring(m, m + 2))
		}
		if (way < waymin) {
			waymin = way
		}
		path.put(instruction, way)
	}

	println(path)

	// Ausgabe der Lösung für Part 1
	println()
	println("******************")
	println("Solution for part1")
	println("    The fewest number of steps is  $waymin")
	println()


}