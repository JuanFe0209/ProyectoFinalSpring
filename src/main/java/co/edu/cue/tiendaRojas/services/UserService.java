package co.edu.cue.tiendaRojas.services;


import co.edu.cue.tiendaRojas.mapping.dtos.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> list();
    UserDto getUserById(int id);
    UserDto save(UserDto user);
    UserDto update(UserDto user);
    void delete(int id);
}
