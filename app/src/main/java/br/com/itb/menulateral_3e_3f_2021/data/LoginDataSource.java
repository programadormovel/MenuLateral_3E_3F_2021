package br.com.itb.menulateral_3e_3f_2021.data;

import br.com.itb.menulateral_3e_3f_2021.data.dao.LoggedInUserDao;
import br.com.itb.menulateral_3e_3f_2021.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            LoggedInUser login = LoggedInUserDao.verificarUsuario(username, password);

            // Verificar se o objeto login voltou nulo
            if(login == null){
                return new Result.Error(new IOException("Login não existente ou senha errada"));
            }

            /*LoggedInUser login =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");*/
            return new Result.Success<>(login);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}