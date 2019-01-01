import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class writeText {


//    public WriteFile() {
//        initWriteFile();
//    }

    public void initWriteFile(){

    }

    /**
     * �g�J��r��(�ϥ�FileWriter �g�ɽs�X���w�]��iso-8859-1)�A
     * �]����method�ϥ�OutputStreamWriter�g�ɡA�i�ۦ���w�榡
     *
     * @param text        �N���String�g�J���w���ɮ�
     * @param filename    �i�ά۹���|�ε�����|
     * @param format    �g�J�ɮת��s�X�榡
     * @param append    true �N�����g�ɦ�b�쥻�ɮ׳̫᭱ | false �N�����g�ɻ\���쥻����r�ɤ��e
     * @return            true �g�ɦ��\ | false �g�ɥ���
     */
    public boolean writeText(String text,String filename,String format,boolean append){
        if(text.equals("")){
            return false;
        }
        File file = new File(filename);//�إ��ɮסA�ǳƼg��
        try{
            BufferedWriter bufWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,append),format));
            bufWriter.write(text);
            bufWriter.close();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println(filename + "�g�ɵo�Ϳ��~");
            return false;
        }
        return true;
    }

    /**
     * �g�J�ɮרϥ�utf8�榡�g�ɡA�åB�_�\�쥻�ɮפ��e
     * @param text
     * @param filename
     * @return
     */
    public boolean writeText_UTF8(String text,String filename){
        return writeText(text, filename, "utf8", false);
    }

    /**
     * �g�J�ɮרϥ�big5�榡�g�ɡA�åB�_�\�쥻�ɮפ��e
     * @param text
     * @param filename
     * @return
     */
    public boolean writeText_BIG5(String text,String filename){
        return writeText(text, filename, "big5", false);
    }

    /**
     * �g�J�ɮרϥ�utf8�榡�g�ɡA��b�쥻�ɮפ��e�᭱
     * @param text
     * @param filename
     * @return
     */
    public boolean writeText_UTF8_Apend(String text,String filename){
        return writeText(text, filename, "utf8", true);
    }

    /**
     * �g�J�ɮרϥ�big5�榡�g�ɡA��b�쥻�ɮפ��e�᭱
     * @param text
     * @param filename
     * @return
     */
    public boolean writeText_BIG5_Apend(String text,String filename){
        return writeText(text, filename, "big5", true);
    }

    /**
     * �ˬd�ɮ׬O�_�s�b
     * @param filename
     * @return true �ɮפw�s�b | false �ɮפ��s�b
     */
    public static boolean exists(String path){
        return new File(path).exists();
    }

    /**
     * �إ߷s��(�ɮפw�s�b�|�R�����ɨëطs��)
     * @param path
     */
    public static void createNewFile(String path){
        try{
            File file = new File(path);
            file.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * �R�ɮ�
     * @param path
     */
    public static void deleteFile(String path){

        File file = new File(path);
        file.delete();

    }

    /**
     * �إ߸�Ƨ�(�i�ئh�h��Ƨ�)
     * @param path
     * @param �̫�@�h����Ƨ�
     */
    public static String mkDir(String path){
        String [] pathAry = path.split("[/]|\\\\");

        StringBuffer list = new StringBuffer();
        for(int i = 0; i < pathAry.length; i++){
            if(!pathAry[i].equals("")){
                list.append(pathAry[i] + "/");
                File dir = new File(list.toString());
                //System.out.println(dir.getName());
                if (!dir.isDirectory()){
                    dir.mkdir();

                }
            }
        }
        return list.toString();
    }

 
	
}
