package cn.gyw.springboot.sliceupload.service;

import cn.gyw.springboot.sliceupload.dto.FileUploadDTO;
import cn.gyw.springboot.sliceupload.dto.FileUploadRequestDTO;

import java.io.IOException;

public interface FileService {

  FileUploadDTO upload(FileUploadRequestDTO fileUploadRequestDTO)throws IOException;

  FileUploadDTO sliceUpload(FileUploadRequestDTO fileUploadRequestDTO);

  FileUploadDTO checkFileMd5(FileUploadRequestDTO fileUploadRequestDTO)throws IOException;

}
