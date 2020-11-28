import java.io.File

import kotlin.math.*


fun main(args: Array<String>) {

	var a: String = ""
	var b: String = ""
	var c: String = ""
	var c1: String = ""
	val DiskSpace: Int =  35651584
	var a1: String = "11101000110010100"
	var a2: String = "11010110011101000"
	var toggle: Int = 0
	var check: String = ""
	var checksum: String = ""
	var count: Int = 1


// generate dragon curve
	println("Part1:")
	while (a.length < DiskSpace.div((a1.length + 1)) + 1) {
		b = ""
		a.forEach {
			if (it.equals('1')) {
				b = "0" + b
			} else if (it.equals('0')) {
				b = "1" + b
			}
		}
		a = a + "0" + b
//		println(a)
		println("Länge short A: ${a.length}")
	}
	println()
	println("Part2:")

	for (i in 0..a.length - 1) {

		if (toggle == 0) {
			c = c + a1 + a[i]
			toggle = 1
		} else if (toggle == 1) {
			c = c + a2 + a[i]
			toggle = 0
		}
		if (c.length > DiskSpace / a1.length) {
			//ermittle Checksum von ersten DiskSpace/a1.lenght
//			println("Teilstring $c")
			c1 = c.substring(0, DiskSpace / a1.length)
			
	// built checksum	
	while (check.length % 2 == 0) {
		check = ""
		for (j in 0..c1.length - 1 step 2) {
			if (c1[j] == c1[j + 1]) {
				check = check + "1"
			} else if (c1[j] != c1[j + 1]) {
				check = check + "0"
			}
		}
		//	println(c)
		c1 = check



	}
			checksum = checksum + check		
			println("Part $count of checksum:   $check")
					count = count +1
			check = ""
			
//			println("Ermittlung erster Checksum aus: $c1")
			// gehe weiter mit Reststring
			c = c.removeRange(0, DiskSpace / a1.length)
//			println("Reststring: $c")
			println()
			
			if (count > 17){
			break
			}
		}
//		println("Länge long A: ${c.length}")
	}
	println()
	println("Part3:")

//	a = c.substring(0, DiskSpace)

//	println("Dragon Curve")

//	println(a.length)
//	println()

/*
// built checksum	
	while (c.length % 2 == 0) {
		c = ""
		for (i in 0..a.length - 1 step 2) {
			if (a[i] == a[i + 1]) {
				c = c + "1"
			} else if (a[i] != a[i + 1]) {
				c = c + "0"
			}
		}
		//	println(c)
		a = c

		println("Current checksum:   ${a.length}")
	}

*/
	println()
	println("******************")
	println("Solution for part1")
	println("   The correct Checksum is $checksum ")

	// 10101110000100001 is to high

	// Ausgabe der Lösung für Part 2
	println()
	println("******************")
	println("Solution for part2")
//	println("   The passwd for 2nd door is $passwd2")
	println()

}