# MarvelApp
App creada por Diego Garzón Molina, iniciada el 09/07/2021.

La app usa como patrón de arquitectura el patrón MVVM y modularización en Clean. Se ha usado Live Data como contenedor de datos, encapsulados
en un tipo Resource para diferenciar fácilmente entre los estados Loading, Success y Error. Además, un segundo encapsulamiento con una estructura Either, para la transmisión de
errores y excepciones o datos exitosos.

En la capa domain se han añadido casos de uso y mappers como muestras. En la clase data se ha consumido servicios REST, a través de retrofit2.

Para la inyección de dependencias se ha usado Koin y para el manejo de hilos un sistema asíncrono de Interactor-Executor que automáticamente gestiona los hilos de background o main según se lance la petición del caso de uso o se reciba la respuesta.

La navegación entre fragmentos se basa en Navigation Component.

La app no funcionará sin añadir las API key pública y privada del web services de Marvel al fichero gradle.properties.

