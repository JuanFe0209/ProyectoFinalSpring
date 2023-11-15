package co.edu.cue.tiendaRojas.mapping.mappers;

import co.edu.cue.tiendaRojas.domain.entities.User;
import co.edu.cue.tiendaRojas.mapping.dtos.UserDto;

import java.util.List;

public class UserMapper {
    public static UserDto mapFrom(User source){
        return new UserDto(source.getUserId(),
                source.getUsername(),
                source.getPassword());
    }
    public static User mapFrom(UserDto source){
        return new User(source.userId(),
                source.username(),
                source.password());
    }
    public static List<UserDto> mapFrom(List<User> sources){
        return sources.parallelStream().map(e-> mapFrom(e)).toList();
    }
}

