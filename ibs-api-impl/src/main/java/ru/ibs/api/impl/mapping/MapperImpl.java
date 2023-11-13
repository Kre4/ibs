package ru.ibs.api.impl.mapping;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.ibs.api.impl.mapping.mapper.AuthorEntityToAuthorMapper;
import ru.ibs.api.impl.mapping.mapper.BookEntityToBookMapper;

import javax.annotation.PostConstruct;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Qualifier("mapper-api")
public class MapperImpl implements Mapper {

    private ModelMapper modelMapper;

    private final ObjectMapper objectMapper;

    @Autowired
    public MapperImpl() {
        this.objectMapper = new ObjectMapper().registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @PostConstruct
    public void init() {
        modelMapper = new ModelMapper();

        modelMapper.addMappings(new BookEntityToBookMapper());
        modelMapper.addMappings(new AuthorEntityToAuthorMapper());
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }

    @Override
    public <D> D map(Object source, Class<D> destinationType) {
        if (source == null) {
            return null;
        }
        return modelMapper.map(source, destinationType);
    }

    @Override
    public void map(Object source, Object destination) {
        if (source == null) {
            return;
        }
        modelMapper.map(source, destination);
    }

    @Override
    public <D> D map(Object source, Type destinationType) {
        return modelMapper.map(source, destinationType);
    }


    @Override
    public <D> List<D> mapList(Collection<?> source, Class<D> destinationType) {
        return source.stream().map(o -> map(o, destinationType)).collect(Collectors.toList());
    }
}
