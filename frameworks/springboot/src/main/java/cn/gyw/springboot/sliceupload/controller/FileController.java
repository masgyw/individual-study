package cn.gyw.springboot.sliceupload.controller;

import com.github.lybgeek.upload.dto.FileUploadDTO;
import com.github.lybgeek.upload.dto.FileUploadRequestDTO;
import com.github.lybgeek.upload.service.FileService;
import com.github.lybgeek.upload.util.FileUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/")
public class FileController {

  private static final Logger log = LoggerFactory.getLogger(FileController.class);

  @Autowired
  private FileService fileService;

  @Autowired
  private HttpServletRequest request;

  @Autowired
  private HttpServletResponse response;


  @GetMapping(value="/")
  public String gotoPage(){
    return "index";
  }

  @GetMapping(value="/uploadFile")
  public String gotoFilePage(){
    return "upload";
  }

  @GetMapping(value="/oss/upload")
  public String gotoOssPage(){
    return "ossUpload";
  }



  @PostMapping(value = "/upload")
  @ResponseBody
  public Result<FileUploadDTO> upload(FileUploadRequestDTO fileUploadRequestDTO) throws IOException {

    boolean isMultipart = ServletFileUpload.isMultipartContent(request);
    FileUploadDTO fileUploadDTO = null;
    if (isMultipart) {

      StopWatch stopWatch = new StopWatch();
      stopWatch.start("upload");
      if (fileUploadRequestDTO.getChunk() != null && fileUploadRequestDTO.getChunks() > 0) {
        fileUploadDTO = fileService.sliceUpload(fileUploadRequestDTO);
      } else {
        fileUploadDTO = fileService.upload(fileUploadRequestDTO);
      }
      stopWatch.stop();
      log.info("{}",stopWatch.prettyPrint());

      return new Result<FileUploadDTO>().setData(fileUploadDTO);
    }

    throw new BizException("上传失败", 406);

  }

  @RequestMapping(value = "checkFileMd5", method = RequestMethod.POST)
  @ResponseBody
  public Result<FileUploadDTO> checkFileMd5(String md5, String path) throws IOException {

    FileUploadRequestDTO param = new FileUploadRequestDTO().setPath(path).setMd5(md5);
    FileUploadDTO fileUploadDTO = fileService.checkFileMd5(param);

    return new Result<FileUploadDTO>().setData(fileUploadDTO);
  }

  @PostMapping("/download")
  public void download(FileDownloadRequestDTO requestDTO) {

      try {
        FileUtil.downloadFile(requestDTO.getName(), requestDTO.getPath(), request, response);
      } catch (FileNotFoundException e) {
        log.error("download error:" + e.getMessage(), e);
        throw new BizException("文件下载失败", 406);
      }
    }


}
