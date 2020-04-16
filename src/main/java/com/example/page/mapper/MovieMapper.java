package com.example.page.mapper;

import org.apache.ibatis.annotations.Mapper;


import com.example.page.domain.Movie;

@Mapper
public interface MovieMapper {
	
	@Mapper
	Movie domainToDto(final MoviesDto movies); 

}
