package Reserva.Notebooks.Service;

import Reserva.Notebooks.Model.M_Resposta;
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

    public static M_Usuario validaLogin(String matricula, String senha) {
        matricula = S_Generico.limparNumero(matricula);

        if (S_Generico.campoVazio(matricula)) {
            return null;
        } else if (S_Generico.campoVazio(senha)) {
            return null;
        }

        return r_usuario.buscarUsuarioPorMatriculaESenha(Long.parseLong(matricula), senha);
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

    public static M_Resposta salvaEditUsuario(String nome, String matricula,
                                              String email, String Ocupacao,
                                              String senhaAtual, String novaSenha,
                                              String confSenha, String ativo,
                                              M_Usuario usuario) {

        boolean podeSalvar = true;
        String mensagem = "";
        boolean isAdmin = usuario.getOcupacao() == 1;
        matricula = isAdmin ? S_Generico.limparNumero(matricula): matricula;

        if (senhaAtual.equals(usuario.getSenha())) {
            if (S_Generico.campoVazio(nome)) {
                podeSalvar = false;
                mensagem += "O Nome precisa ser preenchido";
            }
            if (S_Generico.campoVazio(matricula)) {
                podeSalvar = false;
                mensagem += "Matricula invalida!";
            }
            if (S_Generico.campoVazio(email)) {
                podeSalvar = false;
                mensagem += "O Email precisa ser preenchido";
            }
            if (!novaSenha.equals(confSenha)) {
                podeSalvar = false;
                mensagem += "A nova senha e a confirmação de senha precisam ser iguais";
            }
        } else {
            podeSalvar = false;
            mensagem += "Senha Invalida";
        }
        if (podeSalvar) {
            usuario.setNome(nome);
            usuario.setEmail(email);
            if (!S_Generico.campoVazio(novaSenha)) {
                usuario.setSenha(novaSenha);
            }
            if (isAdmin) {
                usuario.setOcupacao(Long.parseLong(Ocupacao));
                usuario.setMatricula(Long.parseLong(matricula));
                usuario.setAtivo(Boolean.parseBoolean(ativo));
            }
            try {
                r_usuario.save(usuario);
                mensagem += "Atualização efetuada com Sucesso!";
            } catch (DataIntegrityViolationException e) {
                podeSalvar = false;
                mensagem += "Falha ao salvar dados!";

            }
        }
        return new M_Resposta(podeSalvar, mensagem);

    }
}
