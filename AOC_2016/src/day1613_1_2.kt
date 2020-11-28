import java.io.File
import kotlin.math.*

// Aufsetzen des Grids für vorgegebene Größe und Favorite Number
fun SetupGrid(width: Int, depth: Int, Number: Int): MutableMap<String, String> {
	val Grid = mutableMapOf<String, String>()
	var Position: String
	var Texture: String
	var Hilf1: String

	for (y in 0..depth) {
		for (x in 0..width) {
			Position = x.toString() + "=" + y.toString()
			Hilf1 = (x * x + 3 * x + 2 * x * y + y + y * y + Number).toString(2).replace("0", "")
			if (Hilf1.length % 2 == 0) {
				Texture = "."
			} else {
				Texture = "#"
			}
			Grid.put(Position, Texture)
		}
	}
	return Grid
}

// Zeichnen des aktuellenGrids
fun PrintGrid(width: Int, depth: Int, Grid: MutableMap<String, String>) {
	for (y in 0..depth) {
		for (x in 0..width) {
			var Position = x.toString() + "=" + y.toString()
			print(Grid.get(Position))
		}
		println()
	}
	println()
}

// Führe einen Schritt vom Ausgangspunkt aus
fun WalkGrid(step: String, Grid: MutableMap<String, String>): MutableMap<String, String> {

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
		}
		Hilf1 = (instruction[0].toInt() + 1).toString() + "=" + instruction[1]
		//println("Instruction: $instruction, Position: $Position, Texture: $Texture, Hilf1: $Hilf1")
		if (Grid.get(Hilf1) == ".") {
			Grid.put(Hilf1, Texture)
		}
		Hilf1 = instruction[0] + "=" + (instruction[1].toInt() - 1).toString()
		//println("Instruction: $instruction, Position: $Position, Texture: $Texture, Hilf1: $Hilf1")
		if (Grid.get(Hilf1) == ".") {
			Grid.put(Hilf1, Texture)
		}
		Hilf1 = instruction[0] + "=" + (instruction[1].toInt() + 1).toString()
		//println("Instruction: $instruction, Position: $Position, Texture: $Texture, Hilf1: $Hilf1")
		if (Grid.get(Hilf1) == ".") {
			Grid.put(Hilf1, Texture)
		}
	}

	return Grid
}

fun main(args: Array<String>) {

//****************************************************************************	
//*     Declaration Variablen
//****************************************************************************

	val width: Int = 50
	val depth: Int = 50
	
	var SumLocations: Int = 0


// Setze Grid auf
	var Grid = SetupGrid(width, depth, 1358)

// Start und Endpunkt markieren
	Grid.put("1=1", "0")
	Grid.put("31=39", "X")

// Zeichne Grid
//	PrintGrid(width, depth, Grid)

// Untersuche die nächsten Schritte
	for (k in 0..49) {
		var step = k.toString()
		Grid = WalkGrid(step, Grid)
	}
// Zeichne Grid
	PrintGrid(width, depth, Grid)
	println()
	print("  ")
	println(Grid.get("31=38"))
	print(Grid.get("30=39"))
	print("    ")
	println(Grid.get("32=39"))
	print("  ")
	println(Grid.get("31=40"))


// part 2
	for(j in 0..50) {
		val filteredGrid = Grid.filterValues { it == j.toString() }
		SumLocations = SumLocations + filteredGrid.size
	}
	
	
// Ausgabe der Lösung für Part 2
	println()
	println("******************")
	println("Solution for part2")
	println("    Within at least 50 steps $SumLocations could be reached")
	println()
}
