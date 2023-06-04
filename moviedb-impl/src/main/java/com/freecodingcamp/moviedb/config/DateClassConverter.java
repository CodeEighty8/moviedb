package com.freecodingcamp.moviedb.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import java.util.Date;

@WritingConverter
public class DateClassConverter implements Converter<Date, java.sql.Date> {

    @Override
    public java.sql.Date convert(Date source) {
        return new java.sql.Date(source.getTime());
    }
}
