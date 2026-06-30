# Preguntas de reflexión

1. ¿Cuál es la diferencia entre `ActionEvent`, `MouseEvent` y `KeyEvent`?

ActionEvent es un evento general que se activa al completar una acción principal, como activar un botón, sin importar si se hizo con el ratón o el teclado. MouseEvent detecta acciones específicas del ratón, como mover el cursor, arrastrar o hacer clic. KeyEvent detecta acciones exclusivas del teclado, como presionar, soltar o escribir una tecla.

2. ¿Por qué es mejor separar la vista en FXML y la lógica en el Controller?

Esta separación permite que el código Java se mantenga limpio y enfocado únicamente en el funcionamiento interno del sistema. Al mismo tiempo, el diseño visual se maneja de forma independiente en el FXML, lo que facilita el mantenimiento, la organización del proyecto y la actualización de la interfaz gráfica sin afectar la lógica.

3. ¿Qué función cumple `@FXML`?

Cumple la función de enlazar el diseño con el código. Actúa como un conector que permite vincular los componentes visuales definidos en el archivo FXML directamente con las variables y métodos correspondientes dentro de la clase Java del Controller.

4. ¿Qué ocurre si el nombre del método en el FXML no coincide con el método del Controller?

El programa lanza una excepción en tiempo de ejecución al momento de cargar la ventana. Esto sucede porque el archivo FXML intenta buscar un método específico para ejecutar una acción, y al no encontrar el nombre exacto en el Controller, el proceso falla y la interfaz gráfica no logra compilar ni mostrarse.

5. ¿Por qué es recomendable usar CSS en lugar de colocar estilos directamente en Java?

El uso de CSS permite aplicar y modificar estilos visuales en múltiples componentes de la aplicación desde un solo archivo externo, logrando consistencia visual. Esto evita escribir propiedades de diseño directamente en el código Java, manteniéndolo más corto, ordenado y facilitando el cambio de temas (como un modo oscuro) sin alterar la programación.