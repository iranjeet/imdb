package com.example.page.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.page.dto.generic.GenericResponse;
import com.example.page.dto.request.ReqAddActor;
import com.example.page.dto.request.ReqAddCountry;
import com.example.page.dto.request.ReqAddDirector;
import com.example.page.dto.request.ReqAddGeneres;
import com.example.page.dto.request.ReqAddLanguage;
import com.example.page.dto.request.ReqAddMovie;
import com.example.page.dto.request.ReqAddProduction;
import com.example.page.dto.request.ReqAddReview;
import com.example.page.dto.request.ReqGetActor;
import com.example.page.dto.request.ReqGetDirector;
import com.example.page.dto.request.ReqGetGeneres;
import com.example.page.dto.request.ReqGetLanguage;
import com.example.page.dto.request.ReqGetMovie;
import com.example.page.dto.request.ResGetAllLanguage;
import com.example.page.dto.response.ResGetActor;
import com.example.page.dto.response.ResGetAllActor;
import com.example.page.dto.response.ResGetAllCountry;
import com.example.page.dto.response.ResGetAllDirector;
import com.example.page.dto.response.ResGetAllGeneres;
import com.example.page.dto.response.ResGetAllMovies;
import com.example.page.dto.response.ResGetAllProduction;
import com.example.page.dto.response.ResGetDirector;
import com.example.page.dto.response.ResGetGeneres;
import com.example.page.dto.response.ResGetLanguage;
import com.example.page.dto.response.ResGetMovies;
import com.example.page.dto.response.ResGetProduction;
import com.example.page.services.MovieServices;

@RestController
@RequestMapping("/api")
public class pageController {

	@Autowired
	private MovieServices movieServices;
//------------------------------------Add Data----------------------------------

	@PostMapping("/add/actor")
	public GenericResponse addActor(@RequestBody ReqAddActor reqAddActor) {
		GenericResponse genericResponse = movieServices.addActor(reqAddActor);
		return genericResponse;
	}

	@PostMapping("/add/director")
	public GenericResponse addDirector(@RequestBody ReqAddDirector reqAddDirector) {

		GenericResponse genericResponse = movieServices.addDirector(reqAddDirector);
		return genericResponse;
	}

	@PostMapping("/add/movie")
	public GenericResponse addMovie(@RequestBody ReqAddMovie reqAddMovie) {
		GenericResponse resGenericResponse = movieServices.addMovie(reqAddMovie);
		return resGenericResponse;
	}

	@PostMapping("/add/generes")
	public GenericResponse addGenere(@RequestBody ReqAddGeneres reqAddGeneres) {
		GenericResponse genericResponse = movieServices.addGeneres(reqAddGeneres);
		return genericResponse;

	}

	@PostMapping("/add/production")
	public GenericResponse addProduction(@RequestBody ReqAddProduction reqAddProduction) {
		GenericResponse resGenericResponse = movieServices.addProduction(reqAddProduction);
		return resGenericResponse;

	}

	@PostMapping("/add/review")
	public GenericResponse addReview(@RequestBody ReqAddReview reqAddReview) {
		GenericResponse resGenericResponse = movieServices.addReview(reqAddReview);
		return resGenericResponse;
	}
	
	@PostMapping("/add/country")
	public GenericResponse addCountry(@RequestBody ReqAddCountry reqAddCountry) {
		GenericResponse genericResponse=movieServices.addCountry(reqAddCountry);
		return genericResponse;
		
	}
	
	@PostMapping("/add/language")
	public GenericResponse addLanguage(@RequestBody ReqAddLanguage reqAddLanguage) {
		GenericResponse genericResponse=movieServices.addCountry(reqAddLanguage);
		return genericResponse;
	}
//------------------------------------Get-----------------------------------------------------------
	// *********************************Get Actor*********************

	@PostMapping("/get/actor")
	public ResGetActor getActor(@RequestBody ReqGetActor reqGetActor) {
		ResGetActor resGetActor = movieServices.getActor(reqGetActor);
		return resGetActor;
	}

	@GetMapping("/get/allActor")
	public ResGetAllActor getAllActor() {
		return movieServices.getAllActor();

	}
	@PostMapping("/get/language")
	public ResGetLanguage getLanguage(@RequestBody ReqGetLanguage reqLanguage) {
		ResGetLanguage resGetLanguage=movieServices.getlanguage(reqLanguage);
		return resGetLanguage;
		
	}
	@GetMapping("/get/allLanguage")
	public ResGetAllLanguage getAllLanguage() {
		return movieServices.getAllLanguage();
	}
	
	@GetMapping("/get/allCountry")
	public ResGetAllCountry getAllCountry() {
		return movieServices.getAllCountry();
	}

	// *********************************Get Director*********************
	@PostMapping("/get/director")
	public ResGetDirector getDirector(@RequestBody ReqGetDirector reqGetDirector) {
		ResGetDirector resGetDirector = movieServices.getDirector(reqGetDirector);
		return resGetDirector;
	}

	@GetMapping("/get/allDirector")
	public ResGetAllDirector getAllDirector() {

		return movieServices.getAllDirector();
	}

	// *********************************Get Generes*********************
	@PostMapping("/get/genres")
	public ResGetGeneres getGeneres(@RequestBody ReqGetGeneres reqGetGeneres) {
		ResGetGeneres resGetGeneres = movieServices.getGeneres(reqGetGeneres);
		return resGetGeneres;
	}

	@GetMapping("/get/allGeneres")
	public ResGetAllGeneres getAllGeneres() {
		return movieServices.getAllGeneres();
	}

	// *********************************Get Production*********************
	@GetMapping("/get/production")
	public ResGetProduction getProduction(@RequestBody ReqGetDirector reqGetProduction) {
		ResGetProduction resGetProduction = movieServices.getProduction(reqGetProduction);
		return resGetProduction;

	}

	@GetMapping("/get/allProduction")
	public ResGetAllProduction getAllProduction() {
		return movieServices.getAllProduction();
	}

	// *********************************Get Movies*********************
	@PostMapping("/get/movies")
	public ResGetMovies getMovies(@RequestBody ReqGetMovie reqGetMovie) {
		ResGetMovies resGetMovies = movieServices.getMovie(reqGetMovie);
		return resGetMovies;
	}

	@GetMapping("/get/allMovies")
	public ResGetAllMovies getAllMovies() {
		return movieServices.getAllMovies();
	}

	// *********************************Delete-Actor*********************
	@DeleteMapping("/delete/actor/{id}")
	public GenericResponse deleteActor(@PathVariable Long id) {
		GenericResponse genericResponse = movieServices.deleteActor(id);
		return genericResponse;
	}

	// **************************Delete -Director**************************

	@DeleteMapping("/delete/director/{id}")
	public GenericResponse deleteDirector(@PathVariable Long id) {
		GenericResponse genericResponse = movieServices.deleteDirector(id);

		return genericResponse;
	}
	// *********************************Delete-movie************************

	@DeleteMapping("/delete/movie/{id}")
	public GenericResponse deleteMovie(@PathVariable Long id) {

		GenericResponse genericResponse = movieServices.deleteMovie(id);
		return genericResponse;
	}
	// ***********************************Delete Production***********************

	@DeleteMapping("/Delete/production")
	public GenericResponse deleteProduction(@PathVariable Long id) {
		GenericResponse genericResponse = movieServices.deleteProduction(id);
		return genericResponse;
	}

	// ***********************Update-Actor******************************************
	@PutMapping("/update/actor/{id}/{name}")
	public GenericResponse updateActor(@PathVariable("id") final Long id, @PathVariable("name") final String name) {
		GenericResponse genericResponse = movieServices.updateActor(id, name);
		return genericResponse;
	}

	// ***********************Update-Director******************************************
	@PutMapping("/update/director/{id}/{name}")
	public GenericResponse updateDirector(@PathVariable("id") final Long id, @PathVariable("name") final String name) {
		GenericResponse genericResponse = movieServices.updateDirector(id, name);
		return genericResponse;
	}

	// ***********************Update-Generes******************************************
	@PutMapping("/update/generic/{id}/{name}/")
	public GenericResponse updateGeneric(@PathVariable("id") final Long id, @PathVariable("name") final String name) {
		GenericResponse genericResponse = movieServices.updateGeneric(id, name);
		return genericResponse;
	}

	// ***********************Update-movies******************************************
	@PutMapping("/update/movie/{id}/{name}/{language}")
	public GenericResponse updateMovie(@PathVariable("id") final Long id, @PathVariable("name") final String name,
			@PathVariable("language") final String language) {
		GenericResponse genericResponse = movieServices.updateMovie(id, name, language);
		return genericResponse;
	}

	// ********************update-production******************************************
	@PutMapping("/update/production/{id}/{name}")
	public GenericResponse updateProduction(@PathVariable("id") final Long id,
			@PathVariable("name") final String name) {
		GenericResponse genericResponse = movieServices.updateProduction(id, name);
		return genericResponse;
	}

}
