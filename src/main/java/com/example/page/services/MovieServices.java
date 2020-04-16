package com.example.page.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.page.dao.AssnActorMovieDao;
import com.example.page.domain.AssnMovieReview;
import com.example.page.dao.CountryDao;
import com.example.page.dao.GenresDao;
import com.example.page.dao.LanguageDao;
import com.example.page.dao.MovieDao;
import com.example.page.dao.ReviewDao;
import com.example.page.dao.actorDao;
import com.example.page.dao.directorDao;
import com.example.page.dao.productionDao;
import com.example.page.domain.AssnActorMovie;
import com.example.page.domain.Country;
import com.example.page.domain.Genres;
import com.example.page.domain.Language;
import com.example.page.domain.Movie;
import com.example.page.domain.Review;
import com.example.page.domain.actor;
import com.example.page.domain.director;
import com.example.page.domain.production;
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
import com.example.page.dto.request.ResGetAllLanguage.ResGetAllLang;
import com.example.page.dto.response.ResGetActor;
import com.example.page.dto.response.ResGetAllActor;
import com.example.page.dto.response.ResGetAllActor.ResGetAllAct;
import com.example.page.dto.response.ResGetAllCountry;
import com.example.page.dto.response.ResGetAllCountry.ResGetAllCount;
import com.example.page.dto.response.ResGetAllDirector;
import com.example.page.dto.response.ResGetAllDirector.ResGetAllDir;
import com.example.page.dto.response.ResGetAllGeneres;
import com.example.page.dto.response.ResGetAllGeneres.ResGetAllGen;
import com.example.page.dto.response.ResGetAllMovies;
import com.example.page.dto.response.ResGetAllMovies.ResGetAllMov;
import com.example.page.dto.response.ResGetAllProduction;
import com.example.page.dto.response.ResGetAllProduction.ResGetAllProd;
import com.example.page.dto.response.ResGetDirector;
import com.example.page.dto.response.ResGetGeneres;
import com.example.page.dto.response.ResGetLanguage;
import com.example.page.dto.response.ResGetMovies;
import com.example.page.dto.response.ResGetMovies.GetGenres;
import com.example.page.dto.response.ResGetProduction;

@Service
@Transactional
public class MovieServices {

	@Autowired
	MovieDao mDao;

	@Autowired
	actorDao aDao;

	@Autowired
	directorDao dirDao;

	@Autowired
	productionDao pDao;

	@Autowired
	GenresDao gDao;

	@Autowired
	ReviewDao rvDao;

	@Autowired
	AssnActorMovieDao assnActorMovieDao;

	@Autowired
	CountryDao cDao;

	@Autowired
	LanguageDao lDao;

	// *************************ADD Actor*************************
	public GenericResponse addActor(ReqAddActor reqAddActor) {
		GenericResponse genericResponse = new GenericResponse();

		actor actor = new actor();
		actor.setName(reqAddActor.getName());
		aDao.create(actor);

		genericResponse.setApiSucessStatus(true);
		genericResponse.setApiMessage("SUCCESS ");
		return genericResponse;
	}

	// ***************************Add Country****************************
	public GenericResponse addCountry(ReqAddCountry reqAddCountry) {
		GenericResponse genericResponse = new GenericResponse();
		Country country = new Country();
		country.setName(reqAddCountry.getName());
		cDao.create(country);

		genericResponse.setApiMessage("Country Added Sucessfully");
		genericResponse.setApiSucessStatus(true);

		return genericResponse;
	}

	// ************************Add Language**********************
	public GenericResponse addCountry(ReqAddLanguage reqAddLanguage) {
		GenericResponse genericResponse = new GenericResponse();
		Language language = new Language();
		language.setName(reqAddLanguage.getName());
		lDao.create(language);
		genericResponse.setApiMessage("Language added Sucessfully");
		genericResponse.setApiSucessStatus(true);

		return genericResponse;
	}

	// **************************Delete Actor******************************
	public GenericResponse deleteActor(Long Id) {
		GenericResponse genericResponse = new GenericResponse();

		aDao.delete(Id);
		genericResponse.setApiSucessStatus(true);
		genericResponse.setApiMessage("Delete-SUCCESS");
		return genericResponse;
	}
	// ******************************Update Actor*****************************

	public GenericResponse updateActor(Long id, String name) {
		GenericResponse genericResponse = new GenericResponse();
		actor actor = aDao.getById(id);
		actor.setName(name);
		aDao.update(actor);
		genericResponse.setApiSucessStatus(true);
		genericResponse.setApiMessage("Update-Sucess");
		return genericResponse;
	}
	// *************************Get Actor*************************

	public ResGetActor getActor(ReqGetActor reqGetActor) {
		ResGetActor resGetActor = new ResGetActor();
		actor ActorDb = aDao.getById(reqGetActor.getId());
		if (ActorDb == null) {
			return resGetActor;
		}
		resGetActor.setId(ActorDb.getId());
		resGetActor.setName(ActorDb.getName());
		return resGetActor;
	}

	// ******************************get All Actor************************
	public ResGetAllActor getAllActor() {
		ResGetAllActor resGetAllActor = new ResGetAllActor();
		List<actor> actors = aDao.getAllActor();
		List<ResGetAllAct> actorList = new ArrayList<>();	
		for (actor act : actors) {
			ResGetAllActor.ResGetAllAct act1 = new ResGetAllActor.ResGetAllAct();
			act1.setId(act.getId());
			act1.setName(act.getName());
			actorList.add(act1);
		}
		resGetAllActor.setActors(actorList);
		return resGetAllActor;

	}

	// *********************************Update Director**********************
	public GenericResponse updateDirector(Long id, String name) {
		GenericResponse genericResponse = new GenericResponse();
		director director = dirDao.getById(id);
		director.setName(name);
		dirDao.update(director);
		genericResponse.setApiSucessStatus(true);
		genericResponse.setApiMessage("Update-Sucess");
		return genericResponse;
	}

	// ***********************update Movie*************************
	public GenericResponse updateMovie(Long id, String name, String Language) {
		GenericResponse genericResponse = new GenericResponse();
		Movie movie = mDao.getById(id);
		movie.setName(name);
		movie.setLanguage(Language);
		mDao.create(movie);
		genericResponse.setApiSucessStatus(true);
		genericResponse.setApiMessage("Update-Sucess");
		return genericResponse;
	}

	// ***************************uPDATE Production************************

	public GenericResponse updateProduction(Long id, String name) {
		GenericResponse genericResponse = new GenericResponse();
		production production = pDao.getById(id);
		production.setName(name);
		pDao.update(production);
		genericResponse.setApiSucessStatus(true);
		genericResponse.setApiMessage("Update-Sucess");
		return genericResponse;
	}

	// **************************Delete Director******************

	public GenericResponse deleteDirector(Long id) {
		GenericResponse genericResponse = new GenericResponse();
		dirDao.delete(id);
		genericResponse.setApiSucessStatus(true);
		genericResponse.setApiMessage("Delete-Director-SUCCESS");
		return genericResponse;
	}

	// **************************Delete Movie*************************
	public GenericResponse deleteMovie(Long id) {
		GenericResponse genericResponse = new GenericResponse();
		mDao.delete(id);
		genericResponse.setApiSucessStatus(true);
		genericResponse.setApiMessage("Deleting - Movie - SUCCESS");
		return genericResponse;
	}
	// *****************************Delete Production***********************

	public GenericResponse deleteProduction(Long id) {
		GenericResponse genericResponse = new GenericResponse();
		pDao.delete(id);
		genericResponse.setApiSucessStatus(true);
		genericResponse.setApiMessage("Delete-Production-SUCCESS");
		return genericResponse;
	}

	// *************************ADD Production*************************

	public GenericResponse addProduction(ReqAddProduction reqAddProduction) {
		GenericResponse genericResponse = new GenericResponse();
		production production = new production();
		production.setName(reqAddProduction.getName());
		pDao.create(production);

		genericResponse.setApiSucessStatus(true);
		genericResponse.setApiMessage("SUCCESS");
		return genericResponse;
	}

	// ************************Add Review**********************

	public GenericResponse addReview(ReqAddReview reqAddReview) {
		GenericResponse genericResponse = new GenericResponse();
		Review review = new Review();
		review.setReview(reqAddReview.getReview());
		rvDao.create(review);

		genericResponse.setApiSucessStatus(true);
		genericResponse.setApiMessage("SUCCESS");
		return genericResponse;
	}

//	*******************************Get All Generes********************************
	public ResGetAllGeneres getAllGeneres() {
		ResGetAllGeneres resGetAllGeneres = new ResGetAllGeneres();
		List<Genres> generes = gDao.getAllGeneres();
		List<ResGetAllGen> genresList = new ArrayList<ResGetAllGeneres.ResGetAllGen>();
		for (Genres gen : generes) {
			ResGetAllGeneres.ResGetAllGen gen2 = new ResGetAllGen();
			gen2.setId(gen.getId());
			gen2.setName(gen.getName());
			genresList.add(gen2);
		}
		resGetAllGeneres.setGeneres(genresList);
		return resGetAllGeneres;
	}

	// *************************ADD Director*************************

	public GenericResponse addDirector(ReqAddDirector reqAddDirector) {
		GenericResponse genericResponse = new GenericResponse();

		director dir = new director();
		dir.setName(reqAddDirector.getName());
		dir.setMovies(reqAddDirector.getMovie());
		dirDao.create(dir);

		genericResponse.setApiSucessStatus(true);
		genericResponse.setApiMessage("SUCCESS");

		return genericResponse;
	}

	// ******************************Get All Director************************
	public ResGetAllDirector getAllDirector() {
		ResGetAllDirector resGetAllDirector = new ResGetAllDirector();
		List<director> directors = dirDao.getAllDirector();
		List<ResGetAllDir> directorList = new ArrayList<>();
		for (director dir : directors) {
			ResGetAllDirector.ResGetAllDir direDir = new ResGetAllDirector.ResGetAllDir();
			direDir.setId(dir.getId());
			direDir.setName(dir.getName());
			directorList.add(direDir);
		}
		resGetAllDirector.setDirectors(directorList);
		return resGetAllDirector;
	}

	//***************************************Get All Movies*************************
		public ResGetAllMovies getAllMovies() {
			ResGetAllMovies resGetAllMovies = new ResGetAllMovies();
			List<Movie> movies = mDao.getAllMovies();
			List<ResGetAllMov> movieList = new ArrayList<ResGetAllMov>();
			for (Movie mov : movies) {
				ResGetAllMovies.ResGetAllMov mov2 = new ResGetAllMov();				
				mov2.setId(mov.getId());
				mov2.setName(mov.getName());
				mov2.setReleaseDate(mov.getReleaseDate());
				mov2.setLanguage(mov.getLanguage());
				movieList.add(mov2);
				
			}
			
			resGetAllMovies.setMovies(movieList);
			return resGetAllMovies;
		}
	// *************************Get Movie Details****************************

	public ResGetMovies getMovie(ReqGetMovie reqGetMovie) {
		ResGetMovies resGetMovies = new ResGetMovies();
		List<ResGetMovies.GetActor> actorList = new ArrayList<ResGetMovies.GetActor>();
		List<ResGetMovies.GetReview> reviewList = new ArrayList<ResGetMovies.GetReview>();
		Movie movie = mDao.getById(reqGetMovie.getId());
		// actor actor=aDao.getById(ResGetMovies.GetActor.)
		if (movie == null) {
			return resGetMovies;
		}
		resGetMovies.setId(movie.getId());
		resGetMovies.setName(movie.getName());
		resGetMovies.setReleaseDate(movie.getReleaseDate());
		resGetMovies.setLanguage(movie.getLanguage());
		GetGenres genres = new GetGenres();
		genres.setId(movie.getGenres().getId());
		genres.setName(movie.getGenres().getName());

		Set<AssnActorMovie> actorSet = movie.getActorMovies();
		for (AssnActorMovie actorMovie : actorSet) {
			ResGetMovies.GetActor actor = new ResGetMovies.GetActor();
			actor.setId(actorMovie.getActor().getId());
			actor.setName(actorMovie.getActor().getName());
			actorList.add(actor);
		}
		resGetMovies.setActors(actorList);
		resGetMovies.setGenres(genres);
		Set<AssnMovieReview> reviewSet = movie.getReviewMovie();
		for (AssnMovieReview mReview : reviewSet) {
			ResGetMovies.GetReview rev = new ResGetMovies.GetReview();
			rev.setId(mReview.getReview().getId());
			rev.setReview(mReview.getReview().getReview());
			rev.setStars(mReview.getReview().getStars());
			reviewList.add(rev);
		}
		resGetMovies.setReviews(reviewList);
		return resGetMovies;
	}
	//***************************************************************************************
	/*
	 * This is for Giving only the Movie name in list instead of the ID and Name
	 * public ResGetMovies getMovie(ReqGetMovie reqGetMovie) { ResGetMovies
	 * resGetMovies = new ResGetMovies(); List<String> actorList = new
	 * ArrayList<>(); Movie movie = mDao.getById(reqGetMovie.getId());
	 * 
	 * if (movie == null) { return resGetMovies; }
	 * resGetMovies.setId(movie.getId()); resGetMovies.setName(movie.getName());
	 * resGetMovies.setReleaseDate(movie.getReleaseDate());
	 * resGetMovies.setLanguage(movie.getLanguage()); GetGenres genres = new
	 * GetGenres(); genres.setId(movie.getGenres().getId());
	 * genres.setName(movie.getGenres().getName()); Set<AssnActorMovie> actorSet =
	 * movie.getActorMovies(); for (AssnActorMovie actorMovie : actorSet) { //
	 * ResGetMovies.GetActor actor = new ResGetMovies.GetActor(); //
	 * actor.setId(actorMovie.getActor().getId()); //
	 * actor.setName(actorMovie.getActor().getName());
	 * actorList.add(actorMovie.getActor().getName()); }
	 * resGetMovies.setActors(actorList); resGetMovies.setGenres(genres); return
	 * resGetMovies; }
	 * 
	 */

	// *************************Get Director*************************

	public ResGetDirector getDirector(ReqGetDirector reqGetDirector) {
		ResGetDirector resGetDirector = new ResGetDirector();
		director director = dirDao.getById(reqGetDirector.getId());
		if (director == null) {
			return resGetDirector;
		}
		resGetDirector.setId(director.getId());
		resGetDirector.setName(director.getName());
//		resGetDirector.setMovie(director.getMovies());
		return resGetDirector;
	}

	// **********************************Get Language********************
	public ResGetLanguage getlanguage(ReqGetLanguage reqGetLanguage) {
		ResGetLanguage resGetLanguage = new ResGetLanguage();
		Language language = lDao.getById(reqGetLanguage.getId());
		if (language == null) {
			return resGetLanguage;
		}
		resGetLanguage.setId(language.getId());
		resGetLanguage.setName(language.getName());
		return resGetLanguage;
	}

	// **********************Get Production*****************************

	public ResGetProduction getProduction(ReqGetDirector reqGetProduction) {
		ResGetProduction resGetProduction = new ResGetProduction();
		production production = pDao.getById(resGetProduction.getId());
		if (production == null) {
			return resGetProduction;
		}
		resGetProduction.setId(production.getId());
		resGetProduction.setName(production.getName());

		return resGetProduction;
	}

	// *******************************Get All Production***********************

	public ResGetAllProduction getAllProduction() {
		ResGetAllProduction resGetAllProduction = new ResGetAllProduction();
		List<production> productions = pDao.getAllProduction();
		List<ResGetAllProd> productionList = new ArrayList<>();
		for (production prod : productions) {
			ResGetAllProduction.ResGetAllProd productionHouse = new ResGetAllProduction.ResGetAllProd();
			productionHouse.setId(prod.getId());
			productionHouse.setName(prod.getName());
			productionList.add(productionHouse);
		}
		resGetAllProduction.setProductions(productionList);
		return resGetAllProduction;
	}
	
	//*********************************Get All Language***************************

	public ResGetAllLanguage getAllLanguage() {
		ResGetAllLanguage resGetAllLanguage=new ResGetAllLanguage();
		List<Language> languages=lDao.getAllLanguage();
		List<ResGetAllLang> languageList=new ArrayList<ResGetAllLanguage.ResGetAllLang>();
		for(Language lang:languages) {
			ResGetAllLang reslanguage=new ResGetAllLang();
			reslanguage.setId(lang.getId());
			reslanguage.setName(lang.getName());
			languageList.add(reslanguage);
		}
		resGetAllLanguage.setGetAllLanguage(languageList);
		return resGetAllLanguage;
	}
	
	//*******************************Get AllCountry**************************
	
public ResGetAllCountry getAllCountry() {
		ResGetAllCountry resGetAllCountry=new ResGetAllCountry();
		List<Country> countrys=cDao.getAllCountry();
		List<ResGetAllCount> countryList=new ArrayList<ResGetAllCountry.ResGetAllCount>();
		for(Country count: countrys) {
			ResGetAllCount resGetAllCount=new ResGetAllCount();
			resGetAllCount.setId(count.getId());
			resGetAllCount.setName(count.getName());
			countryList.add(resGetAllCount);
		}
		resGetAllCountry.setGetAllCountry(countryList);
		
		return resGetAllCountry;
	}

////
//	
//	public List<ReqGetAllActor> getAllActor() {
//		ResGetAllActor resGetAllActor=new ResGetAllActor();
//		for (Long actorId : resGetAllActor.getId()) {
//			actor actor = aDao.getById(actorId);
//		resGetAllActor.setId(actor.getId());
//		resGetAllActor.setName(actor.getName());
//		
//		}
//		return null;
//	}
	// *************************ADD Movie*************************

	public GenericResponse addMovie(ReqAddMovie reqAddMovie) {

		GenericResponse genericResponse = new GenericResponse();
		Timestamp currentTime = new Timestamp(new Date().getTime());

		Movie movie = new Movie();
		movie.setName(reqAddMovie.getName());
		movie.setCreatedDate(currentTime);
		movie.setReleaseDate(reqAddMovie.getReleaseDate());

		director director = dirDao.getById(reqAddMovie.getDirectorId());
		movie.setDir(director);

		production production = pDao.getById(reqAddMovie.getProductionId());
		movie.setProduction(production);

		Genres genre = gDao.getById(reqAddMovie.getGenreId());
		movie.setGenres(genre);

		movie.setLanguage(reqAddMovie.getLanguage());
		mDao.create(movie);

		for (Long actorId : reqAddMovie.getActorIds()) {
			actor actor = aDao.getById(actorId);
			AssnActorMovie actorMovie = new AssnActorMovie();
			actorMovie.setActor(actor);
			actorMovie.setMovie(movie);
			assnActorMovieDao.create(actorMovie);
		}
		mDao.create(movie);
		genericResponse.setApiSucessStatus(true);
		genericResponse.setApiMessage("SUCCESS");
		return genericResponse;
	}

	//	**************************Get Genres************************
	
	public ResGetGeneres getGeneres(ReqGetGeneres reqGetGeneres) {
		ResGetGeneres resGetGeneres = new ResGetGeneres();
		Genres genres = gDao.getById(reqGetGeneres.getId());
		if (genres == null) {
			return resGetGeneres;
		}
		resGetGeneres.setId(genres.getId());
		resGetGeneres.setName(genres.getName());

		return resGetGeneres;
	}
	
	// ******************************Add Generes******************

	public GenericResponse addGeneres(ReqAddGeneres reqAddGeneres) {

		GenericResponse genericResponse = new GenericResponse();

		Genres genres = new Genres();
		genres.setName(reqAddGeneres.getName());
		gDao.create(genres);

		genericResponse.setApiSucessStatus(true);
		genericResponse.setApiMessage("SUCCESS");
		return genericResponse;
	}

	// ********************************update Generes**********************
	
	public GenericResponse updateGeneric(Long id, String name) {
		GenericResponse genericResponse = new GenericResponse();
		Genres genres = gDao.getById(id);
		genres.setName(name);
		gDao.update(genres);
		genericResponse.setApiSucessStatus(true);
		genericResponse.setApiMessage("Update-Sucess");
		return genericResponse;
	}



//	public production addProduction(production pro) {
//		// TODO Auto-generated method stub
//		return pDao.create(pro);
//	}
}