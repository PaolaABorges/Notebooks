package Reserva.Notebooks.Service;

import Reserva.Notebooks.Model.M_Usuario;
import Reserva.Notebooks.Repository.R_Usuario;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class S_Usuario {

    private static R_Usuario r_usuario;

    public S_Usuario(R_Usuario r_usuario) {
        this.r_usuario = r_usuario;
    }

    public static String CadastrarUsuario(String nome, String matricula, String Ocupacao, String email) {
        boolean podesalvar = true;
        String mensagem = "";

        matricula = S_Generico.limparNumero(matricula);
        Ocupacao = S_Generico.limparNumero(Ocupacao);

        if (S_Generico.campoVazio(nome)) {
            podesalvar = false;
            mensagem += "O nome deve ser informado";
        }
        if (S_Generico.campoVazio(matricula)) {
            podesalvar = false;
            mensagem += "A matricula deve ser informada";
        }
        if (S_Generico.campoVazio(Ocupacao)) {
            podesalvar = false;
            mensagem += "A ocupação deve ser selecionada";
        }

        if (S_Generico.campoVazio(email)) {
            podesalvar = false;
            mensagem += "O email deve ser infomado";
        }
        if (podesalvar) {
            M_Usuario m_usuario = new M_Usuario();
            m_usuario.setNome(nome);
            m_usuario.setEmail(email);
            m_usuario.setSenha(S_GeradorSenha.gerador_senha(5, 3, 2));
            m_usuario.setMatricula(Long.parseLong(matricula));
            m_usuario.setOcupacao(Long.parseLong(Ocupacao));
            m_usuario.setAtivo(true);

            try {
                r_usuario.save(m_usuario);
                mensagem += "Usuario salvo com sucesso";
            } catch (DataIntegrityViolationException e) {
                mensagem += "Falha ao inserir registro no banco de dados";
            }
        }
        return mensagem;
    }
}
