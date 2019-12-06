package br.com.servico.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ejb.Schedule;

public class CopiaCola {
	
	public static void copia(File de, File para) {
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream(de);
			os = new FileOutputStream(para);
			
			byte[] buf = new byte[1024];
			
			int bytesRead;
			
			while((bytesRead = is.read(buf)) > 0) {
				os.write(buf, 0, bytesRead);
			}
			
			is.close();
			os.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//File de   = new File("D:\\_projetos\\WhatsApp\\diretorio-a\\arquivo.txt");
		//File para = new File("D:\\_projetos\\WhatsApp\\diretorio-b");
		
		File de   = new File("C:\\Users\\deivison.matos\\Desktop\\diretorio-a\\arquivo.txt");
		File para = new File("C:\\Users\\deivison.matos\\Downloads\\_arquivos\\arquivo.txt");
		
		copia(de, para);
		
	}
}

























