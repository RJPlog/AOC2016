import java.io.File
import kotlin.math.*

fun main(args: Array<String>) {
//****************************************************************************	
//*     Declaration Variablen
//****************************************************************************

	var checksum: String
	var body: String
	var letters: String
	var numbers: String
	var keyval: Int
	val decodingtab = hashMapOf<Char, Int>()

	var hilf1: String
	var hilf2: String

	var sector_sum: Int = 0


// variables part 2

	val encoding_list = mutableListOf<String>()
	var encoding_room: String
	var encoding_number: Int
	var encoding_room_decrypted: String
	var solution: Int = 0

//****************************************************************************	
//*     Einlesen Puzzledaten und direkt Berechnung des Weges.
//****************************************************************************


// Part 1
	File("day1604_puzzle_input.txt").forEachLine {
		letters = ""
		numbers = ""
		decodingtab.clear()
		var line = it.split("[")
		checksum = line[1].replace("]", "")
		body = line[0].replace("-", "")

		for (i in body.indices) {
			if (!body[i].isDigit()
			) {
				letters = letters + body[i]

			} else {
				numbers = numbers + body[i]
			}
		}

		keyval = letters.filter { it == 'a' }.count()
		decodingtab.put('a', keyval)
		keyval = letters.filter { it == 'b' }.count()
		decodingtab.put('b', keyval)
		keyval = letters.filter { it == 'c' }.count()
		decodingtab.put('c', keyval)
		keyval = letters.filter { it == 'd' }.count()
		decodingtab.put('d', keyval)
		keyval = letters.filter { it == 'e' }.count()
		decodingtab.put('e', keyval)
		keyval = letters.filter { it == 'f' }.count()
		decodingtab.put('f', keyval)
		keyval = letters.filter { it == 'g' }.count()
		decodingtab.put('g', keyval)
		keyval = letters.filter { it == 'h' }.count()
		decodingtab.put('h', keyval)
		keyval = letters.filter { it == 'i' }.count()
		decodingtab.put('i', keyval)
		keyval = letters.filter { it == 'j' }.count()
		decodingtab.put('j', keyval)
		keyval = letters.filter { it == 'k' }.count()
		decodingtab.put('k', keyval)
		keyval = letters.filter { it == 'l' }.count()
		decodingtab.put('l', keyval)
		keyval = letters.filter { it == 'm' }.count()
		decodingtab.put('m', keyval)
		keyval = letters.filter { it == 'n' }.count()
		decodingtab.put('n', keyval)
		keyval = letters.filter { it == 'o' }.count()
		decodingtab.put('o', keyval)
		keyval = letters.filter { it == 'p' }.count()
		decodingtab.put('p', keyval)
		keyval = letters.filter { it == 'q' }.count()
		decodingtab.put('q', keyval)
		keyval = letters.filter { it == 'r' }.count()
		decodingtab.put('r', keyval)
		keyval = letters.filter { it == 's' }.count()
		decodingtab.put('s', keyval)
		keyval = letters.filter { it == 't' }.count()
		decodingtab.put('t', keyval)
		keyval = letters.filter { it == 'u' }.count()
		decodingtab.put('u', keyval)
		keyval = letters.filter { it == 'v' }.count()
		decodingtab.put('v', keyval)
		keyval = letters.filter { it == 'w' }.count()
		decodingtab.put('w', keyval)
		keyval = letters.filter { it == 'x' }.count()
		decodingtab.put('x', keyval)
		keyval = letters.filter { it == 'y' }.count()
		decodingtab.put('y', keyval)
		keyval = letters.filter { it == 'z' }.count()
		decodingtab.put('z', keyval)
		val decodingtab_sort = decodingtab.toList().sortedByDescending { (_, value) -> value }.toMap()

		hilf1 = ""
		hilf2 = ""
		for (entry in decodingtab_sort) {
			hilf1 = hilf1 + entry.key
			hilf2 = hilf2 + entry.value
		}
		hilf1 = hilf1.substring(0, 5)

		if (hilf1.equals(checksum)) {
			sector_sum = sector_sum + numbers.toInt()
			encoding_list.add(line[0] + "=" + numbers)
		}

	}


// Lösung für Part2

	for (i in encoding_list) {
		var hilf3 = i.split("=")
		encoding_room = hilf3[0]
		encoding_number = hilf3[1].toInt()
		encoding_number = encoding_number % 26
		encoding_room_decrypted = ""
		for (j in encoding_room.indices) {
			if (encoding_room[j].toInt() > 96 && encoding_room[j].toInt() < 123) {
				var hilf4 = encoding_room[j].toInt() + 	encoding_number
				if (hilf4 > 122) {hilf4 = hilf4 -26}
			encoding_room_decrypted = 	encoding_room_decrypted + hilf4.toChar()
			} else {encoding_room_decrypted = 	encoding_room_decrypted + encoding_room[j]}
		}
		println("Room: $encoding_room, First sign ${encoding_room[0].toInt()},  cipher = $encoding_number, decrypted: $encoding_room_decrypted")
		if(encoding_room_decrypted.contains("north")){solution = hilf3[1].toInt()}
	}


// Ausgabe der Lösung für Part 1
	println()
	println("******************")
	println("Solution for part1")
	println("   The sum of the sector IDs of the real rooms is $sector_sum")
	println()

// Ausgabe der Lösung für Part 2
	println()
	println("******************")
	println("Solution for part2")
	println(solution)
	println()
}