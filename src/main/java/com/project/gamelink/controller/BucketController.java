package com.project.gamelink.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.imageio.stream.FileImageOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@RestController
public class BucketController {

    @Autowired
    private AmazonS3 client;

    @PostMapping
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            String bucketName = "nome-do-seu-bucket"; // Nome do seu bucket S3
            String folderName = "pictures"; // Nome da pasta para armazenar as imagens
            
            // Gerar um nome único para o arquivo
            String fileName = file.getOriginalFilename();

            // Configurar o caminho completo do arquivo no S3
            String s3Key = fileName;

            // Fazer o upload do arquivo para o S3
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            client.putObject(bucketName, s3Key, file.getInputStream(), metadata);

            // Sucesso! Retornar uma resposta adequada
            return "redirect:/success"; // Página de sucesso
        } catch (Exception e) {
            // Lidar com erros de upload
            return "redirect:/error"; // Página de erro
        }
    }


}
