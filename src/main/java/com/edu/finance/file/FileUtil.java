//package com.edu.finance.file;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.io.RandomAccessFile;
//import java.nio.MappedByteBuffer;
//import java.nio.channels.FileChannel;
//import java.nio.channels.FileChannel.MapMode;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;
//import org.apache.poi.POIXMLDocument;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//import org.apache.poi.xwpf.usermodel.XWPFParagraph;
//import org.apache.poi.xwpf.usermodel.XWPFRun;
//import org.apache.poi.xwpf.usermodel.XWPFTable;
//import org.apache.poi.xwpf.usermodel.XWPFTableCell;
//import org.apache.poi.xwpf.usermodel.XWPFTableRow;
//
//public class FileUtil {
//
//	//生成文件路径
//	private static String path = "D:\\file\\temp\\";
//	//文件路径+名称
//    private static String filenameTemp;
//	
//	/**
//	 * 复制文件
//	 * @param f1
//	 * @param f2
//	 * @return
//	 * @throws Exception
//	 */
//	public static long copyFile(File f1,File f2) throws Exception{
//        long time=new Date().getTime();
//        int length=2097152;
//        FileInputStream in=new FileInputStream(f1);
//        RandomAccessFile out=new RandomAccessFile(f2,"rw");
//        FileChannel inC=in.getChannel();
//        MappedByteBuffer outC=null;
//        MappedByteBuffer inbuffer=null;
//        byte[] b=new byte[length];
//        while(true){
//            if(inC.position()==inC.size()){
//                inC.close();
//                outC.force();
//                out.close();
//                return new Date().getTime()-time;
//            }
//            if((inC.size()-inC.position())<length){
//                length=(int)(inC.size()-inC.position());
//            }else{
//                length=20971520;
//            }
//            b= new byte[length];
//            inbuffer=inC.map(MapMode.READ_ONLY,inC.position(),length);
//            inbuffer.load();
//            inbuffer.get(b);
//            outC=out.getChannel().map(MapMode.READ_WRITE,inC.position(),length);
//            inC.position(b.length+inC.position());
//            outC.put(b);
//            outC.force();
//        }
//    }
//	
//	/**
//	 * 
//	 * @param fileName
//	 * @param filecontent
//	 * @return
//	 */
//	public static boolean createFile(String fileName,String filecontent){
//        Boolean bool = false;
//        filenameTemp = path+fileName+".xlsx";//文件路径+名称+文件类型
//        File file = new File(filenameTemp);
//        try {
//            //如果文件不存在，则创建新的文件
//            if(!file.exists()){
//                file.createNewFile();
//                bool = true;
//                System.out.println("success create file,the file is "+filenameTemp);
//                //创建文件成功后，写入内容到文件里
//                writeFileContent(filenameTemp, filecontent);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bool;
//    }
//	
//	/**
//     * 向文件中写入内容
//     * @param filepath 文件路径与名称
//     * @param newstr  写入的内容
//     * @return
//     * @throws IOException
//     */
//    public static boolean writeFileContent(String filepath,String newstr) throws IOException{
//        Boolean bool = false;
//        String filein = newstr+"\r\n";//新写入的行，换行
//        String temp  = "";
//        
//        FileInputStream fis = null;
//        InputStreamReader isr = null;
//        BufferedReader br = null;
//        FileOutputStream fos  = null;
//        PrintWriter pw = null;
//        try {
//            File file = new File(filepath);//文件路径(包括文件名称)
//            //将文件读入输入流
//            fis = new FileInputStream(file);
//            isr = new InputStreamReader(fis);
//            br = new BufferedReader(isr);
//            StringBuffer buffer = new StringBuffer();
//            
//            //文件原有内容
//            for(int i=0;(temp =br.readLine())!=null;i++){
//                buffer.append(temp);
//                // 行与行之间的分隔符 相当于“\n”
//                buffer = buffer.append(System.getProperty("line.separator"));
//            }
//            buffer.append(filein);
//            
//            fos = new FileOutputStream(file);
//            pw = new PrintWriter(fos);
//            pw.write(buffer.toString().toCharArray());
//            pw.flush();
//            bool = true;
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }finally {
//            //不要忘记关闭
//            if (pw != null) {
//                pw.close();
//            }
//            if (fos != null) {
//                fos.close();
//            }
//            if (br != null) {
//                br.close();
//            }
//            if (isr != null) {
//                isr.close();
//            }
//            if (fis != null) {
//                fis.close();
//            }
//        }
//        return bool;
//    }
//    
//    
//    /**
//     * 删除文件
//     * @param fileName 文件名称
//     * @return
//     */
//    public static boolean delFile(String fileName){
//        Boolean bool = false;
//        filenameTemp = path+fileName+".txt";
//        File file  = new File(filenameTemp);
//        try {
//            if(file.exists()){
//                file.delete();
//                bool = true;
//            }
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//        return bool;
//    }
//    
//    
//    
//    /**
//     * 根据模板替换执行文件
//     * @param srcPath
//     * @param destPath
//     * @param map
//     */
//    public static void searchAndReplace(String srcPath, String destPath,Map<String, String> map) {  
//        try {  
//            XWPFDocument document = new XWPFDocument(POIXMLDocument.openPackage(srcPath));  
//            /** 
//             * 替换段落中的指定文字 
//             */  
//            Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();  
//            while (itPara.hasNext()) {  
//                XWPFParagraph paragraph = (XWPFParagraph) itPara.next();  
//                Set<String> set = map.keySet();  
//                Iterator<String> iterator = set.iterator();  
//                while (iterator.hasNext()) {  
//                    String key = iterator.next();  
//                    List<XWPFRun> run=paragraph.getRuns();  
//                    for(int i=0;i<run.size();i++)  
//                    {  
//                        if(run.get(i).getText(run.get(i).getTextPosition())!=null &&  
//                                run.get(i).getText(run.get(i).getTextPosition()).equals(key))  
//                        {  
//                            /** 
//                             * 参数0表示生成的文字是要从哪一个地方开始放置,设置文字从位置0开始 
//                             * 就可以把原来的文字全部替换掉了 
//                             */  
//                            run.get(i).setText(map.get(key),0);  
//                        }  
//                    }  
//                }  
//            }  
//  
//            /** 
//             * 替换表格中的指定文字 
//             */  
//            Iterator<XWPFTable> itTable = document.getTablesIterator();  
//            while (itTable.hasNext()) {  
//                XWPFTable table = (XWPFTable) itTable.next();  
//                int count = table.getNumberOfRows();  
//                for (int i = 0; i < count; i++) {  
//                    XWPFTableRow row = table.getRow(i);  
//                    List<XWPFTableCell> cells = row.getTableCells();  
//                    for (XWPFTableCell cell : cells) {  
//                        for (Entry<String, String> e : map.entrySet()) {  
//                            if (cell.getText().equals(e.getKey())) {  
//                                cell.removeParagraph(0);  
//                                cell.setText(e.getValue());  
//                            }  
//                        }  
//                    }  
//                }  
//            }  
//            FileOutputStream outStream = null;  
//            outStream = new FileOutputStream(destPath);  
//            document.write(outStream);  
//            outStream.close();  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        }  
//        
//        System.out.println("finish ing ");
//    }  
//	
//	public static void main(String[] args) throws Exception {
//		
//		//File oldFile = new File("C:/Users/caozq/Desktop/新建文件夹/信我信用平台接口查询文档-V1.63-171115【用友金融】.docx");
//		//File newFile = new File("C:/Users/caozq/Desktop/新建文件夹/2.docx");
//		//copyFile(oldFile,newFile);
//		
//		Map<String, String> map = new HashMap<String, String>();  
//        map.put("${title}", "POI word export");  
//        map.put("${second}", "2");  
//        map.put("${name}", "李强");  
//        map.put("${tel}", "0000-0000");  
//        map.put("${remark}", "remark info");  
//        String srcPath = "D:\\file\\3.docx";  
//        String destPath = "D:\\file\\4.docx";  
//        searchAndReplace(srcPath, destPath, map);
//	}
//}
