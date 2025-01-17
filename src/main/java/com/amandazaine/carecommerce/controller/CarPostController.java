package com.amandazaine.carecommerce.controller;

import com.amandazaine.carecommerce.dto.CarPostDTO;
import com.amandazaine.carecommerce.message.KafkaProducerMessage;
import com.amandazaine.carecommerce.service.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarPostController {

    @Autowired
    private CarPostService carPostService;

    @Autowired
    KafkaProducerMessage kafkaProducerMessage;

    @PostMapping("/post")
    public ResponseEntity saveCarPost(@RequestBody CarPostDTO carPostDTO) {
        kafkaProducerMessage.sendMessage(carPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDTO>> getAllCarPost() {
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostService.getAllCarPost());
    }

    @PutMapping("/id")
    public ResponseEntity updateCarPost(@RequestBody CarPostDTO carPost, @PathVariable("id") String id) {
        carPostService.updateCarPost(carPost, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public ResponseEntity deleteCarPost(@PathVariable("id") String id) {
        carPostService.deleteCarPost(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/report")
    public ResponseEntity<Object> allCarPostReport() {
        Object arquivoRelatorio = carPostService.generateAllCarPostReport();

        //Retorna o arquivo no corpo da resposta
        return new ResponseEntity<>(arquivoRelatorio, createHttpHeader(), HttpStatus.OK);
    }

    //Configurando os headers HTTP para indicar o tipo de conteúdo e o nome do arquivo
    public HttpHeaders createHttpHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();

        //Indica que o conteúdo da resposta é um arquivo binário
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        //'ContentDisposition' configurado como "attachment" para forçar o download do arquivo pelo navegador com o nome especificado
        httpHeaders.setContentDispositionFormData("attachment", "all_car_posts.xlsx");
        return httpHeaders;
    }
}


