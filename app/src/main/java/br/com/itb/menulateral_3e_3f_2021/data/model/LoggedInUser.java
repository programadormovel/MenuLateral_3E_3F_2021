package br.com.itb.menulateral_3e_3f_2021.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String userId;
    private String displayName;
    private String conta;
    private String senha;
    private String email;
    private int nivelAcesso;
    private String confirmaSenha;

    public LoggedInUser(String userId, String displayName) {
        this.userId = userId;
        this.displayName = displayName;
    }

    public LoggedInUser(String userId, String displayName, String conta, String senha, String email, int nivelAcesso) {
        this.userId = userId;
        this.displayName = displayName;
        this.conta = conta;
        this.senha = senha;
        this.email = email;
        this.nivelAcesso = nivelAcesso;
    }

    public LoggedInUser(String displayName, String conta, String senha, String email, int nivelAcesso, String confirmaSenha) {
        this.displayName = displayName;
        this.conta = conta;
        this.senha = senha;
        this.email = email;
        this.nivelAcesso = nivelAcesso;
        this.confirmaSenha = confirmaSenha;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getConta() {
        return conta;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}