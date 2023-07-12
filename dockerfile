# Utiliza una imagen base de OpenJDK 17
FROM openjdk:17-jdk-slim-buster

# Copia los archivos de tu aplicación en el contenedor
COPY . /app
COPY target/RebaDesafio.jar /app/RebaDesafio.jar

# Establece el directorio de trabajo
WORKDIR /app

# Expone el puerto de tu aplicación (si es necesario)
EXPOSE 8080

# Define el comando de inicio del contenedor
CMD java -jar RebaDesafio.jar
