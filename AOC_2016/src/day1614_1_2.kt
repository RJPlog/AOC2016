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

	var salt: String = "abc"
	var input: String
	var input2: String
	var check: Char
	var KeyCount: Int = 0
	var i: Int = 0

	
	
	
	
	while (KeyCount < 64) {
//	for (i in 0..100) {
		input = salt + i.toString()


		var md5 = input.md5()

		// part 2 --> stretched key	
		for (kk in 1..2016) {
			input = md5
			md5 = input.md5()
		}

		// finde tripples  Achtung, im Moment prüfe ich nicht ob das ein Tripple oder mehr ist!
		for (j in 0..md5.length - 3) {
			if (md5[j] == md5[j + 1] && md5[j + 1] == md5[j + 2]) {
				check = md5[j]
					println("i: $i, MD5: $md5, Check: $check, now check if next 1000 have fifle")

				// now check of fifle
				for (k in 1..1000) {
					input2 = salt + (i + k).toString()
					var md52 = input2.md5()

					for (ll in 1..2016) {
						input2 = md52
						md52 = input2.md5()
					}

					//		println("    k: ${i+k}, md52: $md52")
					for (l in 0..md52.length - 5) {
						//	if (md52[l] == md52[l + 1] && md52[l + 1] == md52[l + 2] && md52[l + 2] == md52[l + 3] && md52[l + 3] == md52[l + 4]) {
						if (md52[l] == check && md52[l + 1] == check && md52[l + 2] == check && md52[l + 3] == check && md52[l + 4] == check) {

								println("     l: ${i + k}, MD5: $md52, Check: $check, now there is a ${KeyCount+1} fifle within next 1000")
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