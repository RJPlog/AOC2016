import java.io.File

import kotlin.math.*


fun main(args: Array<String>) {

	var a: String = "11101000110010100"
	var b: String = ""
	var c: String = ""
	val DiskSpace: Int = 272

// generate dragon curve	
	while (a.length < DiskSpace + 1) {
		b = ""
		a.forEach {
			if (it.equals('1')) {
				b = "0" + b
			} else if (it.equals('0')) {
				b = "1" + b
			}
		}
		a = a + "0" + b
		println(a)
	}

	a = a.substring(0, DiskSpace)

		println(a)
	println()


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
		println(c)
		a = c

		println("   $a")
	}


	println()
	println("******************")
	println("Solution for part1")
	println("   The correct Checksum is $a ")
	
	// 10101110000100001 is to high

	// Ausgabe der Lösung für Part 2
	println()
	println("******************")
	println("Solution for part2")
//	println("   The passwd for 2nd door is $passwd2")
	println()

}