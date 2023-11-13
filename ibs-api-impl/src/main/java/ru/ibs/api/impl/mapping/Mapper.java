package ru.ibs.api.impl.mapping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public interface Mapper {

    <D> D map(Object source, Class<D> destinationType);

    <D> D map(Object source, Class<D> destinationType, String typeMapName);

    void map(Object source, Object destination);

    void map(Object source, Object destination, String typeMapName);

    <D> D map(Object source, Type destinationType);

    <D> D map(Object source, Type destinationType, String typeMapName);

    <D> List<D> mapList(Collection<?> source, Class<D> destinationType);

    <D> List<D> mapStream(Stream<?> source, Class<D> destinationType);

    <T> T readValue(String content, Class<T> valueType) throws Exception;

    <T> T readValue(String content, TypeReference<T> valueTypeRef) throws Exception;

    <T> T readValue(String content, JavaType valueType) throws Exception;
}
