package com.accenture.documentsApi.domain.utils;

import com.accenture.documentsApi.domain.models.Documento;
import com.accenture.documentsApi.domain.models.Palavra;
import com.accenture.documentsApi.domain.models.User;
import com.accenture.documentsApi.domain.repository.IDocumentoRepository;
import com.accenture.documentsApi.domain.repository.IPalavraRepository;
import com.accenture.documentsApi.domain.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    IUserRepository userRepository;
    @Autowired
    IDocumentoRepository documentoRepository;
    @Autowired
    IPalavraRepository palavraRepository;

    //@PostConstruct
    public void salvarUsuario(){
        User user = new User("Login3", "123456", "Administrador");
        User userSaved = userRepository.save(user);
        System.out.println(userSaved.getIdUser());
    }

    //@PostConstruct
    public void buscarTodosUsuarios(){
        List<User> lista = new ArrayList<>();
        lista = userRepository.findAll();

        for (User user: lista) {
            System.out.println(user.getLogin() + " " + user.getTipoUser());
        }
    }

    //@PostConstruct
    public void buscarUsuarioPorId(){
        User user = userRepository.findById(3).get();
        System.out.println(user.getLogin() + " " + user.getTipoUser());
    }

    //@PostConstruct
    public void deletarUsuario(){
        User user = userRepository.findById(3).get();
        userRepository.delete(user);
    }

    //@PostConstruct
    public void salvarDocumento(){
        Date date = new Date();
        Documento documento = new Documento("TXT", "MOBILE", 1, 1);
        documento.setData(date);
        Documento documentoSalved = documentoRepository.save(documento);
    }

    //@PostConstruct
    public void buscarTodosOsDocumentos(){
        List<Documento> listaDocumentos = new ArrayList<>();
        listaDocumentos = documentoRepository.findAll();

        for (Documento documento: listaDocumentos) {
            System.out.println(documento.getIdDocumento() + " " + documento.getTipoArquivo() + " " + documento.getTipoDispositivo());
        }
    }
   // @PostConstruct
    public void buscarDocumentoPorId(){
        Documento documento = documentoRepository.findById(1).get();
        System.out.println("Documento recuperado por ID. ID: " + documento.getIdDocumento() + " Tipo de arquivo " + documento.getTipoArquivo() + " Tipo de Dispositivo " + documento.getTipoDispositivo());
    }

    //@PostConstruct
    public void salvarPalavras(){
        String texto = "fui morar numa casinha enfeitada de pisca pisca . fui morar numa casinha enfeitada de chocolate ";
        String[] listaDePalavrasNoTexto = texto.split(" ");
        List<Palavra> listaDePalavrasVerificadas = new ArrayList<>();
        Palavra palavra = new Palavra();

        for (int i = 0; i < listaDePalavrasNoTexto.length; i++) {
            palavra.setPalavra(listaDePalavrasNoTexto[i]);

            for (int j = 0; j < listaDePalavrasVerificadas.size(); j++) {
                Palavra p2 = new Palavra();
                if (!listaDePalavrasVerificadas.get(j).equals(palavra)) {
                    listaDePalavrasVerificadas.add(palavra);
                }
            }

        }
        System.out.println(listaDePalavrasVerificadas.size());
    }

}
