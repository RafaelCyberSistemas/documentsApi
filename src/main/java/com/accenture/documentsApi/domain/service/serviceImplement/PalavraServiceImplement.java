package com.accenture.documentsApi.domain.service.serviceImplement;

import com.accenture.documentsApi.domain.models.Documento;
import com.accenture.documentsApi.domain.models.Palavra;
import com.accenture.documentsApi.domain.repository.IPalavraRepository;
import com.accenture.documentsApi.domain.service.IPalavraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PalavraServiceImplement implements IPalavraService {

    @Autowired
    IPalavraRepository palavraRepository;

    @Override
    public List<Palavra> buscarTodasPalavras() {
        return palavraRepository.findAll();
    }

    @Override
    public List<Palavra> buscarPalavrasPorIdDoDocumento(Integer id) {
        return null;
    }

    @Override
    public Palavra buscarPalavraPorIdDaPalavra(Integer id) {
        return palavraRepository.findById(id).get();
    }

    @Override
    public void salvarPalavras(List<Palavra> listaDePalavrasNoDocumento) {
        for (Palavra palavra: listaDePalavrasNoDocumento) {
            palavraRepository.save(palavra);
        }
    }

    @Override
    public void atualizarPalavras(List<Palavra> listaDePalavrasNoDocumento, Integer idDocumento) {
        for (Palavra palavra: listaDePalavrasNoDocumento) {
            palavraRepository.save(palavra);
        }
    }


    @Override
    public void deletarPalavras(Palavra palavra) {
        palavraRepository.delete(palavra);
    }
}
