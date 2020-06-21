package app.plantdiary.individualassignment3048q.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.plantdiary.individualassignment3048q.dao.ICountryDAO
import app.plantdiary.individualassignment3048q.service.CountryService

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var countries: MutableLiveData<ArrayList<Country>> = MutableLiveData<ArrayList<Country>>()
    var countryService: CountryService = CountryService()

    fun fetchCountries(){
        countries = countryService.fetchCountries()
    }
}
