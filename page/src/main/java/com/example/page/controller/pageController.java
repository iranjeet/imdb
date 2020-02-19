package com.example.page.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.page.dto.generic.GenericResponse;
import com.example.page.dto.request.ReqAddActor;
import com.example.page.dto.request.ReqAddDirector;
import com.example.page.dto.request.ReqAddGeneres;
import com.example.page.dto.request.ReqAddMovie;
import com.example.page.dto.request.ReqAddProduction;
import com.example.page.dto.request.ReqAddReview;
import com.example.page.dto.request.ReqGetActor;
import com.example.page.dto.request.ReqGetAllActor;
import com.example.page.dto.request.ReqGetDirector;
import com.example.page.dto.request.ReqGetProduction;
import com.example.page.dto.response.ResGetActor;
import com.example.page.dto.response.ResGetAllActor;
import com.example.page.dto.response.ResGetAllDirector;
import com.example.page.dto.response.ResGetAllGeneres;
import com.example.page.dto.response.ResGetAllProduction;
import com.example.page.dto.response.ResGetDirector;
import com.example.page.dto.response.ResGetProduction;
import com.example.page.services.MovieServices;

@RestController
@RequestMapping("/api")
public class pageController {

	@Autowired
	private MovieServices movieServices;
//------------------------------------Add ----------------------------------

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

	@PostMapping("add/production")
	public GenericResponse addProduction(@RequestBody ReqAddProduction reqAddProduction) {
		GenericResponse resGenericResponse = movieServices.addProduction(reqAddProduction);
		return resGenericResponse;

	}

	@PostMapping("add/review")
	public GenericResponse addReview(@RequestBody ReqAddReview reqAddReview) {
		GenericResponse resGenericResponse = movieServices.addReview(reqAddReview);
		return resGenericResponse;
	}
//	----------------------------------Get-------------------------------

	@PostMapping("/get/actor")
	public ResGetActor getActor(@RequestBody ReqGetActor reqGetActor) {
		ResGetActor resGetActor = movieServices.getActor(reqGetActor);
		return resGetActor;
	}

	@GetMapping("/get/allActor")
	public ResGetAllActor getAllActor() {
		return movieServices.getAllActor();

	}

	@GetMapping("/get/allDirector")
	public ResGetAllDirector getAllDirector() {

		return movieServices.getAllDirector();
	}
	
	@GetMapping("/get/allGeneres")
	public ResGetAllGeneres getAllGeneres() {
		return movieServices.getAllGeneres();
	}

	@PostMapping("/get/director")
	public ResGetDirector getDirector(@RequestBody ReqGetDirector reqGetDirector) {
		ResGetDirector resGetDirector = movieServices.getDirector(reqGetDirector);
		return resGetDirector;
	}

	@PostMapping("/get/production")
	public ResGetProduction getProduction(@RequestBody ReqGetDirector reqGetProduction) {
		ResGetProduction resGetProduction = movieServices.getProduction(reqGetProduction);
		return resGetProduction;

	}

	@GetMapping("/get/allProduction")
	public ResGetAllProduction getAllProduction() {
		return movieServices.getAllProduction();
	}

//	@GetMapping("/get/movie")
//	public Movie getMovie(@RequestBody ReqGetActor resGetActor) {
//	    ResGetActor movieServices.getDirector(resGetActor);
//	    return 
//	}

//	@PostMapping("/add/director")
//	public void addDirector(director dir) {
//		movieServices.addDirector(dir);
//	}

//	@PostMapping("/add/production")
//	public production addProduction(String firstName) {
//		return movieServices.addProduction(firstName);
//	}

}