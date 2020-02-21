## SQLiteTable Creator
Cansado de crear las tablas para SQLite en android a mano, no te preocupes.
Esta clase ter permitira crear la query requerida para crear una tabla
de una manaera sencilla y rapida

#### Uso de las clase
El uso de la libreria es bastante sencillo, primero crea un objeto
apartir de la clase SQLiteTalbe, se requieren como parametros el nombre
de la tabla y el nombre del campo primario

```java
SQLiteTable table = new SQLiteTable("table_name", "column_id_name");

```
##### Añadir una columna
Para añadir una columna es muy simple usamos el metodo, el metodo tiene
dos formas de agregar una columna la primera es que resive como parametro
el nombre del campo y el tipo de datos(ya estan definidos en la clase, como se muestra a continuacion.

###### Tipos de datos
```java
table.TYPE_INTEGER = "INTEGER"; //Enteros
table.TYPE_TEXT = "TEXT"; //String
table.TYPE_REAL = "REAL"; //Flotantes o Dobles
```

###### Añadir Columna
```java
table.addColumn("first_name", table.TYPE_DATA);
```

Tambien podemos anadir columna con parameros de que no sean nulos o unicos, si es el caso
agregamos true para que se incluyan en la query en caso de que no solo agregar false, al que
no sea requerido
###### Añadir Columna
```java
table.addColumn("first_name", table.TYPE_DATA, /*isNotNull*/ true, /*isUnique*/true);
```

Para que la clase nos regrese la query, solo ejecutamos el siquiente metodo, asi podemos copiarlo
ingresar en la funcion de crear table de SQLite ya que esta resive como parametro un String

```java
table.getQuery();
//Retorna un String
```
