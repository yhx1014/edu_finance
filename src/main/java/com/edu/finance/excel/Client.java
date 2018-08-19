package com.edu.finance.excel;

//
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//import com.edu.finance.file.FileUtil;
//
///**
// * @author Hongten
// * @created 2014-5-21
// */

public class Client {
	public static void main(String[] args) {
		System.out.println();
	}
}


//public class Client {
//
//    public static void main(String[] args) throws Exception {
//    	String filePath = "D:/file/";
//        String excel2010 = filePath + "student_info.xlsx";
//        // read the 2003-2007 excel
//        List<Student> list = new ReadExcel().readExcel(excel2010);
//        File oldFile = new File(filePath+"信我信用平台接口查询文档-V1.63-171115【用友金融】.docx");
//        if (list != null) {
//            for (Student student : list) {
//                System.out.println("No. : " + student.getNo() + ", name : " + student.getName() + ", age : " + student.getAge() + ", score : " + student.getScore());
//                FileUtil.createFile(student.getName()+".docx", null);
//        		File newFile = new File(filePath+student.getName()+".docx");
//                FileUtil.copyFile(oldFile,newFile);
//            }
//        }
////        System.out.println("======================================");
////        // read the 2010 excel
////        List<Student> list1 = new ReadExcel().readExcel(excel2010);
////        if (list1 != null) {
////            for (Student student : list1) {
////                System.out.println("No. : " + student.getNo() + ", name : " + student.getName() + ", age : " + student.getAge() + ", score : " + student.getScore());
////            }
////        }
//    }
//}