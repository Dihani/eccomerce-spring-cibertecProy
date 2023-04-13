package com.cibertec.ecommerce.service;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//indicamos que la clase es de tipo Service
@Service
public class UploadFileService {
	//declaramos las variables
		private String folder="imagenes//";
		
		//metodo para subir una imagen, traemos un objeto de tipo MultipartFile, que tiene exception IOException
		public String saveImage(MultipartFile file) throws IOException {
			//hacemos una validacion, si es que la imagen no es valido
			if(!file.isEmpty()) {
				byte [] bytes = file.getBytes();
				Path path = Paths.get(folder+file.getOriginalFilename());
				//el path es la ruta, bytes la imagen transformada en ese formato
				Files.write(path, bytes);
				//retorna un String, que sera el nombre de la imagen
				return file.getOriginalFilename();
			}
			//si el usuario no asigna una imagen al product,retornará una imagen por defecto
			return "default.jpg";
		}

		//metodo para eliminar una imagen que esta en el proyecto
		//recibe como parametro el nombre de la imagen
		public void deleteImagen(String nombreImagen) {
			String ruta="imagenes//";
			File file = new File(ruta + nombreImagen);
			file.delete();
		}
}
