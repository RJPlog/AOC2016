import java.io.File
import kotlin.math.*

// Aufsetzen des Grids für vorgegebene Größe und Favorite Number
fun SetupGrid17(width: Int, depth: Int): MutableMap<String, String> {
	val Grid = mutableMapOf<String, String>()
	var Position: String
	var Texture: String

	for (y in 0..depth) {
		for (x in 0..width) {
			Position = x.toString() + "=" + y.toString()
			Texture = "."
			Grid.put(Position, Texture)
		}
	}
	return Grid
}

// Zeichnen des aktuellenGrids
fun PrintGrid17(width: Int, depth: Int, Grid: MutableMap<String, String>) {
	for (y in 0..depth) {
		for (x in 0..width) {
			var Position = x.toString() + "=" + y.toString()
			print(Grid.get(Position))
		}
		println()
	}
	println()
}

fun main(args: Array<String>) {

//****************************************************************************	
//*     Declaration Variablen
//****************************************************************************

	val width: Int = 3
	val depth: Int = 3
	var PassCode: String = "ulqzkmiv"
	var Path: String
	var PathMap = mutableMapOf<String, String>()
	var PathShort: String = ""

// Setze Grid auf
	var Grid = SetupGrid17(width, depth)

// Start und Endpunkt markieren
	Grid.put("3=3", "V")

// Zeichne Grid
	println("*** Initialize ***")
	PrintGrid(width, depth, Grid)
	println()
	println("PathMap: $PathMap")

	var Hilf1: String
	var StepCount: Int = 0
	var VaultReached: Boolean = false

	println()
//	println("*** Start Part 1***")
	PathMap.put("", "0=0")

	while (!VaultReached) {

		val filteredPathMap = PathMap.filterKeys { it.length == StepCount }
//	    println()	
//		println("Run $StepCount: FilteredMap: $filteredPathMap")
		filteredPathMap.forEach {
			val instruction = it.toString().split("=")
			Path = instruction[0]
//			var pos = instruction[1] + "=" + instruction[2]  // Hier Pfad aus filteredMap Value holen
			var md5 = (PassCode + Path).md5()
//			println("   Pos $pos")	
//			println("   Passcode + Path: ${PassCode+Path} --> Hash: $md5")
			// check up
			if (md5[0].equals('b') || md5[0].equals('c') || md5[0].equals('d') || md5[0].equals(
					'e'
				) || md5[0].equals('f')
			) {
				//check if there is a field
				Hilf1 = instruction[1] + "=" + (instruction[2].toInt() - 1).toString()
				if (Grid.get(Hilf1) == ".") {
					PathMap.put(Path + "U", Hilf1)
				} else if (Grid.get(Hilf1) == "V") {
					VaultReached = true
					PathShort = Path + "U"
				}
			}
			// check down
			if (md5[1].equals('b') || md5[1].equals('c') || md5[1].equals('d') || md5[1].equals(
					'e'
				) || md5[1].equals('f')
			) {
				//check if there is a field
				Hilf1 = instruction[1] + "=" + (instruction[2].toInt() + 1).toString()
				if (Grid.get(Hilf1) == ".") {
					PathMap.put(Path + "D", Hilf1)
				} else if (Grid.get(Hilf1) == "V") {
					VaultReached = true
					PathShort = Path + "D"
				}
			}
			// check left
			if (md5[2].equals('b') || md5[2].equals('c') || md5[2].equals('d') || md5[2].equals(
					'e'
				) || md5[2].equals('f')
			) {
				//check if there is a field
				Hilf1 = (instruction[1].toInt() - 1).toString() + "=" + instruction[2]
				if (Grid.get(Hilf1) == ".") {
					PathMap.put(Path + "L", Hilf1)
				} else if (Grid.get(Hilf1) == "V") {
					VaultReached = true
					PathShort = Path + "L"
				}
			}
			// check right
			if (md5[3].equals('b') || md5[3].equals('c') || md5[3].equals('d') || md5[3].equals(
					'e'
				) || md5[3].equals('f')
			) {
				//check if there is a field
				Hilf1 = (instruction[1].toInt() + 1).toString() + "=" + instruction[2]
				if (Grid.get(Hilf1) == ".") {
					PathMap.put(Path + "R", Hilf1)
				} else if (Grid.get(Hilf1) == "V") {
					VaultReached = true
					PathShort = Path + "R"
				}
			}
			//println("PathMap $PathMap")
		}
		StepCount = StepCount + 1
	}

	// Ausgabe der Lösung für Part 1
	println()
	println("******************")
	println("Solution for part1")
	println("    The shortest Path is  $PathShort")
	println()

// ******************************************************************************************************************************************************
// *                                        PART 2
// ******************************************************************************************************************************************************


	println()
	println("*** Start Part 2***")
	PathMap.clear()
	PathMap.put("", "0=0")
	PassCode = "gdjjyniy"
	var PathLong: Int = 0
	StepCount = 0
	VaultReached = false


while (!VaultReached) {  //  while (StepCount < 7 ) { //

		val filteredPathMap2 = PathMap.filterKeys { it.length == StepCount }


		val filteredPathMap = filteredPathMap2.filterValues { it != "3=3" }

		if (filteredPathMap.size == 0) {
			VaultReached = true
			break
		}

//		println()
//		println("Run $StepCount: FilteredMap: ${filteredPathMap.size}")
		filteredPathMap.forEach {
			val instruction = it.toString().split("=")
			Path = instruction[0]
//			var pos = instruction[1] + "=" + instruction[2]  // Hier Pfad aus filteredMap Value holen
			var md5 = (PassCode + Path).md5()
		//			print("   Pos $pos")	
		//			println("   Passcode + Path: ${PassCode+Path} --> Hash: $md5")
			// check up
			if (md5[0].equals('b') || md5[0].equals('c') || md5[0].equals('d') || md5[0].equals(
					'e'
				) || md5[0].equals('f')
			) {
				//check if there is a field
				Hilf1 = instruction[1] + "=" + (instruction[2].toInt() - 1).toString()
				if (Grid.get(Hilf1) == "." || Grid.get(Hilf1) == "V") {
					PathMap.put(Path + "U", Hilf1)
				}
				if (Grid.get(Hilf1) == "V"){
					PathLong = (Path.length + 1)
				}
			}
			// check down
			if (md5[1].equals('b') || md5[1].equals('c') || md5[1].equals('d') || md5[1].equals(
					'e'
				) || md5[1].equals('f')
			) {
				//check if there is a field
				Hilf1 = instruction[1] + "=" + (instruction[2].toInt() + 1).toString()
				if (Grid.get(Hilf1) == "." || Grid.get(Hilf1) == "V") {
					PathMap.put(Path + "D", Hilf1)
				}
								if (Grid.get(Hilf1) == "V"){
					PathLong = (Path.length + 1)
				}
			}
			// check left
			if (md5[2].equals('b') || md5[2].equals('c') || md5[2].equals('d') || md5[2].equals(
					'e'
				) || md5[2].equals('f')
			) {
				//check if there is a field
				Hilf1 = (instruction[1].toInt() - 1).toString() + "=" + instruction[2]
				if (Grid.get(Hilf1) == "." || Grid.get(Hilf1) == "V") {
					PathMap.put(Path + "L", Hilf1)
				}
								if (Grid.get(Hilf1) == "V"){
					PathLong = (Path.length + 1)
				}
			}
			// check right
			if (md5[3].equals('b') || md5[3].equals('c') || md5[3].equals('d') || md5[3].equals(
					'e'
				) || md5[3].equals('f')
			) {
				//check if there is a field
				Hilf1 = (instruction[1].toInt() + 1).toString() + "=" + instruction[2]
				if (Grid.get(Hilf1) == "." || Grid.get(Hilf1) == "V") {
					PathMap.put(Path + "R", Hilf1)
				}
								if (Grid.get(Hilf1) == "V"){
					PathLong = (Path.length + 1)
				}
			}
			//println("PathMap $PathMap")
		}
		StepCount = StepCount + 1
	}


// Ausgabe der Lösung für Part 2
	println()
	println("******************")
	println("Solution for part2")
	println("    The longest Path is  $PathLong")
	println()


}
