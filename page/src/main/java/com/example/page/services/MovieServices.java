package com.example.page.services;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.page.dao.AssnActorMovieDao;
import com.example.page.dao.GenresDao;
import com.example.page.dao.MovieDao;

import com.example.page.dao.ReviewDao;
import com.example.page.dao.actorDao;
import com.example.page.dao.directorDao;
import com.example.page.dao.productionDao;
import com.example.page.domain.AssnActorMovie;
import com.example.page.domain.Genres;
import com.example.page.domain.Movie;
import com.example.page.domain.Review;
import com.example.page.domain.actor;
import com.example.page.domain.director;
import com.example.page.domain.production;
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
import com.example.page.dto.response.ResGetActor;
import com.example.page.dto.response.ResGetAllActor;
import com.example.page.dto.response.ResGetDirector;
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

//*************************ADD Actor*************************
	public GenericResponse addActor(ReqAddActor reqAddActor) {
		GenericResponse genericResponse = new GenericResponse();

		actor actor = new actor();
		actor.setName(reqAddActor.getName());
		aDao.create(actor);

		genericResponse.setApiSucessStatus(true);
		genericResponse.setApiMessage("SUCCESS");
		return genericResponse;
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
	
//******************************get All Actor************************
	public List<ResGetActor> getAllActor() {
		ResGetAllActor resGetAllActor=new ResGetAllActor();
		return aDao.getAllActor();
		  
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

	// *************************Get Director*************************

	public ResGetDirector getDirector(ReqGetDirector reqGetDirector) {
		ResGetDirector resGetDirector = new ResGetDirector();
		director director = dirDao.getById(reqGetDirector.getId());
		if (director == null) {
			return resGetDirector;
		}
		resGetDirector.setId(director.getId());
		resGetDirector.setName(director.getName());
		resGetDirector.setMovie(director.getMovies());
		return resGetDirector;
	}

//**********************Get Production*****************************
	
	public ResGetProduction getProduction(ReqGetDirector reqGetProduction) {
		ResGetProduction resGetProduction=new ResGetProduction();
		production production=pDao.getById(resGetProduction.getId());
		if(production ==null) {
			return resGetProduction;
		}
		resGetProduction.setId(production.getId());
		resGetProduction.setName(production.getName());
						
		return resGetProduction;
	}

	
	public Movie getMovie(Movie movie) {
		// TODO Auto-generated method stub
		return mDao.getById(movie.getId());
	}

	
//	public production addProduction(production pro) {
//		// TODO Auto-generated method stub
//		return pDao.create(pro);
//	}
}
