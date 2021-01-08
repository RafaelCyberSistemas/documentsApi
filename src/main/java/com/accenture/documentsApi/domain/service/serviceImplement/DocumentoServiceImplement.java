package com.accenture.documentsApi.domain.service.serviceImplement;

import com.accenture.documentsApi.domain.models.Documento;
import com.accenture.documentsApi.domain.models.Palavra;
import com.accenture.documentsApi.domain.models.User;
import com.accenture.documentsApi.domain.repository.IDocumentoRepository;
import com.accenture.documentsApi.domain.repository.IPalavraRepository;
import com.accenture.documentsApi.domain.service.IDocumentoService;
import com.accenture.documentsApi.dto.DocumentoDto;
import com.accenture.documentsApi.exception.NotFoundException;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class DocumentoServiceImplement implements IDocumentoService {

    @Autowired
    IDocumentoRepository documentoRepository;

    @Autowired
    IPalavraRepository palavraRepository;

    @Override
    public List<Documento> buscarTodosDocumentos() {
        return documentoRepository.findAll();
    }

    @Override
    public Documento buscarDocumentoPorId(Integer id) {
        return documentoRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Documento não localizado"));
    }

    @Override
    public String salvarDocumento(DocumentoDto dto) {
        User user = new User(dto.getIdUser());
        Documento documento = new Documento(dto.getNomeArquivo(), dto.getTipoArquivo(), dto.getTipoDispositivo(), dto.getQuantidadeDePalavras(), user);
        Date date = new Date();
        documento.setData(date);
        Documento documentoSalved = documentoRepository.save(documento);
        String body = "Documento código: " + documentoSalved.getIdDocumento() +" salvo com sucesso!!!";
        return body;
    }

    @Override
    public Documento saveDoc(MultipartFile file) {
        DocumentoDto documentoDto = new DocumentoDto();

        String nomeArquivo = file.getOriginalFilename();
        String tipoArquivo = FilenameUtils.getExtension(nomeArquivo);

        //TO DO
        String tipoDispositivo = "TESTE MOBILE";

        InputStream inputStream = null;
        String textoConvertido = "";

        if (tipoArquivo != null && (tipoArquivo.equals("doc") || tipoArquivo.equals("txt"))){
            try {
                inputStream = file.getInputStream();
                textoConvertido = IOUtils.toString(inputStream);
                documentoDto.listaDePalavras = contagemDeOcorrenciasDaPalavra(textoConvertido);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            textoConvertido = "tipo inválido";
        }

        documentoDto.setNomeArquivo(nomeArquivo);
        documentoDto.setTipoArquivo(tipoArquivo);
        documentoDto.setTipoDispositivo(tipoDispositivo);
        List<String> qtdDePalavrasNoDocumento = new ArrayList<>();
        qtdDePalavrasNoDocumento = Arrays.asList(textoConvertido.split(" "));
        documentoDto.setQuantidadeDePalavras(qtdDePalavrasNoDocumento.size());
        //TO DO

        User user = new User(1);
        Documento documento = new Documento(documentoDto.getNomeArquivo(), documentoDto.getTipoArquivo(), documentoDto.getTipoDispositivo(),documentoDto.getQuantidadeDePalavras(), user );
        Date date = new Date();
        documento.setData(date);

        Documento documentoSalved = documentoRepository.save(documento);

        //PARA APENAS ADICIONAR O ID DO DOCUMENTO NOS OBJETOS PALAVRAS DA LISTA DE PALAVRAS QUE SERÁ SALVA
        for (Palavra palavra: documentoDto.listaDePalavras) {
            palavra.getDocumento().setIdDocumento(documentoSalved.getIdDocumento());
            palavraRepository.save(palavra);
        }

        return documentoSalved;
    }

    public List<Palavra> contagemDeOcorrenciasDaPalavra(String texto){
        List<String> listaInicial = new ArrayList<>();
        listaInicial = Arrays.asList(texto.split(" "));
        List<String> listaFiltrada = new ArrayList<>();
        Palavra objPalavra;
        ArrayList<Palavra> listaDePalavrasProcessadas = new ArrayList<>();

        for (int i = 0; i < listaInicial.size(); i++) {
            if(!listaFiltrada.contains(listaInicial.get(i))){
                listaFiltrada.add(listaInicial.get(i));
                objPalavra = new Palavra(listaInicial.get(i).trim());
                listaDePalavrasProcessadas.add(objPalavra);
            }
        }

        for (int i = 0; i < listaDePalavrasProcessadas.size(); i++) {
            int contador = 0;
            for (int j = 0; j < listaInicial.size(); j++) {
                if(listaDePalavrasProcessadas.get(i).getPalavra().toString().trim().equals(listaInicial.get(j).toString().trim())){
                    contador = contador + 1;
                    listaDePalavrasProcessadas.get(i).setQuantidadeOcorrencias(contador);
                }
            }

        }
        return listaDePalavrasProcessadas;
    }

    public void salvarPalavrasDoDocumento(Palavra palavra){
            palavraRepository.save(palavra);
    }



    @Override
    public String atualizarDocumento(Documento documento) {
        //documentoRepository.save(documento);
        String body = "Documento atualizado com sucesso!!";
        return body;
    }

    @Override
    public String deletarDocumento(Integer idDocumento) {
        Documento documento = new Documento();
        documento = buscarDocumentoPorId(idDocumento);
        documentoRepository.delete(documento);
        String body = "Documento removido com sucesso!!";
        return body;
    }
}
