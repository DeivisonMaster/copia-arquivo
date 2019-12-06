package br.com.servico.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class Agendamento {
	
	
	@Schedule(dayOfWeek = "Thu", hour = "14", minute = "46")
	public void agendamentoCopiaArquivo() {
		System.out.println("executando tarefa agendada...");
	}
	
	@Schedule(dayOfWeek = "Thu", hour = "2", minute = "46")
	public void agendamentoCopiaArquivo2() {
		System.out.println("executando tarefa agendada...");
	}
	
	@Schedule(dayOfWeek = "Thu", hour = "3", minute = "46")
	public void agendamentoCopiaArquivo3() {
		System.out.println("executando tarefa agendada...");
	}
	
	@Schedule(hour="*", minute="*", second="*/60", persistent=false)
	public void agendamentoCopiaArquivo4() {
		System.out.println("executando tarefa agendada");
		
		File de   = new File("C:\\Users\\deivison.matos\\Desktop\\diretorio-a\\arquivo.txt");
		File para = new File("C:\\Users\\deivison.matos\\Downloads\\_arquivos\\arquivo " + new Random().nextInt() + ".txt");
		
		copia(de, para);
	}
	
	public void copia(File de, File para) {
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
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
