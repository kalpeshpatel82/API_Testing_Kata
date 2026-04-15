package com.booking.models;

public class LoginPoJo {

    public String toString() {
        StringBuilder str = new StringBuilder();
        String json = """
                {
                  "username": "%s",
                  "password": "%s"
                }
                """.formatted(username, password);

        str.append(json);
        return str.toString();
    }

    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
