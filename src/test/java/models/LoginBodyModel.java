package models;

import lombok.Data;


@Data
public class LoginBodyModel {

 String usernameOrEmail, password;
}
