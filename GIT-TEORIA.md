# <p style="text-align: center" >SOLUCION A LA PARTE TEORICA </p>
# Fundamentos de Markdown
**Markdown** es un formato de escritura en texto plano que permite aplicar estilos como títulos, negritas, listas o enlaces utilizando símbolos sencillos del teclado (como numerales # o asteriscos *), diseñado para que el texto sea completamente legible mientras se redacta sin depender de programas complejos ni botones, y con la capacidad de convertirse automáticamente a páginas web (HTML), archivos PDF u otros documentos estructurados.

---

# Git
### Pregunta 1:
Un proyecto normal es una simple carpeta en el sistema de archivos que contiene archivos y subcarpetas. Un repositorio de Git es una carpeta que contiene una subcarpeta oculta llamada *.git.* Esta subcarpeta alberga una base de datos de objetos, referencias y configuraciones donde Git registra todo el historial de cambios, ramas, autores y versiones del proyecto a lo largo del tiempo.

---

### Pregunta 2:
Git organiza el ciclo de vida de las modificaciones mediante **tres estados o zonas de trabajo locales:**

1. **Working Directory (Directorio de trabajo):** Es la carpeta física visible en tu sistema operativo donde te encuentras creando, editando o eliminando código. Representa el estado actual e inestable de tus archivos antes de confirmar nada.
2. **Staging Area / Index (Área de preparación):** Es un espacio borrador o de inspección previa (almacenado técnicamente en *.git/index*). Permite agrupar modificaciones puntuales provenientes del directorio de trabajo antes de realizar una confirmación definitiva. Esto ayuda a crear *commits* limpios y atómicos que contengan únicamente cambios relacionados entre sí.
3. **Repository (Repositorio local o base de datos):** Es la zona donde Git guarda de forma permanente e inmutable las fotografías del proyecto (*snapshots* o commits). Una vez que un cambio entra al repositorio local, queda registrado en el historial del proyecto.

---

### Pregunta 3:
Git no guarda simplemente "diferencias de texto" o *diffs*; gestiona su contenido mediante una base de datos clave-valor orientada por contenido (utilizando algoritmos de cifrado Hash SHA-1 o SHA-256). Internamente utiliza 4 tipos de objetos principales:

* **Blob (Binary Large Object):** Almacena únicamente el contenido en bruto de un archivo. No guarda el nombre del archivo, su ruta ni sus permisos; si dos archivos en carpetas distintas tienen el mismo contenido exacto, Git crea un único objeto Blob para ahorrar espacio.
* **Tree (Árbol):** Equivale a un directorio o carpeta. Un objeto Tree contiene un listado de referencias hacia objetos Blob (archivos) u otros objetos Tree (subcarpetas), vinculándoles sus respectivos nombres de archivo, rutas y permisos de lectura/ejecución.
* **Commit:** Es el objeto que toma una captura completa del estado del proyecto en un instante dado. Contiene un puntero hacia el *Tree* raíz, punteros hacia el o los commits antecedentes (*parents*), el mensaje descriptivo y la información del autor/committer con su marca de tiempo.
* **Tag (Etiqueta de objeto):** Es una referencia fija e inmutable que apunta generalmente a un objeto Commit específico. Contiene un nombre personalizado (ej. v2.1.0), un mensaje opcional y firma digital, utilizada para marcar hitos o lanzamientos de versiones.

---

### Pregunta 4:
Un **commit** se crea ejecutando el comando *git commit -m "Mensaje explicativo"*, tras haber preparado las modificaciones en el área de trabajo con el comando *git add*.

Cuando este proceso se ejecuta, Git emite un nuevo hash único y crea un objeto commit que encapsula la siguiente información:
* **El identificador del Tree raíz:** Un puntero al estado global del árbol de archivos en ese preciso instante.
* **Los datos del autor:** Nombre, correo electrónico y fecha/hora exacta en la que se escribió el cambio originalmente.
* **Los datos del committer:** Nombre, correo electrónico y fecha/hora exacta en la que el cambio fue aplicado al repositorio (puede diferir del autor si se aplican parches).
* **El puntero al Parent (Padre):** La clave Hash del commit inmediatamente anterior sobre el cual se construyó esta versión (los commits de integración pueden tener múltiples padres).
* **El mensaje de confirmación:** El texto explicativo introducido por el desarrollador para documentar el motivo del cambio.

---

### Pregunta 5:
Ambos comandos se emplean para consultar cambios en un servidor o repositorio remoto, pero operan de manera distinta sobre tu código local:

* ***git fetch:*** Se limita a descargar todos los objetos, commits, referencias y ramas del repositorio remoto hacia tu base de datos local (*.git*). **No modifica** tu directorio de trabajo actual ni altera la rama que tienes seleccionada. Es la opción más segura para inspeccionar qué han hecho otros miembros del equipo antes de integrar sus cambios.
* ***git pull:*** Es un comando compuesto que ejecuta dos acciones en secuencia: primero realiza internamente un *git fetch* para obtener las novedades remotas y, de forma inmediata, ejecuta un *git merge* para fusionar dichos cambios en tu rama local activa. Si existen diferencias incompatibles en las mismas líneas de código, este proceso solicitará la resolución de un conflicto.

---

### Pregunta 6:
Una **rama (branch)** en Git no es una copia físicamente duplicada del proyecto. Es simplemente un **puntero ligero de texto plano** que almacena la dirección Hash de un commit específico.

Git gestiona estos punteros utilizando una referencia especial llamada **HEAD**, la cual apunta directamente a la rama local activa en la que estás trabajando. Cada vez que realizas un commit nuevo, la rama activa y el puntero HEAD se desplazan automáticamente hacia adelante apuntando a esa nueva confirmación.

---

### Pregunta 7:
Un **merge** integra el historial de modificaciones de una rama dentro de otra mediante el comando *git merge <rama-origen>*.

* **Tipos de fusión:** Si la rama destino no se ha desviado, ocurre un *Fast-forward* (el puntero solo avanza). Si ambas ramas avanzaron de forma independiente, Git realiza un *3-way merge* y genera un nuevo *commit de fusión*.
* **Conflictos:** Surgen cuando dos ramas modifican las mismas líneas de un archivo con valores diferentes. Git detiene el proceso e inserta delimitadores (*<<<<<<<*, *=======*, *>>>>>>>*).
* **Resolución:** El desarrollador edita el archivo manualmente para elegir los cambios correctos, borra los delimitadores, añade el archivo al Staging Area con *git add* y finaliza la operación ejecutando *git commit*.

---

### Pregunta 8:
El área de **Staging (*git add*)** funciona como un borrador intermedio para seleccionar exactamente qué cambios del directorio de trabajo formarán parte del próximo commit.

Si omites este paso e intentas hacer *git commit*, Git detendrá la operación notificando que no hay cambios preparados (*no changes added to commit*). Los cambios permanecerán únicamente en tu carpeta de trabajo sin guardarse en el historial del repositorio (a menos que utilices el comando combinado *git commit -am "mensaje"* para incluir archivos que ya estaban bajo seguimiento).

---

### Pregunta 9:
El archivo **.gitignore** es un documento de texto en la raíz del proyecto que indica a Git qué archivos o carpetas debe omitir deliberadamente (como archivos de compilación, módulos de dependencias o claves secretas).

Su influencia radica en que evita que esos archivos aparezcan como "no rastreados" o se incluyan accidentalmente al ejecutar comandos masivos como *git add .*. Sin embargo, no afecta a los archivos que ya fueron confirmados previamente en el historial.

---

### Pregunta 10:
Un **commit amend (*--amend*)** sustituye y recompone la confirmación más reciente. Toma lo que esté en el área de staging, modifica el commit anterior y genera un Hash totalmente nuevo en su lugar. Un **nuevo commit**, en cambio, se agrega de forma independiente al historial como un nuevo eslabón en la cadena, conservando intactos todos los commits del pasado.

---

### Pregunta 11:
El comando **git stash** toma las modificaciones inconclusas del directorio de trabajo y del área de staging y las almacena temporalmente en una pila de borrador interna, dejando la carpeta de trabajo limpia e idéntica al último commit.

Es útil cuando debes pausar tu tarea actual de forma inmediata para corregir un error urgente en otra rama o cuando necesitas cambiar de entorno de trabajo sin crear un commit incompleto o desordenado.

---

### Pregunta 12:
Git ofrece tres mecanismos principales para revertir o deshacer modificaciones:

* ***git checkout:*** Restaura un archivo específico en el directorio de trabajo al estado del último commit (*git checkout -- archivo*) o te permite cambiar de rama.
* ***git reset:*** Mueve el puntero de la rama actual hacia un commit del pasado. Puede usarse con *--soft* (conserva los cambios en staging), *--mixed* (los conserva en la carpeta de trabajo) o *--hard* (elimina las modificaciones por completo).
* ***git revert:*** Genera un **nuevo commit** que aplica exactamente los cambios inversos de un commit anterior. Es el método más seguro para ramas compartidas o remotas porque no altera la historia previa.

---

### Pregunta 13:
Un **remoto** es un enlace a la URL de un servidor externo donde se aloja el repositorio.

* ***origin:*** Es el nombre predeterminado asignado al servidor remoto principal desde el cual clonaste el proyecto.
* ***upstream:*** Es el nombre utilizado para referenciar al repositorio fuente original cuando trabajas sobre una copia personal (*fork*).
* **Gestión de forks:** Se utiliza *git remote add upstream <URL>* para vincular el proyecto fuente, *git fetch upstream* para descargar sus novedades y *git merge upstream/main* para mantener tu copia local sincronizada con la fuente original.

---

### Pregunta 14:
Para auditar el historial de un repositorio se utilizan tres herramientas clave:

* ***git log:*** Despliega la lista de commits ordenados cronológicamente (puede personalizarse con opciones como *--oneline* o *--graph*).
* ***git diff:*** Muestra las líneas de código añadidas o eliminadas entre tu directorio de trabajo, la zona de staging o diferentes commits.
* ***git show <hash>:*** Muestra en detalle la información completa y el parche de cambios de un commit específico.

---

# Programación

### Pregunta 15:
Java cuenta con **8 tipos de datos primitivos** almacenados por valor en memoria:

* **Enteros:** *byte* (8 bits), *short* (16 bits), *int* (32 bits), *long* (64 bits).
* **Decimales:** *float* (32 bits), *double* (64 bits).
* **Carácter:** *char* (16 bits, Unicode).
* **Lógico:** *boolean* (*true* o *false*).

---

### Pregunta 16:
Las estructuras de control guían el flujo de ejecución del programa:

* **Condicionales (*if*, *else*, *switch*):** Evalúan condiciones lógicas. *if/else* decide entre caminos según un resultado verdadero o falso, mientras que *switch* evalúa el valor exacto de una variable contra múltiples casos posibles.
* **Bucles (*for*, *while*, *do-while*):** Repiten bloques de código. *for* se usa cuando se conoce el número de iteraciones; *while* evalúa la condición antes de cada ciclo; y *do-while* ejecuta el bloque al menos una vez antes de verificar la condición.

---

### Pregunta 17:
Utilizar nombres significativos en variables y métodos es fundamental porque mejora la **autodocumentación**, **legibilidad** y **mantenibilidad** del código. Permite que cualquier desarrollador entienda el propósito de un dato o función sin necesidad de descifrar la lógica interna ni depender de comentarios extensos que pueden quedar desactualizados.

---

### Pregunta 18:
La **Programación Orientada a Objetos (POO)** es un paradigma de programación que organiza el diseño del software en torno a "objetos" en lugar de funciones o lógica aislada. Cada objeto es una unidad modular que agrupa datos (atributos) y comportamientos (métodos) para representar entidades del mundo real o del sistema.

---

### Pregunta 19:
Los **cuatro pilares de la POO** son:

1. **Abstracción:** Oculta los detalles técnicos complejos de implementación y expone únicamente las características esenciales de un objeto.
2. **Encapsulamiento:** Agrupa los datos y métodos en una clase, protegiendo los atributos internos del acceso no autorizado mediante modificadores de acceso.
3. **Herencia:** Permite que una clase hija derive atributos y métodos de una clase padre, promoviendo la reutilización de código.
4. **Polimorfismo:** Permite enviar el mismo mensaje a distintos tipos de objetos y que cada uno responda de forma personalizada según su clase.

---

### Pregunta 20:
La **herencia** es el mecanismo que permite crear clases secundarias a partir de una clase base. En Java se implementa mediante la palabra reservada **extends**. La clase hija hereda las propiedades y métodos de la clase padre y puede agregar nuevos elementos o sobreescribir (*@Override*) los existentes.

```java
class Vehiculo {
    int velocidad;
}

class Coche extends Vehiculo {
    int cantidadPuertas;
}
```
---

### Pregunta 21:
Los **modificadores de acceso** son palabras clave que establecen qué clases tienen permiso para consultar o usar un atributo, método o clase. En Java existen cuatro niveles:

* **private:** Accesible únicamente dentro de la misma clase.

* **default (sin palabra clave):** Accesible dentro de la misma clase y por clases del mismo paquete.

* **protected:** Accesible dentro del mismo paquete y por subclases que hereden de ella (incluso en otros paquetes).

* **public:** Accesible de forma global desde cualquier parte del  proyecto.

---

### Pregunta 22:
Una **variable de entorno** es un valor dinámico guardado a nivel del sistema operativo que influye en cómo se ejecutan las aplicaciones.

En Java son importantes porque permiten definir configuraciones globales como JAVA_HOME (que señala la ruta de instalación del JDK) y permiten manejar datos confidenciales (como contraseñas de bases de datos o llaves de API) fuera del código fuente, garantizando mayor seguridad y portabilidad al desplegar la aplicación en diferentes entornos.