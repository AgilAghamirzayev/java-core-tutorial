package oop.abstraction.interfaces.mytube.impl;

import oop.abstraction.interfaces.mytube.EmailService;

public class EmailServiceImpl implements EmailService {

    @Override
    public void sendEmail(String userName) {
        System.out.println("Email sent!");
    }
}
