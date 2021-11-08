
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.commons.fileupload.FileItemStream;


public class UploadFile {
    String uploadFileName;
    public boolean processFile(String path,FileItemStream item){
        try{
        File f=new File(path);
        if(!f.exists()){
            f.mkdir();
        }
        File savefile=new File(f.getAbsolutePath()+File.separator+item.getName());
            FileOutputStream fout=new FileOutputStream(savefile);
            InputStream is=item.openStream();
            int x=0;
            byte[] arr=new byte[1024];
            while((x=is.read(arr))!=-1){
                fout.write(arr, 0, x);
            }
            fout.flush();
            fout.close();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public void setUploadedFileName(String uploadFileName){
        this.uploadFileName=uploadFileName;
    }
    public String getUploadedFileName(String uploadFileName){
        return uploadFileName;
    }
}
