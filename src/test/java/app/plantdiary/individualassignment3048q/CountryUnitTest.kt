package app.plantdiary.individualassignment3048q

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.plantdiary.individualassignment3048q.ui.main.Country
import app.plantdiary.individualassignment3048q.ui.main.MainViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule

/**
 * Test the country logic.
 * Validate that the DTO works as expected.
 * Validate the format of the DTO string.
 * Validate that the fetch contains a minimum number of records.
 * Validate that "Belize" is one of the countries returned.
 */
class CountryUnitTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    lateinit var mvm: MainViewModel

    @Before
    fun populateCountries() {
        mvm = MainViewModel()

    }

    @Test
    fun countryDTO_maintainsState() {
        var country = Country(
            "NZ",
            "New Zealand"
        )
        assertTrue(country.code.equals("NZ") )
        assertTrue(country.name.equals("New Zealand"))
    }

    @Test
    fun countryDTO_toStringFormat() {
        var country = Country(
            "NZ",
            "New Zealand"
        )
        assertTrue(country.toString().equals("New Zealand NZ"))
    }

    @Test
    fun countryDTO_isPopulated() {
        givenViewModelIsInitialized()
        whenJSONDataAreReadAndParsed()
        thenTheCollectionSizeShouldBeGreaterThanZero()
    }

    private fun givenViewModelIsInitialized() {
        mvm = MainViewModel()
    }

    private fun whenJSONDataAreReadAndParsed() {
        mvm.fetchCountries()
    }

    private fun thenTheCollectionSizeShouldBeGreaterThanZero() {
        var allCountries = ArrayList<Country>()
        mvm.countries.observeForever{
            allCountries = it
        }
        Thread.sleep(5000)
        assertNotNull(allCountries)
        assertTrue(allCountries.size > 0)
    }


    @Test
    fun countryDTO_containsBelize() {
        givenViewModelIsInitialized()
        whenJSONDataAreReadAndParsed()
        thenResultsShouldContainBelize()
    }

    private fun thenResultsShouldContainBelize() {
        var containsBelize:Boolean = false
        mvm.countries.observeForever {
            it.forEach {
                if (it.name.equals("Belize")) {
                    containsBelize = true
                }
            }
            assertTrue(containsBelize)
        }
    }
}
