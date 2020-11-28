import java.io.File
import kotlin.math.*

fun main(args: Array<String>) {
//****************************************************************************	
//*     Declaration Variablen
//****************************************************************************

	var word0: String = ""
	var word1: String = ""
	var word2: String = ""
	var word3: String = ""
	var word4: String = ""
	var word5: String = ""
	var word6: String = ""
	var word7: String = ""



	var letters: String = ""

	var keyval: Int
	val decodingtab = hashMapOf<Char, Int>()

	var hilf1: String
	var hilf2: String

    var message1: String = ""
	var message2: String = ""


// variables part 2



//****************************************************************************	
//*     Einlesen Puzzledaten und direkt Berechnung des Weges.
//****************************************************************************


// Part 1
	File("day1606_puzzle_input.txt").forEachLine {
		word0 = word0 + it[0]
		word1 = word1 + it[1]
		word2 = word2 + it[2]
		word3 = word3 + it[3]
		word4 = word4 + it[4]
		word5 = word5 + it[5]
		word6 = word6 + it[6]
		word7 = word7 + it[7]

	}

	for (i in 0..7) {

		if (i == 0) {
			letters = word0
		} else if (i == 1) {
			letters = word1
		}else if (i == 2) {
			letters = word2
		}else if (i == 3) {
			letters = word3
		}else if (i == 4) {
			letters = word4
		}else if (i == 5) {
			letters = word5
		} else if (i == 6) {
			letters = word6
		}else if (i == 7) {
			letters = word7
		}
		
		for (it in letters.indices) {
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
		}
		println(decodingtab)

		val decodingtab_sort = decodingtab.toList().sortedByDescending { (_, value) -> value }.toMap()

		hilf1 = ""
		hilf2 = ""
		for (entry in decodingtab_sort) {
			hilf1 = hilf1 + entry.key
			hilf2 = hilf2 + entry.value
		}
		println(hilf1)
		hilf1 = hilf1.substring(0, 1)
		println(hilf1)
		message1 = message1 + hilf1
		 val hilf3 = decodingtab_sort.filterValues {it == 20}.keys
		message2 = message2 + hilf3

	}
/*
// Lösung für Part2

	for (i in encoding_list) {
		var hilf3 = i.split("=")
		encoding_room = hilf3[0]
		encoding_number = hilf3[1].toInt()
		encoding_number = encoding_number % 26
		encoding_room_decrypted = ""
		for (j in encoding_room.indices) {
			if (encoding_room[j].toInt() > 96 && encoding_room[j].toInt() < 123) {
				var hilf4 = encoding_room[j].toInt() + encoding_number
				if (hilf4 > 122) {
					hilf4 = hilf4 - 26
				}
				encoding_room_decrypted = encoding_room_decrypted + hilf4.toChar()
			} else {
				encoding_room_decrypted = encoding_room_decrypted + encoding_room[j]
			}
		}
		println("Room: $encoding_room, First sign ${encoding_room[0].toInt()},  cipher = $encoding_number, decrypted: $encoding_room_decrypted")
		if (encoding_room_decrypted.contains("north")) {
			solution = hilf3[1].toInt()
		}
	}

	*/
// Ausgabe der Lösung für Part 1
	println()
	println("******************")
	println("Solution for part1")
	println("   The error-corrected version of the message being sent is $message1")
	println()

// Ausgabe der Lösung für Part 2
	println()
	println("******************")
	println("Solution for part2")
	println("   The error-corrected version of the message being sent is $message2")
	println()
}