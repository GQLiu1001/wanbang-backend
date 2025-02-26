package com.wanbang.util;

import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import io.minio.http.Method;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.google.common.io.Files.getFileExtension;

public class MinioUpload {
    final static String BUCKET_NAME = "wanbang";
    final static String ACCESS_KEY = "hP3zArCnQzJvCGblFkb4";
    final static String SECRET_KEY = "XevaAMNhoPjmIbIRKqncuTscmeITfxBWDP19MlrM";
    final static String ENDPOINT = "http://localhost:9000";
    public static String uploadFile(MultipartFile file) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        InputStream inputStream = file.getInputStream();
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint(ENDPOINT)
                        .credentials(ACCESS_KEY, SECRET_KEY)
                        .build();
        String originalFileName = file.getOriginalFilename();
        String fileExtension = getFileExtension(originalFileName);
        String fileName = UUID.randomUUID().toString().replace("-", "") +"."+ fileExtension;
        // Upload known sized input stream.
        minioClient.putObject(
                PutObjectArgs.builder().bucket(BUCKET_NAME)
                        .object(fileName)
                        .stream(inputStream, file.getSize(), -1)
                        .build());
        // URL有效期1小时
        return minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .method(Method.GET)
                        .bucket(BUCKET_NAME)
                        .object(fileName)
                        .expiry(7, TimeUnit.DAYS) // URL有效期1小时
                        .build());
    }
}
