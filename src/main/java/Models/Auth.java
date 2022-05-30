package Models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "authorization")
@NamedQueries({
        @NamedQuery(name = "getUser",
                query="select a from Auth a WHERE a.login = :login"),
        @NamedQuery(name = "getLogin",
                query="select a from Auth a WHERE a.login = :login AND a.password = :password"),
})
public class Auth implements Serializable {

    @Id
    @Column(unique = true, name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "type")
    private String user_type;

    public Auth(){}

    public Auth(String login, String password, String type){
        this.login = login;
        this.password = password;
        this.user_type = type;
    }



    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    @Override
    public String toString() {
        return "Authorization{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", user_type='" + user_type + '\'' +
                '}';
    }
}
