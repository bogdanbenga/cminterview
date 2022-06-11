package com.benga.interview.coremaker.service;

import com.benga.interview.coremaker.dto.UserDTO;

import java.util.Set;

/**
 * @author Bogdan Benga <bogdanbenga@gmail.com></>
 */
public interface UserService {

    void create(UserDTO userDTO);

    Set<UserDTO> getUsers();

    UserDTO update(UserDTO userDTO);

    boolean delete(String firstName, String lastName);

}
