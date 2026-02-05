/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.util;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.nio.file.Files;
import java.time.DateTimeException;


/**
 *
 * @author jesus
 */
public class ImagemStora {
    private static final String PASTA_IMAGEM = "imagem";
    
    public  static String salvarimagem( File arquivo ){
        try {
            if(arquivo == null) return null;
            
            // criar objeto que representa a pasta "imagem"
            File pasta = new File(PASTA_IMAGEM);
            if(!pasta.exists())pasta.mkdir();
            
            // gerar data/hora atual como txt 
            //serve para criar nome unico
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            //pega o nome original do arquivo
            //renova espaço e troca por "-"
            String nomeOriginal = arquivo.getName().replaceAll("\\s+", "-");
            // Cria novo nome: data + nome original 
            String novoNome = timestamp + "_" + nomeOriginal;
            // defiir camnho do destino 
            Path destino = Path.of(PASTA_IMAGEM, novoNome);
            // copia o arquvo para pasta
            // se existir, subtiyui
            Files.copy(
                arquivo.toPath(),
                destino,
                StandardCopyOption.REPLACE_EXISTING);
            // retorna o caminho da imagem salva 
            return PASTA_IMAGEM + "/" + novoNome;
            
        } catch (Exception e) {
            
            // caso dê erro, mostres essa mensagem
            throw new RuntimeException("Erro ao cocbetar-se ao banco" + e.getMessage());
        }
    }
    
    
}
