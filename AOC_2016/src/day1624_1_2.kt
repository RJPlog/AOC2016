import java.io.File
import kotlin.math.*

// Aufsetzen des Grids für vorgegebene Größe und Favorite Number
fun SetupGrid24(): MutableMap<String, String> {
	val Grid = mutableMapOf<String, String>()
	var Position: String
	var Texture: String
	var ypos: Int = 0


	File("day1624_puzzle_input.txt").forEachLine {
		for (xpos in 0..it.length - 1) {
			Position = xpos.toString() + "=" + ypos.toString()
			Texture = it[xpos].toString()
			Grid.put(Position, Texture)
		}
		ypos = ypos + 1
	}
	return Grid
}

fun WidthGrid24(): Int {
	var width: Int = 0
	File("day1624_puzzle_input.txt").forEachLine { width = it.length - 1 }
	return width
}

fun DepthGrid24(): Int {
	var depth: Int = 0
	File("day1624_puzzle_input.txt").forEachLine { depth = depth + 1 }
	return depth - 1
}


// Zeichnen des aktuellenGrids
fun PrintGrid24(width: Int, depth: Int, Grid: MutableMap<String, String>) {
	for (y in 0..depth) {
		for (x in 0..width) {
			var Position = x.toString() + "=" + y.toString()
			print(Grid.get(Position))
		}
		println()
	}
	println()
}


fun CleanGrid24(Grid: MutableMap<String, String>): MutableMap<String, String> {
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


fun WalkGridtoX(start: String, end: String, Grid_input: MutableMap<String, String>): Int {
	var step = "0"
	var endnotreached = true
	var Grid = Grid_input

	// Zunächt enthält das Gitter mehrere Punkte, die ereicht werden müssen, das ist schlecht für's Zählen, deswegen werden die für den aktuellen Aufruf unwichtigen hier durch "." ersetzt.
	var prepareGrid = Grid.filterValues { it != "#" }
	prepareGrid = prepareGrid.filterValues { it != "." }
	prepareGrid = prepareGrid.filterValues { it != start }
	prepareGrid = prepareGrid.filterValues { it != end }
	prepareGrid.forEach {
		Grid.put(it.key, ".")
	}
	// die zu erreichenden Punkte sind mit Nummern markiert, das funktioniert nicht mit dem Zählen, deswegen werden Start und Ziel mit "0" und "X" markiert.
	prepareGrid = Grid.filterValues { it == end }
	prepareGrid.forEach {
		Grid.put(it.key, "X")
	}
	prepareGrid = Grid.filterValues { it == start }  /// ??
	prepareGrid.forEach {
		Grid.put(it.key, "0")
	}
//	PrintGrid24(10, 4, Grid)

	// ab jetzt wird von "O" an gezählt, bis "X" erreicht wird, und dann der Zählerwert zurück gegeben.
	while (endnotreached) {
//for (i in 0..1) {

		val filteredGrid = Grid.filterValues { it == step }
		var Hilf1: String
//		var Position: String
		var Texture: String

		filteredGrid.forEach {
			val instruction = it.toString().split("=")
//			Position = instruction[0] + "=" + instruction[1]
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
	var Grid_Init = SetupGrid24()

	// Ermittle width and depth
	var width = WidthGrid24()
	var depth = DepthGrid24()

	// Ausgabe des Grids
	PrintGrid24(width, depth, Grid_Init)

	// Lösche alle unnötigen Pfade in Grid (besere Übersicht)
	var Grid_Clean = CleanGrid24(Grid_Init)


	// Ausgabe des Grids
//	PrintGrid24(width, depth, Grid)
	
	// hier wird für alle möglichen Punktepaare die Distanz zueinander berechent und in einer Map abgelegt.
	var distmap = mutableMapOf<String, Int>()
	for (i in 0..7) {
		for (j in 0..7) {  // 0..7 is for part2, 1..7 is enough for part1
			if (j != i) {
				Grid_Init = SetupGrid24()
				Grid_Clean = CleanGrid24(Grid_Init)

				var dist =
					WalkGridtoX(i.toString(), j.toString(), Grid_Clean)  // das tut noch nicht :-( -- jetzt schon :-)
				distmap.put(i.toString() + j.toString(), dist)
				println(distmap)

			}

		}
	}

	
	// hier werden alle möglichen Reihenfolgen erzeugt, und wenn gültig die Summe der jeweiligen Schritte berechnet. Das min wird jeweils abgespeichert.
	var path = mutableMapOf<String, Int>()
	for (k0 in 0..7) {
		for (k1 in 1..7) {
			for (k2 in 1..7) {
				for (k3 in 1..7) {
					for (k4 in 1..7) {
						for (k5 in 1..7) {
							for (k6 in 1..7) {
								for (k7 in 1..7) {
									var line =
										k0.toString() + k1.toString() + k2.toString() + k3.toString() + k4.toString() + k5.toString() + k6.toString() + k7.toString()
									if (line.contains("0") && line.contains("1") && line.contains("2") && line.contains("3") && line.contains("4") && line.contains("5") && line.contains("6") && line.contains("7")) {
										path.put(line+"0", 0)  // the +"0" is for part 2, remove it for part 1
									}
								}
							}
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
	// 628 is to high
	
	println()
	println("******************")
	println("Solution for part1")
	println("    The fewest number of steps is  $waymin")
	println()


}