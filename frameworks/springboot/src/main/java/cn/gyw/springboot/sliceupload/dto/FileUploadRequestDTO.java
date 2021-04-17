package cn.gyw.springboot.sliceupload.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadRequestDTO {
    //上传文件到指定目录
    private String path;
    //上传文件的文件名称
    private String name;
    //任务ID
    private String id;
    //总分片数量
    private Integer chunks;
    //当前为第几块分片
    private Integer chunk;
    //按多大的文件粒度进行分片
    private Long chunkSize;
    //分片对象
    private MultipartFile file;
    // MD5
    private String md5;

    //当前分片大小
    private Long size = 0L;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getChunks() {
        return chunks;
    }

    public void setChunks(Integer chunks) {
        this.chunks = chunks;
    }

    public Integer getChunk() {
        return chunk;
    }

    public void setChunk(Integer chunk) {
        this.chunk = chunk;
    }

    public Long getChunkSize() {
        return chunkSize;
    }

    public void setChunkSize(Long chunkSize) {
        this.chunkSize = chunkSize;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "FileUploadRequestDTO{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", chunks=" + chunks +
                ", chunk=" + chunk +
                ", chunkSize=" + chunkSize +
                ", file=" + file +
                ", md5='" + md5 + '\'' +
                ", size=" + size +
                '}';
    }
}
