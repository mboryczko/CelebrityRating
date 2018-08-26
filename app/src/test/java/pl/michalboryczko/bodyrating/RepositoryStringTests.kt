package pl.michalboryczko.bodyrating

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import pl.michalboryczko.bodyrating.lib.RepositoryStrings
import pl.michalboryczko.bodyrating.network.RepositoryImpl

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(MockitoJUnitRunner::class)
class RepositoryStringTests {


	@Before
	fun setUp() {
	}


	@Test
	fun getUrlQueryForSingleRegisterValueTest1() {
		val entryValue = "R0100"
		val repositoryOutput = RepositoryStrings.getUrlQueryForSingleRegisterValue(entryValue)
		assertEquals("readVal.exe?PDP,,R0100,d", repositoryOutput)
	}


	@Test
	fun getUrlQueryForSingleRegisterValueTest2() {
		val entryValue = "F1197"
		val repositoryOutput = RepositoryStrings.getUrlQueryForSingleRegisterValue(entryValue)
		assertEquals("readVal.exe?PDP,,F1197,d", repositoryOutput)
	}

	@Test
	fun getUrlQueryForRegisterValuesTest1() {
		val entryValue1 = "R0100"
		val entryValue2 = "F1197"
		val entryValue3 = "R1999"
		val list = listOf(entryValue1, entryValue2, entryValue3)
		val repositoryOutput = RepositoryStrings.getUrlQueryForRegisterValues(list)

		assertEquals("getValues.exe?PDP,,R0100,d&PDP,,F1197,d&PDP,,R1999,d", repositoryOutput)
	}


}
