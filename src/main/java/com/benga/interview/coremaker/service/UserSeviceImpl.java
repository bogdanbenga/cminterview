package com.benga.interview.coremaker.service;

import com.benga.interview.coremaker.dto.UserDTO;
import com.benga.interview.coremaker.model.AppUser;
import com.benga.interview.coremaker.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author Bogdan Benga <bogdanbenga@gmail.com></>
 */
@Service
public class UserSeviceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public void create(UserDTO userDTO) {
        AppUser user = modelMapper.map(userDTO, AppUser.class);
        userRepository.save(user);
    }

    @Override
    public Set<UserDTO> getUsers() {
        Set<AppUser> products = new HashSet<>();
        products.addAll(userRepository.findAll());
        Type listType = new TypeToken<Set<UserDTO>>() {
        }.getType();
        return modelMapper.map(products, listType);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        Optional<AppUser> user = userRepository.findByEmail(userDTO.getEmail());
        if (user.isPresent()){
            AppUser userToUpdate = user.get();
            userToUpdate.setEmail(userDTO.getEmail());
            userToUpdate.setFirstName(userDTO.getFirstName());
            userToUpdate.setLastName(userToUpdate.getLastName());
            userRepository.save(userToUpdate);
        }
        return userDTO;
    }

    @Override
    public boolean delete(String firstName, String lastName) {
        Optional<AppUser> user = userRepository.findByFirstNameAndLastName(firstName, lastName);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return true;
        }
        return false;
    }
}
