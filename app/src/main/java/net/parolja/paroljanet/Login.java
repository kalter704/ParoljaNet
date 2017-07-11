package net.parolja.paroljanet;

public class Login {
    private String mLogin;
    private String mPassword;
    private int mPercent;
    private boolean more;

    public Login(String login, String password, int percent, boolean more) {
        mLogin = login;
        mPassword = password;
        mPercent = percent;
        this.more = more;
    }

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public int getPercent() {
        return mPercent;
    }

    public void setPercent(int percent) {
        mPercent = percent;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }
}
