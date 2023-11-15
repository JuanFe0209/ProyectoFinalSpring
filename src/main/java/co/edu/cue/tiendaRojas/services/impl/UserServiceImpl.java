package co.edu.cue.tiendaRojas.services.impl;

import co.edu.cue.tiendaRojas.domain.entities.User;
import co.edu.cue.tiendaRojas.mapping.dtos.UserDto;
import co.edu.cue.tiendaRojas.mapping.mappers.UserMapper;
import co.edu.cue.tiendaRojas.repositories.UserRepository;
import co.edu.cue.tiendaRojas.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserDto> list() {
        return UserMapper.mapFrom((List<User>)repository.findAll());
    }
    @Override
    public UserDto getUserById(int id) {
        return UserMapper.mapFrom(repository.findById(id).orElseThrow());
    }
    @Override
    public UserDto save(UserDto user) {
        return UserMapper.mapFrom(
                repository.save(UserMapper.mapFrom(user))
        );
    }
    @Override
    public UserDto update(UserDto user) {
        return UserMapper.mapFrom(
                repository.save(UserMapper.mapFrom(user))
        );
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
