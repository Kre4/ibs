package ru.ibs.api.impl.mapping;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public interface Mapper {

    <D> D map(Object source, Class<D> destinationType);

    void map(Object source, Object destination);

    <D> D map(Object source, Type destinationType);

    <D> List<D> mapList(Collection<?> source, Class<D> destinationType);
}
