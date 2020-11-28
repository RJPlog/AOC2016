import java.io.File

import kotlin.math.*


fun main(args: Array<String>) {

	var GameEnd: Boolean = false

	var Disc1: Int = 11
	var Disc2: Int = 0
	var Disc3: Int = 11
	var Disc4: Int = 0
	var Disc5: Int = 2
	var Disc6: Int = 17
		var Disc7: Int = 0

	var Disc1String = mutableListOf<Int>()
	var Disc2String = mutableListOf<Int>()
	var Disc3String = mutableListOf<Int>()
	var Disc4String = mutableListOf<Int>()
	var Disc5String = mutableListOf<Int>()
	var Disc6String = mutableListOf<Int>()
		var Disc7String = mutableListOf<Int>()

	var i: Int = 0

	Disc1String.add(Disc1)
	Disc2String.add(Disc2)
	Disc3String.add(Disc3)
	Disc4String.add(Disc4)
	Disc5String.add(Disc5)
	Disc6String.add(Disc6)
		Disc7String.add(Disc7)

	while (!GameEnd) {
		Disc1 = Disc1 + 1
		if (Disc1 == 13) {
			Disc1 = 0
		}
		Disc1String.add(Disc1)

		Disc2 = Disc2 + 1
		if (Disc2 == 5) {
			Disc2 = 0
		}
		Disc2String.add(Disc2)

				Disc3 = Disc3 + 1
		if (Disc3 == 17) {
			Disc3 = 0
		}
		Disc3String.add(Disc3)

		Disc4 = Disc4 + 1
		if (Disc4 == 3) {
			Disc4 = 0
		}
		Disc4String.add(Disc4)
		
				Disc5 = Disc5 + 1
		if (Disc5 == 7) {
			Disc5 = 0
		}
		Disc5String.add(Disc5)

		Disc6 = Disc6 + 1
		if (Disc6 == 19) {
			Disc6 = 0
		}
		Disc6String.add(Disc6)
		
				Disc7 = Disc7 + 1
		if (Disc7 == 11) {
			Disc7 = 0
		}
		Disc7String.add(Disc7)
		

		if (i > 6) {

			if (Disc1String[i - 7] == 0 && Disc2String[i - 6] == 0 && Disc3String[i - 5]== 0 && Disc4String[i - 4]== 0 && Disc5String[i - 3]== 0 && Disc6String[i - 2]== 0 && Disc7String[i - 1]== 0) {

				GameEnd = true
			}
			
			//else if (i > 10 ) {GameEnd = true}
		}


		i = i + 1
	}

	println()
	println("******************")
	println("Solution for part1")
	println("   you recive a capsule by pressing button at ${i - 8 - 1} ")

	// Ausgabe der Lösung für Part 2
	println()
	println("******************")
	println("Solution for part2")
//	println("   The passwd for 2nd door is $passwd2")
	println()

}