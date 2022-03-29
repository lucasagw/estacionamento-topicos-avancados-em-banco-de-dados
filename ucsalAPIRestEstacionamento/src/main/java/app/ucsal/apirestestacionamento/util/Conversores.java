package app.ucsal.apirestestacionamento.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;

public class Conversores {
	
	public static byte[] converterBase64ParaBytes(String base64Imagem) throws IOException{
		
		byte[] buffer = new byte[1024];
        
        InputStream inputStream = new ByteArrayInputStream(base64Imagem.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        
        while (inputStream.read(buffer) != -1)  {
        	
        	outputStream.write(buffer);
        }
        
        inputStream.close();
		
        return Base64.decodeBase64(outputStream.toByteArray());        
	} 
}
