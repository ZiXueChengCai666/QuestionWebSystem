package domain;

public class User {
    private int userId;
    private String userNiCheng;
    private String userName;
    private String userPassword;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserNiCheng() {
        return userNiCheng;
    }

    public void setUserNiCheng(String userNiCheng) {
        this.userNiCheng = userNiCheng;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
