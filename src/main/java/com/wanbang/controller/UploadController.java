package com.wanbang.controller;

import com.wanbang.common.Result;
import io.minio.errors.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static com.wanbang.util.MinioUpload.uploadFile;

@RestController
public class UploadController {

    @Operation(summary = "上传接口")
    @PostMapping("/api/upload")
    public Result upload(@RequestParam("file") MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        String url = uploadFile(file);
        if (url != null) {
            return Result.success(url);
        }
        else {
            return Result.fail();
        }
    }
}
