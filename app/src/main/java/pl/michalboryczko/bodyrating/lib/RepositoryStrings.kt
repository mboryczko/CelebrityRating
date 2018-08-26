package pl.michalboryczko.bodyrating.lib

/**
 * Created on 20.08.2018.
 */

object RepositoryStrings{
	fun getUrlQueryForSingleRegisterValue(register: String = ""): String =  "readVal.exe?PDP,,$register,d"
	fun getUrlQueryForRegisterValues(registers: List<String>): String {
		val pish = "getValues.exe?"
		var output = ""
		registers.forEach{
			output += "&PDP,,$it,d"
		}
		return (pish + output).replaceFirst("&", "")
	}

	fun convertApiResponseToList(response: String): List<String> = response.split("&")
}
