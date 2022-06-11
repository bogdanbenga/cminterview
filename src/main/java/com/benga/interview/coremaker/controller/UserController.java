package com.benga.interview.coremaker.controller;

import com.benga.interview.coremaker.dto.UserDTO;
import com.benga.interview.coremaker.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

/**
 * @author Bogdan Benga <bogdanbenga@gmail.com></>
 */
@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Set<UserDTO> getUsers() {
        LOGGER.info("Get Users called.");
        return userService.getUsers();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserDTO getUser(@RequestParam Long id) {
        LOGGER.info("Get User called for id: " + id);
        return userService.getUser(id);
    }


    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public void createProduct(@Valid @RequestBody UserDTO userDTO) {
        LOGGER.info("Create user: " + userDTO);
        userService.create(userDTO);
    }

    @RequestMapping(value = "/update-user", method = RequestMethod.PUT)
    public void updateProduct(@Valid @RequestBody UserDTO userDTO) {
        LOGGER.info("Update user: " + userDTO);
        userService.update(userDTO);
    }

    @RequestMapping(value = "/delete-user", method = RequestMethod.DELETE)
    public void deleteProduct(@Valid @RequestBody UserDTO userDTO) {
        LOGGER.info("Delete user: " + userDTO.getFirstName() + " " + userDTO.getLastName());
        userService.delete(userDTO.getFirstName(), userDTO.getLastName());
    }

}
