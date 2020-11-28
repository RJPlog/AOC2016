import java.io.File
import kotlin.math.*
import java.math.BigInteger
import java.security.MessageDigest

/*   function already defined in day05
 fun String.md5b(): String {
	val md = MessageDigest.getInstance("MD5")
	return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
} */

fun main(args: Array<String>) {

// part 1

	var salt: String = "zpqevtbw"
	var input: String
	var input2: String
	var check: Char
	var KeyCount: Int = 0
	var i: Int = 0
	var KeyCand: String = ""
	var KeyCont: String = ""

	val HashMap = mutableListOf<String>()
	
	
// Erzeuge first Hash with control field	
	for(m in 0..1000){
			input = salt + m.toString()
			var md5 = input.md5()
		
		// part 2 --> stretched key	
		for (kk in 1..2016) {
			input = md5
			md5 = input.md5()
		}	
				
			HashMap.add(md5)
	}
	
		
	while (KeyCount < 64) {

		KeyCand = HashMap[i]

		// finde tripples  Achtung, im Moment prüfe ich nicht ob das ein Tripple oder mehr ist!
		for (j in 0..KeyCand.length - 3) {
			if (KeyCand[j] == KeyCand[j + 1] && KeyCand[j + 1] == KeyCand[j + 2]) {
				check = KeyCand[j]
					println("i: $i, MD5: $KeyCand, Check: $check, now check if next 1000 have fifle")

				// now check of fifle
				for (k in 1..1000) {
					KeyCont = HashMap[k+i]


					//		println("    k: ${i+k}, md52: $md52")
					for (l in 0..KeyCont.length - 5) {
						//	if (md52[l] == md52[l + 1] && md52[l + 1] == md52[l + 2] && md52[l + 2] == md52[l + 3] && md52[l + 3] == md52[l + 4]) {
						if (KeyCont[l] == check && KeyCont[l + 1] == check && KeyCont[l + 2] == check && KeyCont[l + 3] == check && KeyCont[l + 4] == check) {

								println("     l: ${i + k}, MD5: $KeyCont, Check: $check, now there is a ${KeyCount+1} fifle within next 1000")
							KeyCount = KeyCount + 1
							break
						}
					}

				}

				// end check of fifle
				break
			}

		}

		i = i + 1

		input = salt + (i+1000).toString()
		var md5 = input.md5()
		
		// part 2 --> stretched key	
		for (kk in 1..2016) {
			input = md5
			md5 = input.md5()
		}	
				
			HashMap.add(md5)		
		
				
	}
 
 


	println()
	println("******************")
	println("Solution for part1")
	println("   you reached $KeyCount th key with index ${i - 1} ")

	// Ausgabe der Lösung für Part 2
	println()
	println("******************")
	println("Solution for part2")
//	println("   The passwd for 2nd door is $passwd2")
	println()

}