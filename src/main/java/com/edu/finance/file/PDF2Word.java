//package com.edu.finance.file;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.io.Writer;
//
//import org.pdfbox.pdmodel.PDDocument;
//import org.pdfbox.util.PDFTextStripper;
//
//public class PDF2Word {
//
//	
//	public static void pdfToDoc(String name1) throws IOException {
//		PDDocument doc = PDDocument.load(name1);
//		int pagenumber = doc.getNumberOfPages();
//		name1 = name1.substring(0, name1.lastIndexOf("."));
//		String fileName = name1 + ".doc";
//		createFile(fileName);
//		FileOutputStream fos = new FileOutputStream(fileName);
//		OutputStreamWriter writer = new OutputStreamWriter(fos, "UTF-8");
//		PDFTextStripper stripper = new PDFTextStripper();
//		stripper.setSortByPosition(true);
//		stripper.setStartPage(1);
//		stripper.setEndPage(pagenumber);
//		stripper.writeText(doc, writer);
//		writer.close();
//		doc.close();
//		System.out.println("pdf转换word成功！");
//	}
//
//	private static void createDir(String destDirName) {
//		File dir = new File(destDirName);
//		if (dir.exists()) {
//			System.out.println("创建目录失败，目标目录已存在！");
//		}
//
//		if (!destDirName.endsWith(File.separator)) {
//			destDirName = destDirName + File.separator;
//		}
//
//		if (dir.mkdirs()) {
//			System.out.println("创建目录成功！" + destDirName);
//		} else {
//			System.out.println("创建目录失败！");
//		}
//
//	}
//
//	public static void createFile(String filePath) {
//		File file = new File(filePath);
//		if (file.exists()) {
//			System.out.println("目标文件已存在" + filePath);
//		}
//
//		if (filePath.endsWith(File.separator)) {
//			System.out.println("目标文件不能为目录！");
//		}
//
//		if (!file.getParentFile().exists()) {
//			System.out.println("目标文件所在目录不存在，准备创建它！");
//			if (!file.getParentFile().mkdirs()) {
//				System.out.println("创建目标文件所在的目录失败！");
//			}
//		}
//
//		try {
//			if (file.createNewFile()) {
//				System.out.println("创建文件成功:" + filePath);
//			} else {
//				System.out.println("创建文件失败！");
//			}
//		} catch (IOException arg2) {
//			arg2.printStackTrace();
//			System.out.println("创建文件失败！" + arg2.getMessage());
//		}
//	}
//	
//	
//	
//	public static void getWordFromPdf(String name) throws IOException{
//		
//		PDDocument doc=PDDocument.load(new File(name));
//        int pagenumber=doc.getNumberOfPages();
//
//        name = name.substring(0, name.lastIndexOf("."));
////      String dirName = "D:\\pdf\\";// 创建目录D:\\pdf\\a.doc
//        String dirName = name;// 创建目录D:\\pdf\\a.doc
//        //createDir(dirName);// 调用方法创建目录
//        String fileName = dirName + ".doc";// 创建文件
//        createFile(fileName);
//        FileOutputStream fos=new FileOutputStream(fileName);
//        Writer writer=new OutputStreamWriter(fos,"UTF-8");
//        PDFTextStripper stripper=new PDFTextStripper();
//
////      doc.addSignature(arg0, arg1, arg2);
//
//        stripper.setSortByPosition(true);//排序
//        //stripper.setWordSeparator("");//pdfbox对中文默认是用空格分隔每一个字，通过这个语句消除空格（视频是这么说的）
//        stripper.setStartPage(1);//设置转换的开始页
//        stripper.setEndPage(pagenumber);//设置转换的结束页
//        stripper.writeText(doc,writer);
//        writer.close();
//        doc.close();
//        System.out.println("pdf转换word成功！");
//	} 
//	
//	
//	public static void main(String[] args) throws IOException {
//		PDF2Word box = new PDF2Word();
//		String name = "D:\\file\\1.pdf";
//		//box.pdfToDoc(a);
//		box.getWordFromPdf(name);
//	}
//}
