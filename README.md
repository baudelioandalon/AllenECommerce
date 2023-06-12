# AllenECommerce

Resumen:
Proyecto Android para el desarrollo de una E-commerce de alto rendimiento, con tecnologias como;
Kotlin
DaggerHilt
Compose
Room
Retrofit
Flows
Coroutines

Se desarrollará siguiendo la arquitectura MVVM y CleanArchitecture, con multiples tipos de usuarios
como:
Client
Partner
Seller
Delivery

Cada uno de estos usuarios podrá ingresar a las diferentes plataformas, sin importar su tipo de usuario, todos podrán comprar
dentro de la aplicacion, el cliente puede ser cualquier usuario registrado.

CLIENT
1- Para entrar a comprar un producto, deberá hacerlo
mediante la aplicacion tipo CLIENTE, que estará disponible en la play store.

PARTNER
2- Para subir una publicacion de un producto el usuario deberá iniciar sesion en la aplicacion tipo
Partner y en la misma se podrá enlazar a sus vendedores y/o repartidores.

SELLER
3- Para vender se necesitará primero;
* Tener creada una cuenta simple tipo cliente
* Estar enlazado a una cuenta de tipo partner
* Estár habilitado para poder realizar ventas (El partner activa ese permiso, por default está activado)
* Tener un dispositivo >= de 8 pulgadas para tener un optimo manejo de la aplicacion
* Iniciar sesion en la aplicacion Punto de venta de Allen

RESTRICCIONES
* No podras estar enlazado a mas de una cuenta de partner a la vez con el mismo correo

DELIVERY
4 - Para poder repartir pedidos se necesita lo siguiente
* Tener creada una cuenta simple tipo cliente
* Subir sus documentos (INE, LICENCIA DE CONDUCIR, PAPELES EN REGLA DEL VEHICULO)
* Esperar su validacion

Teniendo lo anterior en cuenta, iniciemos.
