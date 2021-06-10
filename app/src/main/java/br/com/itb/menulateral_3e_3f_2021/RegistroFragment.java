package br.com.itb.menulateral_3e_3f_2021;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;

import br.com.itb.menulateral_3e_3f_2021.data.dao.LoggedInUserDao;
import br.com.itb.menulateral_3e_3f_2021.data.model.LoggedInUser;
import br.com.itb.menulateral_3e_3f_2021.databinding.FragmentLoginBinding;
import br.com.itb.menulateral_3e_3f_2021.databinding.RegistroFragmentBinding;

public class RegistroFragment extends Fragment {

    private RegistroViewModel mViewModel;
    private RegistroFragmentBinding binding;
    private Button botaoRegistro;
    private EditText edtId;
    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtSenha;
    private EditText edtConfirma;

    public static RegistroFragment newInstance() {
        return new RegistroFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = RegistroFragmentBinding.inflate(inflater, container, false);

        // Vínculos entre objetos Java e objetos da Janela XML
        botaoRegistro = binding.registro;
        edtNome = binding.nameRegistro;
        edtEmail = binding.usernameRegistro;
        edtSenha = binding.passwordRegistro;
        edtConfirma = binding.confirmPasswordRegistro;
        botaoRegistro.setEnabled(true);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        botaoRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Capturar dados da janela e enviar ao banco de dados
                String nome = edtNome.getText().toString();
                String email = edtEmail.getText().toString();
                String conta = edtEmail.getText().toString();
                String senha = edtSenha.getText().toString();
                String confirma = edtConfirma.getText().toString();

                LoggedInUser usuario = new LoggedInUser(nome, conta, senha, email,
                        1, confirma);
                usuario = LoggedInUserDao.inserirUsuario(usuario);
                if(usuario.getUserId()!=null){
                    Snackbar.make(v, "SUCESSO", Snackbar.LENGTH_LONG).show();
                }else{
                    Snackbar.make(v, "FALHA", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RegistroViewModel.class);
        // TODO: Use the ViewModel


    }

}