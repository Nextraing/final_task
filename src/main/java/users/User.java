package users;

import utils.PropertiesLoader;

public class User {

    private String loginName;
    private String password;

    public User() {

        PropertiesLoader propertiesLoader = new PropertiesLoader();

        this.loginName = propertiesLoader.getUserProperty("user.username");
        this.password = propertiesLoader.getUserProperty("user.password");
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
