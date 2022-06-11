package com.benga.interview.coremaker.dto;

import lombok.*;

/**
 * @author Bogdan Benga <bogdanbenga@gmail.com></>
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String email;

}
