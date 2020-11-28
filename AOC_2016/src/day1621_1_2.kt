import java.io.File
import kotlin.math.*

fun scramble(password: String): String {
	var stepcount: Int = 1
	var passwd = password

	File("day1621_puzzle_input.txt").forEachLine {
		var instruction = it.split(" ")
		if (instruction[0].equals("swap") && instruction[1].equals("position")) {  // ok
			var xpos = passwd.substring(instruction[2].toInt(), instruction[2].toInt() + 1)
			var ypos = passwd.substring(instruction[5].toInt(), instruction[5].toInt() + 1)
			passwd = passwd.replaceRange(instruction[2].toInt(), instruction[2].toInt() + 1, ypos)
			passwd = passwd.replaceRange(instruction[5].toInt(), instruction[5].toInt() + 1, xpos)
		} else if (instruction[0].equals("swap") && instruction[1].equals("letter")) { // ok
			passwd = passwd.replace(instruction[2], "(")
			passwd = passwd.replace(instruction[5], instruction[2])
			passwd = passwd.replace("(", instruction[5])
		} else if (instruction[0].equals("rotate") && instruction[1].equals("left")) { // ok
			var shift1 = passwd.take(instruction[2].toInt())
			var shift2 = passwd.takeLast(passwd.length - instruction[2].toInt())
			passwd = shift2 + shift1
		} else if (instruction[0].equals("rotate") && instruction[1].equals("right")) { // ok
			var shift1 = passwd.take(passwd.length - instruction[2].toInt())
			var shift2 = passwd.takeLast(instruction[2].toInt())
			passwd = shift2 + shift1
		} else if (instruction[0].equals("rotate") && instruction[1].equals("based")) {  // das muss ich nochmal checken, insbesondere wegen der Überläufe
			var index = passwd.indexOf(instruction[6])
			if (index >= 4) {
				index = index + 1
			}
			index = index + 1
			index = index % passwd.length
			var shift1 = passwd.take(passwd.length - index)
			var shift2 = passwd.takeLast(index)
			passwd = shift2 + shift1
		} else if (instruction[0].equals("reverse")) { // ok
			var reverse = passwd.substring(instruction[2].toInt(), instruction[4].toInt() + 1)
			reverse = reverse.reversed()
			passwd = passwd.replaceRange(instruction[2].toInt(), instruction[4].toInt() + 1, reverse)
		} else if (instruction[0].equals("move")) {  //ok
			var move = passwd[instruction[2].toInt()].toString()
			passwd = passwd.replaceRange(instruction[2].toInt(), instruction[2].toInt() + 1, "") + "-"
			var move2 = move + passwd[instruction[5].toInt()].toString()
			passwd = passwd.replaceRange(instruction[5].toInt(), instruction[5].toInt() + 1, move2)
			passwd = passwd.dropLast(1)
		}
		stepcount = stepcount + 1
	}
	return passwd
}




fun main(args: Array<String>) {
	var passwd: String = "abcdefgh"

	passwd = scramble(passwd)

	// Ausgabe der Lösung für Part 1
	println()
	println("******************")
	println("Solution for part1")
	println("   the scrambling result is $passwd ")
	println()

	// Part 2

	var Letters = listOf("a", "b", "c", "d", "e", "f", "g", "h")
	var solution2: String = ""
	var count2: Int = 1

	for (a in Letters) {
		for (b in Letters) {
			for (c in Letters) {
				for (d in Letters) {
					for (e in Letters) {
						for (f in Letters) {
							for (g in Letters) {
								for (h in Letters) {
									var passwdstart = a + b + c + d + e + f + g + h
									if (passwdstart.contains("a") && passwdstart.contains("b") && passwdstart.contains("c") && passwdstart.contains(
											"d"
										) && passwdstart.contains("e") && passwdstart.contains("f") && passwdstart.contains(
											"g"
										) && passwdstart.contains("h")
									) {
										passwd = scramble(passwdstart)
										// println("  Run $count2: $passwdstart gets $passwd")
										count2 = count2 +1
										if (passwd == "fbgdceah") {
											solution2 = passwdstart

										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

// hier schleife über alle variationen aufsetzen
	// Ausgabe der Lösung für Part 1
	println()
	println("******************")
	println("Solution for part2")
	println("   the input before scrambling was $solution2 ")
	println()

}