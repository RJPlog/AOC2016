import java.io.File
import kotlin.math.*

fun main(args: Array<String>) {
//****************************************************************************	
//*     Declaration Variablen
//****************************************************************************

	var y_direction = 0        //Zählvariable für N/S
	var x_direction = 0        //Zählvariable für W/O

	var heading: Int = 1     // 1= N, 2 = 0, 3 = S, 0 = W
	var turn: Char              // zwischenvariable für R bzw. L
	var way: Int

	val path = mutableListOf<String>()


	var vist_twice: Boolean = false  // für part 2
	var y_direction_twice = 0        //Zählvariable für N/S für part 2
	var x_direction_twice = 0        //Zählvariable für W/O	für part 2


//****************************************************************************	
//*     Einlesen Puzzledaten und direkt Berechnung des Weges.
//****************************************************************************

	File("day1601_puzzle_input.txt").forEachLine {
		val singlestep = it.split(", ")
		singlestep.forEach {
			turn = it.first()

// Bestimmung Himmelsrichtung aus Turn Anweisung			
			if (turn.equals('R')) {
				heading = heading + 1
				if (heading == 4) {
					heading = 0
				}
			} else if (turn.equals('L')) {
				heading = heading - 1
				if (heading == -1) {
					heading = 3
				}
			}

// Bestimmung Anzahl Schritte aus Anweisung			
			way = it.removeRange(0, 1).toInt()

// Bewegen und Abspeichern des Weges in Liste. Dabei direkt Prüfen, ob Liste diesen Punkt bereits enthält, damit der erste Crosspunkt für Teil zwei gespeichert werden kann			
			if (heading == 1) {
				for (i in 1..way) {
					y_direction = y_direction + 1
					if (!vist_twice && path.contains(x_direction.toString() + "|" + y_direction.toString())) {
						vist_twice = true
						y_direction_twice = y_direction
						x_direction_twice = x_direction
					}
					path.add(x_direction.toString() + "|" + y_direction.toString())
				}
			} else if (heading == 2) {
				for (i in 1..way) {
					x_direction = x_direction + 1
					if (!vist_twice && path.contains(x_direction.toString() + "|" + y_direction.toString())) {
						vist_twice = true
						y_direction_twice = y_direction
						x_direction_twice = x_direction
					}
					path.add(x_direction.toString() + "|" + y_direction.toString())
				}
			} else if (heading == 3) {
				for (i in 1..way) {
					y_direction = y_direction - 1
					if (!vist_twice && path.contains(x_direction.toString() + "|" + y_direction.toString())) {
						vist_twice = true
						y_direction_twice = y_direction
						x_direction_twice = x_direction
					}
					path.add(x_direction.toString() + "|" + y_direction.toString())
				}
			} else if (heading == 0) {
				for (i in 1..way) {
					x_direction = x_direction - 1
					if (!vist_twice && path.contains(x_direction.toString() + "|" + y_direction.toString())) {
						vist_twice = true
						y_direction_twice = y_direction
						x_direction_twice = x_direction
					}
					path.add(x_direction.toString() + "|" + y_direction.toString())
				}
			}




			println(
				"turn ${it.first()} and move ${it.removeRange(
					0,
					1
				)}, means in direction ${heading}, then y = $y_direction, x = $x_direction"
			)

		}

	}

	// Ausgabe der Lösung für Part 1
	println()
	println("******************")
	println("Solution for part1")
	println(
		"   Distance is ${abs(y_direction)} in Y and ${abs(x_direction)} in X which is in sum ${abs(y_direction) + abs(
			x_direction
		)} "
	)
	println()

	// Ausgabe der Lösung für Part 2
	println()
	println("******************")
	println("Solution for part2")
	println(
		"   Der Erste zum 2. mal besuchte Ort ist $y_direction_twice in Y and $x_direction_twice in X which is in sum ${abs(
			y_direction_twice
		) + abs(x_direction_twice)} "
	)
	println()
	println(path)


}