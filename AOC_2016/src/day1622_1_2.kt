import java.io.File
import kotlin.math.*

fun ViablePairs(): Int {
	var count: Int = 0
	var NodeA = mutableMapOf<String, Int>()
	var NodeB = mutableMapOf<String, Int>()
	var Intro: String = "/dev/grid/node-"
	var ithelp: String
	var used: Int
	var avail: Int
	var position: String

	File("day1622_puzzle_input.txt").forEachLine {
		ithelp = it.replace("      ", " ")
		ithelp = ithelp.replace("     ", " ")
		ithelp = ithelp.replace("    ", " ")
		ithelp = ithelp.replace("   ", " ")
		ithelp = ithelp.replace("  ", " ")
		//println(ithelp)
		var instruction = ithelp.split(" ")
		if (instruction[0].take(15) == Intro) {
			position = instruction[0].replace(Intro, "")
			used = instruction[2].dropLast(1).toInt()
			avail = instruction[3].dropLast(1).toInt()
//			println(" Node: $position, used: $used, avail: $avail ")
			if (used > 0) {
				NodeA.put(position, used)
			}
			NodeB.put(position, avail)
		}
	}

// how to do a nested Loop?
	NodeA.forEach {
		var NodeAposition = it.key
		var NodeAused = it.value
		NodeB.forEach {
			var NodeBposition = it.key
			var NodeBavail = it.value
			//println("NodeA, $NodeAposition, Used: $NodeAused, NodeB, $NodeBposition, Avail: $NodeBavail")
			if (NodeA != NodeB) {
				if (NodeAused <= NodeBavail) {
					count = count + 1
				}
			}
		}
	}

	return count
}

fun SetupGrid22(): MutableMap<String, String> {
	val Grid = mutableMapOf<String, String>()
	var Position: String
	var Texture: String
	var ypos: Int = 0

	var count: Int = 0
	var NodeA = mutableMapOf<String, Int>()
	var NodeB = mutableMapOf<String, Int>()
	var Intro: String = "/dev/grid/node-"
	var ithelp: String
	var used: Int
	var avail: Int
	var position: String

	File("day1622_puzzle_input.txt").forEachLine {
		ithelp = it.replace("      ", " ")
		ithelp = ithelp.replace("     ", " ")
		ithelp = ithelp.replace("    ", " ")
		ithelp = ithelp.replace("   ", " ")
		ithelp = ithelp.replace("  ", " ")
		//println(ithelp)
		var instruction = ithelp.split(" ")
		if (instruction[0].take(15) == Intro) {
			position = instruction[0].replace(Intro, "")
			used = instruction[2].dropLast(1).toInt()
			if (used > 100) {
				Grid.put(position, "# ")
			}
			if (used < 100 && used > 10) {
				Grid.put(position, ". ")
			}
			if (used < 10) {
				Grid.put(position, "_ ")
			}
		}
	}
	Grid.put("x34-y0", "D ")
	return Grid
}


// Zeichnen des aktuellenGrids
fun PrintGrid22(width: Int, depth: Int, Grid: MutableMap<String, String>) {
	for (y in 0..depth) {
		for (x in 0..width) {
			var Position = "x"+x.toString() + "-y" + y.toString()
			print(Grid.get(Position))
		}
		println()
	}
	println()
}


fun main(args: Array<String>) {


	var count1: Int

	count1 = ViablePairs()
	
		// Grid wird aus Puzzle_Input eingelesen
	var Grid_Init = SetupGrid22()

	// Ermittle width and depth
	var width = 34
	var depth = 28

	// Ausgabe des Grids
	PrintGrid22(width, depth, Grid_Init)


	// Ausgabe der Lösung für Part 1
	println()
	println("******************")
	println("Solution for part1")
	println("   there are $count1 viable pairs")
	println()
	
		// Ausgabe der Lösung für Part 2 --> hier habe ich das Grid in Excel übertragen und einfach gezählt, erst "_" nach oben und rechts gebracht, 27, dann 5*33 um "D" nach links zu bringen
	println()
	println("******************")
	println("Solution for part2")
	println("   The fewest number of steps required to move your goal data to node-x0-y0 ist 192")
	println()
	
	
}